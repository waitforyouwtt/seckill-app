package com.yidiandian.feign.services;

import com.yidiandian.request.ProductDetailRequest;
import com.yidiandian.request.ProductInfoRequest;
import com.yidiandian.service.ProductInfoService;
import entity.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/25 21:32
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@RestController
public class ProductFeignService {

    @Autowired
    ProductInfoService productInfoService;

/*    @ApiOperation( value = "添加商品信息",notes = "",tags = {"商品信息信息操作"})
    @PostMapping("/add-product")
    public ResponseResult addProduct(@RequestBody ProductInfoRequest productInfoRequest){
        return productInfoService.addProduct(productInfoRequest);
    }

    @ApiOperation( value = "补充商品详情信息",notes = "",tags = {"商品信息信息操作"})
    @PostMapping("/add-product-detail")
    public ResponseResult addProductDetail(@RequestBody ProductDetailRequest productDetailRequest){
        return productInfoService.addProductDetail(productDetailRequest);
    }*/

    @ApiOperation( value = "查询商品集合信息",notes = "",tags = {"商品信息信息操作"})
    @PostMapping("/feign/query-productList")
    public ResponseResult feignQueryProductList(@RequestBody ProductInfoRequest productInfoRequest){
        return productInfoService.queryProduct(productInfoRequest);
    }

    @ApiOperation( value = "商品上下架操作",notes = "",tags = {"商品信息信息操作"})
    @PostMapping("/feign/up-down-product")
    public ResponseResult feignUpOrDownProduct(@RequestParam("id") int id, @RequestParam("state") int state){
        return productInfoService.upOrDownProduct(id,state);
    }
}
