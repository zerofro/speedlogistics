package com.zero.logistics.dao;

import com.zero.logistics.entity.TPrice;

/**
 * (TPrice)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 20:55:05
 */
public interface TPriceDao extends BaseDao<TPrice> {
    /**
     * 通过省份获取数据
     * @param province 省份
     * @return 定价信息
     */
    public TPrice queryByProvince(String province);
}