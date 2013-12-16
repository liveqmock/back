package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.util.List;

import com.ihk.utils.SearchCond;

/**
 * PropertyProjectPlan的查询条件
 * @author peter.kuang
 *
 */
public class PropertyProjectPlanCond extends SearchCond{

    /*
	private String planArea;	
    
	public String getSearchName() {
		return planArea;
	}

	public void setPlanArea(String planArea) {
		this.planArea = planArea;
	}
    */
	
	private static final long serialVersionUID = 1L;
	private String propertyId;
	
	private String planMonth;
	
	/**
	 * 页面查询的公司项目id
	 */
	private List<Integer> searchProjectIds;

	public List<Integer> getSearchProjectIds() {
		return searchProjectIds;
	}

	public void setSearchProjectIds(List<Integer> searchProjectIds) {
		this.searchProjectIds = searchProjectIds;
	}

	public String getPlanMonth() {
		return planMonth;
	}

	public void setPlanMonth(String planMonth) {
		this.planMonth = planMonth;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	
	
}
