package com.yidiandian.service.impl;

import com.yidiandian.dao.SeckilUserResultDao;
import com.yidiandian.dao.SeckillProductDao;
import com.yidiandian.entity.SeckilUserResult;
import com.yidiandian.entity.SeckillProduct;
import com.yidiandian.entity.SeckillUnique;
import com.yidiandian.service.SeckillActionService2;
import com.yidiandian.utils.RedisLockUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/7/5 21:36
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class SeckillActionServiceImpl2 implements SeckillActionService2 {

    @Autowired
    private SeckillProductDao seckillProductDao;

    @Resource
    private SeckilUserResultDao seckilUserResultDao;

    private Map<SeckillUnique,Future<SeckilUserResult>> cacheSeckillResultMap = new HashMap<SeckillUnique,Future<SeckilUserResult>>();

    private ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 分布式锁整合future异步封装秒杀操作
     *
     * @param userId
     * @param id
     */
    @Override
    public Map<SeckillUnique, Future<SeckilUserResult>> seckillIntegrByDistrAndFuture(int userId, int id) {
        SeckillFuture2 seckillFuture = new SeckillFuture2(userId,id);
        Future<SeckilUserResult> reuslt = executorService.submit(seckillFuture);
        SeckillUnique seckillUnique = new SeckillUnique(userId,id);
        cacheSeckillResultMap.put(seckillUnique,reuslt);
        return cacheSeckillResultMap;
    }

    class SeckillFuture2 implements Callable<SeckilUserResult> {
        private Integer userId;
        private Integer id;

        public SeckillFuture2(Integer userId,Integer id){
            this.userId = userId;
            this.id = id;
        }

        @Override
        public SeckilUserResult call() throws Exception {
            try{
                boolean haslock = RedisLockUtil.tryGetDistributedLock(id+"",userId+"", 50000);
                if (!haslock) {
                    while (!haslock) {
                        haslock = RedisLockUtil.tryGetDistributedLock(id + "", userId + "", 50000);
                    }
                }
                SeckillProduct seckillProduct = seckillProductDao.queryById( id );
                //库存
                int seckillInventory = seckillProduct.getSeckillInventory();
                //秒杀数量
                int seckillnum = seckillProduct.getSeckillNum();
                seckillnum++;

                SeckilUserResult seckilUserResult = new SeckilUserResult();
                seckilUserResult.setProductId(seckillProduct.getProductId());
                seckilUserResult.setSeckillId(seckillProduct.getId());
                seckilUserResult.setUserId(userId);
                seckilUserResult.setResultStatus(0);
                seckilUserResult.setResultData("用户"+userId+"秒杀成功！！");
                seckilUserResult.setSeckilTime(new Date());
                seckilUserResult.setCreateTime( new Date(  ) );
                seckilUserResult.setUpdateTime( new Date(  ) );

                if (seckillnum > seckillInventory) {
                    seckilUserResult.setResultStatus(1);
                    seckilUserResult.setResultData("用户"+userId+"秒杀失败");
                }else{
                    SeckillProduct seckillProductInfoUpate = new SeckillProduct();
                    seckillProductInfoUpate.setId(id);
                    seckillProductInfoUpate.setSeckillNum(seckillnum);
                    seckillProductDao.updateSeckillInfoBySeckNum(seckillProductInfoUpate);
                }
                //保存秒杀结果表
                seckilUserResultDao.insert(seckilUserResult);
                return seckilUserResult;
            }finally {
                boolean releaselock = RedisLockUtil.releaseDistributedLock(id+"",userId + "");
                if (!releaselock) {
                    while (!releaselock) {
                        releaselock = RedisLockUtil.releaseDistributedLock(id + "", userId + "");
                    }
                }
            }
        }
    }
}
