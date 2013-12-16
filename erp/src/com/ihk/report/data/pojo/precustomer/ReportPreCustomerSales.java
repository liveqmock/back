package com.ihk.report.data.pojo.precustomer;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 售前客户数：销售
 * @author 
 *
 */
public class ReportPreCustomerSales implements Serializable{
	private static final long serialVersionUID = 1L;


	private int salesId;	//销售id
	private String salesName;	//销售名称
	private int sumCount;	//汇总客户数

	
	
	
	public int getSalesId() {
		return salesId;
	}
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
	public String getSalesName() {
		return salesName;
	}
	public void setSalesName(String salesName) {
		this.salesName = salesName;
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
