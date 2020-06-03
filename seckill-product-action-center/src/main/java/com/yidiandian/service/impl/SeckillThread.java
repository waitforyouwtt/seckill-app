package com.yidiandian.service.impl;

import com.yidiandian.dao.SeckilUserResultDao;
import com.yidiandian.dao.SeckillProductDao;
import com.yidiandian.entity.SeckilUserResult;
import com.yidiandian.entity.SeckillProduct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/2 21:43
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public class SeckillThread implements Runnable{

    private int userid;
    private int seckillnum;
    private int inventorynum;
    private int id;

    @Autowired
    SeckillProductDao seckillProductDao;

    @Autowired
    SeckilUserResultDao seckilUserResultDao;

    public SeckillThread(int userid,int seckillnum,int inventorynum,int id){
        this.inventorynum = inventorynum;
        this.seckillnum = seckillnum;
        this.userid = userid;
        this.id = id;
    }

    @Override
    public void run() {
        SeckilUserResult seckilUserResult = new SeckilUserResult();
        SeckillProduct seckillProduct = seckillProductDao.queryById( id );
        seckilUserResult.setProductId(seckillProduct.getProductId());
        seckilUserResult.setSeckillId(seckillProduct.getId());
        seckilUserResult.setUserId(userid);
        seckilUserResult.setResultStatus(0);
        seckilUserResult.setResultData("用户"+userid+"秒杀成功！！");
        seckilUserResult.setSeckilTime(new Date());
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
    }
}
