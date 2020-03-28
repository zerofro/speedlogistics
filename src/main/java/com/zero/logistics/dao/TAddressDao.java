package com.zero.logistics.dao;

import com.zero.logistics.entity.TAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TAddress)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-18 18:10:04
 */
public interface TAddressDao {

    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    TAddress queryById(Integer addressId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TAddress> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tAddress 实例对象
     * @return 对象列表
     */
    List<TAddress> queryAll(TAddress tAddress);

    /**
     * 新增数据
     *
     * @param tAddress 实例对象
     * @return 影响行数
     */
    int insert(TAddress tAddress);

    /**
     * 修改数据
     *
     * @param tAddress 实例对象
     * @return 影响行数
     */
    int update(TAddress tAddress);

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 影响行数
     */
    int deleteById(Integer addressId);

    /**
     * 通过类型和顾客Id查询地址列表
     * @param type
     * @param customerId
     * @return
     */
    public List<TAddress> getAddressBook(@Param("type") Integer type, @Param("customerId") Integer customerId,
                                         @Param("ownerName") String ownerName);

    /**
     * 更新默认地址
     * @return
     */
    public int updateDefult(Integer customerId);

    public int getCount(TAddress tAddress);

    public List<TAddress> pageByCondition(@Param("startRow") int startRow, @Param("pageSize") int pageSize,
                                          @Param("condition") TAddress condition);
}