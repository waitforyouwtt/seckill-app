package com.yidiandian.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/24 11:36
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ShopRequest implements Serializable {

    /**
     * 商家id
     */
   // @NotEmpty(message = "商家ID不能为空")
    private int merchantId;
    /**
     * 店铺名称
     */
    @NotEmpty(message = "店铺名称不能为空")
    private String shopName;
    /**
     * 店铺头像
     */
    @NotEmpty(message = "店铺头像不能为空")
    private String shopImage;
    /**
     * 店铺描述
     */
    @NotEmpty(message = "店铺描述不能为空")
    private String shopDescription;

    /**
     * 经营范围
     */
    @NotEmpty(message = "经营范围不能为空")
    private String shopBusinessScope;
    /**
     * 省份
     */
    @NotEmpty(message = "省份不能为空")
    private String province;
    /**
     * 城市
     */
    @NotEmpty(message = "城市不能为空")
    private String city;
    /**
     * 区域
     */
    @NotEmpty(message = "区域不能为空")
    private String area;
    /**
     * 营业执照
     */
    @NotEmpty(message = "营业执照不能为空")
    private String businessLicense;
}
