package com.ihk.saleunit.action.new_report;

import java.util.LinkedHashMap;

import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;

/**
 * 报表:销售人员绩效
 * @author peter.kuang
 *
 */
public class XsryjxReportAction extends SupperAction{
	
	public String xsryjxReport() throws Exception{
		System.out.println(">>>>>>>>>>>>>>>>> xsryjxReport");
		return "suc";
	}
	
	
	// 下拉框(分析类型)
	private LinkedHashMap<String, String> listSelCategory;
	private CustomerCond customerCond;
	private String projectName;
	// 选中的分析类型
	private String selCategory;
	

	public LinkedHashMap<String, String> getListSelCategory() {
		if(listSelCategory==null){
			listSelCategory = CustomerUtils.getListSelCategory();
		}
		return listSelCategory;
	}

	public void setListSelCategory(LinkedHashMap<String, String> listSelCategory) {
		this.listSelCategory = listSelCategory;
	}

	public CustomerCond getCustomerCond() {
		return customerCond;
	}

	public void setCustomerCond(CustomerCond customerCond) {
		this.customerCond = customerCond;
	}

	public String getSelCategory() {
		return selCategory;
	}

	public void setSelCategory(String selCategory) {
		this.selCategory = selCategory;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
