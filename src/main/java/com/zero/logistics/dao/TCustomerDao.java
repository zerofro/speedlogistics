package com.zero.logistics.dao;

import com.zero.logistics.entity.TCustomer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TCustomer)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-17 18:18:18
 */
public interface TCustomerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param customerId 主键
     * @return 实例对象
     */
    TCustomer queryById(Integer customerId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TCustomer> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tCustomer 实例对象
     * @return 对象列表
     */
    List<TCustomer> queryAll(TCustomer tCustomer);

    /**
     * 新增数据
     *
     * @param tCustomer 实例对象
     * @return 影响行数
     */
    int insert(TCustomer tCustomer);

    /**
     * 修改数据
     *
     * @param tCustomer 实例对象
     * @return 影响行数
     */
    int update(TCustomer tCustomer);

    /**
     * 通过主键删除数据
     *
     * @param customerId 主键
     * @return 影响行数
     */
    int deleteById(Integer customerId);

    TCustomer queryByWxId(String wxId);

    public int setWxName(TCustomer tCustomer);

    public int getCount(String condition);

    public List<TCustomer> pageByCondition(@Param("startRow") int startRow, @Param("pageSize") int pageSize,
                                           @Param("condition") String condition);
}