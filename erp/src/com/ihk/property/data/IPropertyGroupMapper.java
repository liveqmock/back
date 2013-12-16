package com.ihk.property.data;

import java.util.List;

import com.ihk.property.data.pojo.PropertyGroup;
import com.ihk.property.data.pojo.PropertyGroupCond;

/**
 * PropertyGroup数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPropertyGroupMapper {

	/**
	 * 新增PropertyGroup
	 * @param propertyGroup
	 */
	public void addPropertyGroup(PropertyGroup propertyGroup) ;

	/**
	 * 根据条件删除PropertyGroup
	 * @param cond 删除条件
	 */
	public void deletePropertyGroup(int id) throws RuntimeException;

	/**
	 * 修改PropertyGroup
	 * @param propertyGroup
	 */
	public void updatePropertyGroup(PropertyGroup propertyGroup) throws RuntimeException;

	/**
	 * 查找一条PropertyGroup
	 * @return PropertyGroup
	 * @param id 主键id
	 */
	public PropertyGroup findPropertyGroupById(int id) throws RuntimeException;

	/**
	 * 分页查找PropertyGroup
	 * @param cond 查询条件
	 * @return PropertyGroup列表
	 */
	public List<PropertyGroup> findPropertyGroupPage(PropertyGroupCond cond) ;

	/**
	 * 查找全部PropertyGroup
	 * @param cond 查询条件
	 * @return PropertyGroup列表
	 */
	public List<PropertyGroup> findPropertyGroup(PropertyGroupCond cond) ;

	/**
	 * 查找符合条件的记录条数PropertyGroup
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPropertyGroupCount(PropertyGroupCond cond) ;
	
	
	/**
	 * 根据楼盘项目id获取对应的组团
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	public List<PropertyGroup> findPropertyGroupByProjectId(int projectId) throws RuntimeException;
	
	
}
