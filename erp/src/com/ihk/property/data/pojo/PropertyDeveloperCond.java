package com.ihk.property.data.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * PropertyDeveloperCond的查询条件
 * @author peter.kuang
 *
 */
public class PropertyDeveloperCond extends SearchCond{

	private String developerName;	
    private String searchName;
    private int companyProjectId;
    
	
	
	public int getCompanyProjectId() {
		return companyProjectId;
	}



	public void setCompanyProjectId(int companyProjectId) {
		this.companyProjectId = companyProjectId;
	}



	public String getSearchName() {
		return searchName;
	}



	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}



	public String getDeveloperName() {
		return developerName;
	}



	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}
}
