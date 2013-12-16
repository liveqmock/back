package com.ihk.property.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyAreaCond;

/**
 * PropertyArea的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IPropertyAreaServices {

	/**
	 * 新增PropertyArea
	 * @param propertyArea
	 */
	public void addPropertyArea(PropertyArea propertyArea) throws RuntimeException;

	/**
	 * 删除一条PropertyArea
	 * @param id
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
	public List<PropertyArea> findPropertyAreaPage(PropertyAreaCond cond) throws RuntimeException;

	/**
	 * 查找全部PropertyArea
	 * @param cond 查询条件
	 * @return PropertyArea列表
	 */
	public List<PropertyArea> findPropertyArea(PropertyAreaCond cond) throws RuntimeException;
	
	/**
	 * 查找记录的条数
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public int findPropertyAreaCount(PropertyAreaCond cond)  throws RuntimeException;
}