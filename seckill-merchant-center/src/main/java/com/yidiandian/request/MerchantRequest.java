package com.yidiandian.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/23 22:29
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class MerchantRequest implements Serializable {

    /**
     * 商家名称
     */
    private String merchantName;
    /**
     * 密码
     */
    private String password;

    private String phone;
    /**
     * 省份
     */
    private String province;

    private String city;

    private String area;
    /**
     * 商家详细地址
     */
    private String merchantAddress;
}
