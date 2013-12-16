package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.AddonProperty;
import com.ihk.saleunit.data.pojo.AddonPropertyCond;

/**
 * AddonProperty数据访问接口Mapper
 * @author 
 *
 */ 
public interface IAddonPropertyMapper {

	/**
	 * 新增AddonProperty
	 * @param addonProperty
	 */
	public void addAddonProperty(AddonProperty addonProperty) ;

	/**
	 * 根据条件删除AddonProperty
	 * @param cond 删除条件
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
	public List<AddonProperty> findAddonPropertyPage(AddonPropertyCond cond) ;

	/**
	 * 查找全部AddonProperty
	 * @param cond 查询条件
	 * @return AddonProperty列表
	 */
	public List<AddonProperty> findAddonProperty(AddonPropertyCond cond) ;

	/**
	 * 查找符合条件的记录条数AddonProperty
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findAddonPropertyCount(AddonPropertyCond cond) ;
}
