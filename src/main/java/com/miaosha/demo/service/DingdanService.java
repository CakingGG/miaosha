package com.miaosha.demo.service;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * (Dingdan)表服务接口
 *
 * @author yejiajun
 * @since 2020-03-08 16:15:40
 */
public interface DingdanService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JSONObject queryDingdanById(JSONObject jsonObject);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    JSONObject queryAllDingdanByLimit(JSONObject jsonObject);
    
     /**
     * 通过实体作为筛选条件查询
     *
     * @param dingdan 实例对象
     * @return 对象列表
     */
    JSONObject queryAllDingdan(JSONObject jsonObject);

    /**
     * 新增数据
     *
     * @param dingdan 实例对象
     * @return 实例对象
     */
    JSONObject insertDingdan(JSONObject jsonObject);

    /**
     * 修改数据
     *
     * @param dingdan 实例对象
     * @return 实例对象
     */
    JSONObject updateDingdan(JSONObject jsonObject);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    JSONObject deleteDingdanById(JSONObject jsonObject);
    
    /**
     * 查询
     */
    JSONObject listDingdan(JSONObject jsonObject);
    
    
    /**
     * 删除
     */
    JSONObject deleteDingdan(JSONObject jsonObject);

    /**
     * 查询数量
     * @param jsonObject
     * @return
     */

}