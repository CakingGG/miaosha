package com.miaosha.demo.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Dingdan)表数据库访问层
 *
 * @author yejiajun
 * @since 2020-03-08 16:15:40
 */
public interface DingdanDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JSONObject queryDingdanById(JSONObject jsonObject);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<JSONObject> queryAllDingdanByLimit(JSONObject jsonObject);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dingdan 实例对象
     * @return 对象列表
     */
    List<JSONObject> queryAllDingdan(JSONObject jsonObject);

    /**
     * 新增数据
     *
     * @param dingdan 实例对象
     * @return 影响行数
     */
    int insertDingdan(JSONObject jsonObject);

    /**
     * 修改数据
     *
     * @param dingdan 实例对象
     * @return 影响行数
     */
    int updateDingdan(JSONObject jsonObject);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteDingdanById(JSONObject jsonObject);
    
    /**
     * 统计总数
     */
    int countDingdan(JSONObject jsonObject);

    /**
     * 列表
     */
    List<JSONObject> listDingdan(JSONObject jsonObject);
    
    /**
     * 删除
     */
    int deleteDingdan(JSONObject jsonObject);

}