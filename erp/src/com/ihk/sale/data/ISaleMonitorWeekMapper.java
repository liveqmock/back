package com.ihk.sale.data;

import java.util.List;

import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorWeek;
import com.ihk.sale.data.pojo.SaleMonitorWeekCond;

/**
 * SaleMonitorWeek数据访问接口Mapper
 * @author 
 *
 */ 
public interface ISaleMonitorWeekMapper {

	/**
	 * 新增SaleMonitorWeek
	 * @param saleMonitorWeek
	 */
	public void addSaleMonitorWeek(SaleMonitorWeek saleMonitorWeek) ;

	/**
	 * 根据条件删除SaleMonitorWeek
	 * @param cond 删除条件
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
	public List<SaleMonitorWeek> findSaleMonitorWeekPage(SaleMonitorWeekCond cond) ;

	/**
	 * 查找全部SaleMonitorWeek
	 * @param cond 查询条件
	 * @return SaleMonitorWeek列表
	 */
	public List<SaleMonitorWeek> findSaleMonitorWeek(SaleMonitorWeekCond cond) ;

	/**
	 * 查找符合条件的记录条数SaleMonitorWeek
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findSaleMonitorWeekCount(SaleMonitorWeekCond cond) ;
	

	/**
	 * 查找SaleMonitorWeek用于显示
	 * @param sale 查询条件
	 */
	public SaleMonitorWeek findSaleMonitorWeekToShow(SaleMonitor sale) throws Exception;
	
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
