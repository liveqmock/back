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
import com.ihk.saleunit.data.pojo.AppointCond;
import com.ihk.saleunit.data.services.IAppointServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;

/**
 * 楼盘预约单报表分析
 */
public class GuangZhouAppointPropertyAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IAppointServices appointServices;
	@Autowired
	IPropertyBuildServices buildServices;
	@Autowired
	IPropertyAreaServices areaServices;
	@Autowired
	IPropertyProjectServices projectServices;

	public String appointProperty() throws Exception{
		
		cond = initCond(cond);
		
		List<Map<String, Object>> tmpMap = appointServices.findPropertyReport(cond);
		propertyReportList = new ArrayList<Map<String,Object>>();
		
		//三者放在循环外面可以减少变量个数
		PropertyBuild build = null;
		PropertyArea area = null;
		PropertyProject project = null;
		
		for(Map<String, Object> map : tmpMap){
			
			Integer buildId = (Integer) map.get("bId");
			build = buildServices.findPropertyBuildById(buildId);
			area = areaServices.findPropertyAreaById(build.getAreaId());
			project = projectServices.findPropertyProjectById(build.getPropertyId());
			
			map.put("aId", area.getId());
			map.put("areaName", area.getAreaName());
			map.put("pId", project.getId());
			map.put("propertyName", project.getPropertyName());
			
			propertyReportList.add(map);
		}
		
		return "appointProperty";
	}
	
	private AppointCond initCond(AppointCond cond){
		
		if(cond == null){
			cond = new AppointCond();
		}
		
		if(!CommonUtils.isStrZeroEmpty(cond.getPropertyId()) && CommonUtils.isStrEmpty(cond.getPropertyName())){
			//从公司预约单跳转过来的
			PropertyProject project = projectServices.findPropertyProjectById(Integer.parseInt(cond.getPropertyId()));
			cond.setPropertyName(project.getPropertyName());
		}
		
		return cond;
	
	}
	
	////
	private AppointCond cond;

	private List<Map<String, Object>> propertyReportList;
	
	public void setPropertyReportList(
			List<Map<String, Object>> propertyReportList) {
		this.propertyReportList = propertyReportList;
	}
	
	public List<Map<String, Object>> getPropertyReportList() {
		return propertyReportList;
	}
	
	public void setCond(AppointCond cond) {
		this.cond = cond;
	}
	
	public AppointCond getCond() {
		return cond;
	}
	
	
}
