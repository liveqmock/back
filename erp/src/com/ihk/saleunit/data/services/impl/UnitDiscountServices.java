package com.ihk.saleunit.data.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IUnitDiscountMapper;
import com.ihk.saleunit.data.pojo.UnitDiscount;
import com.ihk.saleunit.data.pojo.UnitDiscountCond;
import com.ihk.saleunit.data.services.IUnitDiscountServices;

/**
 * UnitDiscount的Services实现(业务实现)
 * @author 
 *
 */
@Service("unitDiscountServices")
public class UnitDiscountServices implements IUnitDiscountServices {
	/**
	 * unitDiscount数据访问接口
	 */
	@Autowired	 IUnitDiscountMapper unitDiscountMapper;

	/**
	 * 删除一条UnitDiscount
	 * @param id
	 */
	public void deleteUnitDiscount(int id) throws RuntimeException {
		unitDiscountMapper.deleteUnitDiscount(id);
	}

	/**
	 * 新增UnitDiscount
	 * @param unitDiscount
	 */
	public void addUnitDiscount(UnitDiscount unitDiscount) throws RuntimeException {		
		unitDiscountMapper.addUnitDiscount(unitDiscount);
	}

	/**
	 * 查找一条UnitDiscount
	 * @return UnitDiscount
	 * @param id 主键id
	 */
	@Override
	public UnitDiscount findUnitDiscountById(int id) throws RuntimeException {
		return unitDiscountMapper.findUnitDiscountById(id);
	}

	/**
	 * 修改UnitDiscount
	 * @param unitDiscount
	 */
	@Override
	public void updateUnitDiscount(UnitDiscount unitDiscount) throws RuntimeException {
		unitDiscountMapper.updateUnitDiscount(unitDiscount);		
	}

	/**
	 * 分页查找UnitDiscount
	 * @param cond 查询条件
	 * @return UnitDiscount列表
	 */
	public List<UnitDiscount> findUnitDiscountPage(UnitDiscountCond cond) throws RuntimeException {
		int recordCount = unitDiscountMapper.findUnitDiscountCount(cond);
		
		cond.recordCount = recordCount;
				
		return unitDiscountMapper.findUnitDiscountPage(cond);
	}

	/**
	 * 查找全部UnitDiscount
	 * @param cond 查询条件
	 * @return UnitDiscount列表
	 */
	public List<UnitDiscount> findUnitDiscount(UnitDiscountCond cond) throws RuntimeException {
    	return unitDiscountMapper.findUnitDiscount(cond);
	}

	/**
	 * 修改
	 */
	@Override
	public void updateUnitDiscountMainId(int unitDiscountId, int mainId, String type)
			throws RuntimeException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("unitDiscountId", unitDiscountId + "");
		map.put("mainId", mainId + "");
		map.put("type", type);
		
		unitDiscountMapper.updateUnitDiscountMainId(map);
	}

	/**
	 * 查找，根据type与mainId
	 */
	@Override
	public UnitDiscount findUnitDiscountByTypeAndMainId(String type, int mainId)
			throws RuntimeException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("mainId", mainId + "");
		
		return unitDiscountMapper.findUnitDiscountByTypeAndMainId(map);
	}
}
