package com.ihk.property.data;

import java.util.List;
import java.util.Map;

import com.ihk.property.data.pojo.PropertyPriv;
import com.ihk.property.data.pojo.PropertyPrivCond;

/**
 * PropertyPriv数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPropertyPrivMapper {

	/**
	 * 新增PropertyPriv
	 * @param propertyPriv
	 */
	public void addPropertyPriv(PropertyPriv propertyPriv) ;

	/**
	 * 根据条件删除PropertyPriv
	 * @param cond 删除条件
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
	public List<PropertyPriv> findPropertyPrivPage(PropertyPrivCond cond) ;

	/**
	 * 查找全部PropertyPriv
	 * @param cond 查询条件
	 * @return PropertyPriv列表
	 */
	public List<PropertyPriv> findPropertyPriv(PropertyPrivCond cond) ;

	/**
	 * 查找符合条件的记录条数PropertyPriv
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPropertyPrivCount(PropertyPrivCond cond) ;
}
