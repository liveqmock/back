package com.ihk.property.data;

import java.util.List;
import java.util.Map;

import com.ihk.property.data.pojo.PropertyUnitDefine;
import com.ihk.property.data.pojo.PropertyUnitDefineCond;

/**
 * PropertyUnitDefine数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPropertyUnitDefineMapper {

	/**
	 * 新增PropertyUnitDefine
	 * @param propertyUnitDefine
	 */
	public void addPropertyUnitDefine(PropertyUnitDefine propertyUnitDefine) ;

	/**
	 * 根据条件删除PropertyUnitDefine
	 * @param cond 删除条件
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
	public List<PropertyUnitDefine> findPropertyUnitDefinePage(PropertyUnitDefineCond cond) ;

	/**
	 * 查找全部PropertyUnitDefine
	 * @param cond 查询条件
	 * @return PropertyUnitDefine列表
	 */
	public List<PropertyUnitDefine> findPropertyUnitDefine(PropertyUnitDefineCond cond) ;

	/**
	 * 查找符合条件的记录条数PropertyUnitDefine
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPropertyUnitDefineCount(PropertyUnitDefineCond cond) ;
	
	public PropertyUnitDefine findPropertyUnitDefineByUnitId(int id) ;
}
