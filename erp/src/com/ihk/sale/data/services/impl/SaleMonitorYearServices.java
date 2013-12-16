package com.ihk.sale.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.sale.data.ISaleMonitorYearMapper;
import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorYear;
import com.ihk.sale.data.pojo.SaleMonitorYearCond;
import com.ihk.sale.data.services.ISaleMonitorYearServices;

/**
 * SaleMonitorYear的Services实现(业务实现)
 * @author 
 *
 */
@Service("saleMonitorYearServices")
public class SaleMonitorYearServices implements ISaleMonitorYearServices {

	/**
	 * saleMonitorYear数据访问接口
	 */
	@Autowired	 ISaleMonitorYearMapper saleMonitorYearMapper;

	/**
	 * 删除一条SaleMonitorYear
	 * @param id
	 */
	public void deleteSaleMonitorYear(int id) throws RuntimeException {
		saleMonitorYearMapper.deleteSaleMonitorYear(id);
	}

	/**
	 * 新增SaleMonitorYear
	 * @param saleMonitorYear
	 */
	public void addSaleMonitorYear(SaleMonitorYear saleMonitorYear) throws RuntimeException {		
		saleMonitorYearMapper.addSaleMonitorYear(saleMonitorYear);
	}

	/**
	 * 查找一条SaleMonitorYear
	 * @return SaleMonitorYear
	 * @param id 主键id
	 */
	@Override
	public SaleMonitorYear findSaleMonitorYearById(int id) throws RuntimeException {
		return saleMonitorYearMapper.findSaleMonitorYearById(id);
	}

	/**
	 * 修改SaleMonitorYear
	 * @param saleMonitorYear
	 */
	@Override
	public void updateSaleMonitorYear(SaleMonitorYear saleMonitorYear) throws RuntimeException {
		saleMonitorYearMapper.updateSaleMonitorYear(saleMonitorYear);		
	}

	/**
	 * 分页查找SaleMonitorYear
	 * @param cond 查询条件
	 * @return SaleMonitorYear列表
	 */
	public List<SaleMonitorYear> findSaleMonitorYearPage(SaleMonitorYearCond cond) throws RuntimeException {
		int recordCount = saleMonitorYearMapper.findSaleMonitorYearCount(cond);
		
		cond.recordCount = recordCount;
				
		return saleMonitorYearMapper.findSaleMonitorYearPage(cond);
	}

	/**
	 * 查找全部SaleMonitorYear
	 * @param cond 查询条件
	 * @return SaleMonitorYear列表
	 */
	public List<SaleMonitorYear> findSaleMonitorYear(SaleMonitorYearCond cond) throws RuntimeException {
    	return saleMonitorYearMapper.findSaleMonitorYear(cond);
	}

	/**
	 * 查找,用于显示
	 */
	@Override
	public SaleMonitorYear findSaleMonitorYearToShow(SaleMonitor sale)
			throws Exception {
		return saleMonitorYearMapper.findSaleMonitorYearToShow(sale);
	}

	/**
	 * 查找，定时器
	 */
	@Override
	public SaleMonitorYear findQuartzDateSaleMonitorYear(
			SaleMonitorYearCond cond) throws Exception {
		return saleMonitorYearMapper.findQuartzDateSaleMonitorYear(cond);
	}
	
	/**
	 * 查找，以公司，日期分组
	 */
	@Override
	public List<SaleMonitorYear> findSaleMonitorYearGroupbyCompanyDate(SaleMonitorYearCond cond)
			throws RuntimeException {
		return saleMonitorYearMapper.findSaleMonitorYearGroupbyCompanyDate( cond);
	}
	
	/**
	 * 查找，以全国，日期分组
	 */
	@Override
	public List<SaleMonitorYear> findSaleMonitorYearGroupbyCountryDate(SaleMonitorYearCond cond)
			throws RuntimeException {
		return saleMonitorYearMapper.findSaleMonitorYearGroupbyCountryDate( cond);
	}
}
