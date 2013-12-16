package com.ihk.property.data;

import java.util.List;

import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;

/**
 * PropertyBuild数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPropertyBuildMapper {

	/**
	 * 新增PropertyBuild
	 * @param propertyBuild
	 */
	public void addPropertyBuild(PropertyBuild propertyBuild) ;

	/**
	 * 根据条件删除PropertyBuild
	 * @param cond 删除条件
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
	public List<PropertyBuild> findPropertyBuildPage(PropertyBuildCond cond) ;

	/**
	 * 查找全部PropertyBuild
	 * @param cond 查询条件
	 * @return PropertyBuild列表
	 */
	public List<PropertyBuild> findPropertyBuild(PropertyBuildCond cond) ;

	/**
	 * 查找符合条件的记录条数PropertyBuild
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPropertyBuildCount(PropertyBuildCond cond) ;
	
	/**
	 * 根据name模糊查询
	 * @param name
	 * @return
	 * @throws RuntimeException
	 */
	public List<PropertyBuild> findPropertyBuildsLikeName(String name)  throws RuntimeException;
	
	/**
	 * 根据name,property模糊查询
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<PropertyBuild> findPropertyBuildsLikeNameAndPropertyProjectId(PropertyBuildCond cond)  throws RuntimeException;
	
	/**
	 * 查找同名的build
	 * @param name
	 * @return
	 * @throws RuntimeException
	 */
	public PropertyBuild findBuildIsExistsByBuildName(String name)throws RuntimeException;
	
	/**
	 * 根据PropertyId查找
	 * @param propertyId
	 * @return
	 * @throws RuntimeException
	 */
	public List<PropertyBuild> findPropertyBuildByPropertyId(int propertyId) throws RuntimeException;
	
	/**
	 * 根据areaId查找
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
	 * 根据id获取其全名:项目-分区-楼栋
	 * @param buildId
	 * @return
	 * @throws RuntimeException
	 */
	public String findPropertyBuildAllNameByBuildId(int buildId) throws RuntimeException;
	public String findPropertyBuildAreaNameByBuildId(int buildId) throws RuntimeException;

	/**
	 * 根据楼栋id修改对应的排序
	 * @param build
	 * @throws RuntimeException
	 */
	public void updatePropertyBuildOrderIndex(PropertyBuild build) throws RuntimeException;
	
}
