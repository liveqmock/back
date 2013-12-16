package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.SaleDaily;
import com.ihk.saleunit.data.pojo.SaleDailyCond;

/**
 * SaleDaily的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface ISaleDailyServices {
	/**
	 * 新增SaleDaily
	 * @param saleDaily
	 */
	public void addSaleDaily(SaleDaily saleDaily) throws RuntimeException;

	/**
	 * 删除一条SaleDaily
	 * @param id
	 */
	public void deleteSaleDaily(int id) throws RuntimeException;

	/**
	 * 修改SaleDaily
	 * @param saleDaily
	 */
	public void updateSaleDaily(SaleDaily saleDaily) throws RuntimeException;

	/**
	 * 查找一条SaleDaily
	 * @return SaleDaily
	 * @param id 主键id
	 */
	public SaleDaily findSaleDailyById(int id) throws RuntimeException;

	/**
	 * 分页查找SaleDaily
	 * @param cond 查询条件
	 * @return SaleDaily列表
	 */
	public List<SaleDaily> findSaleDailyPage(SaleDailyCond cond) throws RuntimeException;

	/**
	 * 查找全部SaleDaily
	 * @param cond 查询条件
	 * @return SaleDaily列表
	 */
	public List<SaleDaily> findSaleDaily(SaleDailyCond cond) throws RuntimeException;
}