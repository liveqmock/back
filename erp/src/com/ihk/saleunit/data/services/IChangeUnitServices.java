package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ChangeUnit;
import com.ihk.saleunit.data.pojo.ChangeUnitCond;

/**
 * ChangeUnit的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IChangeUnitServices {
	/**
	 * 新增ChangeUnit
	 * @param changeUnit
	 */
	public void addChangeUnit(ChangeUnit changeUnit) throws RuntimeException;

	/**
	 * 删除一条ChangeUnit
	 * @param id
	 */
	public void deleteChangeUnit(int id) throws RuntimeException;

	/**
	 * 修改ChangeUnit
	 * @param changeUnit
	 */
	public void updateChangeUnit(ChangeUnit changeUnit) throws RuntimeException;

	/**
	 * 查找一条ChangeUnit
	 * @return ChangeUnit
	 * @param id 主键id
	 */
	public ChangeUnit findChangeUnitById(int id) throws RuntimeException;

	/**
	 * 分页查找ChangeUnit
	 * @param cond 查询条件
	 * @return ChangeUnit列表
	 */
	public List<ChangeUnit> findChangeUnitPage(ChangeUnitCond cond) throws RuntimeException;

	/**
	 * 查找全部ChangeUnit
	 * @param cond 查询条件
	 * @return ChangeUnit列表
	 */
	public List<ChangeUnit> findChangeUnit(ChangeUnitCond cond) throws RuntimeException;
}