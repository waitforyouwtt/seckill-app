package com.yidiandian.dao;

import com.yidiandian.entity.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Productinfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-24 19:06:05
 */
@Mapper
public interface ProductInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProductInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProductInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param productinfo 实例对象
     * @return 对象列表
     */
    List<ProductInfo> queryAll(ProductInfo productinfo);

    /**
     * 新增数据
     *
     * @param productinfo 实例对象
     * @return 影响行数
     */
    int insert(ProductInfo productinfo);

    /**
     * 修改数据
     *
     * @param productinfo 实例对象
     * @return 影响行数
     */
    int update(ProductInfo productinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}