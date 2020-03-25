package com.zero.logistics.service;

import com.zero.logistics.entity.TPrice;
import com.zero.logistics.utils.Page;

import java.util.List;

/**
 * (TPrice)表服务接口
 *
 * @author makejava
 * @since 2020-03-24 20:55:05
 */
public interface TPriceService {

    /**
     * 通过ID查询单条数据
     *
     * @param priceId 主键
     * @return 实例对象
     */
    TPrice queryById(Integer priceId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TPrice> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tPrice 实例对象
     * @return 实例对象
     */
    TPrice insert(TPrice tPrice);

    /**
     * 修改数据
     *
     * @param tPrice 实例对象
     * @return 实例对象
     */
    TPrice update(TPrice tPrice);

    /**
     * 通过主键删除数据
     *
     * @param priceId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer priceId);

    public Page<TPrice> getPage(int pageNum, int pageSize, String condition);
}