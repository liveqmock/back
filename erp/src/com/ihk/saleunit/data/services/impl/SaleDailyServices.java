package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.ISaleDailyMapper;
import com.ihk.saleunit.data.pojo.SaleDaily;
import com.ihk.saleunit.data.pojo.SaleDailyCond;
import com.ihk.saleunit.data.services.ISaleDailyServices;

/**
 * SaleDaily的Services实现(业务实现)
 * @author 
 *
 */
@Service("saleDailyServices")
@SuppressWarnings("unchecked")
public class SaleDailyServices implements ISaleDailyServices {
	/**
	 * saleDaily数据访问接口
	 */
	@Autowired	 ISaleDailyMapper saleDailyMapper;

	/**
	 * 删除一条SaleDaily
	 * @param id
	 */
	public void deleteSaleDaily(int id) throws RuntimeException {
		saleDailyMapper.deleteSaleDaily(id);
	}

	/**
	 * 新增SaleDaily
	 * @param saleDaily
	 */
	public void addSaleDaily(SaleDaily saleDaily) throws RuntimeException {		
		saleDailyMapper.addSaleDaily(saleDaily);
	}

	/**
	 * 查找一条SaleDaily
	 * @return SaleDaily
	 * @param id 主键id
	 */
	@Override
	public SaleDaily findSaleDailyById(int id) throws RuntimeException {
		return saleDailyMapper.findSaleDailyById(id);
	}

	/**
	 * 修改SaleDaily
	 * @param saleDaily
	 */
	@Override
	public void updateSaleDaily(SaleDaily saleDaily) throws RuntimeException {
		saleDailyMapper.updateSaleDaily(saleDaily);		
	}

	/**
	 * 分页查找SaleDaily
	 * @param cond 查询条件
	 * @return SaleDaily列表
	 */
	public List<SaleDaily> findSaleDailyPage(SaleDailyCond cond) throws RuntimeException {
		int recordCount = saleDailyMapper.findSaleDailyCount(cond);
		
		cond.recordCount = recordCount;
				
		return saleDailyMapper.findSaleDailyPage(cond);
	}

	/**
	 * 查找全部SaleDaily
	 * @param cond 查询条件
	 * @return SaleDaily列表
	 */
	public List<SaleDaily> findSaleDaily(SaleDailyCond cond) throws RuntimeException {
    	return saleDailyMapper.findSaleDaily(cond);
	}
}
