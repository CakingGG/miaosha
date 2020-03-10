package com.miaosha.demo.service;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * (Shangpin)表服务接口
 *
 * @author yejiajun
 * @since 2020-03-06 17:18:45
 */
public interface ShangpinService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JSONObject queryShangpinById(JSONObject jsonObject);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    JSONObject queryAllShangpinByLimit(JSONObject jsonObject);
    
     /**
     * 通过实体作为筛选条件查询
     *
     * @param shangpin 实例对象
     * @return 对象列表
     */
    JSONObject queryAllShangpin(JSONObject jsonObject);

    /**
     * 新增数据
     *
     * @param shangpin 实例对象
     * @return 实例对象
     */
    JSONObject insertShangpin(JSONObject jsonObject);

    /**
     * 修改数据
     *
     * @param shangpin 实例对象
     * @return 实例对象
     */
    JSONObject updateShangpin(JSONObject jsonObject);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    JSONObject deleteShangpinById(JSONObject jsonObject);
    
    /**
     * 查询
     */
    JSONObject listShangpin(JSONObject jsonObject);
    
    
    /**
     * 删除
     */
    JSONObject deleteShangpin(JSONObject jsonObject);

    /**
     * 商品数量减一
     */
    boolean countDownNum(JSONObject jsonObject) throws Exception;

    /**
     * 查询数量
     */
    JSONObject queryNumAndVision(JSONObject jsonObject);

}