package com.ihk.customer.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.customer.data.IProjectRangeMapper;
import com.ihk.customer.data.pojo.ProjectRange;
import com.ihk.customer.data.pojo.ProjectRangeCond;
import com.ihk.customer.data.services.IProjectRangeServices;

/**
 * ProjectRange的Services实现(业务实现)
 * @author 
 *
 */
@Service("projectRangeServices")
@SuppressWarnings("unchecked")
public class ProjectRangeServices implements IProjectRangeServices {
	/**
	 * projectRange数据访问接口
	 */
	@Autowired	 IProjectRangeMapper projectRangeMapper;

	/**
	 * 删除一条ProjectRange
	 * @param id
	 */
	public void deleteProjectRange(int id) throws RuntimeException {
		projectRangeMapper.deleteProjectRange(id);
	}

	/**
	 * 新增ProjectRange
	 * @param projectRange
	 */
	public void addProjectRange(ProjectRange projectRange) throws RuntimeException {		
		projectRangeMapper.addProjectRange(projectRange);
	}

	/**
	 * 查找一条ProjectRange
	 * @return ProjectRange
	 * @param id 主键id
	 */
	@Override
	public ProjectRange findProjectRangeById(int id) throws RuntimeException {
		return projectRangeMapper.findProjectRangeById(id);
	}

	/**
	 * 修改ProjectRange
	 * @param projectRange
	 */
	@Override
	public void updateProjectRange(ProjectRange projectRange) throws RuntimeException {
		projectRangeMapper.updateProjectRange(projectRange);		
	}

	/**
	 * 分页查找ProjectRange
	 * @param cond 查询条件
	 * @return ProjectRange列表
	 */
	public List<ProjectRange> findProjectRangePage(ProjectRangeCond cond) throws RuntimeException {
		int recordCount = projectRangeMapper.findProjectRangeCount(cond);
		
		cond.recordCount = recordCount;
				
		return projectRangeMapper.findProjectRangePage(cond);
	}

	/**
	 * 查找全部ProjectRange
	 * @param cond 查询条件
	 * @return ProjectRange列表
	 */
	public List<ProjectRange> findProjectRange(ProjectRangeCond cond) throws RuntimeException {
    	return projectRangeMapper.findProjectRange(cond);
	}
}
