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
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;

/**
 *  楼盘合同单报表分析
 */
public class GuangZhouContractPropertyAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IContractServices contractServices;
	@Autowired
	IPropertyBuildServices buildServices;
	@Autowired
	IPropertyAreaServices areaServices;
	@Autowired
	IPropertyProjectServices projectServices;

	
	public String contractProperty() throws Exception{
		
		cond = initCond(cond);
		
		List<Map<String, Object>> tmpMap = contractServices.findPropertyReport(cond);
		contractReportList = new ArrayList<Map<String,Object>>();
		
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
			
			contractReportList.add(map);
		}
		
		return "contractProperty";
	}
	
	private ContractCond initCond(ContractCond cond){
		
		if(cond == null){
			cond = new ContractCond();
		}
		
		if(!CommonUtils.isStrZeroEmpty(cond.getPropertyId()) && CommonUtils.isStrEmpty(cond.getPropertyName())){
			//从公司合同单跳转过来的
			PropertyProject project = projectServices.findPropertyProjectById(Integer.parseInt(cond.getPropertyId()));
			cond.setPropertyName(project.getPropertyName());
		}
		
		return cond;
	
	}
	
	////
	
	private ContractCond cond;
	private List<Map<String, Object>> contractReportList;

	public ContractCond getCond() {
		return cond;
	}

	public void setCond(ContractCond cond) {
		this.cond = cond;
	}

	public List<Map<String, Object>> getContractReportList() {
		return contractReportList;
	}

	public void setContractReportList(List<Map<String, Object>> contractReportList) {
		this.contractReportList = contractReportList;
	}

	
}
