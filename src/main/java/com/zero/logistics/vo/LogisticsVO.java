package com.zero.logistics.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName LogisticsVO
 * @Description TODO
 * @Author zero
 * @Date 2020/4/6 15:32
 * @Version 1.0
 */
public class LogisticsVO implements Serializable {
    private String startDotName;
    private String targetDotName;
    private Integer logisticsType;
    private Date createTime;

    public String getStartDotName() {
        return startDotName;
    }

    public void setStartDotName(String startDotName) {
        this.startDotName = startDotName;
    }

    public String getTargetDotName() {
        return targetDotName;
    }

    public void setTargetDotName(String targetDotName) {
        this.targetDotName = targetDotName;
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