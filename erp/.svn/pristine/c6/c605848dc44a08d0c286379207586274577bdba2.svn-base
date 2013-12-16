package com.ihk.sale.action.guangzhou;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.CustomerRed;
import com.ihk.customer.data.pojo.CustomerRedCond;
import com.ihk.customer.data.services.ICustomerRedServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;


/**
 * 查找项目标红情况
 */
public class searchCustomerRedAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired ICustomerRedServices iCustomerRedServices;
	
	private List<CustomerRed> custredList; 
	private CustomerRedCond custRedCond;
	private String projectName;
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**查询所有cust red*/
	public String listIndex(){
		List<Integer> prlist = PermissionUtils.getUserProjectIdList(EnumPrivCode.SYSTEM_USER_CREATE);
		if(prlist == null || prlist.size() == 0){
			addActionMessage("没有权限");
			return "search";
		}
		custRedCond = new CustomerRedCond();
		custRedCond.setProjectIds(prlist);
		this.custredList = iCustomerRedServices.findCustomerRed(custRedCond);
		return "search";
	}
	/**提交表单*/
	public String listSearch(){
		List<Integer> prlist = PermissionUtils.getUserProjectIdList(EnumPrivCode.SYSTEM_USER_CREATE);
		if(prlist == null || prlist.size() == 0){
			addActionMessage("没有权限");
			return "search";
		}
		if(custRedCond == null){
			custRedCond = new CustomerRedCond();
		}else if(!custRedCond.getProjectId().equals("") || !custRedCond.getProjectId().equals("0")){
			boolean ti = true;
			for(Integer i : prlist){
				if(i.toString() .equals(custRedCond.getProjectId()))ti = false;
			}
			if(ti){
				addActionMessage("没有权限");
				return "search";
			}
			this.custredList = iCustomerRedServices.findCustomerRed(custRedCond);
			return "search";
		}
		custRedCond.setProjectIds(prlist);
		this.custredList = iCustomerRedServices.findCustomerRed(custRedCond);
		return "search";
	}
	
	
	public List<CustomerRed> getCustredList() {
		return custredList;
	}

	public void setCustredList(List<CustomerRed> custredList) {
		this.custredList = custredList;
	}
	public CustomerRedCond getCustRedCond() {
		return custRedCond;
	}
	public void setCustRedCond(CustomerRedCond custRedCond) {
		this.custRedCond = custRedCond;
	}
	
	
}
