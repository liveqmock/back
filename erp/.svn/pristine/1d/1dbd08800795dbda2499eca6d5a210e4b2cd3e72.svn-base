package com.ihk.sale.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.sale.data.ISaleMonitorMonthMapper;
import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorMonth;
import com.ihk.sale.data.pojo.SaleMonitorMonthCond;
import com.ihk.sale.data.services.ISaleMonitorMonthServices;

/**
 * SaleMonitorMonth的Services实现(业务实现)
 * @author 
 *
 */
@Service("saleMonitorMonthServices")
public class SaleMonitorMonthServices implements ISaleMonitorMonthServices {

	/**
	 * saleMonitorMonth数据访问接口
	 */
	@Autowired	 ISaleMonitorMonthMapper saleMonitorMonthMapper;

	/**
	 * 删除一条SaleMonitorMonth
	 * @param id
	 */
	public void deleteSaleMonitorMonth(int id) throws RuntimeException {
		saleMonitorMonthMapper.deleteSaleMonitorMonth(id);
	}

	/**
	 * 新增SaleMonitorMonth
	 * @param saleMonitorMonth
	 */
	public void addSaleMonitorMonth(SaleMonitorMonth saleMonitorMonth) throws RuntimeException {		
		saleMonitorMonthMapper.addSaleMonitorMonth(saleMonitorMonth);
	}

	/**
	 * 查找一条SaleMonitorMonth
	 * @return SaleMonitorMonth
	 * @param id 主键id
	 */
	@Override
	public SaleMonitorMonth findSaleMonitorMonthById(int id) throws RuntimeException {
		return saleMonitorMonthMapper.findSaleMonitorMonthById(id);
	}

	/**
	 * 修改SaleMonitorMonth
	 * @param saleMonitorMonth
	 */
	@Override
	public void updateSaleMonitorMonth(SaleMonitorMonth saleMonitorMonth) throws RuntimeException {
		saleMonitorMonthMapper.updateSaleMonitorMonth(saleMonitorMonth);		
	}

	/**
	 * 分页查找SaleMonitorMonth
	 * @param cond 查询条件
	 * @return SaleMonitorMonth列表
	 */
	public List<SaleMonitorMonth> findSaleMonitorMonthPage(SaleMonitorMonthCond cond) throws RuntimeException {
		int recordCount = saleMonitorMonthMapper.findSaleMonitorMonthCount(cond);
		
		cond.recordCount = recordCount;
				
		return saleMonitorMonthMapper.findSaleMonitorMonthPage(cond);
	}

	/**
	 * 查找,用于添加
	 */
	@Override
	public SaleMonitorMonth findSaleMonitorMonthForAdd(SaleMonitor saleMonitor)
			throws Exception {
		
		return saleMonitorMonthMapper.findSaleMonitorMonthForAdd(saleMonitor);
	}

	/**
	 * 修改,用于添加
	 */
	@Override
	public void updateMonthFromModifySaleMonitorAdd(SaleMonitor saleMonitor)
			throws Exception {
		saleMonitorMonthMapper.updateMonthFromModifySaleMonitorAdd(saleMonitor);		
		
	}

	/**
	 * 删除的时候，修改
	 */
	@Override
	public void updateMonthFromModifySaleMonitorDel(SaleMonitor saleMonitor)
			throws Exception {
		saleMonitorMonthMapper.updateMonthFromModifySaleMonitorDel(saleMonitor);
		
	}

	/**
	 * 修改
	 */
	@Override
	public void updateMonthFromAddSaleMonitor(SaleMonitor saleMonitor)
			throws Exception {
		saleMonitorMonthMapper.updateMonthFromAddSaleMonitor(saleMonitor);		
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteSaleMonitorMonthByMonitorDate(SaleMonitor sale)
			throws Exception {
		saleMonitorMonthMapper.deleteSaleMonitorMonthByMonitorDate(sale);
		
	}

	/**
	 * 查找
	 */
	@Override
	public List<SaleMonitorMonth> findSaleMonitorMonth(SaleMonitorMonthCond cond) throws RuntimeException {
		return saleMonitorMonthMapper.findSaleMonitorMonth(cond);
	}
	
	/**
	 * 查找,用于显示
	 */
	@Override
	public SaleMonitorMonth findSaleMonitorMonthToShow(SaleMonitor saleMonitor)throws Exception {
		return saleMonitorMonthMapper.findSaleMonitorMonthToShow(saleMonitor);
	}

	/**
	 * 查找,用于定时器
	 */
	@Override
	public SaleMonitorMonth findQuartzDateSaleMonitorMonth(
			SaleMonitorMonthCond cond) throws Exception {
		return saleMonitorMonthMapper.findQuartzDateSaleMonitorMonth(cond);
	}
	
	/**
	 * 查找,以CompanyDate分组
	 */
	@Override
	public List<SaleMonitorMonth> findSaleMonitorMonthGroupbyCompanyDate(SaleMonitorMonthCond cond)
			throws RuntimeException {
		return saleMonitorMonthMapper.findSaleMonitorMonthGroupbyCompanyDate( cond);
	}
	
	
	/**
	 * 查找,以CcountryDate分组
	 */
	@Override
	public List<SaleMonitorMonth> findSaleMonitorMonthGroupbyCountryDate(SaleMonitorMonthCond cond)
			throws RuntimeException {
		return saleMonitorMonthMapper.findSaleMonitorMonthGroupbyCountryDate( cond);
	}
}
