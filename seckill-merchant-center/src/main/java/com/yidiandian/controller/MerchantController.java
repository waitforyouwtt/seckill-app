package com.yidiandian.controller;

import com.yidiandian.request.MerchantRequest;
import com.yidiandian.service.MerchantService;
import entity.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/23 22:28
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@RestController
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @ApiOperation( value = "商家入驻",notes = "id不能为空",tags = {"商家信息信息操作"})
    @PostMapping("/addMerchant")
    public ResponseResult addMerchant(@RequestBody MerchantRequest merchantRequest){
        return merchantService.addMerchant(merchantRequest);
    }

    @ApiOperation( value = "商家登录",notes = "用户名 & 密码不能为空",tags = {"商家信息信息操作"})
    @PostMapping("/login")
    public ResponseResult login(){
        return ResponseResult.success();
    }

}
