package com.yidiandian.controller;

import com.yidiandian.entity.Shop;
import com.yidiandian.enums.ShopBusinessEnums;
import com.yidiandian.request.ShopRequest;
import com.yidiandian.service.ShopService;
import entity.ResponseResult;
import exception.BusinessException;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/24 11:35
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@RestController
@Slf4j
public class ShopController {

    @Autowired
    ShopService shopService;

    @ApiOperation( value = "商家申请店铺",notes = "",tags = {"店铺信息信息操作"})
    @PostMapping("apply-shop")
    public ResponseResult applyShop(@RequestBody @Valid ShopRequest shopRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error( "【商家入驻】参数不正确，userinfoRequest={}",shopRequest );
            throw  new BusinessException( ShopBusinessEnums.PARAMS_IS_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage() );
        }
        return shopService.applyShop(shopRequest);
    }

    @ApiOperation( value = "店铺查询",notes = "",tags = {"店铺信息信息操作"})
    @PostMapping("query-shop")
    public ResponseResult queryShop(@RequestParam("state") int state){
        return shopService.queryShop(state);
    }

    @ApiOperation( value = "审核店铺",notes = "",tags = {"店铺信息信息操作"})
    @PostMapping("examine-shop")
    public ResponseResult examineShop(@RequestParam("state") int state,@RequestParam("id") int id){
        return shopService.examineShop( id,state );
    }
}
