package com.zero.logistics.service;

import com.zero.logistics.entity.TStaff;
import java.util.List;

/**
 * (TStaff)表服务接口
 *
 * @author makejava
 * @since 2020-03-28 20:46:10
 */
public interface TStaffService {

    /**
     * 通过ID查询单条数据
     *
     * @param staffId 主键
     * @return 实例对象
     */
    TStaff queryById(Integer staffId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TStaff> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tStaff 实例对象
     * @return 实例对象
     */
    TStaff insert(TStaff tStaff);

    /**
     * 修改数据
     *
     * @param tStaff 实例对象
     * @return 实例对象
     */
    TStaff update(TStaff tStaff);

    /**
     * 通过主键删除数据
     *
     * @param staffId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer staffId);

}