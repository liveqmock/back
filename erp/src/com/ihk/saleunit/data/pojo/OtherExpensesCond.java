package com.ihk.saleunit.data.pojo;

import com.ihk.utils.SearchCond;

public class OtherExpensesCond extends SearchCond{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 楼盘项目id
	 */
	private int projectId;
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public int getProjectId() {
		return projectId;
	}

}
