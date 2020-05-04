package com.zero.logistics.dto;

import java.io.Serializable;

/**
 * @ClassName GeoDotDTO
 * @Description 用户高德地图接口的DTO
 * @Author 郑思华
 * @Date 2020/5/4 15:40
 * @Version 1.0
 */
public class GeoDotDTO implements Serializable {
    private Integer dotId;
    private String dotAddress;
    private String endAddress;

    public Integer getDotId() {
        return dotId;
    }

    public void setDotId(Integer dotId) {
        this.dotId = dotId;
    }

    public String getDotAddress() {
        return dotAddress;
    }

    public void setDotAddress(String dotAddress) {
        this.dotAddress = dotAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }
}