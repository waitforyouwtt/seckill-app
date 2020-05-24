package com.yidiandian.request;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/24 19:49
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ProductInfoRequest implements Serializable {

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
}
