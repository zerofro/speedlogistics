package com.zero.logistics.dto;

import java.io.Serializable;

/**
 * @ClassName CustomerIdentityDTO
 * @Description TODO
 * @Author 郑思华
 * @Date 2020/4/26 22:30
 * @Version 1.0
 */
public class CustomerIdentityDTO implements Serializable {
    private String realName;

    private String realNum;

    private Integer customerId;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealNum() {
        return realNum;
    }

    public void setRealNum(String realNum) {
        this.realNum = realNum;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}