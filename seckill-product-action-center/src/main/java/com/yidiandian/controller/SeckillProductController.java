package com.yidiandian.controller;

import com.yidiandian.feign.client.ProductFeignClient;
import com.yidiandian.request.ProductInfoRequest;
import com.yidiandian.request.SeckillProductRequest;
import com.yidiandian.service.SeckillProductService;
import entity.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    SeckillProductService seckillProductService;

    @ApiOperation( value = "商品上下架操作",notes = "",tags = {"商品信息操作"})
    @PostMapping("/querySeckillProductList")
    public ResponseResult querySeckillProductList(@RequestBody ProductInfoRequest productInfoRequest){
        return productFeignClient.feignQueryProductList( productInfoRequest );
    }

    @ApiOperation( value = "根据ids查询商品信息",notes = "",tags = {"商品信息操作"})
    @PostMapping("/feign/query-productByIds")
    public ResponseResult queryProductByIds(@RequestParam("ids") String ids){
        return productFeignClient.feignQueryProductByIds( ids );
    }

    @ApiOperation( value = "创建秒杀商品信息",notes = "",tags = {"商品信息操作"})
    @PostMapping("/add-seckill-product")
    public ResponseResult addSeckillProduct(@RequestBody SeckillProductRequest seckillProductRequest){
        return seckillProductService.addSeckillProduct(seckillProductRequest);
    }

    @ApiOperation( value = "秒杀商品上下架操作",notes = "",tags = {"商品信息操作"})
    @PostMapping("/upDownSeckillProduct")
    public ResponseResult upDownSeckillProduct(@RequestParam("ids") List<String> ids, @RequestParam("state") int state){
        return seckillProductService.upDownSeckillProduct(ids,state);
    }
}
