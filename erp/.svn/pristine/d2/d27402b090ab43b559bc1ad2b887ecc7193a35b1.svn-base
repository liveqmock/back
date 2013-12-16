package com.ihk.sale.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.sale.data.ISaleMonitorWeekMapper;
import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorWeek;
import com.ihk.sale.data.pojo.SaleMonitorWeekCond;
import com.ihk.sale.data.services.ISaleMonitorWeekServices;

/**
 * SaleMonitorWeek的Services实现(业务实现)
 * @author 
 *
 */
@Service("saleMonitorWeekServices")
public class SaleMonitorWeekServices implements ISaleMonitorWeekServices {
	/**
	 * saleMonitorWeek数据访问接口
	 */
	@Autowired	 ISaleMonitorWeekMapper saleMonitorWeekMapper;

	/**
	 * 删除一条SaleMonitorWeek
	 * @param id
	 */
	public void deleteSaleMonitorWeek(int id) throws RuntimeException {
		saleMonitorWeekMapper.deleteSaleMonitorWeek(id);
	}

	/**
	 * 新增SaleMonitorWeek
	 * @param saleMonitorWeek
	 */
	public void addSaleMonitorWeek(SaleMonitorWeek saleMonitorWeek) throws RuntimeException {		
		saleMonitorWeekMapper.addSaleMonitorWeek(saleMonitorWeek);
	}

	/**
	 * 查找一条SaleMonitorWeek
	 * @return SaleMonitorWeek
	 * @param id 主键id
	 */
	@Override
	public SaleMonitorWeek findSaleMonitorWeekById(int id) throws RuntimeException {
		return saleMonitorWeekMapper.findSaleMonitorWeekById(id);
	}

	/**
	 * 修改SaleMonitorWeek
	 * @param saleMonitorWeek
	 */
	@Override
	public void updateSaleMonitorWeek(SaleMonitorWeek saleMonitorWeek) throws RuntimeException {
		saleMonitorWeekMapper.updateSaleMonitorWeek(saleMonitorWeek);		
	}

	/**
	 * 分页查找SaleMonitorWeek
	 * @param cond 查询条件
	 * @return SaleMonitorWeek列表
	 */
	public List<SaleMonitorWeek> findSaleMonitorWeekPage(SaleMonitorWeekCond cond) throws RuntimeException {
		int recordCount = saleMonitorWeekMapper.findSaleMonitorWeekCount(cond);
		
		cond.recordCount = recordCount;
				
		return saleMonitorWeekMapper.findSaleMonitorWeekPage(cond);
	}

	/**
	 * 查找全部SaleMonitorWeek
	 * @param cond 查询条件
	 * @return SaleMonitorWeek列表
	 */
	public List<SaleMonitorWeek> findSaleMonitorWeek(SaleMonitorWeekCond cond) throws RuntimeException {
    	return saleMonitorWeekMapper.findSaleMonitorWeek(cond);
	}

	/**
	 * 查找,用于显示
	 */
	@Override
	public SaleMonitorWeek findSaleMonitorWeekToShow(SaleMonitor sale)
			throws Exception {
		return saleMonitorWeekMapper.findSaleMonitorWeekToShow(sale);
	}

	/**
	 * 查找,定时器数据
	 */
	@Override
	public SaleMonitorWeek findQuartzDateSaleMonitorWeek(
			SaleMonitorWeekCond cond) throws Exception {
		return saleMonitorWeekMapper.findQuartzDateSaleMonitorWeek(cond);
	}
	
	/**
	 * 查找，以公司，日期分组
	 */
	@Override
	public List<SaleMonitorWeek> findSaleMonitorWeekGroupbyCompanyDate(SaleMonitorWeekCond cond)
			throws RuntimeException {
		return saleMonitorWeekMapper.findSaleMonitorWeekGroupbyCompanyDate( cond);
	}
	
	
	/**
	 * 查找，以全国，日期分组
	 */
	@Override
	public List<SaleMonitorWeek> findSaleMonitorWeekGroupbyCountryDate(SaleMonitorWeekCond cond)
			throws RuntimeException {
		return saleMonitorWeekMapper.findSaleMonitorWeekGroupbyCountryDate( cond);
	}
}
