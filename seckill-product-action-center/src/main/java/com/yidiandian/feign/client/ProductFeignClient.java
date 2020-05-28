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
    ResponseResult feignQueryProductList(@RequestBody ProductInfoRequest productInfoRequest);

    @PostMapping("/feign/query-productByIds")
    ResponseResult feignQueryProductByIds(@RequestParam("ids") String ids);

}
