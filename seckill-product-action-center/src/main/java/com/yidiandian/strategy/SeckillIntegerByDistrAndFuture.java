package com.yidiandian.strategy;

import com.yidiandian.service.SeckillIntegrationByService;
import entity.ResponseResult;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2021/3/2 23:05
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public class SeckillIntegerByDistrAndFuture implements SeckillOperator{

    private SeckillIntegrationByService seckillIntegerByService;

    public SeckillIntegerByDistrAndFuture(){

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
        return null;
    }
}
