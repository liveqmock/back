package com.ihk.customer.data;

import java.util.List;
import java.util.Map;

import com.ihk.customer.data.pojo.ProjectRange;
import com.ihk.customer.data.pojo.ProjectRangeCond;
 
/**
 * ProjectRange数据访问接口Mapper
 * @author 
 *
 */ 
public interface IProjectRangeMapper {

	/**
	 * 新增ProjectRange
	 * @param projectRange
	 */
	public void addProjectRange(ProjectRange projectRange) ;

	/**
	 * 根据条件删除ProjectRange
	 * @param cond 删除条件
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
	public List<ProjectRange> findProjectRangePage(ProjectRangeCond cond) ;

	/**
	 * 查找全部ProjectRange
	 * @param cond 查询条件
	 * @return ProjectRange列表
	 */
	public List<ProjectRange> findProjectRange(ProjectRangeCond cond) ;

	/**
	 * 查找符合条件的记录条数ProjectRange
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findProjectRangeCount(ProjectRangeCond cond) ;
}
