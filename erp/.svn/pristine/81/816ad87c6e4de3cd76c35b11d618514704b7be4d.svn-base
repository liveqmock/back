package com.ihk.sale.data.pojo;


import java.util.ArrayList;
import java.util.List;

import com.ihk.permission.PermissionUtils;
import com.ihk.utils.SearchCond;

/**
 * SaleMonitor的查询条件
 */
public class SaleMonitorCond extends SearchCond{

	private static final long serialVersionUID = 1L;

	private String date1;
	
	private String date2;
	
	private String monitorDate; //供查总数的时候使用
	
	private int projectId; //判断该日期该project id是否存在的时候使用(增加或者更新)
	
	private String companyId; //查询公司的所有项目
	
	private List<Integer> projectIds;  //project id, 普通的操作人员为1个, 而管理员为其所能管理的project

	private List<Integer> permissionProjectIds;  //能查看的项目

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}
	
	public void setMonitorDate(String monitorDate) {
		this.monitorDate = monitorDate;
	}
	
	public String getMonitorDate() {
		return monitorDate;
	}
	
	public void setProjectIds(List<Integer> projectIds) {
		this.projectIds = projectIds;
	}
	
	public List<Integer> getProjectIds() {
		return projectIds;
	}	
	
	public List<Integer> getPermissionProjectIds() {
		return permissionProjectIds;
	}

	public void setPermissionProjectIds(List<Integer> permissionProjectIds) {
		this.permissionProjectIds = permissionProjectIds;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public int getProjectId() {
		return projectId;
	}
	
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	//跟进权限，追加能查看的项目id
	public void addPermissionProjectIds(){
		List<Integer> listIds = PermissionUtils.getUserProjectIdList();
		if(permissionProjectIds==null){
			permissionProjectIds = new ArrayList(); 
		}
		for(int i=0;i<listIds.size();i++){
			if(!this.permissionProjectIds.contains(listIds.get(i))){
				this.permissionProjectIds.add(listIds.get(i));
			}
		}
	}
	
}
