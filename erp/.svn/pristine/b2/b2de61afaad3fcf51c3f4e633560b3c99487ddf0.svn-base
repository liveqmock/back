package com.ihk.sale.data;

import java.util.List;

import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorAll;
import com.ihk.sale.data.pojo.SaleMonitorAllCond;

/**
 * SaleMonitorAll数据访问接口Mapper
 * @author 
 *
 */ 
public interface ISaleMonitorAllMapper {

	/**
	 * 新增SaleMonitorAll
	 * @param saleMonitorAll
	 */
	public void addSaleMonitorAll(SaleMonitorAll saleMonitorAll) ;

	/**
	 * 根据条件删除SaleMonitorAll
	 * @param cond 删除条件
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
	public List<SaleMonitorAll> findSaleMonitorAllPage(SaleMonitorAllCond cond) ;

	/**
	 * 查找符合条件的记录条数SaleMonitorAll
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findSaleMonitorAllCount(SaleMonitorAllCond cond) ;
	
	/**
	 * 查找SaleMonitorAll用于添加
	 * @param sale
	 * @return
	 * @throws Exception
	 */
	public SaleMonitorAll findSaleMonitorAllForAdd(SaleMonitor sale) throws Exception ;
	
	/**
	 * 查找SaleMonitorAll用于显示
	 * @param saleMonitor
	 * @return
	 * @throws Exception
	 */
	public SaleMonitorAll findSaleMonitorAllToShow(SaleMonitor saleMonitor) throws Exception;
	
	/**
	 * 添加后,修改SaleMonitorAll
	 * @param sale
	 * @throws Exception
	 */
	public void updateAllFromModifySaleMonitorAdd(SaleMonitor sale) throws Exception;
	
	/**
	 * 删除后,更新SaleMonitorAll
	 */
	public void updateAllFromModifySaleMonitorDel(SaleMonitor sale) throws Exception;
	
	/**
	 * 添加后,修改SaleMonitorAll
	 * @param saleMonitor
	 * @throws Exception
	 */
	public void updateAllFromAddSaleMonitor(SaleMonitor saleMonitor) throws Exception;
	
	/**
	 * 删除后,更新SaleMonitorAll 
	 * @param sale
	 * @throws Exception
	 */
	public void deleteSaleMonitorAllByMonitorDate(SaleMonitor sale)	throws Exception;

	/**
	 * 查找全部SaleMonitorAll
	 * @param cond 查询条件
	 * @return SaleMonitorAll列表
	 */
	public List<SaleMonitorAll> findSaleMonitorAllNoPage(SaleMonitorAllCond cond) throws Exception;
}
