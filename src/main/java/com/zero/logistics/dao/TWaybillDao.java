package com.zero.logistics.dao;

import com.zero.logistics.entity.TWaybill;
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
}