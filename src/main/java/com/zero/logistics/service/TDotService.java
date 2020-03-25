package com.zero.logistics.service;

import com.zero.logistics.entity.TDot;
import com.zero.logistics.utils.Page;

import java.util.List;

/**
 * (TDot)表服务接口
 *
 * @author makejava
 * @since 2020-03-22 20:17:55
 */
public interface TDotService {

    /**
     * 通过ID查询单条数据
     *
     * @param dotId 主键
     * @return 实例对象
     */
    TDot queryById(Integer dotId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TDot> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tDot 实例对象
     * @return 实例对象
     */
    TDot insert(TDot tDot);

    /**
     * 修改数据
     *
     * @param tDot 实例对象
     * @return 实例对象
     */
    TDot update(TDot tDot);

    /**
     * 通过主键删除数据
     *
     * @param dotId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer dotId);

    public Page<TDot> getPage(int pageNum, int pageSize, String condition);
}