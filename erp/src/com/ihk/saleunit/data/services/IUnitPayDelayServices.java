package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.UnitPayDelay;
import com.ihk.saleunit.data.pojo.UnitPayDelayCond;

/**
 * UnitPayDelay的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IUnitPayDelayServices {
	/**
	 * 新增UnitPayDelay
	 * @param unitPayDelay
	 */
	public void addUnitPayDelay(UnitPayDelay unitPayDelay) throws RuntimeException;

	/**
	 * 删除一条UnitPayDelay
	 * @param id
	 */
	public void deleteUnitPayDelay(int id) throws RuntimeException;

	/**
	 * 修改UnitPayDelay
	 * @param unitPayDelay
	 */
	public void updateUnitPayDelay(UnitPayDelay unitPayDelay) throws RuntimeException;

	/**
	 * 查找一条UnitPayDelay
	 * @return UnitPayDelay
	 * @param id 主键id
	 */
	public UnitPayDelay findUnitPayDelayById(int id) throws RuntimeException;

	/**
	 * 分页查找UnitPayDelay
	 * @param cond 查询条件
	 * @return UnitPayDelay列表
	 */
	public List<UnitPayDelay> findUnitPayDelayPage(UnitPayDelayCond cond) throws RuntimeException;

	/**
	 * 查找全部UnitPayDelay
	 * @param cond 查询条件
	 * @return UnitPayDelay列表
	 */
	public List<UnitPayDelay> findUnitPayDelay(UnitPayDelayCond cond) throws RuntimeException;
}