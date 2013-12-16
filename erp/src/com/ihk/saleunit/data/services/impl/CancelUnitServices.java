package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.ICancelUnitMapper;
import com.ihk.saleunit.data.pojo.CancelUnit;
import com.ihk.saleunit.data.pojo.CancelUnitCond;
import com.ihk.saleunit.data.services.ICancelUnitServices;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * CancelUnit的Services实现(业务实现)
 * @author 
 *
 */
@Service("cancelUnitServices")
@SuppressWarnings("unchecked")
public class CancelUnitServices implements ICancelUnitServices {
	/**
	 * cancelUnit数据访问接口
	 */
	@Autowired	 ICancelUnitMapper cancelUnitMapper;

	/**
	 * 删除一条CancelUnit
	 * @param id
	 */
	public void deleteCancelUnit(int id) throws RuntimeException {
		cancelUnitMapper.deleteCancelUnit(new PojoDeleteCond(id));
	}

	/**
	 * 新增CancelUnit
	 * @param cancelUnit
	 */
	public void addCancelUnit(CancelUnit cancelUnit) throws RuntimeException {		
		cancelUnitMapper.addCancelUnit(cancelUnit);
	}

	/**
	 * 查找一条CancelUnit
	 * @return CancelUnit
	 * @param id 主键id
	 */
	@Override
	public CancelUnit findCancelUnitById(int id) throws RuntimeException {
		return cancelUnitMapper.findCancelUnitById(id);
	}
	
	/**
	 * 查找一条CancelUnit
	 * @return CancelUnit
	 * @param id 主键id
	 */
	@Override
	public List<CancelUnit> findCancelUnitByUnitId(int unitId) throws RuntimeException {
		return cancelUnitMapper.findCancelUnitByUnitId(unitId);
	}

	/**
	 * 修改CancelUnit
	 * @param cancelUnit
	 */
	@Override
	public void updateCancelUnit(CancelUnit cancelUnit) throws RuntimeException {
		cancelUnitMapper.updateCancelUnit(cancelUnit);		
	}
	    
	/**
	 * 分页查找CancelUnit
	 * @param cond 查询条件
	 * @return CancelUnit列表
	 */
	public List<CancelUnit> findCancelUnitPage(CancelUnitCond cond) throws RuntimeException {
		int recordCount = cancelUnitMapper.findCancelUnitCount(cond);
		
		cond.recordCount = recordCount;
				
		return cancelUnitMapper.findCancelUnitPage(cond);
	}
        
	/**
	 * 查找全部CancelUnit
	 * @param cond 查询条件
	 * @return CancelUnit列表
	 */
	public List<CancelUnit> findCancelUnit(CancelUnitCond cond) throws RuntimeException {
    	return cancelUnitMapper.findCancelUnit(cond);
	}
}
