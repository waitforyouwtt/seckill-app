package com.yidiandian.strategy;

import com.yidiandian.service.SeckillIntegrationByService;
import entity.ResponseResult;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2021/3/2 23:05
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public class SeckillIntegrByDistrAndFuture implements SeckillOperator{

    private Lock lock = new ReentrantLock(  );

    private SeckillIntegrationByService seckillIntegerByService;

    public SeckillIntegrByDistrAndFuture(SeckillIntegrationByService seckillIntegerByService){
        this.seckillIntegerByService = seckillIntegerByService;
    }
    /**
     * 用户id & 商品id
     *
     * @param userid
     * @param id
     * @return
     */
    @Override
    public ResponseResult seckillBy(int userid, int id) {
        seckillIntegerByService.seckillIntegrByDistrAndFutrure( userid,id );

        return null;
    }
}
