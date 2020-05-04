package com.zero.logistics.entity;

import java.io.Serializable;

/**
 * (TDot)实体类
 *
 * @author makejava
 * @since 2020-05-04 14:03:00
 */
public class TDot implements Serializable {
    private static final long serialVersionUID = 372254987689374279L;
    /**
    * 网点编号
    */
    private Integer dotId;
    /**
    * 省份
    */
    private String province;
    /**
    * 城市
    */
    private String city;
    /**
    * 地区
    */
    private String area;
    /**
    * 网点地址
    */
    private String dotAddress;
    /**
    * 网点名称
    */
    private String dotName;
    /**
    * 网点联系号码
    */
    private String dotPhone;
    /**
    * 状态
    */
    private Integer state;

    private String dotCity;

    public Integer getDotId() {
        return dotId;
    }

    public void setDotId(Integer dotId) {
        this.dotId = dotId;
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

    public String getDotAddress() {
        return dotAddress;
    }

    public void setDotAddress(String dotAddress) {
        this.dotAddress = dotAddress;
    }

    public String getDotName() {
        return dotName;
    }

    public void setDotName(String dotName) {
        this.dotName = dotName;
    }

    public String getDotPhone() {
        return dotPhone;
    }

    public void setDotPhone(String dotPhone) {
        this.dotPhone = dotPhone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDotCity(){
        return this.dotCity;
    }

    public void setDotCity(String dotCity){
        this.dotCity = dotCity;
    }
}