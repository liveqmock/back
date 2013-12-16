package com.ihk.customer.data.pojo;


import com.ihk.utils.SearchCond;

/**
 * ProjectRange的查询条件
 * @author 
 *
 */
public class ProjectRangeCond extends SearchCond{

	private static final long serialVersionUID = 6895703339164862704L;
	private String companyId;	
    private String projectId;
	
    
	

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getSearchName() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}
