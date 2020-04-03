package com.zero.logistics.service.impl;

import com.zero.logistics.dao.TPriceDao;
import com.zero.logistics.entity.TPrice;
import com.zero.logistics.service.TPriceService;
import com.zero.logistics.utils.LayPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TPrice)表服务实现类
 *
 * @author makejava
 * @since 2020-03-24 20:55:05
 */
@Service("tPriceService")
public class TPriceServiceImpl implements TPriceService {
    @Resource
    private TPriceDao tPriceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param priceId 主键
     * @return 实例对象
     */
    @Override
    public TPrice queryById(Integer priceId) {
        return this.tPriceDao.queryById(priceId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TPrice> queryAllByLimit(int offset, int limit) {
        return this.tPriceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tPrice 实例对象
     * @return 实例对象
     */
    @Override
    public TPrice insert(TPrice tPrice) {
        this.tPriceDao.insert(tPrice);
        return tPrice;
    }

    /**
     * 修改数据
     *
     * @param tPrice 实例对象
     * @return 实例对象
     */
    @Override
    public TPrice update(TPrice tPrice) {
        this.tPriceDao.update(tPrice);
        return this.queryById(tPrice.getPriceId());
    }

    /**
     * 通过主键删除数据
     *
     * @param priceId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer priceId) {
        return this.tPriceDao.deleteById(priceId) > 0;
    }

    @Override
    public LayPage<TPrice> getPage(int page, int limit, TPrice condition) {
        int count = tPriceDao.getCount(condition);
        List<TPrice> data = tPriceDao.pageByCondition((page - 1) * limit, limit, condition);
        LayPage<TPrice> layPage = new LayPage<>(count, data);
        return layPage;
    }

    @Override
    public boolean batchDelete(List ids) {
        int rows = tPriceDao.invalidByIds(ids);
        return rows > 0;
    }

    @Override
    public TPrice queryByProvince(String province) {
        TPrice tPrice = tPriceDao.queryByProvince(province);
        return tPrice;
    }
}