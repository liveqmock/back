package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.SaleUnitLog;
import com.ihk.saleunit.data.pojo.SaleUnitLogCond;

/**
 * SaleUnitLog的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface ISaleUnitLogServices {
	/**
	 * 新增SaleUnitLog
	 * @param saleUnitLog
	 */
	public void addSaleUnitLog(SaleUnitLog saleUnitLog) throws RuntimeException;

	/**
	 * 删除一条SaleUnitLog
	 * @param id
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
	public List<SaleUnitLog> findSaleUnitLogPage(SaleUnitLogCond cond) throws RuntimeException;

	/**
	 * 查找全部SaleUnitLog
	 * @param cond 查询条件
	 * @return SaleUnitLog列表
	 */
	public List<SaleUnitLog> findSaleUnitLog(SaleUnitLogCond cond) throws RuntimeException;
}