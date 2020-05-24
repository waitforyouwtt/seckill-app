package com.yidiandian.controller;

import com.yidiandian.request.MerchantRequest;
import com.yidiandian.service.MerchantService;
import entity.ResponseResult;
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

    @PostMapping("/addMerchant")
    public ResponseResult addMerchant(@RequestBody MerchantRequest merchantRequest){
        return merchantService.addMerchant(merchantRequest);
    }
}
