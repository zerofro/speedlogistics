package com.zero.logistics.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TSend)实体类
 *
 * @author makejava
 * @since 2020-04-06 16:39:01
 */
public class TSend implements Serializable {
    private static final long serialVersionUID = 469031800523276252L;
    /**
    * 派送单编号
    */
    private Long sendId;
    /**
    * 运单编号
    */
    private Integer waybillId;
    /**
    * 配送员编号
    */
    private Integer staffId;
    /**
    * 派送时间
    */
    private Date sendTime;
    /**
    * 签收时间
    */
    private Date signTime;
    /**
    * 签收状态
    */
    private Integer signState;
    /**
    * 拒签原因
    */
    private String rejectReasons;


    public Long getSendId() {
        return sendId;
    }

    public void setSendId(Long sendId) {
        this.sendId = sendId;
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

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Integer getSignState() {
        return signState;
    }

    public void setSignState(Integer signState) {
        this.signState = signState;
    }

    public String getRejectReasons() {
        return rejectReasons;
    }

    public void setRejectReasons(String rejectReasons) {
        this.rejectReasons = rejectReasons;
    }

}