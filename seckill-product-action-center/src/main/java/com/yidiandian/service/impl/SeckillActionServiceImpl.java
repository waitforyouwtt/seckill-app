package com.yidiandian.service.impl;

import com.yidiandian.dao.SeckilUserResultDao;
import com.yidiandian.dao.SeckillProductDao;
import com.yidiandian.entity.SeckilUserResult;
import com.yidiandian.entity.SeckillProduct;
import com.yidiandian.enums.SeckillProductActionBusinessEnum;
import com.yidiandian.request.QueueRequest;
import com.yidiandian.service.SeckillActionService;
import com.yidiandian.utils.RedisLockUtil;
import entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
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

    @Resource
    private SeckilUserResultDao seckilUserResultDao;

    private Lock lock = new ReentrantLock(  );

    private static final String Inventory = "Inventory";
    private static final String Seckillnum = "Seckillnum";

    private ConcurrentHashMap<String,Integer> cacheMap = new ConcurrentHashMap<>(  );

    //通过阻塞队列进行秒杀
    private BlockingQueue<QueueRequest> seckillQueue = new LinkedBlockingDeque<QueueRequest>();

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

    /**
     * 通过乐观锁进行秒杀
     *
     * @param userId
     * @param id
     * @return
     */
    @Override
    public ResponseResult optimisticLock(int userId, int id) {
        SeckillProduct seckillProduct = seckillProductDao.queryById( id );
        int seckillversion = seckillProduct.getSeckillVersion();
        long seckillInventory = seckillProduct.getSeckillInventory();
        int seckillnum = seckillProduct.getSeckillNum();
        if(seckillnum>=seckillInventory){
            return ResponseResult.error( SeckillProductActionBusinessEnum.SALE_COMPLETED.getCode(),SeckillProductActionBusinessEnum.SALE_COMPLETED.getMessage(),null );
        }
        seckillnum++;
        SeckillProduct seckillProductInfoUpate = new SeckillProduct();
        seckillProductInfoUpate.setId(id);
        seckillProductInfoUpate.setSeckillNum(seckillnum);
        seckillProductInfoUpate.setSeckillVersion(seckillversion);
        int result = seckillProductDao.updateSeckillInfoByVersion(seckillProductInfoUpate);
        if (result <= 0){
            return ResponseResult.error( SeckillProductActionBusinessEnum.SALE_COMPLETED.getCode(),SeckillProductActionBusinessEnum.SALE_COMPLETED.getMessage(),null );
        }
        return ResponseResult.success(SeckillProductActionBusinessEnum.SECKILL_SUCCESS.getCode(),SeckillProductActionBusinessEnum.SECKILL_SUCCESS.getMessage(),null);
    }

    @Override
    @Transactional
    public ResponseResult pessimismLock(int userid, int id){
        SeckillProduct seckillProductInfo = seckillProductDao.selectForUpdate(id);

        long seckillInventory = seckillProductInfo.getSeckillInventory();
        int seckillnum = seckillProductInfo.getSeckillNum();

        if(seckillnum>=seckillInventory){
            return ResponseResult.error( SeckillProductActionBusinessEnum.SALE_COMPLETED.getCode(),SeckillProductActionBusinessEnum.SALE_COMPLETED.getMessage(),null );
        }
        seckillnum++;
        SeckillProduct seckillProductInfoUpate = new SeckillProduct();
        seckillProductInfoUpate.setId(id);
        seckillProductInfoUpate.setSeckillNum(seckillnum);
        seckillProductDao.updateSeckillInfoBySeckNum(seckillProductInfoUpate);
        return ResponseResult.success(SeckillProductActionBusinessEnum.SECKILL_SUCCESS.getCode(),SeckillProductActionBusinessEnum.SECKILL_SUCCESS.getMessage(),null);
    }

    /**
     * 通过队列来实现多线程高并发进行秒杀
     *
     * @param userid
     * @param id
     */
    @Override
    public void queueAndThread(int userid, int id) {
        QueueRequest queueRequest = new QueueRequest();
        queueRequest.setUserid(userid);
        queueRequest.setId(id);
        try {
            seckillQueue.put(queueRequest);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过redis来实现进行秒杀操作
     *
     * @param userId
     * @param id
     * @return
     */
    @Override
    public ResponseResult redisDistributeLock(int userId, int id) {

        Map<String,String> dataMap = new HashMap<String,String>();

        boolean haslock = RedisLockUtil.tryGetDistributedLock(id+"",userId+"", 50000);

        if(haslock){
         processSeckill( id,dataMap );
        }else{
            boolean flag = false;
            for(int i=0;i<3;i++){
                haslock = RedisLockUtil.tryGetDistributedLock(id+"",userId+"", 50000);
                if(haslock){
                    processSeckill(id, dataMap);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                dataMap.put("flag","fail");
                dataMap.put("data","太火爆了，请重新抢购");
            }
        }

        boolean releaseResult = RedisLockUtil.releaseDistributedLock(id+"",userId+"");
        while (!releaseResult){
            releaseResult = RedisLockUtil.releaseDistributedLock(id+"",userId+"");
        }
        return ResponseResult.success(dataMap);
    }

    private void processSeckill(int id,Map<String,String> dataMap){
        SeckillProduct seckillProduct = seckillProductDao.queryById( id );
        //库存
        int seckillInventory = seckillProduct.getSeckillInventory();
        //秒杀数量
        int seckillnum = seckillProduct.getSeckillNum();
        seckillnum++;
        if (seckillnum > seckillInventory) {
            dataMap.put("flag","fail");
            dataMap.put("data","卖光了,谢谢惠顾！！");
            return;
        }
        SeckillProduct seckillProductUpdate = new SeckillProduct();
        seckillProductUpdate.setId( id );
        seckillProductUpdate.setSeckillNum( seckillnum );
        int updateResult = seckillProductDao.updateSeckillInfoBySeckNum(seckillProductUpdate);
        if(updateResult>0){
            dataMap.put("flag","success");
            dataMap.put("data","秒杀成功");
        }else{
            dataMap.put("flag","fail");
            dataMap.put("data","秒杀失败，请重新操作");
        }
    }

    //消费queueAndThread 中的队列
    class ConsumerQueueRequest implements Runnable{
        @Override
        public void run() {
            //没有被打断的话进入线程
            while(!Thread.interrupted()){
                try {
                    QueueRequest queueRequest = seckillQueue.take();
                    int userid = queueRequest.getUserid();
                    int id = queueRequest.getId();
                    SeckillProduct seckillProduct = seckillProductDao.queryById( id );
                    Integer inventorynum = seckillProduct.getSeckillInventory();
                    int  seckillnum = seckillProduct.getSeckillNum();
                    seckillnum++;
                    SeckilUserResult seckilUserResult = new SeckilUserResult();
                    seckilUserResult.setProductId(seckillProduct.getProductId());
                    seckilUserResult.setSeckillId(seckillProduct.getId());
                    seckilUserResult.setUserId(userid);
                    seckilUserResult.setResultStatus(0);
                    seckilUserResult.setResultData("用户"+userid+"秒杀成功！！");
                    seckilUserResult.setSeckilTime(new Date());
                    seckilUserResult.setCreateTime( new Date(  ) );
                    seckilUserResult.setUpdateTime( new Date(  ) );
                    if(seckillnum > inventorynum){
                        System.out.println("用户"+userid+"秒杀失败");
                        seckilUserResult.setResultStatus(1);
                        seckilUserResult.setResultData("用户"+userid+"秒杀失败");
                    }else {
                        SeckillProduct seckillProductInfoUpate = new SeckillProduct();
                        seckillProductInfoUpate.setId(id);
                        seckillProductInfoUpate.setSeckillNum(seckillnum);
                        seckillProductDao.updateSeckillInfoBySeckNum(seckillProductInfoUpate);
                    }
                    //保存秒杀结果表
                    seckilUserResultDao.insert(seckilUserResult);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    //配合queueAndThread 中的队列
    public SeckillActionServiceImpl(){
        new Thread(  new ConsumerQueueRequest()).start();
    }
}
