package com.ihk.report.data.pojo.commission;

import com.ihk.report.data.pojo.ReportPermissionCond;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.SearchCond;

/**
 * 佣金,查询条件
 * @author 
 *
 */
public class ReportCommissionCond extends ReportPermissionCond{

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
		
		//取得日期所处月份的开始,结束日期
		setDate1(DateTimeUtils.getMonthFirstDayStr(endDate));
		setDate2(DateTimeUtils.getMonthLastDayStr(endDate));
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
