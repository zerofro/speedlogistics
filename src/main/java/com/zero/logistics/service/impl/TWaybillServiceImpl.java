package com.zero.logistics.service.impl;

import com.zero.logistics.dao.TLogisticsDao;
import com.zero.logistics.dao.TOrderDao;
import com.zero.logistics.dao.TSendDao;
import com.zero.logistics.dao.TWaybillDao;
import com.zero.logistics.entity.TLogistics;
import com.zero.logistics.entity.TWaybill;
import com.zero.logistics.service.TWaybillService;
import com.zero.logistics.util.LayPage;
import com.zero.logistics.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TWaybill)表服务实现类
 *
 * @author makejava
 * @since 2020-04-05 16:10:21
 */
@Service("tWaybillService")
public class TWaybillServiceImpl implements TWaybillService {
    @Resource
    private TWaybillDao tWaybillDao;
    @Resource
    private TLogisticsDao tLogisticsDao;
    @Resource
    private TSendDao tSendDao;
    @Resource
    private TOrderDao orderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param waybillId 主键
     * @return 实例对象
     */
    @Override
    public TWaybill queryById(Integer waybillId) {
        return this.tWaybillDao.queryById(waybillId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TWaybill> queryAllByLimit(int offset, int limit) {
        return this.tWaybillDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tWaybill 实例对象
     * @return 实例对象
     */
    @Override
    public TWaybill insert(TWaybill tWaybill) {
        this.tWaybillDao.insert(tWaybill);
        return tWaybill;
    }

    /**
     * 修改数据
     *
     * @param tWaybill 实例对象
     * @return 实例对象
     */
    @Override
    public TWaybill update(TWaybill tWaybill) {
        this.tWaybillDao.update(tWaybill);
        return this.queryById(tWaybill.getWaybillId());
    }

    /**
     * 通过主键删除数据
     *
     * @param waybillId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer waybillId) {
        return this.tWaybillDao.deleteById(waybillId) > 0;
    }

    @Override
    public LayPage<TWaybill> getPage(int page, int limit, TWaybill condition) {
        return null;
    }

    @Override
    public boolean batchDelete(List ids) {
        return false;
    }

    @Override
    public LayPage<WaybillTableVO> getPage(int page, int limit, WaybillTableVO waybillTableVo) {
        int count = tWaybillDao.getCount(waybillTableVo);
        List<WaybillTableVO> data = tWaybillDao.pageByVO((page - 1) * limit, limit, waybillTableVo);
        LayPage<WaybillTableVO> layPage = new LayPage<>(count, data);
        return layPage;
    }

    @Override
    public WaybillDetailVO getDetail(int waybillId) {
        WaybillDetailVO detail = tWaybillDao.getDetail(waybillId);
        List<LogisticsVO> logisticsVOS = tLogisticsDao.getByWaybillId(waybillId);
        SendVO sendVO = tSendDao.getByWaybillId(waybillId);
        detail.setLogisticsVOs(logisticsVOS);
        detail.setSendVO(sendVO);
        return detail;
    }

    /**
     * 获取揽件信息列表
     * @return
     */
    @Override
    public List<StaffPackageVO> listPackage(int dotId) {
        List<StaffPackageVO> resultList = tWaybillDao.listPackage(dotId);
        return resultList;
    }

    /**
     * 获取揽件详情
     * @param waybillId
     * @return
     */
    @Override
    public PackageDetailVO packageDetail(int waybillId) {
        return tWaybillDao.packageDetail(waybillId);
    }

    /**
     * 通过运单号获取详细信息
     * @param code
     * @return
     */
    @Override
    public PackageDetailVO getDetailByCode(String code) {
        return tWaybillDao.getDetailByCode(code);
    }

    /**
     * 揽件方法
     * @param orderId
     * @param logistics
     * @return
     */
    @Override
    @Transactional
    public boolean doPackage(int orderId, TLogistics logistics) {
        //添加物流
        if (tLogisticsDao.insert(logistics) > 0){
            return orderDao.updateState(orderId, 2) > 0;
        }
        return false;
    }

    /**
     * 获取运单信息列表
     * @param waybillCode
     * @return
     */
    @Override
    public WaybillListVO getByCode(String waybillCode) {
        return tWaybillDao.getByCode(waybillCode);
    }

    /**
     * 校验运单号
     * @param waybillCode
     * @return
     */
    @Override
    public Integer checkCode(String waybillCode) {
        return tWaybillDao.checkCode(waybillCode);
    }
}