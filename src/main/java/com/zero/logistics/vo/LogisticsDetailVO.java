package com.zero.logistics.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName LogisticsDetailVO
 * @Description TODO
 * @Author 郑思华
 * @Date 2020/5/7 11:08
 * @Version 1.0
 */
public class LogisticsDetailVO implements Serializable {
    private String desc;
    private Date logTime;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }
}