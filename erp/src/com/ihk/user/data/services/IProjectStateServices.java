package com.ihk.user.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.user.data.pojo.ProjectState;
import com.ihk.user.data.pojo.ProjectStateCond;

/**
 * ProjectState的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IProjectStateServices {
	/**
	 * 新增ProjectState
	 * @param projectState
	 */
	public void addProjectState(ProjectState projectState) throws RuntimeException;

	/**
	 * 删除一条ProjectState
	 * @param id
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
	public List<ProjectState> findProjectStatePage(ProjectStateCond cond) throws RuntimeException;

	/**
	 * 查找全部ProjectState
	 * @param cond 查询条件
	 * @return ProjectState列表
	 */
	public List<ProjectState> findProjectState(ProjectStateCond cond) throws RuntimeException;
}