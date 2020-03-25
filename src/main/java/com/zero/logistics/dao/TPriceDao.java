package com.zero.logistics.dao;

import com.zero.logistics.entity.TPrice;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TPrice)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 20:55:05
 */
public interface TPriceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param priceId 主键
     * @return 实例对象
     */
    TPrice queryById(Integer priceId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TPrice> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tPrice 实例对象
     * @return 对象列表
     */
    List<TPrice> queryAll(TPrice tPrice);

    /**
     * 新增数据
     *
     * @param tPrice 实例对象
     * @return 影响行数
     */
    int insert(TPrice tPrice);

    /**
     * 修改数据
     *
     * @param tPrice 实例对象
     * @return 影响行数
     */
    int update(TPrice tPrice);

    /**
     * 通过主键删除数据
     *
     * @param priceId 主键
     * @return 影响行数
     */
    int deleteById(Integer priceId);

    int getCount(String condition);

    List<TPrice> pageByCondition(@Param("startRow") int startRow, @Param("pageSize") int pageSize,
                                 @Param("condition") String condition);
}