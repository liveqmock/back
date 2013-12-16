package com.ihk.customer.data.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * CustomerLog的查询条件
 * @author 
 *
 */
public class CustomerLogCond extends SearchCond{

	private String customerId;	
    
	public String getSearchName() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
