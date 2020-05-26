package com.yidiandian.service;

import com.yidiandian.entity.SeckillProduct;
import java.util.List;

/**
 * (SeckillProduct)表服务接口
 *
 * @author makejava
 * @since 2020-05-25 21:40:59
 */
public interface SeckillProductService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SeckillProduct queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SeckillProduct> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param seckillProduct 实例对象
     * @return 实例对象
     */
    SeckillProduct insert(SeckillProduct seckillProduct);

    /**
     * 修改数据
     *
     * @param seckillProduct 实例对象
     * @return 实例对象
     */
    SeckillProduct update(SeckillProduct seckillProduct);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}