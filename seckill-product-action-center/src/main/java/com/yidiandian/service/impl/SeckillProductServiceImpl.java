package com.yidiandian.service.impl;

import com.yidiandian.entity.SeckillProduct;
import com.yidiandian.dao.SeckillProductDao;
import com.yidiandian.request.SeckillProductRequest;
import com.yidiandian.service.SeckillProductService;
import entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * (SeckillProduct)表服务实现类
 *
 * @author makejava
 * @since 2020-05-25 21:40:59
 */
@Service
@Slf4j
public class SeckillProductServiceImpl implements SeckillProductService {
    @Resource
    private SeckillProductDao seckillProductDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SeckillProduct queryById(Integer id) {
        return this.seckillProductDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SeckillProduct> queryAllByLimit(int offset, int limit) {
        return this.seckillProductDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param seckillProduct 实例对象
     * @return 实例对象
     */
    @Override
    public SeckillProduct insert(SeckillProduct seckillProduct) {
        this.seckillProductDao.insert(seckillProduct);
        return seckillProduct;
    }

    /**
     * 修改数据
     *
     * @param seckillProduct 实例对象
     * @return 实例对象
     */
    @Override
    public SeckillProduct update(SeckillProduct seckillProduct) {
        this.seckillProductDao.update(seckillProduct);
        return this.queryById(seckillProduct.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.seckillProductDao.deleteById(id) > 0;
    }

    /**
     * 秒杀商品上下架操作
     *
     * @param ids
     * @param state
     * @return
     */
    @Override
    public ResponseResult upDownSeckillProduct(List<String> ids, int state) {
        return ResponseResult.success(seckillProductDao.batchUpdateStatus(ids,state));
    }

    /**
     * 创建秒杀商品信息
     *
     * @param seckillProductRequest
     * @return
     */
    @Override
    public ResponseResult addSeckillProduct(SeckillProductRequest seckillProductRequest) {

        SeckillProduct seckillProduct = new SeckillProduct();
        BeanCopier beanCopier = BeanCopier.create(SeckillProductRequest.class,SeckillProduct.class,false  );
        beanCopier.copy( seckillProductRequest,seckillProduct,null );
        seckillProduct.setApproveTime( new Date(  ) );
        try {
            seckillProduct.setStartTime( DateUtils.parseDate( seckillProductRequest.getStartTime(),"yyyy-MM-dd hh:mm:ss" )  );
            seckillProduct.setEndTime( DateUtils.parseDate( seckillProductRequest.getEndTime(),"yyyy-MM-dd hh:mm:ss" ) );
        } catch (ParseException e) {
            log.error( "日期转换错误：{}",e.getMessage() );
        }
        seckillProduct.setState( 0 );
        seckillProduct.setCreateTime( new Date(  ) );
        seckillProduct.setUpdateTime( new Date(  ) );
        seckillProductDao.insert( seckillProduct );
        return ResponseResult.success(seckillProductRequest);
    }
}