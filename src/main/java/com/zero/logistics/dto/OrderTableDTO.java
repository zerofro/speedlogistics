package com.zero.logistics.dto;

/**
 * @ClassName OrderTableDTO
 * @Description TODO
 * @Author zero
 * @Date 2020/4/5 9:46
 * @Version 1.0
 */
public class OrderTableDTO {
    private Integer dotId;
    private String wxName;
    private String realName;
    private Integer state;

    public Integer getDotId() {
        return dotId;
    }

    public void setDotId(Integer dotId) {
        this.dotId = dotId;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}