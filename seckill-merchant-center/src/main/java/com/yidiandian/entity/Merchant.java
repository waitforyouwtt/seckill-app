package com.yidiandian.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Merchant)实体类
 *
 * @author makejava
 * @since 2020-05-23 21:52:43
 */
@Data
public class Merchant implements Serializable {
    private static final long serialVersionUID = 796458515042641237L;
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 商家账号
    */
    private String account;
    /**
    * 商家名称
    */
    private String merchantName;
    /**
    * 密码
    */
    private String password;

    /**
     * 联系方式
     */
    private String phone;
    /**
    * 省份
    */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 区域
     */
    private String area;
    /**
    * 商家详细地址
    */
    private String merchantAddress;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;
}