package com.zero.logistics.service;

import com.zero.logistics.dto.StaffLoginDTO;
import com.zero.logistics.entity.TStaff;

/**
 * (TStaff)表服务接口
 *
 * @author makejava
 * @since 2020-03-28 20:46:10
 */
public interface TStaffService extends BaseService<TStaff> {
    /**
     * 通过微信id获取员工信息
     * @param wxId
     * @return
     */
    public TStaff queryByWxId(String wxId);

    public TStaff queryByPwd(StaffLoginDTO staffLoginDTO);
}