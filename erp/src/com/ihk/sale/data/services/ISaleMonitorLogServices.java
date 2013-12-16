package com.ihk.sale.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.sale.data.pojo.SaleMonitorLog;
import com.ihk.sale.data.pojo.SaleMonitorLogCond;

/**
 * SaleMonitorLog的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface ISaleMonitorLogServices {

	/**
	 * 新增SaleMonitorLog
	 * @param saleMonitorLog
	 */
	public void addSaleMonitorLog(SaleMonitorLog saleMonitorLog) throws RuntimeException;

	/**
	 * 删除一条SaleMonitorLog
	 * @param id
	 */
	public void deleteSaleMonitorLog(int id) throws RuntimeException;

	/**
	 * 修改SaleMonitorLog
	 * @param saleMonitorLog
	 */
	public void updateSaleMonitorLog(SaleMonitorLog saleMonitorLog) throws RuntimeException;

	/**
	 * 查找一条SaleMonitorLog
	 * @return SaleMonitorLog
	 * @param id 主键id
	 */
	public SaleMonitorLog findSaleMonitorLogById(int id) throws RuntimeException;

	/**
	 * 根据DateId查找SaleMonitorLog
	 * @param DateId 查询条件
	 * @return SaleMonitorLog列表
	 */
	public List<SaleMonitorLog> findSaleMonitorLogByDateId(int dataId) throws RuntimeException;

	/**
	 * 分页查找SaleMonitorLog
	 * @param cond 查询条件
	 * @return SaleMonitorLog列表
	 */
	public List<SaleMonitorLog> findSaleMonitorLogPage(SaleMonitorLogCond cond) throws RuntimeException;
    

	/**
	 * 查找全部SaleMonitorLog
	 * @param cond 查询条件
	 * @return SaleMonitorLog列表
	 */
	public List<SaleMonitorLog> findSaleMonitorLog(SaleMonitorLogCond cond) throws RuntimeException;
}