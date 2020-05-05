package com.zero.logistics.service;

import com.zero.logistics.entity.TWaybill;
import com.zero.logistics.util.LayPage;
import com.zero.logistics.vo.PackageDetailVO;
import com.zero.logistics.vo.StaffPackageVO;
import com.zero.logistics.vo.WaybillDetailVO;
import com.zero.logistics.vo.WaybillTableVO;

import java.util.List;

/**
 * (TWaybill)表服务接口
 *
 * @author makejava
 * @since 2020-04-05 16:10:20
 */
public interface TWaybillService extends BaseService<TWaybill> {
    public LayPage<WaybillTableVO> getPage(int page, int limit, WaybillTableVO waybillTableVo);

    public WaybillDetailVO getDetail(int waybillId);

    public List<StaffPackageVO> listPackage(int dotId);

    public PackageDetailVO packageDetail(int waybillId);
}