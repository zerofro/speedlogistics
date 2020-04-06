package com.zero.logistics.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TWaybill)实体类
 *
 * @author makejava
 * @since 2020-04-05 20:40:21
 */
public class TWaybill implements Serializable {
    private static final long serialVersionUID = 730215033345123637L;
    /**
    * 运单编号
    */
    private Integer waybillId;
    /**
    * 订单编号
    */
    private Integer orderId;
    /**
    * 运单号
    */
    private String waybillCode;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 完成时间
    */
    private Date finishTime;


    public Integer getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(Integer waybillId) {
        this.waybillId = waybillId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getWaybillCode() {
        return waybillCode;
    }

    public void setWaybillCode(String waybillCode) {
        this.waybillCode = waybillCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

}