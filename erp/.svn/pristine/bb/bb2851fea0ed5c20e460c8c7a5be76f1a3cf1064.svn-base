package com.ihk.sale.data;

import java.util.List;

import com.ihk.sale.data.pojo.SaleMonitorLogbefore;
import com.ihk.sale.data.pojo.SaleMonitorLogbeforeCond;

/**
 * SaleMonitorLogbefore数据访问接口Mapper
 * @author 
 *
 */ 
public interface ISaleMonitorLogbeforeMapper {

	/**
	 * 新增SaleMonitorLogbefore
	 * @param saleMonitorLogbefore
	 */
	public void addSaleMonitorLogbefore(SaleMonitorLogbefore saleMonitorLogbefore) ;

	/**
	 * 根据条件删除SaleMonitorLogbefore
	 * @param cond 删除条件
	 */
	public void deleteSaleMonitorLogbefore(int id) throws RuntimeException;


	/**
	 * 修改SaleMonitorLogbefore
	 * @param saleMonitorLogbefore
	 */
	public void updateSaleMonitorLogbefore(SaleMonitorLogbefore saleMonitorLogbefore) throws RuntimeException;

	/**
	 * 查找一条SaleMonitorLogbefore
	 * @return SaleMonitorLogbefore
	 * @param id 主键id
	 */
	public SaleMonitorLogbefore findSaleMonitorLogbeforeById(int id) throws RuntimeException;

	/**
	 * 分页查找SaleMonitorLogbefore
	 * @param cond 查询条件
	 * @return SaleMonitorLogbefore列表
	 */
	public List<SaleMonitorLogbefore> findSaleMonitorLogbeforePage(SaleMonitorLogbeforeCond cond) ;

	/**
	 * 查找全部SaleMonitorLogbefore
	 * @param cond 查询条件
	 * @return SaleMonitorLogbefore列表
	 */
	public List<SaleMonitorLogbefore> findSaleMonitorLogbefore(SaleMonitorLogbeforeCond cond) ;

	/**
	 * 查找符合条件的记录条数SaleMonitorLogbefore
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findSaleMonitorLogbeforeCount(SaleMonitorLogbeforeCond cond) ;
	
	/**
	 * 查找SaleMonitorLogbefore ,用于 定时器
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<SaleMonitorLogbefore> findSaleMonitorLogbeforeForQuartz(SaleMonitorLogbeforeCond cond) throws Exception; //定时器使用
	
	/**
	 * 查找一天前的SaleMonitorLogbefore
	 * @param cond
	 * @return
	 */
	public List<SaleMonitorLogbefore> findOneDay(SaleMonitorLogbeforeCond cond);
	
}
