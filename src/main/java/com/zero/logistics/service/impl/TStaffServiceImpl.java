package com.zero.logistics.service.impl;

import com.zero.logistics.entity.TStaff;
import com.zero.logistics.dao.TStaffDao;
import com.zero.logistics.service.TStaffService;
import com.zero.logistics.utils.LayPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TStaff)表服务实现类
 *
 * @author makejava
 * @since 2020-03-28 20:46:10
 */
@Service("tStaffService")
public class TStaffServiceImpl implements TStaffService {
    @Resource
    private TStaffDao tStaffDao;

    /**
     * 通过ID查询单条数据
     *
     * @param staffId 主键
     * @return 实例对象
     */
    @Override
    public TStaff queryById(Integer staffId) {
        return this.tStaffDao.queryById(staffId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TStaff> queryAllByLimit(int offset, int limit) {
        return this.tStaffDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tStaff 实例对象
     * @return 实例对象
     */
    @Override
    public TStaff insert(TStaff tStaff) {
        this.tStaffDao.insert(tStaff);
        return tStaff;
    }

    /**
     * 修改数据
     *
     * @param tStaff 实例对象
     * @return 实例对象
     */
    @Override
    public TStaff update(TStaff tStaff) {
        this.tStaffDao.update(tStaff);
        return this.queryById(tStaff.getStaffId());
    }

    /**
     * 通过主键删除数据
     *
     * @param staffId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer staffId) {
        return this.tStaffDao.deleteById(staffId) > 0;
    }


    @Override
    public LayPage<TStaff> getPage(int page, int limit, TStaff condition) {
        int count = tStaffDao.getCount(condition);
        List<TStaff> data = tStaffDao.pageByCondition((page-1)*limit, limit, condition);
        LayPage<TStaff> layPage = new LayPage<TStaff>(count, data);
        return layPage;
    }

    @Override
    public boolean batchDelete(List ids) {
        int rows = tStaffDao.invalidByIds(ids);
        return rows > 0;
    }
}