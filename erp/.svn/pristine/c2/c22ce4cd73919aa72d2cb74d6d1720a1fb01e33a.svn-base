package com.ihk.property.data;

import java.util.List;

import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;

/**
 * PropertyProject数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPropertyProjectMapper {

	/**
	 * 新增PropertyProject
	 * @param propertyProject
	 */
	public void addPropertyProject(PropertyProject propertyProject) ;

	/**
	 * 根据条件删除PropertyProject
	 * @param cond 删除条件
	 */
	public void deletePropertyProject(int id) throws RuntimeException;

	/**
	 * 修改PropertyProject
	 * @param propertyProject
	 */
	public void updatePropertyProject(PropertyProject propertyProject) throws RuntimeException;

	/**
	 * 查找一条PropertyProject
	 * @return PropertyProject
	 * @param id 主键id
	 */
	public PropertyProject findPropertyProjectById(int id) throws RuntimeException;

	/**
	 * 分页查找PropertyProject
	 * @param cond 查询条件
	 * @return PropertyProject列表
	 */
	public List<PropertyProject> findPropertyProjectPage(PropertyProjectCond cond) ;

	/**
	 * 查找全部PropertyProject
	 * @param cond 查询条件
	 * @return PropertyProject列表
	 */
	public List<PropertyProject> findPropertyProject(PropertyProjectCond cond) ;

	/**
	 * 查找符合条件的记录条数PropertyProject
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPropertyProjectCount(PropertyProjectCond cond) ;
	
	/**
	 * 根据name模糊查找
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<PropertyProject> findPropertyProjectsLikeName(String name) throws Exception;
	
	/**
	 * 根据name查找
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public PropertyProject findPropertyProjectIsExistsByProjectName(String name) throws Exception; //根据项目名称判断该项目是否存在
	
	/**
	 * 根据ids进行查找
	 * @param cond
	 * @return
	 */
	public List<PropertyProject> findPropertyProjectByIds(PropertyProjectCond cond);
	
	/**
	 * 根据单元id获取对应的楼盘项目id
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public int findPropertyProjectIdByUnitId(int unitId) throws RuntimeException;
	
	/**
	 * 根据公司id获取对应的楼盘项目
	 * @param comId
	 * @return
	 * @throws RuntimeException
	 */
	public List<PropertyProject> findPropertyProjectByCompanyId(int comId) throws RuntimeException;
	
	/**
	 * 根据公司项目id获取对应的楼盘项目
	 * @param companyProjectId
	 * @return
	 * @throws RuntimeException
	 */
	public List<PropertyProject> findPropertyProjectByCompanyProjectId(int companyProjectId) throws RuntimeException;

}
