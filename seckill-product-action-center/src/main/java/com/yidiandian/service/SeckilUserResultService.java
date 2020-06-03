package com.yidiandian.service;

import com.yidiandian.entity.SeckilUserResult;
import java.util.List;

/**
 * (SeckilUserResult)表服务接口
 *
 * @author makejava
 * @since 2020-05-30 13:01:26
 */
public interface SeckilUserResultService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SeckilUserResult queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SeckilUserResult> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param seckilUserResult 实例对象
     * @return 实例对象
     */
    SeckilUserResult insert(SeckilUserResult seckilUserResult);

    /**
     * 修改数据
     *
     * @param seckilUserResult 实例对象
     * @return 实例对象
     */
    SeckilUserResult update(SeckilUserResult seckilUserResult);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}