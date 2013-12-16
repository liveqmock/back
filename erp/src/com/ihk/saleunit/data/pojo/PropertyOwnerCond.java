package com.ihk.saleunit.data.pojo;

import com.ihk.utils.SearchCond;

/**
 *  权益人的查询条件
 */
public class PropertyOwnerCond extends SearchCond{

	private static final long serialVersionUID = 1L;
	
	private String confirmType;	
	
	private String mainId;

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}
	
	public String getMainId() {
		return mainId;
	}
	
	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
	
	public String getConfirmType() {
		return confirmType;
	}
}
