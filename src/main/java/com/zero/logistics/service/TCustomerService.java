package com.zero.logistics.service;

import com.zero.logistics.entity.TCustomer;
import com.zero.logistics.utils.LayPage;

import java.util.List;

/**
 * (TCustomer)表服务接口
 *
 * @author makejava
 * @since 2020-03-17 18:14:50
 */
public interface TCustomerService {

    /**
     * 通过ID查询单条数据
     *
     * @param customerId 主键
     * @return 实例对象
     */
    TCustomer queryById(Integer customerId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TCustomer> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tCustomer 实例对象
     * @return 实例对象
     */
    TCustomer insert(TCustomer tCustomer);

    /**
     * 修改数据
     *
     * @param tCustomer 实例对象
     * @return 实例对象
     */
    TCustomer update(TCustomer tCustomer);

    /**
     * 通过主键删除数据
     *
     * @param customerId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer customerId);

    /**
     * 通过微信id查找单条数据
     * @param wxId 微信id
     * @return 实例对象
     */
    TCustomer queryByWxId(String wxId);

    public boolean setWxName(TCustomer tCustomer);

    public LayPage<TCustomer> getPage(int page, int limit, TCustomer condition);

    public boolean batchDelete(List<Integer> customerIdList);
}