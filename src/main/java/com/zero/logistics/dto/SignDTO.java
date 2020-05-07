package com.zero.logistics.dto;

import java.io.Serializable;

/**
 * @ClassName SignDTO
 * @Description 签收确认DTO
 * @Author 郑思华
 * @Date 2020/5/6 16:32
 * @Version 1.0
 */
public class SignDTO implements Serializable {
    private Integer orderId;
    private Integer waybillId;
    private Integer signState;
    private String rejectReasons;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(Integer waybillId) {
        this.waybillId = waybillId;
    }

    public String getRejectReasons() {
        return rejectReasons;
    }

    public void setRejectReasons(String rejectReasons) {
        this.rejectReasons = rejectReasons;
    }

    public Integer getSignState() {
        return signState;
    }

    public void setSignState(Integer signState) {
        this.signState = signState;
    }
}