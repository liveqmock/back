package com.ihk.user.data;

import java.util.List;
import java.util.Map;

import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;

/**
 * CompanyProject数据访问接口Mapper
 * @author 
 *
 */ 
public interface ICompanyProjectMapper {

	/**
	 * 查找全部CompanyProject
	 * @return CompanyProject列表
	 */
	public List<CompanyProject> findCompanyProject();

	/**
	 * 新增CompanyProject
	 * @param companyProject
	 */
	public void addCompanyProject(CompanyProject companyProject) ;

	/**
	 * 根据条件删除CompanyProject
	 * @param id 删除条件
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
	public List<CompanyProject> findCompanyProjectPage(CompanyProjectCond cond) ;

	/**
	 * 查找符合条件的记录条数CompanyProject
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findCompanyProjectCount(CompanyProjectCond cond) ;
	
	/**
	 * 根据name 查找
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<CompanyProject> findCompanyProjectsLikeName(String name) throws Exception;
	
	/**
	 * 根据companyId查找
	 * @param companyId
	 * @return
	 * @throws RuntimeException
	 */
	public List<CompanyProject> findCompanyProjectsByCompanyId(int companyId) throws RuntimeException;
	
	/**
	 * companyId 查找
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<CompanyProject> findCompanyProjectsLikeNameAndCompanyId(CompanyProjectCond cond) throws Exception; //根据公司id及项目like name来获取项目
	
	/**
	 * 根据companyId 查找
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public CompanyProject findCompanyProjectIsExistsByProjectNameAndCompanyId(Map<String, String> map) throws Exception; //根据项目名称及公司id判断该项目是否存在
	
	/**
	 * 恒大的公司项目
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<CompanyProject> findCompanyProjectForHengDa() throws Exception;
	
	/**
	 * 新建项目之后 要初始化一套数据给该项目
	 * @param id 新项目的ID
	 * */
	public void addCodeProjectByNewProject(int id) throws Exception;

    /**
     * 根据项目名称和id判断是否一致,
     * @param map
     * @return
     * @throws RuntimeException
     */
	public List<CompanyProject> findCompanyProjectByNameAndId(Map<String, String> map) throws RuntimeException;
	
	/**
	 * 查询companyProject列表
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<CompanyProject> findCompanyProjectByCond(CompanyProjectCond cond) throws RuntimeException;
	
	/**
	 * 增加或修改公司项目的拼音
	 * @param project
	 * @throws RuntimeException
	 */
	public void updateCompanyProjectPinyin(CompanyProject project) throws RuntimeException;

	public List<CompanyProject> findCompanyProjectPageIncludeIsDeleted(
			CompanyProjectCond condProject);
		
}
