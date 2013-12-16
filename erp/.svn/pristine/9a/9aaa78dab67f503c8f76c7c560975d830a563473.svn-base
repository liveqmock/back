package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.SaleUnitLog;
import com.ihk.saleunit.data.pojo.SaleUnitLogCond;

/**
 * SaleUnitLog数据访问接口Mapper
 * @author 
 *
 */ 
public interface ISaleUnitLogMapper {

	/**
	 * 新增SaleUnitLog
	 * @param saleUnitLog
	 */
	public void addSaleUnitLog(SaleUnitLog saleUnitLog) ;

	/**
	 * 根据条件删除SaleUnitLog
	 * @param cond 删除条件
	 */
	public void deleteSaleUnitLog(int id) throws RuntimeException;

	/**
	 * 修改SaleUnitLog
	 * @param saleUnitLog
	 */
	public void updateSaleUnitLog(SaleUnitLog saleUnitLog) throws RuntimeException;

	/**
	 * 查找一条SaleUnitLog
	 * @return SaleUnitLog
	 * @param id 主键id
	 */
	public SaleUnitLog findSaleUnitLogById(int id) throws RuntimeException;

	/**
	 * 分页查找SaleUnitLog
	 * @param cond 查询条件
	 * @return SaleUnitLog列表
	 */
	public List<SaleUnitLog> findSaleUnitLogPage(SaleUnitLogCond cond) ;

	/**
	 * 查找全部SaleUnitLog
	 * @param cond 查询条件
	 * @return SaleUnitLog列表
	 */
	public List<SaleUnitLog> findSaleUnitLog(SaleUnitLogCond cond) ;

	/**
	 * 查找符合条件的记录条数SaleUnitLog
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findSaleUnitLogCount(SaleUnitLogCond cond) ;
}
