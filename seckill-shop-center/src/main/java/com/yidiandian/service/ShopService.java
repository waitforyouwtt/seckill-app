package com.yidiandian.service;

import com.yidiandian.entity.Shop;
import com.yidiandian.request.ShopRequest;
import entity.ResponseResult;

import java.util.List;

/**
 * (Shop)表服务接口
 *
 * @author makejava
 * @since 2020-05-24 11:14:31
 */
public interface ShopService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Shop queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Shop> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    Shop insert(Shop shop);

    /**
     * 修改数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    Shop update(Shop shop);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 申请入住
     * @param shopRequest
     * @return
     */
    ResponseResult applyShop(ShopRequest shopRequest);

    /**
     * 根据状态查询
     * @param state
     * @return
     */
    ResponseResult queryShop(Integer state);

    /**
     * 审核商家
     * @param id
     * @param state
     * @return
     */
    ResponseResult examineShop(Integer id,Integer state);
}