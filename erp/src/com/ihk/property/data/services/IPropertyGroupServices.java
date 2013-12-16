package com.ihk.property.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.PropertyGroup;
import com.ihk.property.data.pojo.PropertyGroupCond;


/**
 * PropertyGroup的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IPropertyGroupServices {
	/**
	 * 新增PropertyGroup
	 * @param propertyGroup
	 */
	public void addPropertyGroup(PropertyGroup propertyGroup) throws RuntimeException;

	/**
	 * 删除一条PropertyGroup
	 * @param id
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
	public List<PropertyGroup> findPropertyGroupPage(PropertyGroupCond cond) throws RuntimeException;

	/**
	 * 查找全部PropertyGroup
	 * @param cond 查询条件
	 * @return PropertyGroup列表
	 */
	public List<PropertyGroup> findPropertyGroup(PropertyGroupCond cond) throws RuntimeException;
	
	/**
	 * 根据楼盘项目id获取对应的组团
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	public List<PropertyGroup> findPropertyGroupByProjectId(int projectId) throws RuntimeException;
	
	
}