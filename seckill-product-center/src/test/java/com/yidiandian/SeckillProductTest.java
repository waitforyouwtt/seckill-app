package com.yidiandian;

import com.yidiandian.service.ProductInfoService;
import entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/27 22:43
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class SeckillProductTest extends SeckillProductCenterApplicationTests {

    @Autowired
    ProductInfoService productInfoService;

    @Test
    public void contextLoads() {

        ResponseResult responseResult = productInfoService.queryProductByIds( "1,2" );

        log.info( "根据id集合查询商品集合信息：{}",responseResult );
    }
}
