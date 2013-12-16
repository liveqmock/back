package com.ihk.user.data.services.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.setting.data.pojo.ProjectText;
import com.ihk.setting.data.services.IProjectTextServices;
import com.ihk.user.data.ICompanyProjectMapper;
import com.ihk.user.data.IProjectStateMapper;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.pojo.ProjectState;
import com.ihk.user.data.pojo.ProjectStateCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;


@Service("companyProjectServices")
@SuppressWarnings("unchecked")
public class CompanyProjectServices implements ICompanyProjectServices {
	@Autowired ICompanyProjectMapper companyProjectMapper;

	@Autowired IProjectStateMapper projectStateMapper;
	@Autowired IProjectTextServices projectTextServices;
	@Override
	public List<CompanyProject> findCompanyProject() {
		return companyProjectMapper.findCompanyProject();
	}
	
	public void deleteCompanyProject(int id) throws RuntimeException {
		companyProjectMapper.deleteCompanyProject(id);
	}
	
	public void addKnCompanyProject(CompanyProject companyProject) throws RuntimeException {		
		companyProjectMapper.addCompanyProject(companyProject);

	}

	public void addCompanyProject(CompanyProject companyProject) throws RuntimeException {		
		companyProjectMapper.addCompanyProject(companyProject);
		
		try {//新建项目初始 project_text的值
			ProjectText t = new ProjectText();
			t.setCreatedId(SessionUser.getUserId());
			t.setCreatedTime(new Date());
			t.setModId(t.getCreatedId());
			t.setModTime(t.getCreatedTime());
			t.setIsDeleted("0");
			t.setTypeName("PRODUCT_TYPE");
			t.setProjectId(companyProject.getId());
			
			t.setCodeOrder(1);
			t.setCodeDesc("住宅");
			projectTextServices.addProjectText(t);
			t.setCodeOrder(2);
			t.setCodeDesc("公寓");
			projectTextServices.addProjectText(t);
			t.setCodeOrder(3);
			t.setCodeDesc("办公");
			projectTextServices.addProjectText(t);
			t.setCodeOrder(4);
			t.setCodeDesc("商业");
			projectTextServices.addProjectText(t);
			t.setCodeOrder(5);
			t.setCodeDesc("车位");
			projectTextServices.addProjectText(t);
			
			t.setTypeName("RENOVATE_DESC");
			t.setCodeOrder(1);
			t.setCodeDesc("毛坯");
			projectTextServices.addProjectText(t);
			t.setCodeOrder(5);
			t.setCodeDesc("普通");
			projectTextServices.addProjectText(t);
			t.setCodeOrder(5);
			t.setCodeDesc("豪华");
			projectTextServices.addProjectText(t);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public CompanyProject findCompanyProjectById(int id) throws RuntimeException {
		return companyProjectMapper.findCompanyProjectById(id);
	}

	@Override
	public void updateCompanyProject(CompanyProject companyProject) throws RuntimeException {
		companyProjectMapper.updateCompanyProject(companyProject);		
	}
	
	@SuppressWarnings("rawtypes")
	public List findCompanyProjectPage(CompanyProjectCond cond) throws RuntimeException {
		int recordCount = companyProjectMapper.findCompanyProjectCount(cond);
		
		cond.recordCount = recordCount;
				
		return companyProjectMapper.findCompanyProjectPage(cond);
	}
	@Override
	public List<CompanyProject> findCompanyProjectsLikeName(String name) throws Exception {
		return companyProjectMapper.findCompanyProjectsLikeName(name);
	}
	@Override
	public List<CompanyProject> findCompanyProjectsByCompanyId(int companyId)
			throws RuntimeException {
		return companyProjectMapper.findCompanyProjectsByCompanyId(companyId);
	}

	@Override
	public boolean isProjectStateActive(int id, DateTime date) throws RuntimeException {
		ProjectStateCond  cond = new ProjectStateCond();
		cond.setProjectId(String.valueOf(id));
		cond.setDate2(date.toString("yyyy-MM-dd"));
		cond.setOrderByFiled("11");
		List<ProjectState> list = projectStateMapper.findProjectState(cond);
		
		if(list.size()>0 && list.get(0).getProjectState().equals("1")==false){
			return false;
		}
		return true;
	}

	@Override
	public boolean isProjectStateActive(int id, DateTime fromDate,
			DateTime toDate) throws RuntimeException {
		ProjectStateCond  cond = new ProjectStateCond();
		cond.setProjectId(String.valueOf(id));
		cond.setDate1(fromDate.toString("yyyy-MM-dd"));
		cond.setDate2(toDate.toString("yyyy-MM-dd"));
		cond.setOrderByFiled("11");

		List<ProjectState> list = projectStateMapper.findProjectState(cond);
		
		if(list.size()<=0){
			return true;
		}
		
		boolean flag = false;
		for(ProjectState ps : list){
			if("1".equals(ps.getProjectState())){
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public List<CompanyProject> findCompanyProjectsLikeNameAndCompanyId(CompanyProjectCond cond) throws Exception {
		
		return companyProjectMapper.findCompanyProjectsLikeNameAndCompanyId(cond);
	}

	@Override
	public CompanyProject findCompanyProjectIsExistsByProjectNameAndCompanyId(String projectName, int companyId)
			throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("projectName", projectName);
		map.put("companyId", companyId + "");
		
		return companyProjectMapper.findCompanyProjectIsExistsByProjectNameAndCompanyId(map);
	}

	@Override
	public List<CompanyProject> findCompanyProjectForHengDa() throws Exception {
		
		return companyProjectMapper.findCompanyProjectForHengDa();
	}

	@Override
	public void addCodeProjectByNewProject(int id) throws RuntimeException {
		try {
			companyProjectMapper.addCodeProjectByNewProject(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean findCompanyProjectIsFitByNameAndId(String name, int id)
			throws RuntimeException {
		
		try{
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", name);
			map.put("id", id + "");
			
			List<CompanyProject> getList = companyProjectMapper.findCompanyProjectByNameAndId(map);
			if(CommonUtils.isCollectionEmpty(getList)){
				
				return false;
			}
			
			if(getList.size() >= 2){
				
				return false;
			}
			
			return true;
			
		}catch (Exception e) {
			
			return false;
		}
		
	}

	@Override
	public int findCompanyProjectCount(CompanyProjectCond cond)
			throws RuntimeException {
		return companyProjectMapper.findCompanyProjectCount(cond);
	}
	
	@Override
	public List<CompanyProject> findCompanyProjectByCond(CompanyProjectCond cond) throws RuntimeException {
		return companyProjectMapper.findCompanyProjectByCond(cond);
	}

	@Override
	public void updateCompanyProjectPinyin(CompanyProject project)
			throws RuntimeException {
		
		companyProjectMapper.updateCompanyProjectPinyin(project);
	}

	@Override
	public List<CompanyProject> findCompanyProjectPageIncludeIsDeleted(
			CompanyProjectCond condProject) {
		return companyProjectMapper.findCompanyProjectPageIncludeIsDeleted(condProject);
	}
	
}
