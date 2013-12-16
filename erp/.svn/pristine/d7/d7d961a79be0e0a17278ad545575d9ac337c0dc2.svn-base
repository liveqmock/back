package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IMortgageMapper;
import com.ihk.saleunit.data.pojo.Mortgage;
import com.ihk.saleunit.data.pojo.MortgageCond;
import com.ihk.saleunit.data.services.IMortgageServices;

/**
 * Mortgage的Services实现(业务实现)
 * @author 
 *
 */
@Service("mortgageServices")
@SuppressWarnings("unchecked")
public class MortgageServices implements IMortgageServices {
	/**
	 * mortgage数据访问接口
	 */
	@Autowired	 IMortgageMapper mortgageMapper;

	/**
	 * 删除一条Mortgage
	 * @param id
	 */
	public void deleteMortgage(int id) throws RuntimeException {
		mortgageMapper.deleteMortgage(id);
	}

	/**
	 * 新增Mortgage
	 * @param mortgage
	 */
	public void addMortgage(Mortgage mortgage) throws RuntimeException {		
		mortgageMapper.addMortgage(mortgage);
	}

	/**
	 * 查找一条Mortgage
	 * @return Mortgage
	 * @param id 主键id
	 */
	@Override
	public Mortgage findMortgageById(int id) throws RuntimeException {
		return mortgageMapper.findMortgageById(id);
	}

	/**
	 * 修改Mortgage
	 * @param mortgage
	 */
	@Override
	public void updateMortgage(Mortgage mortgage) throws RuntimeException {
		mortgageMapper.updateMortgage(mortgage);		
	}

	/**
	 * 分页查找Mortgage
	 * @param cond 查询条件
	 * @return Mortgage列表
	 */
	public List<Mortgage> findMortgagePage(MortgageCond cond) throws RuntimeException {
		int recordCount = mortgageMapper.findMortgageCount(cond);
		
		cond.recordCount = recordCount;
				
		return mortgageMapper.findMortgagePage(cond);
	}

	/**
	 * 查找全部Mortgage
	 * @param cond 查询条件
	 * @return Mortgage列表
	 */
	public List<Mortgage> findMortgage(MortgageCond cond) throws RuntimeException {
    	return mortgageMapper.findMortgage(cond);
	}
}
