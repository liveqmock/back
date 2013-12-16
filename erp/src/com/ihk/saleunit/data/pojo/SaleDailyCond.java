package com.ihk.saleunit.data.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * SaleDaily的查询条件
 * @author peter.kuang
 *
 */
public class SaleDailyCond extends SearchCond{
	private static final long serialVersionUID = 1L;

	private String saleDate;	
	private String propertyName; //项目名称	
	private String propertyId;
	private String date1;
	
	private String date2;
    
	public String getSearchName() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public String getPropertyName() {
		return propertyName;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}
}
