package com.ihk.saleunit.action.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.common.tag.CheckboxTagUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 多选公司项目的业务抽象类
 * @author dtc
 * 2012-11-27,下午04:36:51
 */
public abstract class MyCompanyProjectChangeTemplate {
	
	/**
	 * 初始化页面显示的公司选择框,项目table
	 * @param request
	 * @return
	 */
	public Map<Company, List<CompanyProject>> initMap(HttpServletRequest request){
		
		Map<Company, List<CompanyProject>> retMap = new LinkedHashMap<Company, List<CompanyProject>>();
		
		List<CompanyProject> projects  = doExecuteCallback();
		
		if(!CommonUtils.isCollectionEmpty(projects)){
			
			Set<Integer> comIdSet = new HashSet<Integer>(); //所有的公司
			
			for(CompanyProject pro : projects){
				
				int comId = pro.getCompanyId();
				if(!comIdSet.contains(comId)){
					comIdSet.add(comId);
				}
			}
			
			for(int comId : comIdSet){
				
				Company company = MyPropertyUtils.getCompanyServices().findCompanyById(comId);
				List<CompanyProject> proList = getProjectListByCompanyId(projects, comId);

				retMap.put(company, proList);
				
			}
			
		}
		
		//上个页面选中的项目id(id1,id2,id3...)
		String projectId = request.getParameter("projectId");
		if(CommonUtils.isStrZeroEmpty(projectId)){
			projectId = "";
		}
		
		Map<String, String> _selCompanyMap = CheckboxTagUtils.projectListToCompanyMap(projects);
		request.setAttribute("_selCompanyMap", _selCompanyMap);
		request.setAttribute("_projectId", projectId);
		
		return retMap;
		
	}
	
	/**
	 * 实际返回的项目list(根据权限来获取)
	 * @return
	 */
	public abstract List<CompanyProject> doExecuteCallback();
	
	/**
	 * 根据公司id,获取对应的项目list
	 * @param projects
	 * @param comId
	 * @return
	 */
	private List<CompanyProject> getProjectListByCompanyId(List<CompanyProject> projects, int comId){
		
		if(CommonUtils.isCollectionEmpty(projects) || comId <= 0)
			return null;
		
		List<CompanyProject> retList = new ArrayList<CompanyProject>();
		
		for(CompanyProject pro : projects){
			
			int getComId = pro.getCompanyId();
			if(comId == getComId){
				retList.add(pro);
			}
			
		}
		
		return retList;
	}

}
