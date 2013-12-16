package com.ihk.sale.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorMonth;
import com.ihk.sale.data.pojo.SaleMonitorMonthCond;

/**
 * SaleMonitorMonth的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface ISaleMonitorMonthServices {

	/**
	 * 新增SaleMonitorMonth
	 * @param saleMonitorMonth
	 */
	public void addSaleMonitorMonth(SaleMonitorMonth saleMonitorMonth) throws RuntimeException;

	/**
	 * 删除一条SaleMonitorMonth
	 * @param id
	 */
	public void deleteSaleMonitorMonth(int id) throws RuntimeException;

	/**
	 * 修改SaleMonitorMonth
	 * @param saleMonitorMonth
	 */
	public void updateSaleMonitorMonth(SaleMonitorMonth saleMonitorMonth) throws RuntimeException;

	/**
	 * 查找一条SaleMonitorMonth
	 * @return SaleMonitorMonth
	 * @param id 主键id
	 */
	public SaleMonitorMonth findSaleMonitorMonthById(int id) throws RuntimeException;

	/**
	 * 分页查找SaleMonitorMonth
	 * @param cond 查询条件
	 * @return SaleMonitorMonth列表
	 */
	public List<SaleMonitorMonth> findSaleMonitorMonthPage(SaleMonitorMonthCond cond) throws RuntimeException;
	
	/**
	 * 查找,用于添加
	 * @param saleMonitor
	 * @return
	 * @throws Exception
	 */
	public SaleMonitorMonth findSaleMonitorMonthForAdd(SaleMonitor saleMonitor) throws Exception;
	
	/**
	 * 查找,用于显示
	 * @param saleMonitor
	 * @return
	 * @throws Exception
	 */
	public SaleMonitorMonth findSaleMonitorMonthToShow(SaleMonitor saleMonitor) throws Exception; //用于显示
	
	/**
	 * 修改,根据添加
	 * @param saleMonitor
	 * @throws Exception
	 */
	public void updateMonthFromModifySaleMonitorAdd(SaleMonitor saleMonitor) throws Exception; //修改，或删除SaleMonitor的时候对SaleMonitorMonth的相关操作
	
	/**
	 * 修改,根据删除
	 * @param saleMonitor
	 * @throws Exception
	 */
	public void updateMonthFromModifySaleMonitorDel(SaleMonitor saleMonitor) throws Exception; //修改，或删除SaleMonitor的时候对SaleMonitorMonth的相关操作
	
	/**
	 * 修改,用于添加
	 * @param saleMonitor
	 * @throws Exception
	 */
	public void updateMonthFromAddSaleMonitor(SaleMonitor saleMonitor) throws Exception; //增加SaleMonitor的时候对SaleMonitorMonth的相关操作
	
	/**
	 * 根据MonitorDate删除
	 * @param sale
	 * @throws Exception
	 */
	public void deleteSaleMonitorMonthByMonitorDate(SaleMonitor sale) throws Exception;
	
	/**
	 * 查找全部
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<SaleMonitorMonth> findSaleMonitorMonth(SaleMonitorMonthCond cond) throws RuntimeException; //管理员使用
	
	/**
	 * 查找,用于定时器
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public SaleMonitorMonth findQuartzDateSaleMonitorMonth(SaleMonitorMonthCond cond) throws Exception; //用于定时器
	
	/**
	 * 查找，以公司与日期分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitorMonth> findSaleMonitorMonthGroupbyCompanyDate(SaleMonitorMonthCond cond);  //以公司与日期分组
	
	/**
	 * 查找以全国与日期分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitorMonth> findSaleMonitorMonthGroupbyCountryDate(SaleMonitorMonthCond cond);  //以全国与日期分组
}