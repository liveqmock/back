package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IReplaceUnitMapper;
import com.ihk.saleunit.data.pojo.ReplaceUnit;
import com.ihk.saleunit.data.pojo.ReplaceUnitCond;
import com.ihk.saleunit.data.services.IReplaceUnitServices;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * ReplaceUnit的Services实现(业务实现)
 * @author 
 *
 */
@Service("replaceUnitServices")
@SuppressWarnings("unchecked")
public class ReplaceUnitServices implements IReplaceUnitServices {
	/**
	 * replaceUnit数据访问接口
	 */
	@Autowired	 IReplaceUnitMapper replaceUnitMapper;

	/**
	 * 删除一条ReplaceUnit
	 * @param id
	 */
	public void deleteReplaceUnit(int id) throws RuntimeException {
		replaceUnitMapper.deleteReplaceUnit(new PojoDeleteCond(id));
	}

	/**
	 * 新增ReplaceUnit
	 * @param replaceUnit
	 */
	public void addReplaceUnit(ReplaceUnit replaceUnit) throws RuntimeException {		
		replaceUnitMapper.addReplaceUnit(replaceUnit);
	}

	/**
	 * 查找一条ReplaceUnit
	 * @return ReplaceUnit
	 * @param id 主键id
	 */
	@Override
	public ReplaceUnit findReplaceUnitById(int id) throws RuntimeException {
		return replaceUnitMapper.findReplaceUnitById(id);
	}
	
	/**
	 * 查找多条ReplaceUnit
	 * @return List<ReplaceUnit>ReplaceUnit
	 * @param id unit_id
	 */
	public List<ReplaceUnit> findReplaceUnitByUnitId(int unitId)
			throws RuntimeException {
		return replaceUnitMapper.findReplaceUnitByUnitId(unitId);
	}

	/**
	 * 修改ReplaceUnit
	 * @param replaceUnit
	 */
	@Override
	public void updateReplaceUnit(ReplaceUnit replaceUnit) throws RuntimeException {
		replaceUnitMapper.updateReplaceUnit(replaceUnit);		
	}
	    
	/**
	 * 分页查找ReplaceUnit
	 * @param cond 查询条件
	 * @return ReplaceUnit列表
	 */
	public List<ReplaceUnit> findReplaceUnitPage(ReplaceUnitCond cond) throws RuntimeException {
		int recordCount = replaceUnitMapper.findReplaceUnitCount(cond);
		
		cond.recordCount = recordCount;
				
		return replaceUnitMapper.findReplaceUnitPage(cond);
	}
        
	/**
	 * 查找全部ReplaceUnit
	 * @param cond 查询条件
	 * @return ReplaceUnit列表
	 */
	public List<ReplaceUnit> findReplaceUnit(ReplaceUnitCond cond) throws RuntimeException {
    	return replaceUnitMapper.findReplaceUnit(cond);
	}

	
	
}
