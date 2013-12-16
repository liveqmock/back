package com.ihk.saleunit.data.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.ISaleUnitLogMapper;
import com.ihk.saleunit.data.pojo.SaleUnitLog;
import com.ihk.saleunit.data.pojo.SaleUnitLogCond;
import com.ihk.saleunit.data.services.ISaleUnitLogServices;
import com.ihk.utils.SessionUser;

/**
 * SaleUnitLog的Services实现(业务实现)
 * @author 
 *
 */
@Service("saleUnitLogServices")
@SuppressWarnings("unchecked")
public class SaleUnitLogServices implements ISaleUnitLogServices {
	/**
	 * saleUnitLog数据访问接口
	 */
	@Autowired	 ISaleUnitLogMapper saleUnitLogMapper;
	/**
	 * 删除一条SaleUnitLog
	 * @param id
	 */
	public void deleteSaleUnitLog(int id) throws RuntimeException {
		saleUnitLogMapper.deleteSaleUnitLog(id);
	}

	/**
	 * 新增SaleUnitLog
	 * @param saleUnitLog
	 */
	public void addSaleUnitLog(SaleUnitLog saleUnitLog) throws RuntimeException {	
		saleUnitLog.setCreatedId(SessionUser.getUserId());
		saleUnitLog.setModId(SessionUser.getUserId());
		saleUnitLog.setModTime(new Date());
		saleUnitLog.setCreatedTime(saleUnitLog.getModTime());
		saleUnitLog.setIsDeleted("0");
		saleUnitLogMapper.addSaleUnitLog(saleUnitLog);
	}

	/**
	 * 查找一条SaleUnitLog
	 * @return SaleUnitLog
	 * @param id 主键id
	 */
	@Override
	public SaleUnitLog findSaleUnitLogById(int id) throws RuntimeException {
		return saleUnitLogMapper.findSaleUnitLogById(id);
	}

	/**
	 * 修改SaleUnitLog
	 * @param saleUnitLog
	 */
	@Override
	public void updateSaleUnitLog(SaleUnitLog saleUnitLog) throws RuntimeException {
		saleUnitLogMapper.updateSaleUnitLog(saleUnitLog);		
	}

	/**
	 * 分页查找SaleUnitLog
	 * @param cond 查询条件
	 * @return SaleUnitLog列表
	 */
	public List<SaleUnitLog> findSaleUnitLogPage(SaleUnitLogCond cond) throws RuntimeException {
		int recordCount = saleUnitLogMapper.findSaleUnitLogCount(cond);
		
		cond.recordCount = recordCount;
				
		return saleUnitLogMapper.findSaleUnitLogPage(cond);
	}

	/**
	 * 查找全部SaleUnitLog
	 * @param cond 查询条件
	 * @return SaleUnitLog列表
	 */
	public List<SaleUnitLog> findSaleUnitLog(SaleUnitLogCond cond) throws RuntimeException {
    	return saleUnitLogMapper.findSaleUnitLog(cond);
	}
}
