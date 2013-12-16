package com.ihk.property.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.PropertyDeveloper;
import com.ihk.property.data.pojo.PropertyDeveloperCond;

/**
 * PropertyDeveloper的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IPropertyDeveloperServices {

	/**
	 * 新增PropertyDeveloper
	 * @param propertyDeveloper
	 */
	public void addPropertyDeveloper(PropertyDeveloper propertyDeveloper) throws RuntimeException;


	/**
	 * 删除一条PropertyDeveloper
	 * @param id
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
	public List<PropertyDeveloper> findPropertyDeveloperPage(PropertyDeveloperCond cond) throws RuntimeException;

	/**
	 * 查找全部PropertyDeveloper
	 * @param cond 查询条件
	 * @return PropertyDeveloper列表
	 */
	public List<PropertyDeveloper> findPropertyDeveloper(PropertyDeveloperCond cond) throws RuntimeException;
	
	/**
	 * 查找记录数
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public int findPropertyDeveloperCount(PropertyDeveloperCond cond) throws RuntimeException;
}