package com.yidiandian.service;

import com.yidiandian.entity.ProductInfo;
import com.yidiandian.request.ProductDetailRequest;
import com.yidiandian.request.ProductInfoRequest;
import entity.ResponseResult;

import java.util.List;

/**
 * (Productinfo)表服务接口
 *
 * @author makejava
 * @since 2020-05-24 19:06:06
 */
public interface ProductInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProductInfo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProductInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param productinfo 实例对象
     * @return 实例对象
     */
    ProductInfo insert(ProductInfo productinfo);

    /**
     * 修改数据
     *
     * @param productinfo 实例对象
     * @return 实例对象
     */
    ProductInfo update(ProductInfo productinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 添加商品信息
     * @param productInfoRequest
     * @return
     */
    ResponseResult addProduct(ProductInfoRequest productInfoRequest);

    /**
     * 补充商品详情
     * @param productDetailRequest
     * @return
     */
    ResponseResult addProductDetail(ProductDetailRequest productDetailRequest);

    /**
     * 查询商品信息
     * @param productInfoRequest
     * @return
     */
    ResponseResult queryProductList(ProductInfoRequest productInfoRequest);

    /**
     * 商品上下架
     * @param id
     * @param state
     * @return
     */
    ResponseResult upOrDownProduct(int id, int state);

    /**
     * 根据id查询商品信息
     * @param ids
     * @return
     */
    ResponseResult queryProductByIds(String ids);
}