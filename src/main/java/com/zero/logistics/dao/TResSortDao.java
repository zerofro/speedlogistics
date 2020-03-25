package com.zero.logistics.dao;

import com.zero.logistics.entity.TResSort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TResSort)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-19 20:21:27
 */
public interface TResSortDao {

    /**
     * 通过ID查询单条数据
     *
     * @param resSortId 主键
     * @return 实例对象
     */
    TResSort queryById(Integer resSortId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TResSort> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tResSort 实例对象
     * @return 对象列表
     */
    List<TResSort> queryAll(TResSort tResSort);

    /**
     * 新增数据
     *
     * @param tResSort 实例对象
     * @return 影响行数
     */
    int insert(TResSort tResSort);

    /**
     * 修改数据
     *
     * @param tResSort 实例对象
     * @return 影响行数
     */
    int update(TResSort tResSort);

    /**
     * 通过主键删除数据
     *
     * @param resSortId 主键
     * @return 影响行数
     */
    int deleteById(Integer resSortId);

}