package com.miaosha.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.miaosha.demo.dao.DingdanDao;
import com.miaosha.demo.service.DingdanService;
import com.miaosha.demo.utils.CommonUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dingdan)表服务实现类
 *
 * @author yejiajun
 * @since 2020-03-08 16:15:40
 */
@Service("dingdanService")
public class DingdanServiceImpl implements DingdanService {
    @Resource
    private DingdanDao dingdanDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject queryDingdanById(JSONObject jsonObject) {
        return CommonUtil.successJson(dingdanDao.queryDingdanById(jsonObject));
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject queryAllDingdanByLimit(JSONObject jsonObject) {
        return CommonUtil.successJson(dingdanDao.queryAllDingdanByLimit(jsonObject));
    }
    
     /**
     * 通过实体作为筛选条件查询
     *
     * @param dingdan 实例对象
     * @return 对象列表
     */
    @Override
    public JSONObject queryAllDingdan(JSONObject jsonObject){
        return CommonUtil.successJson(dingdanDao.queryAllDingdan(jsonObject));
    }

    /**
     * 新增数据
     *
     * @param dingdan 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject insertDingdan(JSONObject jsonObject) {
        dingdanDao.insertDingdan(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 修改数据
     *
     * @param dingdan 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateDingdan(JSONObject jsonObject) {
        this.dingdanDao.updateDingdan(jsonObject);
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
    public JSONObject deleteDingdanById(JSONObject jsonObject) {
        dingdanDao.deleteDingdanById(jsonObject);
        return CommonUtil.successJson();
    }
    
    @Override
    public JSONObject listDingdan(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = dingdanDao.countDingdan(jsonObject);
        List<JSONObject> list = dingdanDao.listDingdan(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject deleteDingdan(JSONObject jsonObject) {
        dingdanDao.deleteDingdan(jsonObject);
        return CommonUtil.successJson();
    }
    
}