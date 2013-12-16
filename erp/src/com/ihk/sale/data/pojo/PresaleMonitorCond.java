package com.ihk.sale.data.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * PresaleMonitorCond的查询条件
 * @author peter.kuang
 *
 */
public class PresaleMonitorCond extends SearchCond{

	public String monitorDate;
	public String projectId ;
	
	
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String preojectId) {
		this.projectId = preojectId;
	}

	public String getMonitorDate() {
		return monitorDate;
	}

	public void setMonitorDate(String monitorDate) {
		this.monitorDate = monitorDate;
	}	
	
}
