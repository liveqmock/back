package com.ihk.customer.log;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.data.pojo.CustomerLog;
import com.ihk.customer.data.pojo.CustomerLogCond;
import com.ihk.customer.data.services.ICustomerLogServices;

/**
 * CustomerLog的action
 * @author peter.kuang
 *
 */
public class CustomerLogIndexAction {
	
	@Autowired ICustomerLogServices customerLogServices;
	
	private int customerId;//需要查看的客户信息
	
	private List<CustomerLog> customerLogList; 
	
	public String index(){
		this.initInfo();
		return "index";
	}

	private void initInfo(){
		if(customerId == 0)return ;
		CustomerLogCond cond = new CustomerLogCond();
		cond.setCustomerId(this.customerId+"");
		customerLogList = this.customerLogServices.findCustomerLog(cond);
		if(customerLogList == null)customerLogList = new ArrayList<CustomerLog>();
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<CustomerLog> getCustomerLogList() {
		return customerLogList;
	}

	public void setCustomerLogList(List<CustomerLog> customerLogList) {
		this.customerLogList = customerLogList;
	}
	
	
	
}
