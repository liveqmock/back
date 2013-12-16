package com.ihk.user.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.user.data.IProjectStateMapper;
import com.ihk.user.data.pojo.ProjectState;
import com.ihk.user.data.pojo.ProjectStateCond;
import com.ihk.user.data.services.IProjectStateServices;

@Service("projectStateServices")
public class ProjectStateServices implements IProjectStateServices {
	@Autowired	 IProjectStateMapper projectStateMapper;

	public void deleteProjectState(int id) throws RuntimeException {
		projectStateMapper.deleteProjectState(id);
	}

	public void addProjectState(ProjectState projectState) throws RuntimeException {		
		projectStateMapper.addProjectState(projectState);
	}

	@Override
	public ProjectState findProjectStateById(int id) throws RuntimeException {
		return projectStateMapper.findProjectStateById(id);
	}

	@Override
	public void updateProjectState(ProjectState projectState) throws RuntimeException {
		projectStateMapper.updateProjectState(projectState);		
	}
	
	public List<ProjectState> findProjectStatePage(ProjectStateCond cond) throws RuntimeException {
		int recordCount = projectStateMapper.findProjectStateCount(cond);
		
		cond.recordCount = recordCount;
				
		return projectStateMapper.findProjectStatePage(cond);
	}
    
	public List<ProjectState> findProjectState(ProjectStateCond cond) throws RuntimeException {
    	return projectStateMapper.findProjectState(cond);
	}
}
