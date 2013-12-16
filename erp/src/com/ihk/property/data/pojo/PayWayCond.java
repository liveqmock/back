package com.ihk.property.data.pojo;

import com.ihk.utils.SearchCond;

/**
 * PayWayCond的查询条件
 * @author peter.kuang
 *
 */
public class PayWayCond extends SearchCond{

	private static final long serialVersionUID = 1L;
	
	private int buildId;	
    private String payType;
    
    private int projectId;
    
    public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
    
    public int getProjectId() {
		return projectId;
	}
    
	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	
	
}
