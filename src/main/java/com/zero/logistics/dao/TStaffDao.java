package com.zero.logistics.dao;

import com.zero.logistics.dto.StaffLoginDTO;
import com.zero.logistics.entity.TStaff;

/**
 * (TStaff)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-28 20:46:10
 */
public interface TStaffDao extends BaseDao<TStaff> {
    /**
     * 通过微信id获取员工信息
     * @param wxId
     * @return
     */
    public TStaff queryByWxId(String wxId);

    /**
     * 根据登录名获取信息
     * @param staffLoginDTO
     * @return
     */
    public TStaff queryByPwd(StaffLoginDTO staffLoginDTO);
}