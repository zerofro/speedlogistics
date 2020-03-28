package com.zero.logistics.entity;

import java.io.Serializable;

/**
 * (TDot)实体类
 *
 * @author makejava
 * @since 2020-03-28 14:39:23
 */
public class TDot implements Serializable {
    private static final long serialVersionUID = 819862913258224184L;
    /**
    * 网点编号
    */
    private Integer dotId;
    /**
    * 网点所属城市
    */
    private String dotCity;
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


    public Integer getDotId() {
        return dotId;
    }

    public void setDotId(Integer dotId) {
        this.dotId = dotId;
    }

    public String getDotCity() {
        return dotCity;
    }

    public void setDotCity(String dotCity) {
        this.dotCity = dotCity;
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

}