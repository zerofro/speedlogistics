package com.zero.logistics.vo;

import java.io.Serializable;

/**
 * @ClassName StaffPackageVO
 * @Description 配送员揽件VO
 * @Author 郑思华
 * @Date 2020/5/4 23:25
 * @Version 1.0
 */
public class StaffPackageVO implements Serializable {
    private Integer waybillId;
    private String waybillCode;
    private String senderName;
    private String receiverName;
    private String createTime;

    public Integer getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(Integer waybillId) {
        this.waybillId = waybillId;
    }

    public String getWaybillCode() {
        return waybillCode;
    }

    public void setWaybillCode(String waybillCode) {
        this.waybillCode = waybillCode;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}