package com.yidiandian.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/24 19:53
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ProductDetailRequest implements Serializable {

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
}
