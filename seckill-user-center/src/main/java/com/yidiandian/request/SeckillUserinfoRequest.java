package com.yidiandian.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/23 14:54
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
@ApiModel(value="app用户对象信息",description="app用户对象信息")
public class SeckillUserinfoRequest implements Serializable {

    /**
     * 用户真实姓名
     */
    @ApiModelProperty(value="用户名",name="userName")
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户密码
     */
    @ApiModelProperty(value="密码",name="password")
    @NotEmpty(message = "用户密码不能为空")
    private String password;
    /**
     * 用户身份证号
     */
    @ApiModelProperty(value="身份证号",name="idCard")
    @NotEmpty(message = "身份证号不能为空")
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

}
