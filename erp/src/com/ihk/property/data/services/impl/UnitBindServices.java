package com.ihk.property.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IUnitBindMapper;
import com.ihk.property.data.pojo.UnitBind;
import com.ihk.property.data.pojo.UnitBindCond;
import com.ihk.property.data.services.IUnitBindServices;

/**
 * UnitBind的Services实现(业务实现)
 * @author 
 *
 */
@Service("unitBindServices")
@SuppressWarnings("unchecked")
public class UnitBindServices implements IUnitBindServices {
	/**
	 * unitBind数据访问接口
	 */
	@Autowired	 IUnitBindMapper unitBindMapper;

	/**
	 * 删除一条UnitBind
	 * @param id
	 */
	public void deleteUnitBind(int id) throws RuntimeException {
		unitBindMapper.deleteUnitBind(id);
	}

	/**
	 * 新增UnitBind
	 * @param unitBind
	 */
	public void addUnitBind(UnitBind unitBind) throws RuntimeException {		
		unitBindMapper.addUnitBind(unitBind);
	}

	/**
	 * 查找一条UnitBind
	 * @return UnitBind
	 * @param id 主键id
	 */
	@Override
	public UnitBind findUnitBindById(int id) throws RuntimeException {
		return unitBindMapper.findUnitBindById(id);
	}


	/**
	 * 修改UnitBind
	 * @param unitBind
	 */
	@Override
	public void updateUnitBind(UnitBind unitBind) throws RuntimeException {
		unitBindMapper.updateUnitBind(unitBind);		
	}

	/**
	 * 分页查找UnitBind
	 * @param cond 查询条件
	 * @return UnitBind列表
	 */
	public List<UnitBind> findUnitBindPage(UnitBindCond cond) throws RuntimeException {
		int recordCount = unitBindMapper.findUnitBindCount(cond);
		
		cond.recordCount = recordCount;
				
		return unitBindMapper.findUnitBindPage(cond);
	}

	/**
	 * 查找全部UnitBind
	 * @param cond 查询条件
	 * @return UnitBind列表
	 */
	public List<UnitBind> findUnitBind(UnitBindCond cond) throws RuntimeException {
    	return unitBindMapper.findUnitBind(cond);
	}

	/**
	 * 根据buildId删除
	 */
	@Override
	public int deletedByBuildId(int buildId) throws RuntimeException {
		return unitBindMapper.deletedByBuildId(buildId);
	}
}
