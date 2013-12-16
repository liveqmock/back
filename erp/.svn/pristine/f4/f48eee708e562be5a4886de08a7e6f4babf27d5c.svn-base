package com.ihk.property.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;

/**
 * PropertyProject的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IPropertyProjectServices {

	/**
	 * 新增PropertyProject
	 * @param propertyProject
	 */
	public void addPropertyProject(PropertyProject propertyProject) throws RuntimeException;


	/**
	 * 删除一条PropertyProject
	 * @param id
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
	public List<PropertyProject> findPropertyProjectPage(PropertyProjectCond cond) throws RuntimeException;

	/**
	 * 查找全部PropertyProject
	 * @param cond 查询条件
	 * @return PropertyProject列表
	 */
	public List<PropertyProject> findPropertyProject(PropertyProjectCond cond) throws RuntimeException;
	
	/**
	 * 根据name模糊查询
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<PropertyProject> findPropertyProjectsLikeName(String name) throws Exception;
	
	/**
	 * 根据name查询
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public PropertyProject findPropertyProjectIsExistsByProjectName(String name) throws Exception; //根据项目名称判断该项目是否存在
	
	/**
	 * 符合条件的记录条数
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public int findPropertyProjectCount(PropertyProjectCond cond) throws Exception;

	/**
	 * 根据ids查询
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