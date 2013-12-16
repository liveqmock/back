package com.ihk.user.data.services;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;

/**
 * CompanyProject的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface ICompanyProjectServices {
	
	public int findCompanyProjectCount(CompanyProjectCond cond)  throws RuntimeException;
	/**
	 * 新增CompanyProject
	 * @param companyProject
	 */
	public void addCompanyProject(CompanyProject companyProject) throws RuntimeException;
	public void addKnCompanyProject(CompanyProject companyProject) throws RuntimeException;
	
	/**
	 * 删除一条CompanyProject
	 * @param id
	 */
	public void deleteCompanyProject(int id) throws RuntimeException;

	/**
	 * 修改CompanyProject
	 * @param companyProject
	 */
	public void updateCompanyProject(CompanyProject companyProject) throws RuntimeException;

	/**
	 * 查找一条CompanyProject
	 * @return CompanyProject
	 * @param id 主键id
	 */
	public CompanyProject findCompanyProjectById(int id) throws RuntimeException;

	/**
	 * 分页查找CompanyProject
	 * @param cond 查询条件
	 * @return CompanyProject列表
	 */
	public List<CompanyProject> findCompanyProjectPage(CompanyProjectCond cond) throws RuntimeException;
	
	/**
	 * 查询CompanyProject列表
	 * @param cond 查询条件
	 * @return
	 * @throws RuntimeException
	 */
	public List<CompanyProject> findCompanyProjectByCond(CompanyProjectCond cond) throws RuntimeException;

	/**
	 * 查找全部CompanyProject
	 * @param cond 查询条件
	 * @return CompanyProject列表
	 */
	public List<CompanyProject> findCompanyProject()throws Exception;
	
	/**
	 * 根据name 模糊查询
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<CompanyProject> findCompanyProjectsLikeName(String name) throws Exception;
	
	/**
	 * 根据CompanyId查找
	 * @param companyId
	 * @return
	 * @throws RuntimeException
	 */
	public List<CompanyProject> findCompanyProjectsByCompanyId(int companyId) throws RuntimeException;
	
	/**
	 * 在某一日期，是否活动
	 * @param id
	 * @param date
	 * @return
	 * @throws RuntimeException
	 */
	public boolean isProjectStateActive(int id,DateTime date) throws RuntimeException;

	/**
	 * 在日期范围内是否有活动，只要有一天活动，则视为活动
	 * @param id
	 * @param fromDate
	 * @param toDate
	 * @return
	 * @throws RuntimeException
	 */
	public boolean isProjectStateActive(int id,DateTime fromDate,DateTime toDate) throws RuntimeException;
	
	/**
	 * 根据name与companyId查找
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<CompanyProject> findCompanyProjectsLikeNameAndCompanyId(CompanyProjectCond cond) throws Exception; //根据公司id及项目like name来获取项目
	
	/**
	 * 根据项目名称及公司id判断该项目是否存在
	 * @param projectName
	 * @param companyId
	 * @return
	 * @throws Exception
	 */
	public CompanyProject findCompanyProjectIsExistsByProjectNameAndCompanyId(String projectName, int companyId) throws Exception; 
	
	/**
	 * 获取恒大所有的公司项目
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<CompanyProject> findCompanyProjectForHengDa() throws Exception;
	
	/**
	 * 新建项目之后 要初始化一套数据给该项目
	 * @param id 新项目的ID
	 * */
	public void addCodeProjectByNewProject(int id)throws RuntimeException;
	
	/**
	 * 判断项目名称和id是否一致
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public boolean findCompanyProjectIsFitByNameAndId(String name, int id) throws RuntimeException;
	
	/**
	 * 增加或修改公司项目的拼音
	 * @param project
	 * @throws RuntimeException
	 */
	public void updateCompanyProjectPinyin(CompanyProject project) throws RuntimeException;
	
	public List<CompanyProject> findCompanyProjectPageIncludeIsDeleted(
			CompanyProjectCond condProject);
	
}
