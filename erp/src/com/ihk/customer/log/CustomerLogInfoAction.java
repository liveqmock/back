package com.ihk.customer.log;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.data.pojo.CustomerLog;
import com.ihk.customer.data.services.ICustomerLogServices;
import com.ihk.utils.SupperAction;

/**
 * 查看CustomerLog的action
 * @author peter.kuang
 *
 */
public class CustomerLogInfoAction extends SupperAction{
	private static final long serialVersionUID = 1L;

	@Autowired ICustomerLogServices customerLogServices;
	
	private int customerLogId;
	private CustomerLog customerLog;
	
	public String logInfo(){
		this.init();
		return "index";
	}
	
	public void init(){
		this.customerLog = this.customerLogServices.findCustomerLogById(this.customerLogId);
		if(this.customerLog == null)this.customerLog = new CustomerLog();
	}

	public int getCustomerLogId() {
		return customerLogId;
	}

	public void setCustomerLogId(int customerLogId) {
		this.customerLogId = customerLogId;
	}

	public CustomerLog getCustomerLog() {
		return customerLog;
	}

	public void setCustomerLog(CustomerLog customerLog) {
		this.customerLog = customerLog;
	}
	
	
	
	
}
