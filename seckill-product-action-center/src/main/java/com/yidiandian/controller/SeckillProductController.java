package com.yidiandian.controller;

import com.yidiandian.feign.client.ProductFeignClient;
import com.yidiandian.request.ProductInfoRequest;
import entity.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/25 22:02
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@RestController
public class SeckillProductController {

    @Autowired
    ProductFeignClient productFeignClient;

    @ApiOperation( value = "商品上下架操作",notes = "",tags = {"商品信息信息操作"})
    @PostMapping("/querySeckillProductList")
    public ResponseResult querySeckillProductList(@RequestBody ProductInfoRequest productInfoRequest){
        return ResponseResult.success(productFeignClient.feignQueryProductList( productInfoRequest ));
    }

    @ApiOperation( value = "商品上下架操作",notes = "",tags = {"商品信息信息操作"})
    @PostMapping("/upDownSeckillProduct")
    public ResponseResult upDownSeckillProduct(@RequestParam("id") int id, @RequestParam("state") int state){
        return productFeignClient.feignUpOrDownProduct(id,state);
    }
}
