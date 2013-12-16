package com.ihk.property.data.pojo;

import com.ihk.utils.SearchCond;
import java.util.List;

/**
 * PropertyPrivCond的查询条件
 * @author peter.kuang
 *
 */
public class PropertyProjectCond extends SearchCond{

	private static final long serialVersionUID = 1L;
	
	private String propertyName;	
    private String searchName;
    private List<Integer> ids;
    private int companyProjectId;
    private List<Integer> companyProjectIds;
    
    
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public int getCompanyProjectId() {
		return companyProjectId;
	}
	public void setCompanyProjectId(int companyProjectId) {
		this.companyProjectId = companyProjectId;
	}
	public List<Integer> getCompanyProjectIds() {
		return companyProjectIds;
	}
	public void setCompanyProjectIds(List<Integer> companyProjectIds) {
		this.companyProjectIds = companyProjectIds;
	}
	
	
    
	
	
}
