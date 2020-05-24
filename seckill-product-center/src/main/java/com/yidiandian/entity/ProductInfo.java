package com.yidiandian.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * (Productinfo)实体类
 *
 * @author makejava
 * @since 2020-05-24 19:06:04
 */
@Data
public class ProductInfo implements Serializable {
    private static final long serialVersionUID = 829175362896701741L;
    /**
    * 自增ID
    */
    private Integer id;
    /**
    * 商品标题
    */
    private String productTitle;
    /**
    * 商品名称
    */
    private String productName;
    /**
    * 商品图片地址
    */
    private String productPictureUrl;
    /**
    * 商品价格
    */
    private BigDecimal productPrice;
    /**
    * 商品优惠价格
    */
    private BigDecimal productDiscounts;
    /**
    * 商家id
    */
    private Integer mechantId;
    /**
    * 商品类型id
    */
    private Integer productTypeId;
    /**
    * 商品库存量
    */
    private Long productInventory;
    /**
    * 商铺id
    */
    private Integer shopId;
    /**
    * 0申请中1审核通过2退回3上架4下架
    */
    private Integer state;
    /**
    * 审核时间
    */
    private Date approveTime;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;

}