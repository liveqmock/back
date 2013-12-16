package com.ihk.saleunit.data;

import java.util.List;
import java.util.Map;

import com.ihk.saleunit.data.pojo.PropertyProjectPlan;
import com.ihk.saleunit.data.pojo.PropertyProjectPlanCond;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * PropertyProjectPlan数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPropertyProjectPlanMapper {

	/**
	 * 新增PropertyProjectPlan
	 * @param propertyProjectPlan
	 */
	public void addPropertyProjectPlan(PropertyProjectPlan propertyProjectPlan) ;

	/**
	 * 根据条件删除PropertyProjectPlan
	 * @param cond 删除条件
	 */
	public void deletePropertyProjectPlan(PojoDeleteCond cond) throws RuntimeException;

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
	public List<PropertyProjectPlan> findPropertyProjectPlanPage(PropertyProjectPlanCond cond) ;

	/**
	 * 查找全部PropertyProjectPlan
	 * @param cond 查询条件
	 * @return PropertyProjectPlan列表
	 */
	public List<PropertyProjectPlan> findPropertyProjectPlan(PropertyProjectPlanCond cond) ;

	/**
	 * 查找符合条件的记录条数PropertyProjectPlan
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPropertyProjectPlanCount(PropertyProjectPlanCond cond) ;
}
