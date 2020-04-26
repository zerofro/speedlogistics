package com.zero.logistics.service;

import com.zero.logistics.entity.TOrder;
import com.zero.logistics.entity.TPrice;

/**
 * (TPrice)表服务接口
 *
 * @author makejava
 * @since 2020-03-24 20:55:05
 */
public interface TPriceService extends BaseService<TPrice> {
    /**
     * 通过省份获取数据
     * @param province 省份
     * @return 定价信息
     */
    public TPrice queryByProvince(String province);

    /**
     * 估价
     * @param order
     * @return
     */
    public Double valuation(TOrder order);
}