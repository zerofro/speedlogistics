package com.zero.logistics.service;

import com.zero.logistics.dto.OrderTableDTO;
import com.zero.logistics.entity.TOrder;
import com.zero.logistics.util.LayPage;
import com.zero.logistics.vo.OrderDetailVO;
import com.zero.logistics.vo.OrderTableVO;
import com.zero.logistics.vo.OrdersVO;

import java.util.List;

/**
 * (TOrder)表服务接口
 *
 * @author makejava
 * @since 2020-04-04 16:43:04
 */
public interface TOrderService extends BaseService<TOrder> {

    public LayPage<OrderTableVO> getPage(int page, int limit, OrderTableDTO orderTableDTO);

    public OrderDetailVO getDetail(Integer orderId);

    public int commitOrder(TOrder order);

    public List<TOrder> list(int customerId, int state);

    public boolean cancel(int orderId);

    public List<OrdersVO> listByDotId(int dotId);

    public boolean orderBatch(List<Integer> orderIds);
}