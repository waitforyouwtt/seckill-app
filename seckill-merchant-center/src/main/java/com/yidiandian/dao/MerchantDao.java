package com.yidiandian.dao;

import com.yidiandian.entity.Merchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Merchant)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-23 22:01:24
 */
@Mapper
public interface MerchantDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Merchant queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Merchant> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param merchant 实例对象
     * @return 对象列表
     */
    List<Merchant> queryAll(Merchant merchant);

    /**
     * 新增数据
     *
     * @param merchant 实例对象
     * @return 影响行数
     */
    int insert(Merchant merchant);

    /**
     * 修改数据
     *
     * @param merchant 实例对象
     * @return 影响行数
     */
    int update(Merchant merchant);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}