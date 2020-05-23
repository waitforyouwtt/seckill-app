package com.yidiandian.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (SeckillUserinfo)实体类
 *
 * @author makejava
 * @since 2020-05-23 11:15:17
 */
@Data
public class SeckillUserinfo implements Serializable {
    private static final long serialVersionUID = 411275139921474273L;
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 用户id
    */
    private String userId;
    /**
    * 用户真实姓名
    */
    private String userName;
    /**
    * 用户昵称
    */
    private String nickName;
    /**
    * 用户密码
    */
    private String password;
    /**
    * 用户身份证号
    */
    private String idCard;
    /**
    * 用户年龄
    */
    private Integer age;
    /**
    * 用户生日
    */
    private Date birthday;
    /**
    * 用户性别： 0 男 1女
    */
    private Integer gender;
    /**
    * 用户微信号
    */
    private String weChat;
    /**
    * 用户qq
    */
    private String qq;
    /**
    * 用户手机号
    */
    private String phone;
    /**
    * 用户备用手机号
    */
    private String telPhone;
    /**
    * 用户详细住址
    */
    private String homeAddress;
    /**
    * 用户状态：0 正常 2 禁用
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