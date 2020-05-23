package com.yidiandian.service;

import com.yidiandian.entity.SeckillUserinfo;
import com.yidiandian.request.SeckillUserinfoRequest;
import entity.ResponseResult;

import java.util.List;

/**
 * (SeckillUserinfo)表服务接口
 *
 * @author makejava
 * @since 2020-05-23 11:16:56
 */
public interface SeckillUserinfoService {

    /**
     * 用户注册
     * @param userinfoRequest
     * @return
     */
    ResponseResult register(SeckillUserinfoRequest userinfoRequest);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SeckillUserinfo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SeckillUserinfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param seckillUserinfo 实例对象
     * @return 实例对象
     */
    SeckillUserinfo insert(SeckillUserinfo seckillUserinfo) throws Exception;

    /**
     * 修改数据
     *
     * @param seckillUserinfo 实例对象
     * @return 实例对象
     */
    SeckillUserinfo update(SeckillUserinfo seckillUserinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据条件查询秒杀用户
     * @param userinfoRequest
     * @return
     */
    SeckillUserinfo queryByParams(SeckillUserinfoRequest userinfoRequest);

}