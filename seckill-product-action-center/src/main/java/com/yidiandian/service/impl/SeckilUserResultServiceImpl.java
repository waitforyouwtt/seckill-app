package com.yidiandian.service.impl;

import com.yidiandian.entity.SeckilUserResult;
import com.yidiandian.dao.SeckilUserResultDao;
import com.yidiandian.service.SeckilUserResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SeckilUserResult)表服务实现类
 *
 * @author makejava
 * @since 2020-05-30 13:01:26
 */
@Service
public class SeckilUserResultServiceImpl implements SeckilUserResultService {
    @Resource
    private SeckilUserResultDao seckilUserResultDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SeckilUserResult queryById(Integer id) {
        return this.seckilUserResultDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SeckilUserResult> queryAllByLimit(int offset, int limit) {
        return this.seckilUserResultDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param seckilUserResult 实例对象
     * @return 实例对象
     */
    @Override
    public SeckilUserResult insert(SeckilUserResult seckilUserResult) {
        this.seckilUserResultDao.insert(seckilUserResult);
        return seckilUserResult;
    }

    /**
     * 修改数据
     *
     * @param seckilUserResult 实例对象
     * @return 实例对象
     */
    @Override
    public SeckilUserResult update(SeckilUserResult seckilUserResult) {
        this.seckilUserResultDao.update(seckilUserResult);
        return this.queryById(seckilUserResult.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.seckilUserResultDao.deleteById(id) > 0;
    }
}