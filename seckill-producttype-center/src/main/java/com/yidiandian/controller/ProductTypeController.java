package com.yidiandian.controller;

import com.yidiandian.request.ProductTypeRequest;
import com.yidiandian.service.ProductTypeService;
import entity.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/24 18:21
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@RestController
public class ProductTypeController {

    @Autowired
    ProductTypeService productTypeService;

    @ApiOperation( value = "添加商品分类",notes = "",tags = {"分类信息信息操作"})
    @PostMapping("/add-product-type")
    public ResponseResult addProductType(@RequestBody ProductTypeRequest productTypeRequest){
        return productTypeService.addProductType(productTypeRequest);
    }
}
