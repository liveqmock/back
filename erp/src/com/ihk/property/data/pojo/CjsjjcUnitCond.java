package com.ihk.property.data.pojo;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.SearchCond;

/**
 * 成交数据交叉报表
 * @author dtc
 * 2013-3-13,上午11:24:18
 */
public class CjsjjcUnitCond extends SearchCond{

	private static final long serialVersionUID = 1L;
	
	private String reportName;
	
	private String selectField;
	
	private int companyProjectId;

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getSelectField() {
		
		if(CommonUtils.isStrEmpty(selectField)){
			
			if("CJSJJC_LC".equals(reportName)){
				
				selectField = "floor_num";
			}else if("CJSJJC_FH".equals(reportName)){
				
				selectField = "room_no";
			}else if("CJSJJC_LCx".equals(reportName)){
				
				selectField = "build_id";
			}
		}
		
		return selectField;
	}

	public void setSelectField(String selectField) {
		this.selectField = selectField;
	}

	public int getCompanyProjectId() {
		return companyProjectId;
	}

	public void setCompanyProjectId(int companyProjectId) {
		this.companyProjectId = companyProjectId;
	}
	
}
