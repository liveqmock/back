package com.ihk.customer.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.utils.SupperAction;
import com.ihk.utils.base.MySqlSessionFactory;

/**
 * 客户电话归属地action
 * @author dtc
 * 2012-9-10
 */
public class CustomerPhoneFromAction extends SupperAction{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	ICustomerServices customerServices;
	
	public String to() throws Exception{
		
		
		return "to";
	}
	
	public String getCustomerBySql() throws Exception{
		
		Connection conn = MySqlSessionFactory.newConnectionInstance();
		
		message = conn.toString();
		
		String sql = request.getParameter("sql");
		sql = sql.replace("\r\n", " ").toLowerCase();
		
		ResultSet set = conn.createStatement().executeQuery(sql);
		
		while(set.next()){
			System.out.println(set.getRow());
		}
		
		set.close();
		conn.close();
		
		//customerList = customerServices.findCustomerListBySql(sql);
		
		return "getCustomerBySql";
	}
	
	/**
	 * 根据sql设置查询结果中customer的电话归属地
	 * @return
	 * @throws Exception
	 */
	public String updatePhoneFromBySql() throws Exception{
		
		
		return "updatePhoneFromBySql";
	}
	
	
	////
	private List<Customer> customerList;
	
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	
	public List<Customer> getCustomerList() {
		return customerList;
	}
	
	

}
