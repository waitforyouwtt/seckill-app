package com.yidiandian.dao;

import com.yidiandian.entity.SeckillUserinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SeckillUserinfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-23 11:22:35
 */
@Mapper
public interface SeckillUserinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SeckillUserinfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SeckillUserinfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param seckillUserinfo 实例对象
     * @return 对象列表
     */
    List<SeckillUserinfo> queryAll(SeckillUserinfo seckillUserinfo);

    /**
     * 新增数据
     *
     * @param seckillUserinfo 实例对象
     * @return 影响行数
     */
    int insert(SeckillUserinfo seckillUserinfo);

    /**
     * 修改数据
     *
     * @param seckillUserinfo 实例对象
     * @return 影响行数
     */
    int update(SeckillUserinfo seckillUserinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}