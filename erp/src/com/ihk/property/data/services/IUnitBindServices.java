package com.ihk.property.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.UnitBind;
import com.ihk.property.data.pojo.UnitBindCond;

/**
 * UnitBind的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IUnitBindServices {

	/**
	 * 新增UnitBind
	 * @param unitBind
	 */
	public void addUnitBind(UnitBind unitBind) throws RuntimeException;

	/**
	 * 删除一条UnitBind
	 * @param id
	 */
	public void deleteUnitBind(int id) throws RuntimeException;

	/**
	 * 修改UnitBind
	 * @param unitBind
	 */
	public void updateUnitBind(UnitBind unitBind) throws RuntimeException;

	/**
	 * 查找一条UnitBind
	 * @return UnitBind
	 * @param id 主键id
	 */
	public UnitBind findUnitBindById(int id) throws RuntimeException;

	/**
	 * 分页查找UnitBind
	 * @param cond 查询条件
	 * @return UnitBind列表
	 */
	public List<UnitBind> findUnitBindPage(UnitBindCond cond) throws RuntimeException;

	/**
	 * 查找全部UnitBind
	 * @param cond 查询条件
	 * @return UnitBind列表
	 */
	public List<UnitBind> findUnitBind(UnitBindCond cond) throws RuntimeException;
	
	/**
	 * 符合条件的记录数
	 * @param buildId
	 * @return
	 * @throws RuntimeException
	 */
	public int deletedByBuildId (int buildId) throws RuntimeException;
}