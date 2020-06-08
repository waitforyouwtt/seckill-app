package com.yidiandian.service;

import entity.ResponseResult;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/30 11:05
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public interface SeckillActionService {

    /**
     * 通过程序锁进行秒杀
     * 但线程跑没问题，但是多个用户同时秒杀，
     * 会有问题，因为还没来得及释放锁，下一个用户就进来了
     * 读的还是上一个锁的秒杀数量呢
     * @param userId
     * @param id
     * @return
     */
    ResponseResult procedureLockBy(int userId, int id);

    /**
     * 通过程序锁进行秒杀，且通过aop 切面编程解决超卖现象
     * @param userId
     * @param id
     * @return
     */
    ResponseResult procedureLockByAOP(int userId,int id);

    /**
     * 通过多线程进行秒杀操作
     * @param userId
     * @param id
     * @return
     */
    void multiThread(int userId, int id);

    /**
     * 通过乐观锁进行秒杀
     * @param userId
     * @param id
     * @return
     */
    ResponseResult optimisticLock(int userId, int id);

    /**
     * 通过悲观锁进行秒杀
     * @param userid
     * @param id
     * @return
     */
    ResponseResult pessimismLock(int userid, int id);

    /**
     * 通过队列来实现多线程高并发进行秒杀
     * @param userid
     * @param id
     */
    void queueAndThread(int userid, int id);
}
