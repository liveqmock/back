package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.CancelUnit;
import com.ihk.saleunit.data.pojo.CancelUnitCond;

/**
 * CancelUnit的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface ICancelUnitServices {

	/**
	 * 新增CancelUnit
	 * @param cancelUnit
	 */
	public void addCancelUnit(CancelUnit cancelUnit) throws RuntimeException;

	/**
	 * 删除一条CancelUnit
	 * @param id
	 */
	public void deleteCancelUnit(int id) throws RuntimeException;

	/**
	 * 修改CancelUnit
	 * @param cancelUnit
	 */
	public void updateCancelUnit(CancelUnit cancelUnit) throws RuntimeException;

	/**
	 * 查找一条CancelUnit
	 * @return CancelUnit
	 * @param id 主键id
	 */
	public CancelUnit findCancelUnitById(int id) throws RuntimeException;
	
	/**
	 * 查找多条CancelUnit
	 * @return CancelUnit
	 * @param id 主键id
	 */
	public List<CancelUnit> findCancelUnitByUnitId(int unitId) throws RuntimeException;
    
	/**
	 * 分页查找CancelUnit
	 * @param cond 查询条件
	 * @return CancelUnit列表
	 */
	public List<CancelUnit> findCancelUnitPage(CancelUnitCond cond) throws RuntimeException;
    
	/**
	 * 查找全部CancelUnit
	 * @param cond 查询条件
	 * @return CancelUnit列表
	 */
	public List<CancelUnit> findCancelUnit(CancelUnitCond cond) throws RuntimeException;
}