package com.ihk.sale.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.sale.data.ISaleMonitorLogMapper;
import com.ihk.sale.data.pojo.SaleMonitorLog;
import com.ihk.sale.data.pojo.SaleMonitorLogCond;
import com.ihk.sale.data.services.ISaleMonitorLogServices;

/**
 * SaleMonitorLog的Services实现(业务实现)
 * @author 
 *
 */
@Service("saleMonitorLogServices")
@SuppressWarnings("unchecked")
public class SaleMonitorLogServices implements ISaleMonitorLogServices {

	/**
	 * saleMonitorLog数据访问接口
	 */
	@Autowired	 ISaleMonitorLogMapper saleMonitorLogMapper;

	/**
	 * 删除一条SaleMonitorLog
	 * @param id
	 */
	public void deleteSaleMonitorLog(int id) throws RuntimeException {
		saleMonitorLogMapper.deleteSaleMonitorLog(id);
	}

	/**
	 * 新增SaleMonitorLog
	 * @param saleMonitorLog
	 */
	public void addSaleMonitorLog(SaleMonitorLog saleMonitorLog) throws RuntimeException {		
		saleMonitorLogMapper.addSaleMonitorLog(saleMonitorLog);
	}

	/**
	 * 查找一条SaleMonitorLog
	 * @return SaleMonitorLog
	 * @param id 主键id
	 */
	@Override
	public SaleMonitorLog findSaleMonitorLogById(int id) throws RuntimeException {
		return saleMonitorLogMapper.findSaleMonitorLogById(id);
	}

	/**
	 * 修改SaleMonitorLog
	 * @param saleMonitorLog
	 */
	@Override
	public void updateSaleMonitorLog(SaleMonitorLog saleMonitorLog) throws RuntimeException {
		saleMonitorLogMapper.updateSaleMonitorLog(saleMonitorLog);		
	}

	/**
	 * 分页查找SaleMonitorLog
	 * @param cond 查询条件
	 * @return SaleMonitorLog列表
	 */
	public List<SaleMonitorLog> findSaleMonitorLogPage(SaleMonitorLogCond cond) throws RuntimeException {
		int recordCount = saleMonitorLogMapper.findSaleMonitorLogCount(cond);
		
		cond.recordCount = recordCount;
				
		return saleMonitorLogMapper.findSaleMonitorLogPage(cond);
	}

	/**
	 * 分页查找SaleMonitorLog
	 * @param cond 查询条件
	 * @return SaleMonitorLog列表
	 */
	public List<SaleMonitorLog> findSaleMonitorLog(SaleMonitorLogCond cond) throws RuntimeException {
    	return saleMonitorLogMapper.findSaleMonitorLog(cond);
	}

	/**
	 * 根据DateId查找
	 */
	@Override
	public List<SaleMonitorLog> findSaleMonitorLogByDateId(int dataId)
			throws RuntimeException {
		return saleMonitorLogMapper.findSaleMonitorLogByDateId(dataId);
	}
}
