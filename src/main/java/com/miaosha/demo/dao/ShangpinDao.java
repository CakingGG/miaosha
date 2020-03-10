package com.miaosha.demo.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Shangpin)表数据库访问层
 *
 * @author yejiajun
 * @since 2020-03-06 17:18:44
 */
public interface ShangpinDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JSONObject queryShangpinById(JSONObject jsonObject);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<JSONObject> queryAllShangpinByLimit(JSONObject jsonObject);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param shangpin 实例对象
     * @return 对象列表
     */
    List<JSONObject> queryAllShangpin(JSONObject jsonObject);

    /**
     * 新增数据
     *
     * @param shangpin 实例对象
     * @return 影响行数
     */
    int insertShangpin(JSONObject jsonObject);

    /**
     * 修改数据
     *
     * @param shangpin 实例对象
     * @return 影响行数
     */
    int updateShangpin(JSONObject jsonObject);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteShangpinById(JSONObject jsonObject);
    
    /**
     * 统计总数
     */
    int countShangpin(JSONObject jsonObject);

    /**
     * 列表
     */
    List<JSONObject> listShangpin(JSONObject jsonObject);
    
    /**
     * 删除
     */
    int deleteShangpin(JSONObject jsonObject);

    int countDownNum(JSONObject jsonObject);

    JSONObject queryNumAndVision(JSONObject jsonObject);

}