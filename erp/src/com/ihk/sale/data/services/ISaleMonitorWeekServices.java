package com.ihk.sale.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorWeek;
import com.ihk.sale.data.pojo.SaleMonitorWeekCond;

/**
 * SaleMonitorWeek的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface ISaleMonitorWeekServices {

	/**
	 * 新增SaleMonitorWeek
	 * @param saleMonitorWeek
	 */
	public void addSaleMonitorWeek(SaleMonitorWeek saleMonitorWeek) throws RuntimeException;

	/**
	 * 删除一条SaleMonitorWeek
	 * @param id
	 */
	public void deleteSaleMonitorWeek(int id) throws RuntimeException;

	/**
	 * 修改SaleMonitorWeek
	 * @param saleMonitorWeek
	 */
	public void updateSaleMonitorWeek(SaleMonitorWeek saleMonitorWeek) throws RuntimeException;

	/**
	 * 查找一条SaleMonitorWeek
	 * @return SaleMonitorWeek
	 * @param id 主键id
	 */
	public SaleMonitorWeek findSaleMonitorWeekById(int id) throws RuntimeException;

	/**
	 * 分页查找SaleMonitorWeek
	 * @param cond 查询条件
	 * @return SaleMonitorWeek列表
	 */
	public List<SaleMonitorWeek> findSaleMonitorWeekPage(SaleMonitorWeekCond cond) throws RuntimeException;

	/**
	 * 查找全部SaleMonitorWeek
	 * @param cond 查询条件
	 * @return SaleMonitorWeek列表
	 */
	public List<SaleMonitorWeek> findSaleMonitorWeek(SaleMonitorWeekCond cond) throws RuntimeException;
	
	/**
	 * 用于显示
	 * @param sale
	 * @return
	 * @throws Exception
	 */
	public SaleMonitorWeek findSaleMonitorWeekToShow(SaleMonitor sale) throws Exception; //用于显示
	
	/**
	 * 用于定时器
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public SaleMonitorWeek findQuartzDateSaleMonitorWeek(SaleMonitorWeekCond cond) throws Exception; //用于定时器
	
	/**
	 * 以公司与日期分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitorWeek> findSaleMonitorWeekGroupbyCompanyDate(SaleMonitorWeekCond cond);  //以公司与日期分组
	
	/**
	 * 以全国与日期分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitorWeek> findSaleMonitorWeekGroupbyCountryDate(SaleMonitorWeekCond cond);  //以全国与日期分组
}