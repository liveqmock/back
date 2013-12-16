package com.ihk.saleunit.data.pojo;

import com.ihk.utils.SearchCond;

/**
 * AppointCustomer的查询条件
 */
public class AppointCustomerCond extends SearchCond{

	private static final long serialVersionUID = 1L;
	
	private String customerName;	
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerName() {
		return customerName;
	}
    
}
