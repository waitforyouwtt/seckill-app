package com.yidiandian.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
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
public class SeckillLoginRequest implements Serializable {

    /**
     * 用户真实姓名
     */
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    /**
     * 用户密码
     */
    @NotEmpty(message = "用户密码不能为空")
    private String password;


}
