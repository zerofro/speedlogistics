package com.zero.logistics.service.impl;

import com.zero.logistics.dao.TOrderDao;
import com.zero.logistics.dao.TWaybillDao;
import com.zero.logistics.dto.SignDTO;
import com.zero.logistics.entity.TSend;
import com.zero.logistics.dao.TSendDao;
import com.zero.logistics.entity.TWaybill;
import com.zero.logistics.service.TSendService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (TSend)表服务实现类
 *
 * @author makejava
 * @since 2020-05-06 09:19:29
 */
@Service("tSendService")
public class TSendServiceImpl implements TSendService {
    @Resource
    private TSendDao tSendDao;
    @Resource
    private TOrderDao tOrderDao;
    @Resource
    private TWaybillDao tWaybillDao;

    /**
     * 通过ID查询单条数据
     *
     * @param sendId 主键
     * @return 实例对象
     */
    @Override
    public TSend queryById(Long sendId) {
        return this.tSendDao.queryById(sendId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TSend> queryAllByLimit(int offset, int limit) {
        return this.tSendDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tSend 实例对象
     * @return 实例对象
     */
    @Override
    public TSend insert(TSend tSend) {
        this.tSendDao.insert(tSend);
        return tSend;
    }

    /**
     * 修改数据
     *
     * @param tSend 实例对象
     * @return 实例对象
     */
    @Override
    public TSend update(TSend tSend) {
        this.tSendDao.update(tSend);
        return this.queryById(tSend.getSendId());
    }

    /**
     * 通过主键删除数据
     *
     * @param sendId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long sendId) {
        return this.tSendDao.deleteById(sendId) > 0;
    }

    /**
     * 设置派送
     * @param orderId
     * @param waybillId
     * @return
     */
    @Override
    @Transactional
    public boolean send(int orderId, int waybillId, int staffId) {
        if (tOrderDao.updateState(orderId, 3) > 0){
            TSend send = new TSend();
            send.setStaffId(staffId);
            send.setWaybillId(waybillId);
            return tSendDao.insert(send) > 0;
        }
        return false;
    }

    /**
     * 签收
     * @param signDTO
     * @return
     */
    @Override
    @Transactional
    public boolean sign(SignDTO signDTO) {
        //更新派送表
        if (tSendDao.sign(signDTO) > 0){
            //更新运单信息
            TWaybill waybill = new TWaybill();
            waybill.setWaybillId(signDTO.getWaybillId());
            waybill.setFinishTime(new Date());
            tWaybillDao.update(waybill);
            //更新订单信息
            tOrderDao.updateState(signDTO.getOrderId(), 4);
            return true;
        }
        return false;
    }
}