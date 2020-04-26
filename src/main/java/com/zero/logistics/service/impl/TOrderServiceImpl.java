package com.zero.logistics.service.impl;

import com.zero.logistics.dto.OrderTableDTO;
import com.zero.logistics.entity.TOrder;
import com.zero.logistics.dao.TOrderDao;
import com.zero.logistics.service.TOrderService;
import com.zero.logistics.util.LayPage;
import com.zero.logistics.vo.OrderDetailVO;
import com.zero.logistics.vo.OrderTableVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public boolean commitOrder(TOrder order) {
        int rows = tOrderDao.insert(order);
        return rows > 0;
    }
}