package com.yidiandian.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (ProductType)实体类
 *
 * @author makejava
 * @since 2020-05-24 18:19:11
 */
@Data
public class ProductType implements Serializable {
    private static final long serialVersionUID = -72112660452884906L;
    
    private Integer id;
    /**
    * 类型名称
    */
    private String productTypeName;
    /**
    * 类型描述
    */
    private String productTypeDescription;
    /**
    * 父级ID
    */
    private Integer parentId;
    /**
    * 等级
    */
    private Integer grade;
    /**
    * 状态：0正常 1 禁用
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