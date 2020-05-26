package com.yidiandian.feign.client;

import com.yidiandian.request.ProductInfoRequest;
import entity.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/25 21:49
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
//value 指的是调用服务者的spring.application.name
@FeignClient(value = "seckill-product-center")
public interface ProductFeignClient {

    @PostMapping("/feign/query-productList")
    public ResponseResult feignQueryProductList(@RequestBody ProductInfoRequest productInfoRequest);

    @ApiOperation( value = "商品上下架操作",notes = "",tags = {"商品信息信息操作"})
    @PostMapping("/feign/up-down-product")
    public ResponseResult feignUpOrDownProduct(@RequestParam("id") int id, @RequestParam("state") int state);
}
