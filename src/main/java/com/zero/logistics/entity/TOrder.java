package com.zero.logistics.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TOrder)实体类
 *
 * @author makejava
 * @since 2020-04-04 16:47:28
 */
public class TOrder implements Serializable {
    private static final long serialVersionUID = -32103060590897786L;
    /**
    * 订单编号
    */
    private Integer orderId;
    /**
    * 客户编号
    */
    private Integer customerId;
    /**
    * 网点编号
    */
    private Integer dotId;
    /**
    * 寄出地址id
    */
    private Integer senderAddressId;
    /**
    * 收货地址id
    */
    private Integer receiveAddressId;
    /**
    * 物品类别id
    */
    private Integer resSortId;
    /**
    * 预计重量
    */
    private Integer weight;
    /**
    * 保价
    */
    private Integer insuredPrice;
    /**
    * 运费
    */
    private Double freight;
    /**
    * 备注
    */
    private String remarks;
    /**
    * 下单时间
    */
    private Date orderTime;
    /**
    * 状态
    */
    private Integer state;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getDotId() {
        return dotId;
    }

    public void setDotId(Integer dotId) {
        this.dotId = dotId;
    }

    public Integer getSenderAddressId() {
        return senderAddressId;
    }

    public void setSenderAddressId(Integer senderAddressId) {
        this.senderAddressId = senderAddressId;
    }

    public Integer getReceiveAddressId() {
        return receiveAddressId;
    }

    public void setReceiveAddressId(Integer receiveAddressId) {
        this.receiveAddressId = receiveAddressId;
    }

    public Integer getResSortId() {
        return resSortId;
    }

    public void setResSortId(Integer resSortId) {
        this.resSortId = resSortId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getInsuredPrice() {
        return insuredPrice;
    }

    public void setInsuredPrice(Integer insuredPrice) {
        this.insuredPrice = insuredPrice;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}