package com.ihk.report.data.pojo.precustomer;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 售前客户数：销售人员
 * @author 
 *
 */
public class ReportPreCustomerSalesman implements Serializable{
	private static final long serialVersionUID = 1L;


	private int salesmanId;	//销售人员id
	private String salesmanName;	//销售人员名称
	private String projectName;	//项目名称
	private int sumCount;	//汇总客户数


	/**
	 * 销售人员id
	 * @return
	 */
	public int getSalesmanId() {
		return salesmanId;
	}
	/**
	 * 销售人员id
	 * @param salesmanId
	 */
	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}

	/**
	 * 销售人员名称
	 * @return
	 */
	public String getSalesmanName() {
		return salesmanName;
	}
	/**
	 * 销售人员名称
	 * @param salesmanName
	 */
	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	/**
	 * 项目名称
	 * @return
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 项目名称
	 * @param projectName
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
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
