package com.yidiandian.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/30 12:36
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Component
@Aspect
public class SeckillAspect {

    private static Lock lock = new ReentrantLock(  );

    @Pointcut("execution(public * com.yidiandian.service.SeckillActionService.procedureLockByAOP(*,*))")
    public void lockSeckill(){};

    @Around("lockSeckill()")
    public  Object around(ProceedingJoinPoint joinPoint) {
        lock.lock();
        Object obj = null;
        try {
            obj = joinPoint.proceed();
            System.out.println("进入around");
        } catch (Throwable e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
        return obj;
    }
}
