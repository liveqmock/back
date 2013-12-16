package com.ihk.report.data.pojo.precustomer;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 售前客户数：日期
 * @author 
 *
 */
public class ReportPreCustomerDate implements Serializable{
	private static final long serialVersionUID = 1L;


	private String reportDate;	//日期
	private int sumCount;	//汇总客户数


	/**
	 * 日期
	 * @return
	 */
	public String getReportDate() {
		return reportDate;
	}
	/**
	 * 日期
	 * @param reportDate
	 */
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	/**
	 * 汇总客户数
	 * @return the sumCount
	 */
	public int getSumCount() {
		return sumCount;
	}
	/**
	 * 汇总客户数
	 * @param sumCount the sumCount to set
	 */
	public void setSumCount(int sumCount) {
		this.sumCount = sumCount;
	}


	
    
}
