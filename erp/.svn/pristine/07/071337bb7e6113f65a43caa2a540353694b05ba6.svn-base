package com.ihk.property.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.PropertyUnitDefine;
import com.ihk.property.data.pojo.PropertyUnitDefineCond;

/**
 * PropertyUnitDefine的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IPropertyUnitDefineServices {
	/**
	 * 新增PropertyUnitDefine
	 * @param propertyUnitDefine
	 */
	public void addPropertyUnitDefine(PropertyUnitDefine propertyUnitDefine) throws RuntimeException;

	/**
	 * 删除一条PropertyUnitDefine
	 * @param id
	 */
	public void deletePropertyUnitDefine(int id) throws RuntimeException;

	/**
	 * 修改PropertyUnitDefine
	 * @param propertyUnitDefine
	 */
	public void updatePropertyUnitDefine(PropertyUnitDefine propertyUnitDefine) throws RuntimeException;

	/**
	 * 查找一条PropertyUnitDefine
	 * @return PropertyUnitDefine
	 * @param id 主键id
	 */
	public PropertyUnitDefine findPropertyUnitDefineById(int id) throws RuntimeException;

	/**
	 * 分页查找PropertyUnitDefine
	 * @param cond 查询条件
	 * @return PropertyUnitDefine列表
	 */
	public List<PropertyUnitDefine> findPropertyUnitDefinePage(PropertyUnitDefineCond cond) throws RuntimeException;

	/**
	 * 查找全部PropertyUnitDefine
	 * @param cond 查询条件
	 * @return PropertyUnitDefine列表
	 */
	public List<PropertyUnitDefine> findPropertyUnitDefine(PropertyUnitDefineCond cond) throws RuntimeException;
	
	public PropertyUnitDefine findPropertyUnitDefineByUnitId(int id) throws RuntimeException;
}