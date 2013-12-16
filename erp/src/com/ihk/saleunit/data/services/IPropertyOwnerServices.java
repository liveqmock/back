package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.PropertyOwner;
import com.ihk.saleunit.data.pojo.PropertyOwnerCond;

/**
 * PropertyOwner的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IPropertyOwnerServices {
	/**
	 * 新增PropertyOwner
	 * @param propertyOwner
	 */
	public void addPropertyOwner(PropertyOwner propertyOwner) throws RuntimeException;

	/**
	 * 删除一条PropertyOwner
	 * @param id
	 */
	public void deletePropertyOwner(int id) throws RuntimeException;

	/**
	 * 修改PropertyOwner
	 * @param propertyOwner
	 */
	public void updatePropertyOwner(PropertyOwner propertyOwner) throws RuntimeException;

	/**
	 * 查找一条PropertyOwner
	 * @return PropertyOwner
	 * @param id 主键id
	 */
	public PropertyOwner findPropertyOwnerById(int id) throws RuntimeException;

	/**
	 * 分页查找PropertyOwner
	 * @param cond 查询条件
	 * @return PropertyOwner列表
	 */
	public List<PropertyOwner> findPropertyOwnerPage(PropertyOwnerCond cond) throws RuntimeException;

	/**
	 * 查找全部PropertyOwner
	 * @param cond 查询条件
	 * @return PropertyOwner列表
	 */
	public List<PropertyOwner> findPropertyOwner(PropertyOwnerCond cond) throws RuntimeException;
	
	
}