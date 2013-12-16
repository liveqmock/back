package com.ihk.report.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.utils.SupperAction;

/**
 *  公司合同单报表分析
 */
public class GuangZhouContractAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IContractServices contractServices;
	@Autowired
	IPropertyProjectServices projectServices;

	public String contract() throws Exception{
		
		if(cond == null){
			cond = new ContractCond();
		}
		
		List<Map<String, Object>> tmpMap = contractServices.findCompanyReport(cond);
		contractReportList = new ArrayList<Map<String,Object>>();
		
		//放在循环外面可以减少变量个数
		PropertyProject project = null;
		
		for(Map<String, Object> map : tmpMap){
			
			Integer propertyId = (Integer) map.get("pId");
			project = projectServices.findPropertyProjectById(propertyId);
			
			map.put("propertyName", project.getPropertyName());
			
			contractReportList.add(map);
		}
		
		return "contract";
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
	
	public void setContractReportList(
			List<Map<String, Object>> contractReportList) {
		this.contractReportList = contractReportList;
	}
	
	public List<Map<String, Object>> getContractReportList() {
		return contractReportList;
	}
	
	
}
