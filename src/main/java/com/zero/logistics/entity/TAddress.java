package com.zero.logistics.entity;

import java.io.Serializable;

/**
 * (TAddress)实体类
 *
 * @author makejava
 * @since 2020-04-26 11:46:22
 */
public class TAddress implements Serializable {
    private static final long serialVersionUID = 584118433213944169L;
    /**
    * 地址编号
    */
    private Integer addressId;
    /**
    * 客户编号
    */
    private Integer customerId;
    /**
    * 所属人姓名
    */
    private String ownerName;
    /**
    * 省
    */
    private String province;
    /**
    * 市
    */
    private String city;
    /**
    * 区
    */
    private String area;
    /**
    * 详细地址
    */
    private String address;
    /**
    * 联系号码
    */
    private String phone;
    /**
    * 寄件地址/收件地址
    */
    private Integer type;
    /**
    * 状态
    */
    private Integer state;
    private String wxName;


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }
}