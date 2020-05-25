package com.zero.logistics.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TFeedback)实体类
 *
 * @author makejava
 * @since 2020-04-05 21:35:51
 */
public class TFeedback implements Serializable {
    private static final long serialVersionUID = 504337573190105355L;
    /**
    * 反馈建议编号
    */
    private Integer feedbackId;
    /**
    * 客户编号
    */
    private Integer customerId;
    /**
    * 反馈内容
    */
    private String feedbackContent;
    /**
    * 创建时间
    */
    private Date createTime;


    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}