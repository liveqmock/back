package com.ihk.customer.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.data.pojo.ProjectRange;
import com.ihk.customer.data.pojo.ProjectRangeCond;

/**
 * ProjectRange的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IProjectRangeServices {

	/**
	 * 新增ProjectRange
	 * @param projectRange
	 */
	public void addProjectRange(ProjectRange projectRange) throws RuntimeException;

	/**
	 * 删除一条ProjectRange
	 * @param id
	 */
	public void deleteProjectRange(int id) throws RuntimeException;

	/**
	 * 修改ProjectRange
	 * @param projectRange
	 */
	public void updateProjectRange(ProjectRange projectRange) throws RuntimeException;

	/**
	 * 查找一条ProjectRange
	 * @return ProjectRange
	 * @param id 主键id
	 */
	public ProjectRange findProjectRangeById(int id) throws RuntimeException;

	/**
	 * 分页查找ProjectRange
	 * @param cond 查询条件
	 * @return ProjectRange列表
	 */
	public List<ProjectRange> findProjectRangePage(ProjectRangeCond cond) throws RuntimeException;

	/**
	 * 查找全部ProjectRange
	 * @param cond 查询条件
	 * @return ProjectRange列表
	 */
	public List<ProjectRange> findProjectRange(ProjectRangeCond cond) throws RuntimeException;
}