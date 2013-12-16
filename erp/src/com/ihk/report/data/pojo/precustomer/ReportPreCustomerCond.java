package com.ihk.report.data.pojo.precustomer;

import com.ihk.report.data.pojo.ReportPermissionCond;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.SearchCond;

/**
 * 售前客户数,的查询条件
 * @author 
 *
 */
public class ReportPreCustomerCond extends ReportPermissionCond{

	private static final long serialVersionUID = 1L;

	private String endDate;	//截止日期
	private String date1;	//开始日期
	private String date2;	//结束日期



	/**
	 * 截止日期
	 * @return
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 截止日期
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
		setDate2(this.endDate);
	}

	/**
	 * 开始日期
	 * @return
	 */
	public String getDate1() {
		return date1;
	}
	/**
	 * 开始日期
	 * @param date1
	 */
	public void setDate1(String date1) {
		this.date1 = date1;
	}

	/**
	 * 结束日期
	 * @return
	 */
	public String getDate2() {
		return date2;
	}
	/**
	 * 结束日期
	 * @param date2
	 */
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	
	
	
}
