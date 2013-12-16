package com.ihk.report.data.pojo.unitamount;

import com.ihk.report.data.pojo.ReportPermissionCond;
import com.ihk.utils.SearchCond;

/**
 * 总货量,公司的查询条件
 * @author 
 *
 */
public class ReportUnitAmountCompanyCond extends ReportPermissionCond{

	private static final long serialVersionUID = 1L;

	private int returnCount=5;	//返回的记录数(公司数,前几名),默认返回前5名
	private String endDate;	//推货日期


	/**
	 * 返回的记录数(公司数,前几名),默认返回前5名
	 * @return
	 */
	public int getReturnCount() {
		return returnCount;
	}
	/**
	 * 返回的记录数(公司数,前几名),默认返回前5名
	 * @param returnCount
	 */
	public void setReturnCount(int returnCount) {
		this.returnCount = returnCount;
	}

	/**
	 * 推货日期
	 * @return
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 推货日期
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	
	
}
