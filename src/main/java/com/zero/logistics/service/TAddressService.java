package com.zero.logistics.service;

import com.zero.logistics.entity.TAddress;
import com.zero.logistics.utils.LayPage;

import java.util.List;

/**
 * (TAddress)表服务接口
 *
 * @author makejava
 * @since 2020-03-18 18:08:29
 */
public interface TAddressService {

    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    TAddress queryById(Integer addressId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TAddress> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tAddress 实例对象
     * @return 实例对象
     */
    TAddress insert(TAddress tAddress);

    /**
     * 修改数据
     *
     * @param tAddress 实例对象
     * @return 实例对象
     */
    TAddress update(TAddress tAddress);

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer addressId);

    /**
     * 通过类型和顾客Id查询地址列表
     * @param type
     * @param customerId
     * @param ownerName
     * @return
     */
    public List<TAddress> getAddressBook(Integer type, Integer customerId, String ownerName);

    public LayPage<TAddress> getPage(int page, int limit, TAddress tAddress);
}