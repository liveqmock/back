package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.PropertyProjectPlan;
import com.ihk.saleunit.data.pojo.PropertyProjectPlanCond;

/**
 * PropertyProjectPlan的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IPropertyProjectPlanServices {
	/**
	 * 新增PropertyProjectPlan
	 * @param propertyProjectPlan
	 */
	public void addPropertyProjectPlan(PropertyProjectPlan propertyProjectPlan) throws RuntimeException;

	/**
	 * 删除一条PropertyProjectPlan
	 * @param id
	 */
	public void deletePropertyProjectPlan(int id) throws RuntimeException;

	/**
	 * 修改PropertyProjectPlan
	 * @param propertyProjectPlan
	 */
	public void updatePropertyProjectPlan(PropertyProjectPlan propertyProjectPlan) throws RuntimeException;

	/**
	 * 查找一条PropertyProjectPlan
	 * @return PropertyProjectPlan
	 * @param id 主键id
	 */
	public PropertyProjectPlan findPropertyProjectPlanById(int id) throws RuntimeException;

	/**
	 * 分页查找PropertyProjectPlan
	 * @param cond 查询条件
	 * @return PropertyProjectPlan列表
	 */
	public List<PropertyProjectPlan> findPropertyProjectPlanPage(PropertyProjectPlanCond cond) throws RuntimeException;

	/**
	 * 查找全部PropertyProjectPlan
	 * @param cond 查询条件
	 * @return PropertyProjectPlan列表
	 */
	public List<PropertyProjectPlan> findPropertyProjectPlan(PropertyProjectPlanCond cond) throws RuntimeException;
}