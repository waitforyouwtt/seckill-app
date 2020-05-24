package com.yidiandian.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Shop)实体类
 *
 * @author makejava
 * @since 2020-05-24 11:14:29
 */
@Data
public class Shop implements Serializable {
    private static final long serialVersionUID = 166178915610728349L;
    
    private Integer id;
    /**
    * 商家id
    */
    private Integer merchantId;
    /**
    * 店铺名称
    */
    private String shopName;
    /**
    * 店铺头像
    */
    private String shopImage;
    /**
    * 店铺描述
    */
    private String shopDescription;
    
    private String shopBusinessScope;
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
    * 营业执照
    */
    private String businessLicense;
    /**
    * 状态：0申请中 1 申请通过 2 退回 3 商铺下架
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