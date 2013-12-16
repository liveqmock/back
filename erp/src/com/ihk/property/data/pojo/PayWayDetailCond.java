package com.ihk.property.data.pojo;


import com.ihk.utils.SearchCond;

/**
 * PayWayDetailCond的查询条件
 * @author peter.kuang
 *
 */
public class PayWayDetailCond extends SearchCond{

	private String wayId;	
    
	public String getSearchName() {
		return wayId;
	}

	public void setWayId(String wayId) {
		this.wayId = wayId;
	}
}
