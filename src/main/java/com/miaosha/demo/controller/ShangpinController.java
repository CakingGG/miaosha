package com.miaosha.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.miaosha.demo.service.DingdanService;
import com.miaosha.demo.service.ShangpinService;
import com.miaosha.demo.utils.CommonUtil;
import com.miaosha.demo.utils.RedisUtil;
import com.miaosha.demo.utils.constants.ErrorEnum;
import com.miaosha.demo.utils.constants.TopicConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * (Shangpin)表控制层
 *
 * @author yejiajun
 * @since 2020-03-06 17:18:50
 */
@RestController
@RequestMapping("shangpin")
public class ShangpinController {
    /**
     * 服务对象
     */
    @Resource
    private ShangpinService shangpinService;

    @Resource
    private DingdanService dingdanService;

    @Resource
    private RedisUtil redisUtil;

    @Autowired
    private KafkaTemplate kafkaTemplate;
    private Gson gson = new GsonBuilder().create();

    private Random random = new Random(1);

    @PostMapping("countDownNum")
    public JSONObject countDownNum(@RequestBody JSONObject requestJson){
        //倒计时
        Object countDownTime = redisUtil.get("countDownTime");
        if(countDownTime == null){
            CommonUtil.hasAllRequired(requestJson, "id");
            redisUtil.incr("limitNum", 1);
            int limitNum = (int)redisUtil.get("limitNum");
            if(limitNum > 500){
                //只允许500个线程进来
                System.out.println("超过500了");
                return CommonUtil.errorJson(ErrorEnum.E_30003);
            }
            System.out.println("开始秒杀");
            JSONObject numJson = shangpinService.queryNumAndVision(requestJson);
            String numStr = numJson.getString("num");
            int num = Integer.parseInt(numStr);
            //如果数量大于零，可以送给消息队列里面
            if(num > 0){
                //将请求送到kafka
                try {
                    String msg = gson.toJson(requestJson);
                    kafkaTemplate.send(TopicConst.PAY_TOPIC, msg);
                }catch (Exception e){
                    e.printStackTrace();
                    //秒杀失败
                    return CommonUtil.errorJson(ErrorEnum.E_30002);
                }
                return CommonUtil.successJson();
            }else{
                //商品没了
                return CommonUtil.errorJson(ErrorEnum.E_30003);
            }
        }else{
            //时间没有到
            return CommonUtil.errorJson(ErrorEnum.E_30001);
        }
    }

    //这里为了方便就不重新创建一个消费者类了
    @KafkaListener(topics = TopicConst.PAY_TOPIC)
    private void onMessage(String payMessage) {
        JSONObject requestJson = gson.fromJson(payMessage, JSONObject.class);
        System.out.println("MessageConsumer: onMessage: message is: [" + requestJson + "]");
        //获得版本号
        JSONObject idAndVision = shangpinService.queryNumAndVision(requestJson);
        try {
            boolean idSuccess = shangpinService.countDownNum(idAndVision);
            if(idSuccess){
                JSONObject uidAndSid = new JSONObject();
                //随机的uid,模拟用户
                int uid = random.nextInt(1000);
                uidAndSid.put("sid", idAndVision.getString("id"));
                uidAndSid.put("uid", uid);
                dingdanService.insertDingdan(uidAndSid);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("并发锁失败了");
        }
    }

}