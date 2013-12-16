package com.ihk.report.data.pojo.precustomer;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 售前客户数：公司
 * @author 
 *
 */
public class ReportPreCustomerCompany implements Serializable{
	private static final long serialVersionUID = 1L;


	private int companyId;	//公司id
	private String companyName;	//公司名称
	private int sumCount;	//汇总客户数


	/**
	 * 公司id
	 * @return
	 */
	public int getCompanyId() {
		return companyId;
	}
	/**
	 * 公司id
	 * @param companyId
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	/**
	 * 公司名称
	 * @return
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 公司名称
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
