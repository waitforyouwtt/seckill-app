package com.yidiandian.service.impl;

import com.yidiandian.applicationContext.BeanContext;
import com.yidiandian.dao.SeckilUserResultDao;
import com.yidiandian.dao.SeckillProductDao;
import com.yidiandian.entity.SeckilUserResult;
import com.yidiandian.entity.SeckillProduct;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/22 21:08
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public class SeckillFuture implements Callable<Integer> {

    private int userId;
    private int id;

    private SeckillProductDao seckillProductDao;

    private SeckilUserResultDao seckilUserResultDao;

    public SeckillFuture(int userId,int id){
        this.userId = userId;
        this.id = id;
    }

    @Override
    public Integer call() throws Exception {

        this.seckillProductDao = BeanContext.getApplicationContext().getBean(SeckillProductDao.class);
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
            seckilUserResult.setResultData("用户"+userId+"秒杀失败！！");
        }else{
            SeckillProduct seckillProductUpdate = new SeckillProduct();
            seckillProductUpdate.setId( id );
            seckillProductUpdate.setSeckillNum( seckillnum );
            int updateResult = seckillProductDao.updateSeckillInfoBySeckNum(seckillProductUpdate);
        }
        //保存秒杀结果表
        this.seckilUserResultDao = BeanContext.getApplicationContext().getBean(SeckilUserResultDao.class);
        seckilUserResultDao.insert(seckilUserResult);
        return seckilUserResult.getResultStatus();
    }
}
