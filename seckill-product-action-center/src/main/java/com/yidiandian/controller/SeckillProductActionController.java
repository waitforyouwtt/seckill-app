package com.yidiandian.controller;

import com.yidiandian.service.SeckillActionService;
import entity.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/30 11:55
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@RestController
public class SeckillProductActionController {

    @Autowired
    SeckillActionService seckillActionService;

    @ApiOperation( value = "通过程序锁进行秒杀操作",notes = "",tags = {"商品秒杀操作"})
    @PostMapping("/procedureLockBy")
    public ResponseResult procedureLockBy(@RequestParam("userId") int userId,@RequestParam("id") int id){
        return seckillActionService.procedureLockBy( userId,id );
    }

    @ApiOperation( value = "通过程序锁AOP解决超卖问题进行秒杀操作",notes = "",tags = {"商品秒杀操作"})
    @PostMapping("/procedureLockByAOP")
    public ResponseResult procedureLockByAOP(@RequestParam("userId") int userId,@RequestParam("id") int id){
        return seckillActionService.procedureLockByAOP( userId,id );
    }

    @ApiOperation( value = "通过多线程进行秒杀操作",notes = "",tags = {"商品秒杀操作"})
    @PostMapping("/multiThread")
    public void multiThread(@RequestParam("userId") int userId,@RequestParam("id") int id){
        seckillActionService.multiThread(userId,id);
    }
}
