package com.yidiandian.service.impl;

import com.yidiandian.entity.Shop;
import com.yidiandian.dao.ShopDao;
import com.yidiandian.request.ShopRequest;
import com.yidiandian.service.ShopService;
import entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * (Shop)表服务实现类
 *
 * @author makejava
 * @since 2020-05-24 11:14:32
 */
@Service
@Slf4j
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Shop queryById(Integer id) {
        return this.shopDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Shop> queryAllByLimit(int offset, int limit) {
        return this.shopDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    @Override
    public Shop insert(Shop shop) {
        this.shopDao.insert(shop);
        return shop;
    }

    /**
     * 修改数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    @Override
    public Shop update(Shop shop) {
        this.shopDao.update(shop);
        return this.queryById(shop.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.shopDao.deleteById(id) > 0;
    }

    /**
     * 申请入住
     *
     * @param shopRequest
     * @return
     */
    @Override
    public ResponseResult applyShop(ShopRequest shopRequest) {
        Shop shop = new Shop();
        BeanCopier beanCopier = BeanCopier.create(  ShopRequest.class,Shop.class,false);
        beanCopier.copy( shopRequest,shop,null );
        shop.setMerchantId( shopRequest.getMerchantId() );
        shop.setStatus( 0 );
        shop.setCreateTime( new Date(  ) );
        shop.setUpdateTime( new Date(  ) );
        shopDao.insert( shop );
        return ResponseResult.success( shop );
    }

    /**
     * 根据状态查询
     *
     * @param state
     * @return
     */
    @Override
    public ResponseResult queryShop(Integer state) {
        Shop shop = new Shop();
        shop.setStatus( state );
        return ResponseResult.success( shopDao.queryAll( shop) );
    }

    /**
     * 审核商家
     *
     * @param id
     * @param state
     * @return
     */
    @Override
    public ResponseResult examineShop(Integer id,Integer state) {
        Shop shop = new Shop();
        shop.setId( id );
        shop.setStatus( state );
        return ResponseResult.success(shopDao.update( shop ));
    }
}