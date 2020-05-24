package com.yidiandian.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (ProductDetail)实体类
 *
 * @author makejava
 * @since 2020-05-24 19:06:49
 */
@Data
public class ProductDetail implements Serializable {
    private static final long serialVersionUID = 583713481753066121L;
    /**
    * 自增ID
    */
    private Integer id;
    /**
    * 商品id
    */
    private Integer productId;
    /**
    * 商品产地
    */
    private String productPalce;
    /**
    * 商品品牌
    */
    private String productBrand;
    /**
    * 商品描述
    */
    private String productDecsrption;
    /**
    * 商品重量
    */
    private Double productWeight;
    /**
    * 商品详情图片地址
    */
    private String productDetailPcitureUrl;
    /**
    * 规格和包装
    */
    private String specificationPack;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;
}