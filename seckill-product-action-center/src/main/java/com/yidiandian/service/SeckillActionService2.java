package com.yidiandian.service;

import com.yidiandian.entity.SeckilUserResult;
import com.yidiandian.entity.SeckillUnique;
import entity.ResponseResult;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/30 11:05
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public interface SeckillActionService2 {

    /**
     * 分布式锁整合future异步封装秒杀操作
     * @param userId
     * @param id
     */
    Map<SeckillUnique, Future<SeckilUserResult>> seckillIntegrByDistrAndFuture(int userId, int id);
}
