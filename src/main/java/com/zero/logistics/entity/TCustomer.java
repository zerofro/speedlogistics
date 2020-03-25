package com.zero.logistics.entity;

import java.io.Serializable;

/**
 * (TCustomer)实体类
 *
 * @author makejava
 * @since 2020-03-17 22:11:49
 */
public class TCustomer implements Serializable {
    private static final long serialVersionUID = 924344073258933653L;
    /**
    * 客户编号
    */
    private Integer customerId;
    /**
    * 微信账号代码
    */
    private String wxId;
    /**
    * 客户姓名
    */
    private String wxName;
    /**
    * 联系号码
    */
    private String customerPhone;
    /**
    * 身份证号
    */
    private String realNum;
    private String realName;
    private Integer state;


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getRealNum() {
        return realNum;
    }

    public void setRealNum(String realNum) {
        this.realNum = realNum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}