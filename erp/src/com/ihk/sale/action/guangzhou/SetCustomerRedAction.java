package com.ihk.sale.action.guangzhou;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.CustomerRed;
import com.ihk.customer.data.pojo.CustomerRedCond;
import com.ihk.customer.data.services.ICustomerRedServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.UserAccountCond;
import com.ihk.utils.DescUtils;
import com.ihk.utils.GuangZhouUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;


/**
 * 设置客户录入标红
 */
public class SetCustomerRedAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired ICustomerRedServices iCustomerRedServices;
	
	private String projectId;
	private CustomerRed customerRed;
	private List<CompanyProject> projectList;
	private String tip;
	private String projectName;
	private String RES = "set"; 
	
	/**跳转到cus red 页面*/
	public String index(){
//		this.setTip("index");
		initCompanyProject();
		//拥有管理权限的项目的列表 下拉框
		return RES;
	}
	
	/**查询项目之后的跳转*/
	public String searchProject(){
		//传入projectId
		List<Integer> prlist = PermissionUtils.getUserProjectIdList(EnumPrivCode.SYSTEM_USER_CREATE);
		if(prlist == null || prlist.size() == 0){
			addActionMessage("没有管理用户权限");
			return RES;
		}
		boolean ti = true;
		for(Integer i :prlist){
			if(i.toString().equals(this.projectId)){
				ti = false;
			}
		}
		if(ti){
			addActionMessage("没有管理权限");
			return RES;
		}
	
		try {
			initCustomerRed(Integer.parseInt(this.projectId));
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError("项目错误");
		}
		this.projectName = DescUtils.getCompanyProjectRealName(Integer.parseInt(this.projectId));
//		initCompanyProject();
		//需要查询到该项目的customer red 的资料 如果没有 给一个全不是必选的
		//保存查询项目的ID
		return RES;
	}
	
	/**保存*/
	public String saveCustomerRed(){
		initCompanyProject();
		
		if(this.projectId == null || this.projectId.equals("")){
			addActionError("项目错误");
			return RES;
		}
		if(customerRed == null){
			customerRed = new CustomerRed();
		}
		this.customerRed.setProjectId(Integer.parseInt(projectId));
		CustomerRed temp = this.iCustomerRedServices.findCustomerRedByProjectId(Integer.parseInt(this.projectId));
		if(temp != null){
			this.customerRed.setCreatedId(temp.getCreatedId());
			this.customerRed.setCreatedTime(temp.getCreatedTime());
			this.customerRed.setModId(SessionUser.getUserId());
			this.customerRed.setModTime(new Date());
			this.customerRed.setId(temp.getId());
			this.customerRed.setIsDeleted(temp.getIsDeleted());
			this.iCustomerRedServices.updateCustomerRed(this.customerRed);//update
		}else{
			this.customerRed.setCreatedId(SessionUser.getUserId());
			this.customerRed.setCreatedTime(new Date());
			this.customerRed.setModId(SessionUser.getUserId());
			this.customerRed.setModTime(this.customerRed.getCreatedTime());
			this.customerRed.setIsDeleted("0");
			this.iCustomerRedServices.addCustomerRed(this.customerRed);//add
		}
		addActionError("保存成功");
		this.projectName = DescUtils.getCompanyProjectRealName(Integer.parseInt(this.projectId));
		return RES;
	}
	
	//得到项目列表 应为 本用户所拥有的广州项目管理权限列表
	private void initCompanyProject(){
		projectList = GuangZhouUtils.getGuangZhouCompanyProject();
	}
	
	//查询projectId 的customer _ red 表的数据 如果没有  全部不是必选
	private void initCustomerRed(int PID){
		this.customerRed = this.iCustomerRedServices.findCustomerRedByProjectId(PID);
	}
	
	
	/**********************************************************/
	
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public CustomerRed getCustomerRed() {
		return customerRed;
	}

	public void setCustomerRed(CustomerRed customerRed) {
		this.customerRed = customerRed;
	}

	public List<CompanyProject> getProjectList() {
		return projectList;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
}
