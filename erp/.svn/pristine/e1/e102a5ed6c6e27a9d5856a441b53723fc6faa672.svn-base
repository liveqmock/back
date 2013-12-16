package com.ihk.sale.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.sale.data.ISaleMonitorAllMapper;
import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorAll;
import com.ihk.sale.data.pojo.SaleMonitorAllCond;
import com.ihk.sale.data.services.ISaleMonitorAllServices;

/**
 * SaleMonitorAll的Services实现(业务实现)
 * @author 
 *
 */
@Service("saleMonitorAllServices")
public class SaleMonitorAllServices implements ISaleMonitorAllServices {

	/**
	 * saleMonitorAll数据访问接口
	 */
	@Autowired	 ISaleMonitorAllMapper saleMonitorAllMapper;

	/**
	 * 删除一条SaleMonitorAll
	 * @param id
	 */
	public void deleteSaleMonitorAll(int id) throws RuntimeException {
		saleMonitorAllMapper.deleteSaleMonitorAll(id);
	}

	/**
	 * 新增SaleMonitorAll
	 * @param saleMonitorAll
	 */
	public void addSaleMonitorAll(SaleMonitorAll saleMonitorAll) throws RuntimeException {		
		saleMonitorAllMapper.addSaleMonitorAll(saleMonitorAll);
	}

	/**
	 * 查找一条SaleMonitorAll
	 * @return SaleMonitorAll
	 * @param id 主键id
	 */
	@Override
	public SaleMonitorAll findSaleMonitorAllById(int id) throws RuntimeException {
		return saleMonitorAllMapper.findSaleMonitorAllById(id);
	}

	/**
	 * 修改SaleMonitorAll
	 * @param saleMonitorAll
	 */
	@Override
	public void updateSaleMonitorAll(SaleMonitorAll saleMonitorAll) throws RuntimeException {
		saleMonitorAllMapper.updateSaleMonitorAll(saleMonitorAll);		
	}

	/**
	 * 分页查找SaleMonitorAll
	 * @param cond 查询条件
	 * @return SaleMonitorAll列表
	 */
	@SuppressWarnings("rawtypes")
	public List findSaleMonitorAllPage(SaleMonitorAllCond cond) throws RuntimeException {
		int recordCount = saleMonitorAllMapper.findSaleMonitorAllCount(cond);
		
		cond.recordCount = recordCount;
				
		return saleMonitorAllMapper.findSaleMonitorAllPage(cond);
	}

	/**
	 * 查找,用于添加
	 */
	@Override
	public SaleMonitorAll findSaleMonitorAllForAdd(SaleMonitor sale) throws Exception {
		return saleMonitorAllMapper.findSaleMonitorAllForAdd(sale);
	}

	
	@Override
	public SaleMonitorAll findSaleMonitorAllToShow(SaleMonitor saleMonitor)
			throws Exception {
		return saleMonitorAllMapper.findSaleMonitorAllToShow(saleMonitor);
	}
	
	@Override
	public void updateAllFromModifySaleMonitorAdd(SaleMonitor sale)
			throws Exception {
		
		saleMonitorAllMapper.updateAllFromModifySaleMonitorAdd(sale);
		
	}


	@Override
	public void updateAllFromModifySaleMonitorDel(SaleMonitor sale)
			throws Exception {
		
		saleMonitorAllMapper.updateAllFromModifySaleMonitorDel(sale);
		
	}

	@Override
	public void updateAllFromAddSaleMonitor(SaleMonitor saleMonitor)
			throws Exception {
		
		saleMonitorAllMapper.updateAllFromAddSaleMonitor(saleMonitor);
		
	}

	@Override
	public void deleteSaleMonitorAllByMonitorDate(SaleMonitor sale)
			throws Exception {
		saleMonitorAllMapper.deleteSaleMonitorAllByMonitorDate(sale);
		
	}

	@Override
	public List<SaleMonitorAll> findSaleMonitorAllNoPage(SaleMonitorAllCond cond)
			throws Exception {
		return saleMonitorAllMapper.findSaleMonitorAllNoPage(cond);
	}
}
