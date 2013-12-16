package com.ihk.property.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.PropertyPriv;
import com.ihk.property.data.pojo.PropertyPrivCond;

/**
 * PropertyPriv的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IPropertyPrivServices {

	/**
	 * 新增PropertyPriv
	 * @param propertyPriv
	 */
	public void addPropertyPriv(PropertyPriv propertyPriv) throws RuntimeException;

	/**
	 * 删除一条PropertyPriv
	 * @param id
	 */
	public void deletePropertyPriv(int id) throws RuntimeException;

	/**
	 * 修改PropertyPriv
	 * @param propertyPriv
	 */
	public void updatePropertyPriv(PropertyPriv propertyPriv) throws RuntimeException;

	/**
	 * 查找一条PropertyPriv
	 * @return PropertyPriv
	 * @param id 主键id
	 */
	public PropertyPriv findPropertyPrivById(int id) throws RuntimeException;

	/**
	 * 分页查找PropertyPriv
	 * @param cond 查询条件
	 * @return PropertyPriv列表
	 */
	public List<PropertyPriv> findPropertyPrivPage(PropertyPrivCond cond) throws RuntimeException;

	/**
	 * 查找全部PropertyPriv
	 * @param cond 查询条件
	 * @return PropertyPriv列表
	 */
	public List<PropertyPriv> findPropertyPriv(PropertyPrivCond cond) throws RuntimeException;
}