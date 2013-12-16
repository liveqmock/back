package com.ihk.junit.import_cus.hubei.en;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.junit.SupperJunit;
import com.ihk.junit.import_cus.hubei.stl.LeadingInUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;

/**
 * 4.恩施硒都茶城来电
 * @author dtc
 * 2013-8-16,下午02:23:09
 */
public class ImportEnLaiDianCustomer extends SupperJunit {
	
	final ICustomerServices customerServices = 
		(ICustomerServices) factory.getBean("customerServices");
	
	@Test
	public void _import() throws Exception {
		
		new MyTransationTemplate() {
			
			@Override
			protected void doExecuteCallback() throws Exception {
				
				List<Customer> list = getEnLaiDianCustomer();
				
				for(Customer cus : list){
					
					try{
						customerServices.saveCustomer(cus);
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				
			}
		}.doExecuteCallback();
	
	}
	
	private List<Customer> getEnLaiDianCustomer(){
		
		List<Customer> list = new ArrayList<Customer>();
		
		List<String> strList = LeadingInUtils.realXls("c:\\4.xls");
		
		Customer customer = null;
		
		for(String str : strList){
			
			customer = stringToBean(str);
			
			if(customer != null){
				
				list.add(customer);
			}
			
			
		}
		
		return list;
	}

	private Customer stringToBean(String str){
		
		try{
		
			if(CommonUtils.isStrEmpty(str)){
				
				return null;
			}
			
			Customer customer = new Customer();
			
			String[] fields = str.split("\\|");
			
			customer.setVisitDate(LeadingInUtils.changeVisitDate(fields[0]));
			customer.setCustomerName(fields[1]);
			customer.setPhone(getPhone(fields[2]));
			customer.setRemark1(fields[3]);
			
			customer.setCustomerNo(CustomerUtils.getTmpCustomerNo());
			
			customer.setHomeProvince(17); //居住省
			customer.setHomeCity(169); //居住市
			
			customer.setCompanyId(29);
			customer.setProjectId(216); //
			
			customer.setTeamId(0);
			customer.setUserId(2400);
			
			customer.setManagerId(2400);
			customer.setCustomerSource("1"); //客户来源,来电
			
			customer.setIsDeleted(CommonUtils.NORMAL);
			customer.setCreatedId(2400);
			customer.setCreatedTime(new Date());
			customer.setModId(2400);
			customer.setModTime(new Date());
			
			return customer;
			
		}catch (Exception e) {
			return null;
		}
	}
	
	private static String getPhone(String oldPhone){
		
		if(CommonUtils.isStrEmpty(oldPhone)){
			return "";
		}
		
		if(oldPhone.contains("-")){
			oldPhone = oldPhone.replace("-", "");
		}
		
		return oldPhone;
	}
	
}
		
		