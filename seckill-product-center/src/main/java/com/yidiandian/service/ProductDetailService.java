package com.yidiandian.service;

import com.yidiandian.entity.ProductDetail;
import java.util.List;

/**
 * (ProductDetail)表服务接口
 *
 * @author makejava
 * @since 2020-05-24 19:06:49
 */
public interface ProductDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProductDetail queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProductDetail> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param productDetail 实例对象
     * @return 实例对象
     */
    ProductDetail insert(ProductDetail productDetail);

    /**
     * 修改数据
     *
     * @param productDetail 实例对象
     * @return 实例对象
     */
    ProductDetail update(ProductDetail productDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    ProductDetail queryByProductId(int productId);

}