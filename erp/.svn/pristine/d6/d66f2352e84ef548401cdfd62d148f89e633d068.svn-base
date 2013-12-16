package com.ihk.property.data;

import java.util.List;
import java.util.Map;

import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyAreaCond;

/**
 * PropertyArea数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPropertyAreaMapper {

	/**
	 * 新增PropertyArea
	 * @param propertyArea
	 */
	public void addPropertyArea(PropertyArea propertyArea) ;

	/**
	 * 根据条件删除PropertyArea
	 * @param cond 删除条件
	 */
	public void deletePropertyArea(int id) throws RuntimeException;


	/**
	 * 修改PropertyArea
	 * @param propertyArea
	 */
	public void updatePropertyArea(PropertyArea propertyArea) throws RuntimeException;

	/**
	 * 查找一条PropertyArea
	 * @return PropertyArea
	 * @param id 主键id
	 */
	public PropertyArea findPropertyAreaById(int id) throws RuntimeException;

	/**
	 * 分页查找PropertyArea
	 * @param cond 查询条件
	 * @return PropertyArea列表
	 */
	public List<PropertyArea> findPropertyAreaPage(PropertyAreaCond cond) ;

	/**
	 * 查找全部PropertyArea
	 * @param cond 查询条件
	 * @return PropertyArea列表
	 */
	public List<PropertyArea> findPropertyArea(PropertyAreaCond cond) ;

	/**
	 * 查找符合条件的记录条数PropertyArea
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPropertyAreaCount(PropertyAreaCond cond) ;
}
