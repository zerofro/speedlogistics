package com.zero.logistics.vo;

import java.util.Date;

/**
 * @ClassName OrderDetailVO
 * @Description TODO
 * @Author zero
 * @Date 2020/4/5 10:38
 * @Version 1.0
 */
public class OrderDetailVO {
    private String wxName;
    private String realName;
    private String dotName;
    private String senderName;
    private String senderPhone;
    private String senderAddress;
    private String receiveName;
    private String receivePhone;
    private String receiveAddress;
    private String resSort;
    private Integer weight;
    private Integer insuredPrice;
    private Double freight;
    private String remarks;
    private Date orderTime;
    private Integer state;

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

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getResSort() {
        return resSort;
    }

    public void setResSort(String resSort) {
        this.resSort = resSort;
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