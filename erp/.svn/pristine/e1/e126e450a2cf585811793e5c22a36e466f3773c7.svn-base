package com.ihk.report.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.services.IPropertyAreaServices;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;

/**
 *  楼盘认购单报表分析
 */
public class GuangZhouConfirmPropertyAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IPropertyBuildServices buildServices;
	@Autowired
	IPropertyAreaServices areaServices;
	@Autowired
	IPropertyProjectServices projectServices;
	
	public String confirmProperty() throws Exception{
		
		cond = initCond(cond);
		
		List<Map<String, Object>> tmpMap = confirmServices.findPropertyReport(cond);
		confirmReportList = new ArrayList<Map<String,Object>>();
		
		//放在循环外面可以减少变量个数
		PropertyBuild build = null;
		PropertyArea area = null;
		PropertyProject project = null;
		
		for(Map<String, Object> map : tmpMap){
			
			Integer buildId = (Integer) map.get("bId");
			
			build = buildServices.findPropertyBuildById(buildId);
			area = areaServices.findPropertyAreaById(build.getAreaId());
			project = projectServices.findPropertyProjectById(build.getPropertyId());
			
			map.put("propertyName", project.getPropertyName());
			map.put("areaName", area.getAreaName());
			map.put("buildName", build.getBuildName());
			
			confirmReportList.add(map);
		}
		
		return "confirmProperty";
	}
	
	private ConfirmCond initCond(ConfirmCond cond){
		
		if(cond == null){
			cond = new ConfirmCond();
		}
		
		if(!CommonUtils.isStrZeroEmpty(cond.getPropertyId()) && CommonUtils.isStrEmpty(cond.getPropertyName())){
			//从公司认购单跳转过来的
			PropertyProject project = projectServices.findPropertyProjectById(Integer.parseInt(cond.getPropertyId()));
			cond.setPropertyName(project.getPropertyName());
		}
		
		return cond;
	
	}
	
	////
	
	private ConfirmCond cond;
	private List<Map<String, Object>> confirmReportList;

	public ConfirmCond getCond() {
		return cond;
	}
	
	public void setCond(ConfirmCond cond) {
		this.cond = cond;
	}
	
	public List<Map<String, Object>> getConfirmReportList() {
		return confirmReportList;
	}
	
	public void setConfirmReportList(List<Map<String, Object>> confirmReportList) {
		this.confirmReportList = confirmReportList;
	}
	
	
	
}
