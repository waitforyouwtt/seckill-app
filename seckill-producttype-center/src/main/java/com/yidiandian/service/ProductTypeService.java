package com.yidiandian.service;

import com.yidiandian.entity.ProductType;
import com.yidiandian.request.ProductTypeRequest;
import entity.ResponseResult;

import java.util.List;

/**
 * (ProductType)表服务接口
 *
 * @author makejava
 * @since 2020-05-24 18:13:22
 */
public interface ProductTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProductType queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProductType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param productType 实例对象
     * @return 实例对象
     */
    ProductType insert(ProductType productType);

    /**
     * 修改数据
     *
     * @param productType 实例对象
     * @return 实例对象
     */
    ProductType update(ProductType productType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 添加分类
     * @param productTypeRequest
     * @return
     */
    ResponseResult addProductType(ProductTypeRequest productTypeRequest);
}