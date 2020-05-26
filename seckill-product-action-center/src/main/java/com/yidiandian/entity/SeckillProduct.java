package com.yidiandian.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * (SeckillProduct)实体类
 *
 * @author makejava
 * @since 2020-05-25 21:41:54
 */
@Data
public class SeckillProduct implements Serializable {
    private static final long serialVersionUID = 212874204229582740L;
    /**
    * 自增ID
    */
    private Integer id;
    /**
    * 商品id
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
    private Date startTime;
    /**
    * 结束时间
    */
    private Date endTime;
    /**
    * 商铺id
    */
    private Integer shopId;
    /**
    * 0申请中1审核通过2退回3上架4下架
    */
    private Integer state;
    /**
    * 商品价格
    */
    private BigDecimal productPrice;
    /**
    * 商品title
    */
    private String productTitle;
    /**
    * 商品名称
    */
    private String productName;
    /**
    * 审核时间
    */
    private Date approveTime;
    /**
    * 版本号
    */
    private Integer seckillVersion;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;
}