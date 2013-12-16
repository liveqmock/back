package com.ihk.user.data;

import java.util.List;

import com.ihk.user.data.pojo.ProjectState;
import com.ihk.user.data.pojo.ProjectStateCond;

/**
 * ProjectState数据访问接口Mapper
 * @author 
 *
 */ 
public interface IProjectStateMapper {

	/**
	 * 新增ProjectState
	 * @param projectState
	 */
	public void addProjectState(ProjectState projectState) ;

	/**
	 * 根据条件删除ProjectState
	 * @param cond 删除条件
	 */
	public void deleteProjectState(int id) throws RuntimeException;

	/**
	 * 修改ProjectState
	 * @param projectState
	 */
	public void updateProjectState(ProjectState projectState) throws RuntimeException;

	/**
	 * 查找一条ProjectState
	 * @return ProjectState
	 * @param id 主键id
	 */
	public ProjectState findProjectStateById(int id) throws RuntimeException;

	/**
	 * 分页查找ProjectState
	 * @param cond 查询条件
	 * @return ProjectState列表
	 */
	public List<ProjectState> findProjectStatePage(ProjectStateCond cond) ;

	/**
	 * 查找全部ProjectState
	 * @param cond 查询条件
	 * @return ProjectState列表
	 */
	public List<ProjectState> findProjectState(ProjectStateCond cond) ;

	/**
	 * 查找符合条件的记录条数ProjectState
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findProjectStateCount(ProjectStateCond cond) ;
}
