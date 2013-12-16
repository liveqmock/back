package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IMortgageUnitMapper;
import com.ihk.saleunit.data.pojo.MortgageUnit;
import com.ihk.saleunit.data.pojo.MortgageUnitCond;
import com.ihk.saleunit.data.services.IMortgageUnitServices;

/**
 * MortgageUnit的Services实现(业务实现)
 * @author 
 *
 */
@Service("mortgageUnitServices")
@SuppressWarnings("unchecked")
public class MortgageUnitServices implements IMortgageUnitServices {
	/**
	 * mortgageUnit数据访问接口
	 */
	@Autowired	 IMortgageUnitMapper mortgageUnitMapper;

	/**
	 * 删除一条MortgageUnit
	 * @param id
	 */
	public void deleteMortgageUnit(int id) throws RuntimeException {
		mortgageUnitMapper.deleteMortgageUnit(id);
	}

	/**
	 * 新增MortgageUnit
	 * @param mortgageUnit
	 */
	public void addMortgageUnit(MortgageUnit mortgageUnit) throws RuntimeException {		
		mortgageUnitMapper.addMortgageUnit(mortgageUnit);
	}

	/**
	 * 查找一条MortgageUnit
	 * @return MortgageUnit
	 * @param id 主键id
	 */
	@Override
	public MortgageUnit findMortgageUnitById(int id) throws RuntimeException {
		return mortgageUnitMapper.findMortgageUnitById(id);
	}

	/**
	 * 修改MortgageUnit
	 * @param mortgageUnit
	 */
	@Override
	public void updateMortgageUnit(MortgageUnit mortgageUnit) throws RuntimeException {
		mortgageUnitMapper.updateMortgageUnit(mortgageUnit);		
	}

	/**
	 * 分页查找MortgageUnit
	 * @param cond 查询条件
	 * @return MortgageUnit列表
	 */
	public List<MortgageUnit> findMortgageUnitPage(MortgageUnitCond cond) throws RuntimeException {
		int recordCount = mortgageUnitMapper.findMortgageUnitCount(cond);
		
		cond.recordCount = recordCount;
				
		return mortgageUnitMapper.findMortgageUnitPage(cond);
	}

	/**
	 * 查找全部MortgageUnit
	 * @param cond 查询条件
	 * @return MortgageUnit列表
	 */
	public List<MortgageUnit> findMortgageUnit(MortgageUnitCond cond) throws RuntimeException {
    	return mortgageUnitMapper.findMortgageUnit(cond);
	}
}
