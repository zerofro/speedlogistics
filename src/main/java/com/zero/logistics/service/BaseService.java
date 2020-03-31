package com.zero.logistics.service;

import com.zero.logistics.utils.LayPage;

import java.util.List;

/**
 * @ClassName BaseService
 * @Description TODO
 * @Author zero
 * @Date 2020/3/28 21:03
 * @Version 1.0
 */
public interface BaseService<T> {


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    T queryById(Integer id);


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<T> queryAllByLimit(int offset, int limit);


    /**
     * 新增数据
     *
     * @param obj 实例对象
     * @return 实例对象
     */
    T insert(T obj);

    /**
     * 修改数据
     *
     * @param obj 实例对象
     * @return 实例对象
     */
    T update(T obj);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 获取页内容
     * @param page 页码
     * @param limit 页内最大记录数
     * @param condition 条件
     * @return 页内容
     */
    public LayPage<T> getPage(int page, int limit, T condition);

    /**
     * 批量删除记录
     * @param ids 主键列表
     * @return 是否成功
     */
    public boolean batchDelete(List ids);
}
