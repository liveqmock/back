package com.ihk.saleunit.action.new_report.cond;

import java.util.List;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.SearchCond;

/**
 * 中山客户情况分析cond
 * @author dtc
 * 2013-9-3,下午03:27:41
 */
public class ZsCustomerAnalysisCond extends SearchCond{

	private static final long serialVersionUID = 3278166535061781861L;
	
	/**
	 * ,相连的项目id
	 */
	private String projectId; 
	
	/**
	 * 开始日期
	 */
	private String date1;
	
	/**
	 * 结束日期
	 */
	private String date2;
	
	/**
	 * 来访或来电
	 */
	private String type;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * 根据请求参数项目id,转成对应的id list
	 * @return
	 */
	public List<Integer> getCompanyProjectIds(){
		
		if(CommonUtils.isStrEmpty(projectId)){
			return null;
		}
		
		return CommonUtils.stringToList(projectId);
		
	}
	
}
