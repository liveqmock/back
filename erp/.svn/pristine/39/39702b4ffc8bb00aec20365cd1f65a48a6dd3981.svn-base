package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ReplaceUnit;
import com.ihk.saleunit.data.pojo.ReplaceUnitCond;

/**
 * ReplaceUnit的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IReplaceUnitServices {

	/**
	 * 新增ReplaceUnit
	 * @param replaceUnit
	 */
	public void addReplaceUnit(ReplaceUnit replaceUnit) throws RuntimeException;

	/**
	 * 删除一条ReplaceUnit
	 * @param id
	 */
	public void deleteReplaceUnit(int id) throws RuntimeException;

	/**
	 * 修改ReplaceUnit
	 * @param replaceUnit
	 */
	public void updateReplaceUnit(ReplaceUnit replaceUnit) throws RuntimeException;

	/**
	 * 查找一条ReplaceUnit
	 * @return ReplaceUnit
	 * @param id 主键id
	 */
	public ReplaceUnit findReplaceUnitById(int id) throws RuntimeException;
	
	/**
	 * 查找多条ReplaceUnit
	 * @return List<ReplaceUnit>ReplaceUnit
	 * @param id unit_id
	 */
	public List<ReplaceUnit> findReplaceUnitByUnitId(int unit_id) throws RuntimeException;
    
	/**
	 * 分页查找ReplaceUnit
	 * @param cond 查询条件
	 * @return ReplaceUnit列表
	 */
	public List<ReplaceUnit> findReplaceUnitPage(ReplaceUnitCond cond) throws RuntimeException;
    
	/**
	 * 查找全部ReplaceUnit
	 * @param cond 查询条件
	 * @return ReplaceUnit列表
	 */
	public List<ReplaceUnit> findReplaceUnit(ReplaceUnitCond cond) throws RuntimeException;
}