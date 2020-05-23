package com.yidiandian.controller;

import com.yidiandian.entity.SeckillUserinfo;
import com.yidiandian.enums.UserBusinessEnums;
import com.yidiandian.request.SeckillLoginRequest;
import com.yidiandian.request.SeckillUserinfoRequest;
import com.yidiandian.service.SeckillUserinfoService;
import entity.ResponseResult;
import exception.BusinessException;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


/**
 * (SeckillUserinfo)表控制层
 *
 * @author makejava
 * @since 2020-05-23 11:14:31
 */
@RestController
@Slf4j
public class SeckillUserinfoController {
    /**
     * 服务对象
     */
    @Autowired
    private SeckillUserinfoService seckillUserinfoService;

    @ApiOperation( value = "用户注册",notes = "用户名/身份证/密码不能为空",tags = {"用户信息操作"})
    @PostMapping("/register")
    public ResponseResult register(@RequestBody @Valid SeckillUserinfoRequest userinfoRequest,
                                   HttpServletRequest request, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error( "【用户注册】参数不正确，userinfoRequest={}",userinfoRequest );
            throw  new BusinessException( UserBusinessEnums.PARAMS_IS_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage() );
        }
        request.getRemoteAddr();
        return seckillUserinfoService.register(userinfoRequest);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation( value = "根据id查询用户信息",notes = "id不能为空",tags = {"用户信息操作"})
    @GetMapping("/findUserById/{id}")
    public SeckillUserinfo selectOne(@PathVariable Integer id) {
        return this.seckillUserinfoService.queryById(id);
    }

    @ApiOperation( value = "用户登录",tags = {"用户信息操作"})
    @PostMapping("/login")
    public ResponseResult login(@RequestBody @Valid SeckillLoginRequest seckillLoginRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error( "【用户登录】参数不正确，userinfoRequest={}",seckillLoginRequest );
            throw  new BusinessException( UserBusinessEnums.PARAMS_IS_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage() );
        }
      return seckillUserinfoService.login(seckillLoginRequest);
    }

}