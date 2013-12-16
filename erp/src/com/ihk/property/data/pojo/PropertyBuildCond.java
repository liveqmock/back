package com.ihk.property.data.pojo;

import java.util.List;

import com.ihk.utils.SearchCond;

/**
 * PropertyBuildCond的查询条件
 * @author peter.kuang
 *
 */
public class PropertyBuildCond extends SearchCond{

	private static final long serialVersionUID = 1L;
	
    private String searchName;
    
    private String propertyId;
    private String propertyName;
    
    private String areaId;
    private String areaName;
    
    private String buildName;
    private String buildId;
    private int companyProjectId;
    
    private List<Integer> buildIds;
    
    private List<Integer> companyProjectIds;
    
    
    public int getCompanyProjectId() {
		return companyProjectId;
	}

	public void setCompanyProjectId(int companyProjectId) {
		this.companyProjectId = companyProjectId;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public List<Integer> getBuildIds() {
		return buildIds;
	}
    
    public void setBuildIds(List<Integer> buildIds) {
		this.buildIds = buildIds;
	}
    
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public String getBuildId() {
		return buildId;
	}
	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}
	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	
	public String getSearchName() {
		return searchName;
	}
	
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public List<Integer> getCompanyProjectIds() {
		return companyProjectIds;
	}

	public void setCompanyProjectIds(List<Integer> companyProjectIds) {
		this.companyProjectIds = companyProjectIds;
	}
	
    
    
}
