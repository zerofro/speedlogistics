package com.zero.logistics.dto;

import java.io.Serializable;

/**
 * @ClassName StaffLoginDTO
 * @Description 员工登录DTO
 * @Author 郑思华
 * @Date 2020/5/3 17:45
 * @Version 1.0
 */
public class StaffLoginDTO implements Serializable {
    private String staffLoginName;
    private String staffPassword;
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}