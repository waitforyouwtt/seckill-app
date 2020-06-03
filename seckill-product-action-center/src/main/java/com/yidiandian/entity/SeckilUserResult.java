package com.yidiandian.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (SeckilUserResult)实体类
 *
 * @author makejava
 * @since 2020-05-30 13:01:25
 */
public class SeckilUserResult implements Serializable {
    private static final long serialVersionUID = 983847359191337938L;
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 秒杀用户id
    */
    private Integer userId;
    /**
    * 秒杀商品id
    */
    private Integer productId;
    /**
    * 秒杀id
    */
    private Integer seckillId;
    /**
    * 秒杀结果状态：0成功 1失败 2正在生成订单
    */
    private Integer resultStatus;
    /**
    * 秒杀结果
    */
    private String resultData;
    /**
    * 秒杀时间
    */
    private Date seckilTime;
    /**
    * 秒杀订单号
    */
    private Integer orderId;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 结束时间
    */
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Integer seckillId) {
        this.seckillId = seckillId;
    }

    public Integer getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(Integer resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultData() {
        return resultData;
    }

    public void setResultData(String resultData) {
        this.resultData = resultData;
    }

    public Date getSeckilTime() {
        return seckilTime;
    }

    public void setSeckilTime(Date seckilTime) {
        this.seckilTime = seckilTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}