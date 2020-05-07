package com.zero.logistics.dao;

import com.zero.logistics.entity.TLogistics;
import com.zero.logistics.vo.LogisticsDetailVO;
import com.zero.logistics.vo.LogisticsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TLogistics)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-06 16:38:48
 */
public interface TLogisticsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param logisticsId 主键
     * @return 实例对象
     */
    TLogistics queryById(Integer logisticsId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TLogistics> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tLogistics 实例对象
     * @return 对象列表
     */
    List<TLogistics> queryAll(TLogistics tLogistics);

    /**
     * 新增数据
     *
     * @param tLogistics 实例对象
     * @return 影响行数
     */
    int insert(TLogistics tLogistics);

    /**
     * 修改数据
     *
     * @param tLogistics 实例对象
     * @return 影响行数
     */
    int update(TLogistics tLogistics);

    /**
     * 通过主键删除数据
     *
     * @param logisticsId 主键
     * @return 影响行数
     */
    int deleteById(Integer logisticsId);

    List<LogisticsVO> getByWaybillId(int waybillId);

    /**
     * 根据运单号获取物流详情列表
     * @param waybillCode
     * @return
     */
    List<LogisticsDetailVO> getDetailList(String waybillCode);
}