package com.zero.logistics.dao;

import com.zero.logistics.entity.TOrder;
import com.zero.logistics.vo.OrderDetailVO;
import com.zero.logistics.vo.OrderTableVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TOrder)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-04 16:43:04
 */
public interface TOrderDao extends BaseDao<TOrder> {
    public List<OrderTableVO> pageByOrderVo(@Param("startRow") int startRow, @Param("pageSize") int pageSize,
                                            @Param("condition") Object condition);

    public OrderDetailVO getDetail(Integer orderId);
}