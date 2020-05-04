package com.zero.logistics.dao;

import com.zero.logistics.entity.TOrder;
import com.zero.logistics.vo.OrderDetailVO;
import com.zero.logistics.vo.OrderTableVO;
import com.zero.logistics.vo.OrdersVO;
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

    /**
     * 获取订单列表
     * @return
     */
    public List<TOrder> list(@Param("customerId") int customerId, @Param("state") int state);

    /**
     * 更新state
     * @param orderId
     * @param state
     * @return
     */
    public int updateState(@Param("orderId") int orderId, @Param("state") int state);

    /**
     * 根据网点获取订单列表
     * @param dotId
     * @return
     */
    public List<OrdersVO> listByDotId(int dotId);

    /**
     * 批量接单
     * @param orderIds
     * @return
     */
    public int ordersBatch(@Param("orderIds") List<Integer> orderIds);
}