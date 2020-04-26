package com.zero.logistics.service.impl;

import com.zero.logistics.entity.TAdmin;
import com.zero.logistics.dao.TAdminDao;
import com.zero.logistics.service.TAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TAdmin)表服务实现类
 *
 * @author makejava
 * @since 2020-04-26 09:49:37
 */
@Service("tAdminService")
public class TAdminServiceImpl implements TAdminService {
    @Resource
    private TAdminDao tAdminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param adminId 主键
     * @return 实例对象
     */
    @Override
    public TAdmin queryById(Integer adminId) {
        return this.tAdminDao.queryById(adminId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TAdmin> queryAllByLimit(int offset, int limit) {
        return this.tAdminDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tAdmin 实例对象
     * @return 实例对象
     */
    @Override
    public TAdmin insert(TAdmin tAdmin) {
        this.tAdminDao.insert(tAdmin);
        return tAdmin;
    }

    /**
     * 修改数据
     *
     * @param tAdmin 实例对象
     * @return 实例对象
     */
    @Override
    public TAdmin update(TAdmin tAdmin) {
        this.tAdminDao.update(tAdmin);
        return this.queryById(tAdmin.getAdminId());
    }

    /**
     * 通过主键删除数据
     *
     * @param adminId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer adminId) {
        return this.tAdminDao.deleteById(adminId) > 0;
    }

    @Override
    public TAdmin login(TAdmin tAdmin) {
        TAdmin admin = tAdminDao.queryBylogin(tAdmin);
        return admin;
    }
}