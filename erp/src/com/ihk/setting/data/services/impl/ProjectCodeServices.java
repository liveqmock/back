package com.ihk.setting.data.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.setting.data.IProjectCodeMapper;
import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.pojo.ProjectCode;
import com.ihk.setting.data.pojo.ProjectCodeCond;
import com.ihk.setting.data.services.IProjectCodeServices;

@Service("projectCodeServices")
public class ProjectCodeServices implements IProjectCodeServices {
	@Autowired	 IProjectCodeMapper projectCodeMapper;

	@Override
	public List<CodeDtl> findCodeList(ProjectCodeCond cond) {
		
		return projectCodeMapper.findCodeList(cond);
	}

	@Override
	public ProjectCode findCodeDescByCodeVal(ProjectCodeCond cond)
			throws RuntimeException {
		
		return projectCodeMapper.findCodeDescByCodeVal(cond);
	}

	@Override
	public List<ProjectCode> findAllProjectCode() {
		
		return projectCodeMapper.findAllProjectCode();
	}

	@Override
	public List<ProjectCode> findProjectCodeByProjectIdAndTypeName(
			int projectId, String typeName) throws RuntimeException {
		
		ProjectCodeCond cond = new ProjectCodeCond();
		cond.setProjectId(projectId);
		cond.setTypeName(typeName);
		
		return projectCodeMapper.findProjectCodeByProjectIdAndTypeName(cond);
	}
	
	@Override
	public ProjectCode findProjectCode(ProjectCodeCond cond) throws RuntimeException {
		return projectCodeMapper.findProjectCode(cond);
	}

	@Override
	public void saveProjectCode(ProjectCode projectCode)
			throws RuntimeException {
		projectCodeMapper.saveProjectCode(projectCode);
		
	}

	@Override
	public void deleteAllProjectCode(Map map) {
		projectCodeMapper.deleteAllProjectCode(map);
		
	}

	

}
