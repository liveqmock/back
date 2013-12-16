package com.ihk.report.data.pojo.precustomer;

import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.customer.data.pojo.Customer;

/**
 * 跨项目(电话)客户
 * @author 
 *
 */
public class ReportPreCustomerPhoneMulProject implements Serializable{
	private static final long serialVersionUID = 1L;


	private String phone;	//电话
	private int projectCount;	//项目数
	
	private List<Customer> customerList;//客户明细列表
	
	/**
	 * 电话
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * 电话
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * 项目数
	 * @return
	 */
	public int getProjectCount() {
		return projectCount;
	}
	
	/**
	 * 项目数
	 * @param projectCount
	 */
	public void setProjectCount(int projectCount) {
		this.projectCount = projectCount;
	}

	/**
	 * 客户明细列表
	 * @return
	 */
	public List<Customer> getCustomerList() {
		return customerList;
	}

	/**
	 * 客户明细列表
	 * @param customerList
	 */
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}




	
    
}
