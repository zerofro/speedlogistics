package com.zero.logistics.entity;

import java.io.Serializable;

/**
 * (TPrice)实体类
 *
 * @author makejava
 * @since 2020-03-31 21:17:53
 */
public class TPrice implements Serializable {
    private static final long serialVersionUID = 577277107734945476L;
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
    private Double infirstPriority;
    /**
    * 省外首重
    */
    private Double outFirstPriotity;
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

    public Double getInfirstPriority() {
        return infirstPriority;
    }

    public void setInfirstPriority(Double infirstPriority) {
        this.infirstPriority = infirstPriority;
    }

    public Double getOutFirstPriotity() {
        return outFirstPriotity;
    }

    public void setOutFirstPriotity(Double outFirstPriotity) {
        this.outFirstPriotity = outFirstPriotity;
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