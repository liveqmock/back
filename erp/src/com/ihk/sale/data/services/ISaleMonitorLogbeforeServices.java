package com.ihk.sale.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.sale.data.pojo.SaleMonitorLogbefore;
import com.ihk.sale.data.pojo.SaleMonitorLogbeforeCond;

/**
 * SaleMonitorLogbefore的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface ISaleMonitorLogbeforeServices {

	/**
	 * 新增SaleMonitorLogbefore
	 * @param saleMonitorLogbefore
	 */
	public void addSaleMonitorLogbefore(SaleMonitorLogbefore saleMonitorLogbefore) throws RuntimeException;

	/**
	 * 删除一条SaleMonitorLogbefore
	 * @param id
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
	public List<SaleMonitorLogbefore> findSaleMonitorLogbeforePage(SaleMonitorLogbeforeCond cond) throws RuntimeException;

	/**
	 * 查找全部SaleMonitorLogbefore
	 * @param cond 查询条件
	 * @return SaleMonitorLogbefore列表
	 */
	public List<SaleMonitorLogbefore> findSaleMonitorLogbefore(SaleMonitorLogbeforeCond cond) throws RuntimeException;
	

	/**
	 * 查找全部SaleMonitorLogbefore
	 * 用于定时器
	 * @param cond 查询条件
	 * @return SaleMonitorLogbefore列表
	 */
	public List<SaleMonitorLogbefore> findSaleMonitorLogbeforeForQuartz(SaleMonitorLogbeforeCond cond) throws Exception; //定时器使用
}