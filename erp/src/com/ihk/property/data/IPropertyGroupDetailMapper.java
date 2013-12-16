package com.ihk.property.data;

import java.util.List;

import com.ihk.property.data.pojo.PropertyGroupDetail;
import com.ihk.property.data.pojo.PropertyGroupDetailCond;

/**
 * PropertyGroupDetail数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPropertyGroupDetailMapper {

	/**
	 * 新增PropertyGroupDetail
	 * @param propertyGroupDetail
	 */
	public void addPropertyGroupDetail(PropertyGroupDetail propertyGroupDetail) ;

	/**
	 * 根据条件删除PropertyGroupDetail
	 * @param cond 删除条件
	 */
	public void deletePropertyGroupDetail(int id) throws RuntimeException;

	/**
	 * 修改PropertyGroupDetail
	 * @param propertyGroupDetail
	 */
	public void updatePropertyGroupDetail(PropertyGroupDetail propertyGroupDetail) throws RuntimeException;

	/**
	 * 查找一条PropertyGroupDetail
	 * @return PropertyGroupDetail
	 * @param id 主键id
	 */
	public PropertyGroupDetail findPropertyGroupDetailById(int id) throws RuntimeException;

	/**
	 * 分页查找PropertyGroupDetail
	 * @param cond 查询条件
	 * @return PropertyGroupDetail列表
	 */
	public List<PropertyGroupDetail> findPropertyGroupDetailPage(PropertyGroupDetailCond cond) ;

	/**
	 * 查找全部PropertyGroupDetail
	 * @param cond 查询条件
	 * @return PropertyGroupDetail列表
	 */
	public List<PropertyGroupDetail> findPropertyGroupDetail(PropertyGroupDetailCond cond) ;

	/**
	 * 查找符合条件的记录条数PropertyGroupDetail
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPropertyGroupDetailCount(PropertyGroupDetailCond cond) ;
	
	/**
	 * 根据ids批量添加房间
	 * @param cond.ids 房间ID
	 * @param cond.pojo 创建时间/人 修改时间/人
	 * @param cond.groupId 组团ID 
	 * */
	public void addUnitByUnitIds(PropertyGroupDetailCond cond);
	
	/**
	 * 根据buildID批量添加房间
	 * @param cond.buildId 楼栋ID
	 * @param cond.pojo 创建时间/人 修改时间/人
	 * @param cond.groupId 组团ID  
	 * */
	public void addUnitByBuildId(PropertyGroupDetailCond cond);
	
	/**
	 * 根据组团ID 和房间ID 删除在该组团的房间ID  //需要添加修改人和修改时间
	 * @param cond.groupId 组团ID
	 * @param cond.unitId 房间ID
	 * */
	public void  deletePropertyGroupDetailByGroupIdAndUnitId (PropertyGroupDetailCond cond);
	
}
