package com.zero.logistics.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName OrdersVO
 * @Description 配送员接单VO
 * @Author 郑思华
 * @Date 2020/5/3 22:40
 * @Version 1.0
 */
public class OrdersVO implements Serializable {
    private Integer orderId;
    private String senderName;
    private String receiverName;
    private Date orderTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}