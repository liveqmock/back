package com.ihk.customer.data.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * CustomerFocus的查询条件
 * @author 
 *
 */
public class CustomerFocusCond extends SearchCond{

	private String customerId;	
    
	public String getSearchName() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
