package com.ihk.sale.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorYear;
import com.ihk.sale.data.pojo.SaleMonitorYearCond;

/**
 * SaleMonitorYear的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface ISaleMonitorYearServices {

	/**
	 * 新增SaleMonitorYear
	 * @param saleMonitorYear
	 */
	public void addSaleMonitorYear(SaleMonitorYear saleMonitorYear) throws RuntimeException;

	/**
	 * 删除一条SaleMonitorYear
	 * @param id
	 */
	public void deleteSaleMonitorYear(int id) throws RuntimeException;

	/**
	 * 修改SaleMonitorYear
	 * @param saleMonitorYear
	 */
	public void updateSaleMonitorYear(SaleMonitorYear saleMonitorYear) throws RuntimeException;

	/**
	 * 查找一条SaleMonitorYear
	 * @return SaleMonitorYear
	 * @param id 主键id
	 */
	public SaleMonitorYear findSaleMonitorYearById(int id) throws RuntimeException;

	/**
	 * 分页查找SaleMonitorYear
	 * @param cond 查询条件
	 * @return SaleMonitorYear列表
	 */
	public List<SaleMonitorYear> findSaleMonitorYearPage(SaleMonitorYearCond cond) throws RuntimeException;

	/**
	 * 查找全部SaleMonitorYear
	 * @param cond 查询条件
	 * @return SaleMonitorYear列表
	 */
	public List<SaleMonitorYear> findSaleMonitorYear(SaleMonitorYearCond cond) throws RuntimeException;
	
	/**
	 * 查找,用于显示
	 * @param sale
	 * @return
	 * @throws Exception
	 */
	public SaleMonitorYear findSaleMonitorYearToShow(SaleMonitor sale) throws Exception;
	
	/**
	 * 用于定时器
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public SaleMonitorYear findQuartzDateSaleMonitorYear(SaleMonitorYearCond cond) throws Exception; //用于定时器
	
	/**
	 * 以公司与日期分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitorYear> findSaleMonitorYearGroupbyCompanyDate(SaleMonitorYearCond cond);  //以公司与日期分组
	
	/**
	 * 以全国与日期分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitorYear> findSaleMonitorYearGroupbyCountryDate(SaleMonitorYearCond cond);  //以全国与日期分组
}