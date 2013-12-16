package com.ihk.customer.collection.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * VipCustFollow的查询条件
 * @author 
 *
 */
public class VipCustFollowCond extends SearchCond{

	private static final long serialVersionUID = 1L;
    
	private int refId;

	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}
	
    /*
	private String followType;	
    
	public String getSearchName() {
		return followType;
	}

	public void setFollowType(String followType) {
		this.followType = followType;
	}
    */
}
