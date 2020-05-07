package com.zero.logistics.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TLogistics)实体类
 *
 * @author makejava
 * @since 2020-04-06 16:38:48
 */
public class TLogistics implements Serializable {
    private static final long serialVersionUID = 689804971091195619L;
    /**
    * 物流编号
    */
    private Integer logisticsId;
    /**
    * 运单编号
    */
    private Integer waybillId;
    /**
    * 配送员编号
    */
    private Integer staffId;
    /**
    * 起始网点id
    */
    private Integer startDotId;
    /**
    * 目标网点id
    */
    private Integer targetDotId;
    /**
    * 物流更新类型(0->发出 1->接收)
    */
    private Integer logisticsType;
    /**
    * 填写物流信息时间
    */
    private Date createTime;

    public TLogistics() {
    }

    public TLogistics(Integer waybillId, Integer staffId, Integer startDotId, Integer targetDotId, Integer logisticsType) {
        this.waybillId = waybillId;
        this.staffId = staffId;
        this.startDotId = startDotId;
        this.targetDotId = targetDotId;
        this.logisticsType = logisticsType;
    }

    public Integer getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Integer logisticsId) {
        this.logisticsId = logisticsId;
    }

    public Integer getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(Integer waybillId) {
        this.waybillId = waybillId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getStartDotId() {
        return startDotId;
    }

    public void setStartDotId(Integer startDotId) {
        this.startDotId = startDotId;
    }

    public Integer getTargetDotId() {
        return targetDotId;
    }

    public void setTargetDotId(Integer targetDotId) {
        this.targetDotId = targetDotId;
    }

    public Integer getLogisticsType() {
        return logisticsType;
    }

    public void setLogisticsType(Integer logisticsType) {
        this.logisticsType = logisticsType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}