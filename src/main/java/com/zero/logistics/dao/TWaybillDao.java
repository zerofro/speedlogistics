package com.zero.logistics.dao;

import com.zero.logistics.entity.TWaybill;
import com.zero.logistics.vo.PackageDetailVO;
import com.zero.logistics.vo.StaffPackageVO;
import com.zero.logistics.vo.WaybillDetailVO;
import com.zero.logistics.vo.WaybillTableVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TWaybill)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-05 16:10:19
 */
public interface TWaybillDao extends BaseDao<TWaybill> {

    public List<WaybillTableVO> pageByVO(@Param("startRow") int startRow, @Param("pageSize") int pageSize,
                                         @Param("condition") Object condition);

    public WaybillDetailVO getDetail(int waybillId);

    /**
     * 批量新增
     * @param waybills
     * @return
     */
    public int insertBatch(@Param("waybills") List<TWaybill> waybills);

    /**
     * 获取网点订单
     * @param dotId
     * @return
     */
    public List<StaffPackageVO> listPackage(int dotId);

    /**
     * 获取揽件的详情
     * @param waybillId
     * @return
     */
    public PackageDetailVO packageDetail(int waybillId);
}