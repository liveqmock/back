package com.ihk.user.data.pojo;

import java.util.List;

import com.ihk.permission.CompanyProjectPermissionCond;

/**
 * UserAccount的查询条件
 * @author peter.kuang
 */
public class UserAccountCond extends CompanyProjectPermissionCond{

	private static final long serialVersionUID = -8276814508812049693L;
	
	private String userName;	
	private String realName;
	private String orderByFiled;
	
	private String date1;
	private String date2;
	
	private int proId;
	private String projectId;
	private List<Integer> projectIds;
	
	private String roleId;
	private String userRoleProjectId;
	private String projectName;

	private int companyId;  //查找广州用户的时候使用findGuangZhouUser
	
	/**
	 * 默认为0表示只查找正常的账号,设置为-1表示不使用该条件,查找所有,设置为1查找删除
	 */
	private int isDeleted=0;
	
	/**
	 * 工号
	 */
	private String jobNumber;
	
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	
	public String getJobNumber() {
		return jobNumber;
	}
	
	public void setSearchInclueDeleted(){
		setIsDeleted(-1);
	}
	
	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getDate1() {
		return date1;
	}


	public void setDate1(String date1) {
		this.date1 = date1.trim();
	}


	public String getDate2() {
		return date2;
	}


	public void setDate2(String date2) {
		this.date2 = date2.trim();
	}





	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName.trim();
	}


	

	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId.trim();
	}


	public String getUserRoleProjectId() {
		return userRoleProjectId;
	}


	public void setUserRoleProjectId(String userRoleProjectId) {
		this.userRoleProjectId = userRoleProjectId.trim();
	}


	public String getProjectId() {
		return projectId;
	}


	public void setProjectId(String projectId) {
		this.projectId = projectId.trim();
	}


	public List<Integer> getProjectIds() {
		return projectIds;
	}


	public void setProjectIds(List<Integer> projectIds) {
		this.projectIds = projectIds;
	}


	public int getProId() {
		return proId;
	}


	public void setProId(int proId) {
		this.proId = proId;
	}
	
	public void setProId(String proId) {
		this.proId = Integer.parseInt(proId.trim());
	}	
	
	public String getOrderByFiled() {
		return orderByFiled;
	}


	public void setOrderByFiled(String orderByFiled) {
		this.orderByFiled = orderByFiled;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
