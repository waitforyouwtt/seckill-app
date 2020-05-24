package com.yidiandian.service;

import com.yidiandian.request.MerchantRequest;
import entity.ResponseResult;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/23 22:17
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public interface MerchantService {
    /**
     * 添加商家信息
     * @param merchantRequest
     * @return
     */
    ResponseResult addMerchant(MerchantRequest merchantRequest);
}
