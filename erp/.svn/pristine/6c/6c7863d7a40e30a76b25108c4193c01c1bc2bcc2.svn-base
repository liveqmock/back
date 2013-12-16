package com.ihk.sale.data;

import java.util.List;
import java.util.Map;

import com.ihk.sale.data.pojo.SaleMonitorLog;
import com.ihk.sale.data.pojo.SaleMonitorLogCond;

/**
 * SaleMonitorLog数据访问接口Mapper
 * @author 
 *
 */ 
public interface ISaleMonitorLogMapper {

	/**
	 * 新增SaleMonitorLog
	 * @param saleMonitorLog
	 */
	public void addSaleMonitorLog(SaleMonitorLog saleMonitorLog) ;

	/**
	 * 根据条件删除SaleMonitorLog
	 * @param cond 删除条件
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
	 * 分页查找SaleMonitorLog
	 * @param cond 查询条件
	 * @return SaleMonitorLog列表
	 */
	public List<SaleMonitorLog> findSaleMonitorLogPage(SaleMonitorLogCond cond) ;
	

	/**
	 * 根据dateId 查找符合条件的记录条数SaleMonitorLog
	 * @param dataId 
	 * @return 记录条数
	 */
	public List<SaleMonitorLog> findSaleMonitorLogByDateId(int dataId) throws RuntimeException;

	/**
	 * 查找全部SaleMonitorLog
	 * @param cond 查询条件
	 * @return SaleMonitorLog列表
	 */
	public List<SaleMonitorLog> findSaleMonitorLog(SaleMonitorLogCond cond) ;

	/**
	 * 查找符合条件的记录条数SaleMonitorLog
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findSaleMonitorLogCount(SaleMonitorLogCond cond) ;
}
