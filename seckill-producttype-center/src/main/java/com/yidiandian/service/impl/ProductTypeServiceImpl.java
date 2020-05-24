package com.yidiandian.service.impl;

import com.yidiandian.entity.ProductType;
import com.yidiandian.dao.ProductTypeDao;
import com.yidiandian.request.ProductTypeRequest;
import com.yidiandian.service.ProductTypeService;
import entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * (ProductType)表服务实现类
 *
 * @author makejava
 * @since 2020-05-24 18:13:23
 */
@Service
@Slf4j
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProductType queryById(Integer id) {
        return this.productTypeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProductType> queryAllByLimit(int offset, int limit) {
        return this.productTypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param productType 实例对象
     * @return 实例对象
     */
    @Override
    public ProductType insert(ProductType productType) {
        this.productTypeDao.insert(productType);
        return productType;
    }

    /**
     * 修改数据
     *
     * @param productType 实例对象
     * @return 实例对象
     */
    @Override
    public ProductType update(ProductType productType) {
        this.productTypeDao.update(productType);
        return this.queryById(productType.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.productTypeDao.deleteById(id) > 0;
    }

    /**
     * 添加分类
     *
     * @param productTypeRequest
     * @return
     */
    @Override
    public ResponseResult addProductType(ProductTypeRequest productTypeRequest) {

        ProductType productType = new ProductType();
        BeanCopier beanCopier = BeanCopier.create( ProductTypeRequest.class,ProductType.class,false );
        beanCopier.copy( productTypeRequest,productType,null );
        productType.setStatus( 0 );
        productType.setCreateTime( new Date() );
        productType.setUpdateTime( new Date(  ) );
        productTypeDao.insert( productType );
        return ResponseResult.success( productType );
    }
}