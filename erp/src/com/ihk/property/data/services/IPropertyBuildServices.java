package com.ihk.property.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;

/**
 * PropertyBuild的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IPropertyBuildServices {
	/**
	 * 新增PropertyBuild
	 * @param propertyBuild
	 */
	public void addPropertyBuild(PropertyBuild propertyBuild) throws RuntimeException;
	public void addKnPropertyBuild(PropertyBuild propertyBuild)throws RuntimeException;
	/**
	 * 删除一条PropertyBuild
	 * @param id
	 */
	public void deletePropertyBuild(int id) throws RuntimeException;

	/**
	 * 修改PropertyBuild
	 * @param propertyBuild
	 */
	public void updatePropertyBuild(PropertyBuild propertyBuild) throws RuntimeException;

	/**
	 * 查找一条PropertyBuild
	 * @return PropertyBuild
	 * @param id 主键id
	 */
	public PropertyBuild findPropertyBuildById(int id) throws RuntimeException;

	/**
	 * 分页查找PropertyBuild
	 * @param cond 查询条件
	 * @return PropertyBuild列表
	 */
	public List<PropertyBuild> findPropertyBuildPage(PropertyBuildCond cond) throws RuntimeException;

	/**
	 * 查找全部PropertyBuild
	 * @param cond 查询条件
	 * @return PropertyBuild列表
	 */
	public List<PropertyBuild> findPropertyBuild(PropertyBuildCond cond) throws RuntimeException;
	
	/**
	 * 根据name模糊查询
	 * @param name
	 * @return
	 * @throws RuntimeException
	 */
	public List<PropertyBuild> findPropertyBuildsLikeName(String name)  throws RuntimeException;
	
	/**
	 * 根据name 与propertyProjectId 模糊查询
	 * @param name
	 * @param propertyProjectId
	 * @return
	 * @throws RuntimeException
	 */
	public List<PropertyBuild> findPropertyBuildsLikeNameAndPropertyProjectId(String name, int propertyProjectId)  throws RuntimeException;
	
	/**
	 * 根据name 查找
	 * @param name
	 * @return
	 * @throws RuntimeException
	 */
	public PropertyBuild findBuildIsExistsByBuildName(String name)throws RuntimeException;
	
	/**
	 * 根据 propertyId 查找
	 * @param propertyId
	 * @return
	 * @throws RuntimeException
	 */
	public List<PropertyBuild> findPropertyBuildByPropertyId(int propertyId) throws RuntimeException;
	
	/**
	 * 根据areaId 查找
	 * @param areaId
	 * @return
	 * @throws RuntimeException
	 */
	public List<PropertyBuild> findPropertyBuildByAreaId(int areaId) throws RuntimeException;
	
	/**
	 * 根据组团id获取对应的楼栋id
	 * @param groupDetailId
	 * @return
	 * @throws RuntimeException
	 */
	public List<Integer> findPropertyBuildByGroupId(int groupId) throws RuntimeException;
	
	/**
	 * 查找的记录数
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public int findPropertyBuildCount(PropertyBuildCond cond)  throws RuntimeException;
	
	/**
	 * 根据id获取其全名:项目-分区-楼栋
	 * @param buildId
	 * @return
	 * @throws RuntimeException
	 */
	public String findPropertyBuildAllNameByBuildId(int buildId) throws RuntimeException;
	public String findPropertyBuildAreaNameByBuildId(int buildId) throws RuntimeException;

	/**
	 * 根据楼栋id修改对应的排序
	 * @param buildId
	 * @param orderIndex
	 * @return
	 * @throws RuntimeException
	 */
	public void updatePropertyBuildOrderIndex(int buildId, int orderIndex) throws RuntimeException;
	
}