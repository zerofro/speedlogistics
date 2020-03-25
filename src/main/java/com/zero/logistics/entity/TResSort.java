package com.zero.logistics.entity;

import java.io.Serializable;

/**
 * (TResSort)实体类
 *
 * @author makejava
 * @since 2020-03-19 20:20:46
 */
public class TResSort implements Serializable {
    private static final long serialVersionUID = 107887686400239873L;
    /**
    * 物品类别编号
    */
    private Integer resSortId;
    /**
    * 物品类别
    */
    private String resSort;
    /**
    * 物品类别定价
    */
    private Double resSortMoney;


    public Integer getResSortId() {
        return resSortId;
    }

    public void setResSortId(Integer resSortId) {
        this.resSortId = resSortId;
    }

    public String getResSort() {
        return resSort;
    }

    public void setResSort(String resSort) {
        this.resSort = resSort;
    }

    public Double getResSortMoney() {
        return resSortMoney;
    }

    public void setResSortMoney(Double resSortMoney) {
        this.resSortMoney = resSortMoney;
    }

}