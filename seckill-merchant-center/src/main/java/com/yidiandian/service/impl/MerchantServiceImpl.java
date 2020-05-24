package com.yidiandian.service.impl;

import com.utils.Md5Util;
import com.yidiandian.dao.MerchantDao;
import com.yidiandian.entity.Merchant;
import com.yidiandian.request.MerchantRequest;
import com.yidiandian.service.MerchantService;
import entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/23 22:17
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class MerchantServiceImpl implements MerchantService {

    @Value( "${md5.private.key}" )
    private String md5Key;

    @Autowired
    MerchantDao merchantDao;
    /**
     * 添加商家信息
     *
     * @param merchantRequest
     * @return
     */
    @Override
    public ResponseResult addMerchant(MerchantRequest merchantRequest) {
        Merchant merchant = new Merchant();
        BeanCopier beanCopier= BeanCopier.create(  MerchantRequest.class,Merchant.class,false);
        beanCopier.copy( merchantRequest,merchant,null );
        if (queryParams(merchant) != null){
            return ResponseResult.error( "商家已存在" );
        }
        merchant.setAccount( merchantRequest.getPhone() );
        merchant.setPassword( Md5Util.md5( merchantRequest.getPassword(),md5Key ) );
        merchant.setStatus( 0 );
        merchant.setCreateTime( new Date(  ) );
        merchant.setUpdateTime( new Date(  ) );
        merchantDao.insert( merchant );
        return ResponseResult.success( merchant );
    }

    public Merchant queryParams(Merchant merchant){
        Merchant merchanParams = new Merchant();
        merchanParams.setPhone( merchant.getPhone() );
        List<Merchant> merchants = merchantDao.queryAll( merchanParams );
        if (CollectionUtils.isEmpty( merchants )){
            return null;
        }
        return merchants.get( 0 );
    }


}
