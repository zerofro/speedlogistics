package com.zero.logistics.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName BaseDao
 * @Description TODO
 * @Author zero
 * @Date 2020/3/28 21:17
 * @Version 1.0
 */
public interface BaseDao<T> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public T queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<T> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param obj 实例对象
     * @return 对象列表
     */
    List<T> queryAll(T obj);

    /**
     * 新增数据
     *
     * @param obj 实例对象
     * @return 影响行数
     */
    int insert(T obj);

    /**
     * 修改数据
     * @param obj 实例对象
     * @return 影响行数
     */
    int update(T obj);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 根据条件获取总记录数
     * @param condition 条件
     * @return 总记录数
     */
    public int getCount(Object condition);

    /**
     * 根据条件获取页内容
     * @param startRow 开始的行数
     * @param pageSize 页内最大记录数
     * @param condition 条件
     * @return 页数据列表
     */
    public List<T> pageByCondition(@Param("startRow") int startRow, @Param("pageSize") int pageSize,
                                   @Param("condition") Object condition);

    /**
     * 批量无效数据
     * @param ids 主键列表
     * @return 受影响的行数
     */
    public int invalidByIds(@Param("ids") List ids);
}
