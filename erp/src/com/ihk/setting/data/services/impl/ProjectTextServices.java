package com.ihk.setting.data.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.setting.data.IProjectTextMapper;
import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.pojo.ProjectText;
import com.ihk.setting.data.pojo.ProjectTextCond;
import com.ihk.setting.data.services.IProjectTextServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * ProjectText的Services实现(业务实现)
 * @author 
 *
 */
@Service("projectTextServices")
public class ProjectTextServices implements IProjectTextServices {
	/**
	 * projectText数据访问接口
	 */
	@Autowired	 IProjectTextMapper projectTextMapper;

	/**
	 * 删除一条ProjectText
	 * @param id
	 */
	public void deleteProjectText(int id) throws RuntimeException {
		
		PojoDeleteCond cond = new PojoDeleteCond(id);
		projectTextMapper.deleteProjectText(cond);
	}

	/**
	 * 新增ProjectText
	 * @param projectText
	 */
	public void addProjectText(ProjectText projectText) throws RuntimeException {		
		projectTextMapper.addProjectText(projectText);
	}

	/**
	 * 查找一条ProjectText
	 * @return ProjectText
	 * @param id 主键id
	 */
	@Override
	public ProjectText findProjectTextById(int id) throws RuntimeException {
		return projectTextMapper.findProjectTextById(id);
	}

	/**
	 * 修改ProjectText
	 * @param projectText
	 */
	@Override
	public void updateProjectText(ProjectText projectText) throws RuntimeException {
		projectTextMapper.updateProjectText(projectText);		
	}

	/**
	 * 分页查找ProjectText
	 * @param cond 查询条件
	 * @return ProjectText列表
	 */
	public List<ProjectText> findProjectTextPage(ProjectTextCond cond) throws RuntimeException {
		int recordCount = projectTextMapper.findProjectTextCount(cond);
		
		cond.recordCount = recordCount;
				
		return projectTextMapper.findProjectTextPage(cond);
	}

	/**
	 * 查找全部ProjectText
	 * @param cond 查询条件
	 * @return ProjectText列表
	 */
	public List<ProjectText> findProjectText(ProjectTextCond cond) throws RuntimeException {
    	return projectTextMapper.findProjectText(cond);
	}

	/**
	 * 查找列表
	 */
	@Override
	public List<CodeDtl> findCodeList(ProjectTextCond cond)
			throws RuntimeException {
		return projectTextMapper.findCodeList(cond);
	}

	/**
	 * 查找最大顺序的记录
	 */
	@Override
	public ProjectText findMaxOrderProjectTextByProjectIdAndTypeName(
			int projectId, String typeName) throws RuntimeException {
		
		ProjectTextCond cond = new ProjectTextCond();
		cond.setProjectId(projectId + "");
		cond.setTypeName(typeName);
		
		return projectTextMapper.findMaxOrderProjectTextByProjectIdAndTypeName(cond);
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteProjectTextByTypeName(String typeName)
			throws RuntimeException {
		
		ProjectTextCond cond = new ProjectTextCond();
		cond.setTypeName(typeName);
		cond.setProjectId(SessionUser.getProjectId() + "");
		cond.setModId(SessionUser.getUserId());
		cond.setModTime(new Date());
		
		projectTextMapper.deleteProjectTextByTypeName(cond);
		
	}

	/**
	 * 修改
	 */
	@Override
	public void updateProjectTextCodeDesc(ProjectText text)throws RuntimeException {
		
		ProjectTextCond cond = new ProjectTextCond();
		cond.setId(text.getId());
		cond.setCodeDesc(text.getCodeDesc());
		cond.setModId(SessionUser.getUserId());
		cond.setModTime(new Date());
		
		projectTextMapper.updateProjectTextCodeDesc(cond);
		
	}
}
