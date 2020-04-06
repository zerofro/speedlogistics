package com.zero.logistics.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName FeedBackVO
 * @Description TODO
 * @Author zero
 * @Date 2020/4/5 21:43
 * @Version 1.0
 */
public class FeedBackVO implements Serializable {
    private Integer feedbackId;
    private String wxName;
    private String realName;
    private String email;
    private Date createTime;
    private String feedbackContent;

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}