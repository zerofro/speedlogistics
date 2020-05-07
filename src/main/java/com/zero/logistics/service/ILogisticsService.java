package com.zero.logistics.service;

import com.zero.logistics.entity.TLogistics;
import com.zero.logistics.vo.LogisticsDetailVO;

import java.util.List;

/**
 * @ClassName ILogisticsService
 * @Description TODO
 * @Author zero
 * @Date 2020/5/5 17:15
 * @Version 1.0
 */
public interface ILogisticsService extends BaseService<TLogistics> {
    List<LogisticsDetailVO> listDetail(String waybillCode);
}
