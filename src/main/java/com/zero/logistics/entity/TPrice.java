package com.zero.logistics.entity;

import java.io.Serializable;

/**
 * (TPrice)实体类
 *
 * @author makejava
 * @since 2020-05-25 11:45:55
 */
public class TPrice implements Serializable {
    private static final long serialVersionUID = 347644555977550271L;
    /**
    * 地区定价编号
    */
    private Integer priceId;
    /**
    * 省份
    */
    private String province;
    /**
    * 省内首重
    */
    private Double inFirstPriority;
    /**
    * 省外首重
    */
    private Double outFirstPriority;
    /**
    * 省内续重
    */
    private Double inContinued;
    /**
    * 省外续重
    */
    private Double outContinued;


    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Double getInFirstPriority() {
        return inFirstPriority;
    }

    public void setInFirstPriority(Double inFirstPriority) {
        this.inFirstPriority = inFirstPriority;
    }

    public Double getOutFirstPriority() {
        return outFirstPriority;
    }

    public void setOutFirstPriority(Double outFirstPriority) {
        this.outFirstPriority = outFirstPriority;
    }

    public Double getInContinued() {
        return inContinued;
    }

    public void setInContinued(Double inContinued) {
        this.inContinued = inContinued;
    }

    public Double getOutContinued() {
        return outContinued;
    }

    public void setOutContinued(Double outContinued) {
        this.outContinued = outContinued;
    }

}