package com.zero.logistics.dao;

import com.zero.logistics.entity.TDot;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TDot)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-22 20:17:55
 */
public interface TDotDao {

    /**
     * 通过ID查询单条数据
     *
     * @param dotId 主键
     * @return 实例对象
     */
    TDot queryById(Integer dotId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TDot> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tDot 实例对象
     * @return 对象列表
     */
    List<TDot> queryAll(TDot tDot);

    /**
     * 新增数据
     *
     * @param tDot 实例对象
     * @return 影响行数
     */
    int insert(TDot tDot);

    /**
     * 修改数据
     *
     * @param tDot 实例对象
     * @return 影响行数
     */
    int update(TDot tDot);

    /**
     * 通过主键删除数据
     *
     * @param dotId 主键
     * @return 影响行数
     */
    int deleteById(Integer dotId);

    public int getCount(String condition);

    public List<TDot> pageByCondition(@Param("startRow") int startRow, @Param("pageSize") int pageSize,
                                      @Param("condition") String condition);
}