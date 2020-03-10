package com.miaosha.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.miaosha.demo.dao.ShangpinDao;
import com.miaosha.demo.service.ShangpinService;
import com.miaosha.demo.utils.CommonUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Shangpin)表服务实现类
 *
 * @author yejiajun
 * @since 2020-03-06 17:18:46
 */
@Service("shangpinService")
public class ShangpinServiceImpl implements ShangpinService {
    @Resource
    private ShangpinDao shangpinDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public JSONObject queryShangpinById(JSONObject jsonObject) {
        return CommonUtil.successJson(shangpinDao.queryShangpinById(jsonObject));
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public JSONObject queryAllShangpinByLimit(JSONObject jsonObject) {
        return CommonUtil.successJson(shangpinDao.queryAllShangpinByLimit(jsonObject));
    }
    
     /**
     * 通过实体作为筛选条件查询
     *
     * @param shangpin 实例对象
     * @return 对象列表
     */
    @Override
    public JSONObject queryAllShangpin(JSONObject jsonObject){
        return CommonUtil.successJson(shangpinDao.queryAllShangpin(jsonObject));
    }

    /**
     * 新增数据
     *
     * @param shangpin 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject insertShangpin(JSONObject jsonObject) {
        shangpinDao.insertShangpin(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 修改数据
     *
     * @param shangpin 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateShangpin(JSONObject jsonObject) {
        this.shangpinDao.updateShangpin(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject deleteShangpinById(JSONObject jsonObject) {
        shangpinDao.deleteShangpinById(jsonObject);
        return CommonUtil.successJson();
    }
    
    @Override
    public JSONObject listShangpin(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = shangpinDao.countShangpin(jsonObject);
        List<JSONObject> list = shangpinDao.listShangpin(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject deleteShangpin(JSONObject jsonObject) {
        shangpinDao.deleteShangpin(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean countDownNum(JSONObject jsonObject) throws Exception{
        int res = shangpinDao.countDownNum(jsonObject);
        if(res == 0){
            return false;
        }
        return true;
    }

    @Override
    public JSONObject queryNumAndVision(JSONObject jsonObject){
        return shangpinDao.queryNumAndVision(jsonObject);
    }
}