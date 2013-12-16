package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.PropertyOwner;
import com.ihk.saleunit.data.pojo.PropertyOwnerCond;

/**
 * PropertyOwner数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPropertyOwnerMapper {

	/**
	 * 新增PropertyOwner
	 * @param propertyOwner
	 */
	public void addPropertyOwner(PropertyOwner propertyOwner) ;

	/**
	 * 根据条件删除PropertyOwner
	 * @param cond 删除条件
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
	public List<PropertyOwner> findPropertyOwnerPage(PropertyOwnerCond cond) ;

	/**
	 * 查找全部PropertyOwner
	 * @param cond 查询条件
	 * @return PropertyOwner列表
	 */
	public List<PropertyOwner> findPropertyOwner(PropertyOwnerCond cond) ;

	/**
	 * 查找符合条件的记录条数PropertyOwner
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPropertyOwnerCount(PropertyOwnerCond cond) ;
}
