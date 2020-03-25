package com.zero.logistics.service.impl;

import com.zero.logistics.dao.TCustomerDao;
import com.zero.logistics.entity.TCustomer;
import com.zero.logistics.service.TCustomerService;
import com.zero.logistics.utils.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TCustomer)表服务实现类
 *
 * @author makejava
 * @since 2020-03-17 18:18:19
 */
@Service("tCustomerService")
public class TCustomerServiceImpl implements TCustomerService {
    @Resource
    private TCustomerDao tCustomerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param customerId 主键
     * @return 实例对象
     */
    @Override
    public TCustomer queryById(Integer customerId) {
        return this.tCustomerDao.queryById(customerId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TCustomer> queryAllByLimit(int offset, int limit) {
        return this.tCustomerDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tCustomer 实例对象
     * @return 实例对象
     */
    @Override
    public TCustomer insert(TCustomer tCustomer) {
        this.tCustomerDao.insert(tCustomer);
        return tCustomer;
    }

    /**
     * 修改数据
     *
     * @param tCustomer 实例对象
     * @return 实例对象
     */
    @Override
    public TCustomer update(TCustomer tCustomer) {
        this.tCustomerDao.update(tCustomer);
        return this.queryById(tCustomer.getCustomerId());
    }

    /**
     * 通过主键删除数据
     *
     * @param customerId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer customerId) {
        return this.tCustomerDao.deleteById(customerId) > 0;
    }

    @Override
    public TCustomer queryByWxId(String wxId) {
        TCustomer tCustomer = tCustomerDao.queryByWxId(wxId);
        return tCustomer;
    }

    @Override
    public boolean setWxName(TCustomer tCustomer) {
        int rows = tCustomerDao.setWxName(tCustomer);
        return rows>0;
    }

    @Override
    public Page<TCustomer> getPage(int pageNum, int pageSize, String condition) {
        int count = tCustomerDao.getCount(condition);
        List<TCustomer> list = tCustomerDao.pageByCondition((pageNum - 1) * pageSize, pageSize, condition);
        Page<TCustomer> page = new Page<>(pageNum, pageSize, count, list);
        return page;
    }
}