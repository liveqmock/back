package com.ihk.junit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.phone.PhoneUtils;

/**
 * 设置手机归属地
 * @author dtc
 * 2013-8-1,下午05:10:10
 */
public class CustomerPhoneFrom extends SupperJunit {
	
	@SuppressWarnings("deprecation")
	@Test
	public void setUpCustomerPhoneFrom() throws Exception{
		
		int pageSize = 50;
		
		CustomerCond cond = new CustomerCond();
		cond.pageSize = pageSize;
		
		final ICustomerServices customerServices = 
			(ICustomerServices) factory.getBean("customerServices");
		
		int size = customerServices.tmpCount();
		int count = size/pageSize; 
		
		for(int i=0; i<=count; i++){
			
			int startLine = i*pageSize;
			cond.startLine = startLine;
			
			List<Customer> allCustomer = customerServices.tmpList(cond);
			allCustomer = PhoneUtils.postPhoneForcha14(allCustomer);
			
			final List<Customer> tracList = allCustomer;
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					Map<String, String> map = new HashMap<String, String>();
					for(Customer cus : tracList){
						
						map.put("id", cus.getId() + "");
						map.put("phoneFrom", cus.getPhoneFrom());
						//System.out.println(cus.getId() + "\t" + cus.getPhoneComeFrom());
						
						customerServices.updateCustomerPhoneFrom(map);
						
					}
					
				}
			}.execute();
			
		}
		
	}

}
