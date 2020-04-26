package com.zero.logistics.service.impl;

import com.zero.logistics.dao.TAddressDao;
import com.zero.logistics.entity.TAddress;
import com.zero.logistics.service.TAddressService;
import com.zero.logistics.util.LayPage;
import com.zero.logistics.vo.AddressTableVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TAddress)表服务实现类
 *
 * @author makejava
 * @since 2020-03-18 18:10:04
 */
@Service("tAddressService")
public class TAddressServiceImpl implements TAddressService {
    @Resource
    private TAddressDao tAddressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    @Override
    public TAddress queryById(Integer addressId) {
        return this.tAddressDao.queryById(addressId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TAddress> queryAllByLimit(int offset, int limit) {
        return this.tAddressDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tAddress 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TAddress insert(TAddress tAddress) {
        //更新默认地址
        if (tAddress.getState() == 1)
            tAddressDao.updateDefult(tAddress.getCustomerId());
        this.tAddressDao.insert(tAddress);
        return tAddress;
    }

    /**
     * 修改数据
     *
     * @param tAddress 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TAddress update(TAddress tAddress) {
        //更新默认地址
        if (tAddress.getState() == 1)
            tAddressDao.updateDefult(tAddress.getCustomerId());
        this.tAddressDao.update(tAddress);
        return this.queryById(tAddress.getAddressId());
    }

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer addressId) {
        return this.tAddressDao.deleteById(addressId) > 0;
    }

    @Override
    public List<TAddress> getAddressBook(Integer type, Integer customerId, String ownerName) {
        List<TAddress> tAddresses = tAddressDao.getAddressBook(type, customerId, ownerName);
        return tAddresses;
    }

    @Override
    public LayPage<AddressTableVO> getPage(int page, int limit, TAddress tAddress) {
        int count = tAddressDao.getCount(tAddress);
        List<AddressTableVO> data = tAddressDao.pageByCondition((page - 1) * limit, limit, tAddress);
        LayPage<AddressTableVO> layPage = new LayPage<>(count, data);
        return layPage;
    }

}