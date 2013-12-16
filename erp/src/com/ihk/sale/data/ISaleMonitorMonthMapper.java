package com.ihk.sale.data;

import java.util.List;

import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorMonth;
import com.ihk.sale.data.pojo.SaleMonitorMonthCond;

/**
 * SaleMonitorMonth数据访问接口Mapper
 * @author 
 *
 */ 
public interface ISaleMonitorMonthMapper {

	/**
	 * 新增SaleMonitorMonth
	 * @param saleMonitorMonth
	 */
	public void addSaleMonitorMonth(SaleMonitorMonth saleMonitorMonth) ;

	/**
	 * 根据条件删除SaleMonitorMonth
	 * @param cond 删除条件
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
	 * 查找全部SaleMonitorMonth
	 * @param cond 查询条件
	 * @return SaleMonitorMonth列表
	 */
	public List<SaleMonitorMonth> findSaleMonitorMonth(SaleMonitorMonthCond cond) throws RuntimeException;

	/**
	 * 查找符合条件的记录条数SaleMonitorMonth
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findSaleMonitorMonthCount(SaleMonitorMonthCond cond) ;
	
	/**
	 * 用于添加,查找SaleMonitorMonth
	 */
	public SaleMonitorMonth findSaleMonitorMonthForAdd(SaleMonitor saleMonitor) throws Exception;
	
	/**
	 * 用于显示,查找SaleMonitorMonth
	 * @param saleMonitor
	 * @return
	 * @throws Exception
	 */
	public SaleMonitorMonth findSaleMonitorMonthToShow(SaleMonitor saleMonitor) throws Exception;
	
	/**
	 * 根据添加,进行更新SaleMonitorMonth
	 * @param saleMonitor
	 * @throws Exception
	 */
	public void updateMonthFromModifySaleMonitorAdd(SaleMonitor saleMonitor) throws Exception;
	
	/**
	 * 根据删除,进行更新SaleMonitorMonth
	 * @param saleMonitor
	 * @throws Exception
	 */
	public void updateMonthFromModifySaleMonitorDel(SaleMonitor saleMonitor) throws Exception; 
	
	/**
	 * 根据添加,进行更新SaleMonitorMonth
	 * @param saleMonitor
	 * @throws Exception
	 */
	public void updateMonthFromAddSaleMonitor(SaleMonitor saleMonitor) throws Exception; 
	
	/**
	 * 删除SaleMonitorMonth,根据监控日期
	 * @param sale
	 * @throws Exception
	 */
	public void deleteSaleMonitorMonthByMonitorDate(SaleMonitor sale) throws Exception;	
	
	/**
	 * 查找定时器,生成SaleMonitorMonth
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public SaleMonitorMonth findQuartzDateSaleMonitorMonth(SaleMonitorMonthCond cond) throws Exception; //用于定时器
	
	/**
	 * 查找SaleMonitorMonth,以CompanyDate分组
	 * 以公司与日期分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitorMonth> findSaleMonitorMonthGroupbyCompanyDate(SaleMonitorMonthCond cond);  //以公司与日期分组
	
	/**
	 * 
	 * 查找SaleMonitorMonth,以CountryDate分组
	 * 以全国与日期分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitorMonth> findSaleMonitorMonthGroupbyCountryDate(SaleMonitorMonthCond cond);  //以全国与日期分组
}
