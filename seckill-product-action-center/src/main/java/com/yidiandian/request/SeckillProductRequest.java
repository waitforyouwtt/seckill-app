package com.yidiandian.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/27 22:59
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class SeckillProductRequest extends ProductInfoRequest {

    /**
     * 商品Id
     */
    private Integer productId;

    /**
     * 秒杀数量
     */
    private Integer seckillNum;
    /**
     * 秒杀价格
     */
    private BigDecimal seckillPrice;
    /**
     * 秒杀库存
     */
    private Integer seckillInventory;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;

}
