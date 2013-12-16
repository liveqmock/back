package com.ihk.property.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.PropertyGroupDetail;
import com.ihk.property.data.pojo.PropertyGroupDetailCond;

/**
 * PropertyGroupDetail的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IPropertyGroupDetailServices {

	/**
	 * 新增PropertyGroupDetail
	 * @param propertyGroupDetail
	 */
	public void addPropertyGroupDetail(PropertyGroupDetail propertyGroupDetail) throws RuntimeException;

	/**
	 * 删除一条PropertyGroupDetail
	 * @param id
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
	public List<PropertyGroupDetail> findPropertyGroupDetailPage(PropertyGroupDetailCond cond) throws RuntimeException;

	/**
	 * 查找全部PropertyGroupDetail
	 * @param cond 查询条件
	 * @return PropertyGroupDetail列表
	 */
	public List<PropertyGroupDetail> findPropertyGroupDetail(PropertyGroupDetailCond cond) throws RuntimeException;
	
	/**
	 * 根据ids批量添加房间
	 * @param cond.ids 房间ID
	 * @param cond.pojo 创建时间/人 修改时间/人
	 * @param cond.groupId 组团ID 
	 * */
	public void addUnitByUnitIds(PropertyGroupDetailCond cond) throws RuntimeException;
	
	/** 根据buildID批量添加房间
	 * @param cond.buildId 楼栋ID
	 * @param cond.pojo 创建时间/人 修改时间/人
	 * @param cond.groupId 组团ID  
	 * */
	public void addUnitByBuildId(PropertyGroupDetailCond cond) throws RuntimeException;
	
	/**
	 * 根据组团ID 和房间ID 删除在该组团的房间ID  //需要添加修改人和修改时间
	 * @param cond.groupId 组团ID
	 * @param cond.unitId 房间ID
	 * */
	public void  deletePropertyGroupDetailByGroupIdAndUnitId (PropertyGroupDetailCond cond) throws RuntimeException;
	
}