package com.ihk.report.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.utils.SupperAction;

/**
 *  公司认购单报表分析
 */
public class GuangZhouConfirmAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IPropertyProjectServices projectServices;
	
	public String confirm() throws Exception{
		
		if(cond == null){
			cond = new ConfirmCond();
		}
		
		List<Map<String, Object>> tmpMap = confirmServices.findCompanyReport(cond);
		confirmReportList = new ArrayList<Map<String,Object>>();
		
		//放在循环外面可以减少变量个数
		PropertyProject project = null;
		
		for(Map<String, Object> map : tmpMap){
			
			Integer propertyId = (Integer) map.get("pId");
			project = projectServices.findPropertyProjectById(propertyId);
			
			map.put("propertyName", project.getPropertyName());
			
			confirmReportList.add(map);
		}
		
		return "confirm";
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
