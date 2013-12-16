package com.ihk.property.data;

import java.util.List;
import java.util.Map;

import com.ihk.property.data.pojo.PropertyDeveloper;
import com.ihk.property.data.pojo.PropertyDeveloperCond;

/**
 * PropertyDeveloper数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPropertyDeveloperMapper {

	/**
	 * 新增PropertyDeveloper
	 * @param propertyDeveloper
	 */
	public void addPropertyDeveloper(PropertyDeveloper propertyDeveloper) ;

	/**
	 * 根据条件删除PropertyDeveloper
	 * @param cond 删除条件
	 */
	public void deletePropertyDeveloper(int id) throws RuntimeException;

	/**
	 * 修改PropertyDeveloper
	 * @param propertyDeveloper
	 */
	public void updatePropertyDeveloper(PropertyDeveloper propertyDeveloper) throws RuntimeException;

    
	/**
	 * 查找一条PropertyDeveloper
	 * @return PropertyDeveloper
	 * @param id 主键id
	 */
	public PropertyDeveloper findPropertyDeveloperById(int id) throws RuntimeException;

	/**
	 * 分页查找PropertyDeveloper
	 * @param cond 查询条件
	 * @return PropertyDeveloper列表
	 */
	public List<PropertyDeveloper> findPropertyDeveloperPage(PropertyDeveloperCond cond) ;

	/**
	 * 查找全部PropertyDeveloper
	 * @param cond 查询条件
	 * @return PropertyDeveloper列表
	 */
	public List<PropertyDeveloper> findPropertyDeveloper(PropertyDeveloperCond cond) ;

	/**
	 * 查找符合条件的记录条数PropertyDeveloper
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPropertyDeveloperCount(PropertyDeveloperCond cond) ;
}
