package com.zero.logistics.entity;

import java.io.Serializable;

/**
 * (TAdmin)实体类
 *
 * @author makejava
 * @since 2020-04-26 09:49:37
 */
public class TAdmin implements Serializable {
    private static final long serialVersionUID = 319140928381506651L;
    
    private Integer adminId;
    
    private String adminLoginCode;
    
    private String adminPassword;


    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminLoginCode() {
        return adminLoginCode;
    }

    public void setAdminLoginCode(String adminLoginCode) {
        this.adminLoginCode = adminLoginCode;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

}