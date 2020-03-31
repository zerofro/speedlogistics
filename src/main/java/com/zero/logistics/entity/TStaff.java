package com.zero.logistics.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (TStaff)实体类
 *
 * @author makejava
 * @since 2020-03-29 15:43:31
 */
public class TStaff implements Serializable {
    private static final long serialVersionUID = 961262589423554673L;
    /**
    * 配送员编号
    */
    private Integer staffId;
    /**
    * 微信账号代码
    */
    private String wxId;
    /**
    * 配送员姓名
    */
    private String staffName;
    /**
    * 配送员账号
    */
    private String staffLoginName;
    /**
    * 登录密码
    */
    private String staffPassword;
    /**
    * 年龄
    */
    private Integer staffAge;
    /**
    * 性别
    */
    private String staffSex;
    /**
    * 联系号码
    */
    private String staffPhone;
    /**
    * 雇用时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;
    /**
    * 解雇日期
    */
    private Date firedata;
    /**
    * 网点id
    */
    private Integer dotId;
    /**
    * 是否在职
    */
    private Integer state;
    private String dotName;


    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffLoginName() {
        return staffLoginName;
    }

    public void setStaffLoginName(String staffLoginName) {
        this.staffLoginName = staffLoginName;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public Integer getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(Integer staffAge) {
        this.staffAge = staffAge;
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Date getFiredata() {
        return firedata;
    }

    public void setFiredata(Date firedata) {
        this.firedata = firedata;
    }

    public Integer getDotId() {
        return dotId;
    }

    public void setDotId(Integer dotId) {
        this.dotId = dotId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDotName() {
        return dotName;
    }

    public void setDotName(String dotName) {
        this.dotName = dotName;
    }
}