package com.zero.logistics.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName WaybillDetailVO
 * @Description TODO
 * @Author zero
 * @Date 2020/4/6 10:46
 * @Version 1.0
 */
public class WaybillDetailVO implements Serializable {
    private String waybillCode;
    private String sendAddress;
    private String receiveAddress;
    private List<LogisticsVO> logisticsVOs;
    private SendVO sendVO;
    private Date createTime;

    public String getWaybillCode() {
        return waybillCode;
    }

    public void setWaybillCode(String waybillCode) {
        this.waybillCode = waybillCode;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public List<LogisticsVO> getLogisticsVOs() {
        return logisticsVOs;
    }

    public void setLogisticsVOs(List<LogisticsVO> logisticsVOs) {
        this.logisticsVOs = logisticsVOs;
    }

    public SendVO getSendVO() {
        return sendVO;
    }

    public void setSendVO(SendVO sendVO) {
        this.sendVO = sendVO;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}