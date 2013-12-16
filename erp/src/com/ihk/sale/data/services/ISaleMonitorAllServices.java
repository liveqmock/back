package com.ihk.sale.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorAll;
import com.ihk.sale.data.pojo.SaleMonitorAllCond;

/**
 * SaleMonitorAll的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface ISaleMonitorAllServices {

	/**
	 * 新增SaleMonitorAll
	 * @param saleMonitorAll
	 */
	public void addSaleMonitorAll(SaleMonitorAll saleMonitorAll) throws RuntimeException;

	/**
	 * 删除一条SaleMonitorAll
	 * @param id
	 */
	public void deleteSaleMonitorAll(int id) throws RuntimeException;

	/**
	 * 修改SaleMonitorAll
	 * @param saleMonitorAll
	 */
	public void updateSaleMonitorAll(SaleMonitorAll saleMonitorAll) throws RuntimeException;

	/**
	 * 查找一条SaleMonitorAll
	 * @return SaleMonitorAll
	 * @param id 主键id
	 */
	public SaleMonitorAll findSaleMonitorAllById(int id) throws RuntimeException;

	/**
	 * 分页查找SaleMonitorAll
	 * @param cond 查询条件
	 * @return SaleMonitorAll列表
	 */
	@SuppressWarnings("rawtypes")
	public List findSaleMonitorAllPage(SaleMonitorAllCond cond) throws RuntimeException;
	
	/**
	 * 查找,用于添加
	 * @param sale
	 * @return
	 * @throws Exception
	 */
	public SaleMonitorAll findSaleMonitorAllForAdd(SaleMonitor sale) throws Exception; //该项目该日期前的所有值之和
	
	/**
	 * 修改,根据添加
	 * @param sale
	 * @throws Exception
	 */
	public void updateAllFromModifySaleMonitorAdd(SaleMonitor sale) throws Exception;
	
	/**
	 * 修改,根据删除
	 * @param sale
	 * @throws Exception
	 */
	public void updateAllFromModifySaleMonitorDel(SaleMonitor sale) throws Exception;
	
	/**
	 * 修改
	 * @param saleMonitor
	 * @throws Exception
	 */
	public void updateAllFromAddSaleMonitor(SaleMonitor saleMonitor) throws Exception; 
	
	/**
	 * 查找，用于显示
	 * @param saleMonitor
	 * @return
	 * @throws Exception
	 */
	public SaleMonitorAll findSaleMonitorAllToShow(SaleMonitor saleMonitor) throws Exception; //用于显示
	
	/**
	 * 删除,根据MonitorDate
	 * @param sale
	 * @throws Exception
	 */
	public void deleteSaleMonitorAllByMonitorDate(SaleMonitor sale) throws Exception;
	
	/**
	 * 查找,不分页
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<SaleMonitorAll> findSaleMonitorAllNoPage(SaleMonitorAllCond cond) throws Exception;
	
	
}