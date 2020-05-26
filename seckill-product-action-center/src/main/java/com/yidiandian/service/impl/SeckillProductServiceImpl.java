package com.yidiandian.service.impl;

import com.yidiandian.entity.SeckillProduct;
import com.yidiandian.dao.SeckillProductDao;
import com.yidiandian.service.SeckillProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SeckillProduct)表服务实现类
 *
 * @author makejava
 * @since 2020-05-25 21:40:59
 */
@Service
@Slf4j
public class SeckillProductServiceImpl implements SeckillProductService {
    @Resource
    private SeckillProductDao seckillProductDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SeckillProduct queryById(Integer id) {
        return this.seckillProductDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SeckillProduct> queryAllByLimit(int offset, int limit) {
        return this.seckillProductDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param seckillProduct 实例对象
     * @return 实例对象
     */
    @Override
    public SeckillProduct insert(SeckillProduct seckillProduct) {
        this.seckillProductDao.insert(seckillProduct);
        return seckillProduct;
    }

    /**
     * 修改数据
     *
     * @param seckillProduct 实例对象
     * @return 实例对象
     */
    @Override
    public SeckillProduct update(SeckillProduct seckillProduct) {
        this.seckillProductDao.update(seckillProduct);
        return this.queryById(seckillProduct.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.seckillProductDao.deleteById(id) > 0;
    }
}