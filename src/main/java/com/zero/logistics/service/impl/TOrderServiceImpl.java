package com.zero.logistics.service.impl;

import com.zero.logistics.dao.TDotDao;
import com.zero.logistics.dao.TOrderDao;
import com.zero.logistics.dao.TWaybillDao;
import com.zero.logistics.dto.GeoDotDTO;
import com.zero.logistics.dto.OrderTableDTO;
import com.zero.logistics.entity.TOrder;
import com.zero.logistics.entity.TWaybill;
import com.zero.logistics.service.TOrderService;
import com.zero.logistics.util.GeoApiUtil;
import com.zero.logistics.util.LayPage;
import com.zero.logistics.vo.OrderDetailVO;
import com.zero.logistics.vo.OrderTableVO;
import com.zero.logistics.vo.OrdersVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (TOrder)表服务实现类
 *
 * @author makejava
 * @since 2020-04-04 16:43:04
 */
@Service("tOrderService")
public class TOrderServiceImpl implements TOrderService {
    @Resource
    private TOrderDao tOrderDao;

    @Resource
    private TWaybillDao tWaybillDao;

    @Resource
    private TDotDao tDotDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TOrder queryById(Integer id) {
        return this.tOrderDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TOrder> queryAllByLimit(int offset, int limit) {
        return this.tOrderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tOrder 实例对象
     * @return 实例对象
     */
    @Override
    public TOrder insert(TOrder tOrder) {
        this.tOrderDao.insert(tOrder);
        return tOrder;
    }

    /**
     * 修改数据
     *
     * @param tOrder 实例对象
     * @return 实例对象
     */
    @Override
    public TOrder update(TOrder tOrder) {
        this.tOrderDao.update(tOrder);
        return this.queryById(tOrder.getOrderId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tOrderDao.deleteById(id) > 0;
    }

    @Override
    public LayPage<TOrder> getPage(int page, int limit, TOrder condition) {
        return null;
    }

    @Override
    public boolean batchDelete(List ids) {
        return false;
    }

    @Override
    public LayPage<OrderTableVO> getPage(int page, int limit, OrderTableDTO condition) {
        int count = tOrderDao.getCount(condition);
        List<OrderTableVO> data = tOrderDao.pageByOrderVo((page - 1) * limit, limit, condition);
        LayPage<OrderTableVO> layPage = new LayPage<>(count, data);
        return layPage;
    }

    @Override
    public OrderDetailVO getDetail(Integer orderId) {
        OrderDetailVO detail = tOrderDao.getDetail(orderId);
        return detail;
    }

    /**
     * 提交订单
     * @param order
     * @return
     */
    @Override
    public int commitOrder(TOrder order) {
        //获取附近的网点信息，获取最近的网点
        List<GeoDotDTO> dotList = tDotDao.getNearByAddressId(order.getSenderAddressId());
        if (dotList.size() > 0){
            int index = 0;
            if (dotList.size() > 1){
                List<String> startAddrList = new ArrayList<>();
                dotList.forEach(d->startAddrList.add(d.getDotAddress()));
                index = GeoApiUtil.getMinDistanceIndexByAddr(startAddrList, dotList.get(0).getEndAddress());
            }
            order.setDotId(dotList.get(index).getDotId());
            return tOrderDao.insert(order);
        }else {
            //附近不存在网点
            return -1;
        }
    }

    @Override
    public List<TOrder> list(int customerId, int state) {
        return tOrderDao.list(customerId,state);
    }

    @Override
    public boolean cancel(int orderId) {
        return tOrderDao.updateState(orderId, 4) > 0;
    }

    @Override
    public List<OrdersVO> listByDotId(int dotId) {
        return tOrderDao.listByDotId(dotId);
    }

    /**
     * 批量接单
     * @param orderIds
     * @return
     */
    @Override
    @Transactional
    public boolean orderBatch(List<Integer> orderIds) {
        if (tOrderDao.ordersBatch(orderIds) > 0){
            //生成运单
            List<TWaybill> waybills = new ArrayList<>();
            orderIds.forEach(o->{
                waybills.add(new TWaybill(o, String.valueOf(System.nanoTime())));
            });
            return tWaybillDao.insertBatch(waybills) > 0;
        }
        return false;
    }
}