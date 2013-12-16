package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IUnitGiftMapper;
import com.ihk.saleunit.data.pojo.UnitGift;
import com.ihk.saleunit.data.pojo.UnitGiftCond;
import com.ihk.saleunit.data.services.IUnitGiftServices;

/**
 * UnitGift的Services实现(业务实现)
 * @author 
 *
 */
@Service("unitGiftServices")
@SuppressWarnings("unchecked")
public class UnitGiftServices implements IUnitGiftServices {
	/**
	 * unitGift数据访问接口
	 */
	@Autowired	 IUnitGiftMapper unitGiftMapper;

	/**
	 * 删除一条UnitGift
	 * @param id
	 */
	public void deleteUnitGift(int id) throws RuntimeException {
		unitGiftMapper.deleteUnitGift(id);
	}

	/**
	 * 新增UnitGift
	 * @param unitGift
	 */
	public void addUnitGift(UnitGift unitGift) throws RuntimeException {		
		unitGiftMapper.addUnitGift(unitGift);
	}

	/**
	 * 查找一条UnitGift
	 * @return UnitGift
	 * @param id 主键id
	 */
	@Override
	public UnitGift findUnitGiftById(int id) throws RuntimeException {
		return unitGiftMapper.findUnitGiftById(id);
	}

	/**
	 * 修改UnitGift
	 * @param unitGift
	 */
	@Override
	public void updateUnitGift(UnitGift unitGift) throws RuntimeException {
		unitGiftMapper.updateUnitGift(unitGift);		
	}

	/**
	 * 分页查找UnitGift
	 * @param cond 查询条件
	 * @return UnitGift列表
	 */
	public List<UnitGift> findUnitGiftPage(UnitGiftCond cond) throws RuntimeException {
		int recordCount = unitGiftMapper.findUnitGiftCount(cond);
		
		cond.recordCount = recordCount;
				
		return unitGiftMapper.findUnitGiftPage(cond);
	}

	/**
	 * 查找全部UnitGift
	 * @param cond 查询条件
	 * @return UnitGift列表
	 */
	public List<UnitGift> findUnitGift(UnitGiftCond cond) throws RuntimeException {
    	return unitGiftMapper.findUnitGift(cond);
	}
}
