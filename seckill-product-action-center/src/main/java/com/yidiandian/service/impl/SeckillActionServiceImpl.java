package com.yidiandian.service.impl;

import com.yidiandian.dao.SeckillProductDao;
import com.yidiandian.entity.SeckillProduct;
import com.yidiandian.enums.SeckillProductActionBusinessEnum;
import com.yidiandian.service.SeckillActionService;
import entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/30 11:06
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class SeckillActionServiceImpl implements SeckillActionService {

    @Autowired
    private SeckillProductDao seckillProductDao;

    private Lock lock = new ReentrantLock(  );

    private static final String Inventory = "Inventory";
    private static final String Seckillnum = "Seckillnum";

    private ConcurrentHashMap<String,Integer> cacheMap = new ConcurrentHashMap<>(  );

    /**
     * 通过程序锁进行秒杀
     * @param userId
     * @param id
     * @return
     */
    @Transactional
    @Override
    public ResponseResult procedureLockBy(int userId, int id) {
        lock.lock();
        try{
            SeckillProduct seckillProduct = seckillProductDao.queryById( id );
            //库存
            int seckillInventory = seckillProduct.getSeckillInventory();
            //秒杀数量
            int seckillnum = seckillProduct.getSeckillNum();
            seckillnum++;
            if (seckillnum > seckillInventory) {
                return ResponseResult.error( SeckillProductActionBusinessEnum.SALE_COMPLETED.getCode(),SeckillProductActionBusinessEnum.SALE_COMPLETED.getMessage(),null );
            }
            SeckillProduct seckillProductUpdate = new SeckillProduct();
            seckillProductUpdate.setId( id );
            seckillProductUpdate.setSeckillNum( seckillnum );
            seckillProductDao.updateSeckillInfoBySeckNum(seckillProductUpdate);
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
        return ResponseResult.success(SeckillProductActionBusinessEnum.SECKILL_SUCCESS.getCode(),SeckillProductActionBusinessEnum.SECKILL_SUCCESS.getMessage(),null);
    }

    /**
     * 通过程序锁进行秒杀，且通过aop 切面编程解决超卖现象
     *
     * @param userId
     * @param id
     * @return
     */
    @Transactional
    @Override
    public ResponseResult procedureLockByAOP(int userId, int id) {
        SeckillProduct seckillProduct = seckillProductDao.queryById( id );
        //库存
        int seckillInventory = seckillProduct.getSeckillInventory();
        //秒杀数量
        int seckillnum = seckillProduct.getSeckillNum();
        seckillnum++;
        if (seckillnum > seckillInventory) {
            return ResponseResult.error( SeckillProductActionBusinessEnum.SALE_COMPLETED.getCode(),SeckillProductActionBusinessEnum.SALE_COMPLETED.getMessage(),null );
        }
        SeckillProduct seckillProductUpdate = new SeckillProduct();
        seckillProductUpdate.setId( id );
        seckillProductUpdate.setSeckillNum( seckillnum );
        seckillProductDao.updateSeckillInfoBySeckNum(seckillProductUpdate);
        return ResponseResult.success(SeckillProductActionBusinessEnum.SECKILL_SUCCESS.getCode(),SeckillProductActionBusinessEnum.SECKILL_SUCCESS.getMessage(),null);
    }

    /**
     * 通过多线程进行秒杀操作
     *
     * @param userId
     * @param id
     * @return
     */
    @Override
    public void multiThread(int userId, int id) {
       Integer inventoryNum =  cacheMap.get( Inventory+id );
       if (inventoryNum == null){
           SeckillProduct seckillProduct = seckillProductDao.queryById( id );
           cacheMap.put(Inventory+id,Integer.valueOf(seckillProduct.getSeckillInventory()+""));
           cacheMap.put(Seckillnum+id,seckillProduct.getSeckillNum());
       }
        inventoryNum = cacheMap.get(Inventory+id);//库存
        Integer seckillnum = cacheMap.get(Seckillnum+id);//秒杀数量
        seckillnum++;
        cacheMap.put(Seckillnum+id,seckillnum);
        //用户名 ，秒杀数量 ，库存，商品ID
        new Thread( new SeckillThread(userId,seckillnum,inventoryNum,id) ).start();
    }
}
