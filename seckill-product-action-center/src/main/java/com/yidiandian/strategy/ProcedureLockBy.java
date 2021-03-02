package com.yidiandian.strategy;

import com.yidiandian.service.SeckillActionService;
import entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/7/16 22:17
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class ProcedureLockBy implements SeckillOperator {

    private SeckillActionService seckillActionService;

    private Lock lock = new ReentrantLock(  );

    public ProcedureLockBy(SeckillActionService seckillActionService){
        this.seckillActionService = seckillActionService;
    }

    @Transactional
    @Override
    public ResponseResult seckillBy(int userid, int id) {
        return seckillActionService.procedureLockBy(userid,id);
    }
}
