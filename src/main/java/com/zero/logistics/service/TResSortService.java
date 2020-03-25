package com.zero.logistics.service;

import com.zero.logistics.entity.TResSort;

import java.util.List;

/**
 * (TResSort)表服务接口
 *
 * @author makejava
 * @since 2020-03-19 20:20:46
 */
public interface TResSortService {

    /**
     * 通过ID查询单条数据
     *
     * @param resSortId 主键
     * @return 实例对象
     */
    TResSort queryById(Integer resSortId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TResSort> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tResSort 实例对象
     * @return 实例对象
     */
    TResSort insert(TResSort tResSort);

    /**
     * 修改数据
     *
     * @param tResSort 实例对象
     * @return 实例对象
     */
    TResSort update(TResSort tResSort);

    /**
     * 通过主键删除数据
     *
     * @param resSortId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer resSortId);

}