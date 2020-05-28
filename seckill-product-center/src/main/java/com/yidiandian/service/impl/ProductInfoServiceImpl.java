package com.yidiandian.service.impl;

import com.google.common.base.Splitter;
import com.yidiandian.entity.ProductDetail;
import com.yidiandian.entity.ProductInfo;
import com.yidiandian.dao.ProductInfoDao;
import com.yidiandian.enums.ProductBusinessEnum;
import com.yidiandian.request.ProductDetailRequest;
import com.yidiandian.request.ProductInfoRequest;
import com.yidiandian.service.ProductDetailService;
import com.yidiandian.service.ProductInfoService;
import entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Productinfo)表服务实现类
 *
 * @author makejava
 * @since 2020-05-24 19:06:06
 */
@Service
@Slf4j
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoDao productinfoDao;

    @Autowired
    private ProductDetailService productDetailService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProductInfo queryById(Integer id) {
        return this.productinfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProductInfo> queryAllByLimit(int offset, int limit) {
        return this.productinfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param productinfo 实例对象
     * @return 实例对象
     */
    @Override
    public ProductInfo insert(ProductInfo productinfo) {
        this.productinfoDao.insert(productinfo);
        return productinfo;
    }

    /**
     * 修改数据
     *
     * @param productinfo 实例对象
     * @return 实例对象
     */
    @Override
    public ProductInfo update(ProductInfo productinfo) {
        this.productinfoDao.update(productinfo);
        return this.queryById(productinfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.productinfoDao.deleteById(id) > 0;
    }

    /**
     * 添加商品信息
     *
     * @param productInfoRequest
     * @return
     */
    @Override
    public ResponseResult addProduct(ProductInfoRequest productInfoRequest) {

        ProductInfo productInfo = new ProductInfo();
        BeanCopier beanCopier = BeanCopier.create( ProductInfoRequest.class,ProductInfo.class,false );
        beanCopier.copy( productInfoRequest,productInfo,null );
        productInfo.setState( 0 );
        productInfo.setCreateTime( new Date(  ) );
        productInfo.setUpdateTime( new Date(  ) );
        productInfo.setApproveTime( new Date(  ) );
        productinfoDao.insert( productInfo );
        return ResponseResult.success(productInfo);
    }

    /**
     * 补充商品详情
     *
     * @param productDetailRequest
     * @return
     */
    @Override
    public ResponseResult addProductDetail(ProductDetailRequest productDetailRequest) {
        ProductDetail productDetail = new ProductDetail();
        BeanCopier beanCopier = BeanCopier.create( ProductDetailRequest.class,ProductDetail.class,false );
        beanCopier.copy( productDetailRequest,productDetail,null );
        productDetail.setCreateTime( new Date(  ) );
        productDetail.setUpdateTime( new Date(  ) );
        productDetailService.insert( productDetail );
        return ResponseResult.success(productDetail);
    }

    /**
     * 查询商品信息
     *
     * @param productInfoRequest
     * @return
     */
    @Override
    public ResponseResult queryProductList(ProductInfoRequest productInfoRequest) {
        ProductInfo productInfo = new ProductInfo();
        BeanCopier beanCopier = BeanCopier.create( ProductInfoRequest.class,ProductInfo.class,false );
        beanCopier.copy( productInfoRequest,productInfo,null );
        List<ProductInfo> queryProductInfos = productinfoDao.queryAll( productInfo );
        return ResponseResult.success(queryProductInfos);
    }

    /**
     * 商品上下架
     *
     * @param id
     * @param state
     * @return
     */
    @Override
    public ResponseResult upOrDownProduct(int id, int state) {
        ProductDetail productDetail = productDetailService.queryByProductId( id );
        if (productDetail == null){
            return ResponseResult.error( ProductBusinessEnum.PRODUCT_DETAIL_NULL.getCode(),ProductBusinessEnum.PRODUCT_DETAIL_NULL.getMessage(),null );
        }
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId( id );
        productInfo.setState( state );
        productInfo.setUpdateTime( new Date(  ) );
        productinfoDao.update( productInfo );
        return ResponseResult.success(productInfo);
    }

    /**
     * 根据id查询商品信息
     *
     * @param ids
     * @return
     */
    @Override
    public ResponseResult queryProductByIds(String ids) {
        List<String> idList = Splitter.on(",").trimResults().splitToList(ids);
        return ResponseResult.success( productinfoDao.queryByIds(idList  ) );
    }
}