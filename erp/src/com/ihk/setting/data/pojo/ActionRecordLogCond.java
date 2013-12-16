package com.ihk.setting.data.pojo;

import com.ihk.utils.DescUtils;
import com.ihk.utils.SearchCond;

public class ActionRecordLogCond extends SearchCond{
	private static final long serialVersionUID = 4497323344854218680L;
	
	private String logType;
	private String searchName;
	private String projectId;
	private String date1;
	private String date2;
	private String userId;
	private String projectName;

	private String userName;

	public String getProjectName() {
		try {
			if (!(projectId == null || projectId.trim().equals("") || projectId
					.trim().equals("0"))) {
				return DescUtils.getCompanyProjectRealName(Integer
						.parseInt(this.projectId));
			}
		} catch (Exception e) {

		}
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getProjectId() {
		if (projectId!=null&&projectId.trim().equals("0"))
			return "";
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
