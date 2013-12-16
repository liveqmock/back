package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IUnitPayDelayMapper;
import com.ihk.saleunit.data.pojo.UnitPayDelay;
import com.ihk.saleunit.data.pojo.UnitPayDelayCond;
import com.ihk.saleunit.data.services.IUnitPayDelayServices;

/**
 * UnitPayDelay的Services实现(业务实现)
 * @author 
 *
 */
@Service("unitPayDelayServices")
@SuppressWarnings("unchecked")
public class UnitPayDelayServices implements IUnitPayDelayServices {
	/**
	 * unitPayDelay数据访问接口
	 */
	@Autowired	 IUnitPayDelayMapper unitPayDelayMapper;

	/**
	 * 删除一条UnitPayDelay
	 * @param id
	 */
	public void deleteUnitPayDelay(int id) throws RuntimeException {
		unitPayDelayMapper.deleteUnitPayDelay(id);
	}

	/**
	 * 新增UnitPayDelay
	 * @param unitPayDelay
	 */
	public void addUnitPayDelay(UnitPayDelay unitPayDelay) throws RuntimeException {		
		unitPayDelayMapper.addUnitPayDelay(unitPayDelay);
	}

	/**
	 * 查找一条UnitPayDelay
	 * @return UnitPayDelay
	 * @param id 主键id
	 */
	@Override
	public UnitPayDelay findUnitPayDelayById(int id) throws RuntimeException {
		return unitPayDelayMapper.findUnitPayDelayById(id);
	}

	/**
	 * 修改UnitPayDelay
	 * @param unitPayDelay
	 */
	@Override
	public void updateUnitPayDelay(UnitPayDelay unitPayDelay) throws RuntimeException {
		unitPayDelayMapper.updateUnitPayDelay(unitPayDelay);		
	}

	/**
	 * 分页查找UnitPayDelay
	 * @param cond 查询条件
	 * @return UnitPayDelay列表
	 */
	public List<UnitPayDelay> findUnitPayDelayPage(UnitPayDelayCond cond) throws RuntimeException {
		int recordCount = unitPayDelayMapper.findUnitPayDelayCount(cond);
		
		cond.recordCount = recordCount;
				
		return unitPayDelayMapper.findUnitPayDelayPage(cond);
	}

	/**
	 * 查找全部UnitPayDelay
	 * @param cond 查询条件
	 * @return UnitPayDelay列表
	 */
	public List<UnitPayDelay> findUnitPayDelay(UnitPayDelayCond cond) throws RuntimeException {
    	return unitPayDelayMapper.findUnitPayDelay(cond);
	}
}
