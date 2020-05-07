package com.zero.logistics.dto;

import java.io.Serializable;

/**
 * @ClassName LogisticsAddVO
 * @Description 增加物流信息DTO
 * @Author 郑思华
 * @Date 2020/5/5 17:18
 * @Version 1.0
 */
public class LogisticsAddDTO implements Serializable {
    private Integer waybillId;
    private Integer staffId;
    private Integer startDotId;
    private Integer targetDotId;
    private Integer logisticsType;

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
}