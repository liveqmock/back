package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.AddonProperty;
import com.ihk.saleunit.data.pojo.AddonPropertyCond;

/**
 * AddonProperty的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IAddonPropertyServices {
	/**
	 * 新增AddonProperty
	 * @param addonProperty
	 */
	public void addAddonProperty(AddonProperty addonProperty) throws RuntimeException;

	/**
	 * 删除一条AddonProperty
	 * @param id
	 */
	public void deleteAddonProperty(int id) throws RuntimeException;

	/**
	 * 修改AddonProperty
	 * @param addonProperty
	 */
	public void updateAddonProperty(AddonProperty addonProperty) throws RuntimeException;

	/**
	 * 查找一条AddonProperty
	 * @return AddonProperty
	 * @param id 主键id
	 */
	public AddonProperty findAddonPropertyById(int id) throws RuntimeException;

	/**
	 * 分页查找AddonProperty
	 * @param cond 查询条件
	 * @return AddonProperty列表
	 */
	public List<AddonProperty> findAddonPropertyPage(AddonPropertyCond cond) throws RuntimeException;

	/**
	 * 查找全部AddonProperty
	 * @param cond 查询条件
	 * @return AddonProperty列表
	 */
	public List<AddonProperty> findAddonProperty(AddonPropertyCond cond) throws RuntimeException;
	
}