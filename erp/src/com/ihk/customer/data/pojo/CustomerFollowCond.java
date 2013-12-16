package com.ihk.customer.data.pojo;

import java.util.ArrayList;
import java.util.List;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.CompanyProjectPermissionCond;
import com.ihk.permission.PermissionUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SearchCond;
import com.ihk.utils.SessionUser;

/**
 * CustomerFollow的查询条件
 * @author 
 *
 */
public class CustomerFollowCond extends CompanyProjectPermissionCond{

	private static final long serialVersionUID = 1L;

	private String customerId;	

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	private String projectId; 
	
	private List<Integer> projectIds;

	private String date1;
	
	private String date2;

	private String followUserId;	
	
	/**
	 * 追加字段:<br/>
	 * 跟进的类型
	 */
	private String followType;
	
	private String companyId;
	

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	public String getFollowType() {
		return followType;
	}

	public void setFollowType(String followType) {
		this.followType = followType;
	}

	public String getProjectId() {
		return projectId;
	}	
	
	public void setProjectIds(List<Integer> projectIds) {
		this.projectIds = projectIds;
	}
	
	public List<Integer> getProjectIds() {
		return projectIds;
	}

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

	public String getFollowUserId() {
		return followUserId;
	}

	public void setFollowUserId(String followUserId) {
		this.followUserId = followUserId;
	}

}
