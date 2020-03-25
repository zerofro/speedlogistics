package com.zero.logistics.entity;

import java.io.Serializable;

/**
 * (TDot)实体类
 *
 * @author makejava
 * @since 2020-03-22 20:17:55
 */
public class TDot implements Serializable {
    private static final long serialVersionUID = 425960082483534035L;
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

}