package com.zero.logistics.dao;

import com.zero.logistics.entity.TAdmin;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TAdmin)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-26 09:49:37
 */
public interface TAdminDao {

    /**
     * 通过ID查询单条数据
     *
     * @param adminId 主键
     * @return 实例对象
     */
    TAdmin queryById(Integer adminId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TAdmin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tAdmin 实例对象
     * @return 对象列表
     */
    List<TAdmin> queryAll(TAdmin tAdmin);

    /**
     * 新增数据
     *
     * @param tAdmin 实例对象
     * @return 影响行数
     */
    int insert(TAdmin tAdmin);

    /**
     * 修改数据
     *
     * @param tAdmin 实例对象
     * @return 影响行数
     */
    int update(TAdmin tAdmin);

    /**
     * 通过主键删除数据
     *
     * @param adminId 主键
     * @return 影响行数
     */
    int deleteById(Integer adminId);

    /**
     * 登录验证
     * @param tAdmin
     * @return
     */
    TAdmin queryBylogin(TAdmin tAdmin);
}