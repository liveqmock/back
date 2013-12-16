package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.ITartMapper;
import com.ihk.saleunit.data.pojo.Tart;
import com.ihk.saleunit.data.pojo.TartCond;
import com.ihk.saleunit.data.services.ITartServices;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * Tart的Services实现(业务实现)
 * @author 
 *
 */
@Service("tartServices")
@SuppressWarnings("unchecked")
public class TartServices implements ITartServices {
	/**
	 * tart数据访问接口
	 */
	@Autowired	 ITartMapper tartMapper;

	/**
	 * 删除一条Tart
	 * @param id
	 */
	public void deleteTart(int id) throws RuntimeException {
		tartMapper.deleteTart(new PojoDeleteCond(id));
	}

	/**
	 * 新增Tart
	 * @param tart
	 */
	public void addTart(Tart tart) throws RuntimeException {		
		tartMapper.addTart(tart);
	}

	/**
	 * 查找一条Tart
	 * @return Tart
	 * @param id 主键id
	 */
	@Override
	public Tart findTartById(int id) throws RuntimeException {
		return tartMapper.findTartById(id);
	}
	
	/**
	 * 查找多条Tart
	 * @return Tart
	 * @param id unit_id
	 */
	@Override
	public List<Tart> findTartByUnitId(int unit_id) throws RuntimeException {
		return tartMapper.findTartByUnitId(unit_id);
	}

	/**
	 * 修改Tart
	 * @param tart
	 */
	@Override
	public void updateTart(Tart tart) throws RuntimeException {
		tartMapper.updateTart(tart);		
	}
	    
	/**
	 * 分页查找Tart
	 * @param cond 查询条件
	 * @return Tart列表
	 */
	public List<Tart> findTartPage(TartCond cond) throws RuntimeException {
		int recordCount = tartMapper.findTartCount(cond);
		
		cond.recordCount = recordCount;
				
		return tartMapper.findTartPage(cond);
	}
        
	/**
	 * 查找全部Tart
	 * @param cond 查询条件
	 * @return Tart列表
	 */
	public List<Tart> findTart(TartCond cond) throws RuntimeException {
    	return tartMapper.findTart(cond);
	}
}
