package com.zero.logistics.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName SendVO
 * @Description TODO
 * @Author zero
 * @Date 2020/4/6 15:37
 * @Version 1.0
 */
public class SendVO implements Serializable {
    private String dotName;
    private String staffName;
    private String staffPhone;
    private Date sendTime;
    private Date signTime;
    private Integer signState;
    private String rejectReasons;

    public String getDotName() {
        return dotName;
    }

    public void setDotName(String dotName) {
        this.dotName = dotName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
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