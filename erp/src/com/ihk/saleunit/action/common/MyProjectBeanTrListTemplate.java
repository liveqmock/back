package com.ihk.saleunit.action.common;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.common.tag.CheckboxTagBean;
import com.ihk.utils.common.tag.CheckboxTagUtils;

/**
 * 多选项目的业务抽象类
 * @author dtc
 * 2012-10-16,上午10:59:34
 */
public abstract class MyProjectBeanTrListTemplate {
	
	/**
	 * 初始化页面显示的项目选择框list
	 * @param request
	 * @return
	 */
	public List<CheckboxTagBean[]> initTrList(HttpServletRequest request){
		
		String projectId = request.getParameter("projectId");
		String projectName = request.getParameter("projectName");
		String companyId = request.getParameter("companyId");
		if(CommonUtils.isStrZeroEmpty(companyId)){
			companyId = "";
		}
		
		List<CompanyProject> projects  = doExecuteCallback();
		
		//把项目下拉框放到session中
		Map<String, String> _selCompanyMap = CheckboxTagUtils.projectListToCompanyMap(projects);
		request.setAttribute("_selCompanyMap", _selCompanyMap);
		request.setAttribute("_selectCompanyId", companyId);
		
		List<CheckboxTagBean> changeList = CheckboxTagUtils.parStringToCheckboxList(projectId, projectName);
		
		return CheckboxTagUtils.initCheckboxTagTrListByPojoList(projects, "id", "projectName", "companyId", 4, changeList);
		
	}
	
	/**
	 * 实际返回的项目list(根据权限来获取)
	 * @return
	 */
	public abstract List<CompanyProject> doExecuteCallback();

}
