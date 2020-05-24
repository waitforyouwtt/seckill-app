package com.yidiandian.service.impl;

import com.yidiandian.entity.ProductDetail;
import com.yidiandian.dao.ProductDetailDao;
import com.yidiandian.service.ProductDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProductDetail)表服务实现类
 *
 * @author makejava
 * @since 2020-05-24 19:06:49
 */
@Service
@Slf4j
public class ProductDetailServiceImpl implements ProductDetailService {
    @Resource
    private ProductDetailDao productDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProductDetail queryById(Integer id) {
        return this.productDetailDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProductDetail> queryAllByLimit(int offset, int limit) {
        return this.productDetailDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param productDetail 实例对象
     * @return 实例对象
     */
    @Override
    public ProductDetail insert(ProductDetail productDetail) {
        this.productDetailDao.insert(productDetail);
        return productDetail;
    }

    /**
     * 修改数据
     *
     * @param productDetail 实例对象
     * @return 实例对象
     */
    @Override
    public ProductDetail update(ProductDetail productDetail) {
        this.productDetailDao.update(productDetail);
        return this.queryById(productDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.productDetailDao.deleteById(id) > 0;
    }

    @Override
    public ProductDetail queryByProductId(int productId) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId( productId );
        List<ProductDetail> productDetails = productDetailDao.queryAll( productDetail );
        if (CollectionUtils.isEmpty( productDetails )){
            return null;
        }
        return productDetails.get( 0 );
    }
}