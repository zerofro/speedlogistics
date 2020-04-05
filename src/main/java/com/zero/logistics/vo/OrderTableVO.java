package com.zero.logistics.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName OrderVO
 * @Description TODO
 * @Author zero
 * @Date 2020/4/4 19:38
 * @Version 1.0
 */
public class OrderTableVO implements Serializable {
    private Integer orderId;
    private String wxName;
    private String realName;
    private String dotName;
    private Date orderTime;
    private Integer state;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getDotName() {
        return dotName;
    }

    public void setDotName(String dotName) {
        this.dotName = dotName;
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