package com.yidiandian.strategy;

import entity.ResponseResult;

import java.util.Map;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/7/16 22:14
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public interface SeckillOperator {

    /**
     * 用户id & 商品id
     * @param userid
     * @param id
     * @return
     */
    ResponseResult seckillBy(int userid, int id);
}
