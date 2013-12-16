package com.ihk.sale.data.pojo;


import com.ihk.utils.SearchCond;

/**
 * SaleMonitorLogbefore的查询条件
 */
public class SaleMonitorLogbeforeCond extends SearchCond{

	private static final long serialVersionUID = 1L;

	private int dateId;
	
	private String modTime;
	
	private String monitorDate;
	
	public void setMonitorDate(String monitorDate) {
		this.monitorDate = monitorDate;
	}
	
	public String getMonitorDate() {
		return monitorDate;
	}

	public int getDateId() {
		return dateId;
	}

	public void setDateId(int dateId) {
		this.dateId = dateId;
	}

	public String getModTime() {
		return modTime;
	}

	public void setModTime(String modTime) {
		this.modTime = modTime;
	}
	
	
}
