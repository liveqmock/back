package com.ihk.junit.import_cus.hubei.th;

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
 * 5.天鸿美庐来访_08前.xls
 * @author dtc
 * 2013-8-19,下午05:51:03
 */
public class ImportThLaiFan08Customer extends SupperJunit {
	
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
		}.execute();
	
	}
	
	private List<Customer> getEnLaiDianCustomer(){
		
		List<Customer> list = new ArrayList<Customer>();
		
		List<String> strList = LeadingInUtils.realXls("c:\\5.xls");
		
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
			
			try{
				customer.setVisitDate(fields[0]);
			}catch (Exception e) {
				customer.setVisitDate("");
			}
			
			try{
				customer.setCustomerName(fields[1]);
			}catch (Exception e) {
				customer.setCustomerName("无");
			}
			
			try{
				customer.setPhone(getPhone(fields[2]));
			}catch (Exception e) {
				customer.setPhone("");
			}
			
			try{
				customer.setGender(getGender(fields[3]));
			}catch (Exception e) {
				customer.setGender("");
			}
			
			customer.setCustomerNo(CustomerUtils.getTmpCustomerNo());
			
			customer.setHomeProvince(17); //居住省
			customer.setHomeCity(169); //居住市
			try{
				customer.setHomeContent(fields[4]); //居住内容
			}catch (Exception e) {
				customer.setHomeContent("");
			}
			
			customer.setWorkProvince(17); //工作省
			customer.setWorkCity(169); //工作市
			try{
				customer.setWorkContent(fields[5]); //工作内容
			}catch (Exception e) {
				customer.setWorkContent("");
			}
			
			try{
				customer.setRemark1(fields[6]); //备注
			}catch (Exception e) {
				customer.setRemark1("");
			}
			
			customer.setCompanyId(29);
			customer.setProjectId(187); //
			
			customer.setTeamId(0);
			customer.setUserId(2400);
			
			customer.setManagerId(2400);
			customer.setCustomerSource("2"); //客户来源,来访
			
			customer.setIsDeleted(CommonUtils.NORMAL);
			customer.setCreatedId(2400);
			customer.setCreatedTime(new Date());
			customer.setModId(2400);
			customer.setModTime(new Date());
			
			return customer;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static String getPhone(String oldPhone){
		
		if(CommonUtils.isStrEmpty(oldPhone)){
			return "";
		}
		
		oldPhone = oldPhone.trim();
		
		if(oldPhone.contains("-")){
			oldPhone = oldPhone.replace("-", "");
		}
		
		return oldPhone;
	}
	
	private static String getGender(String val){
		
		if(CommonUtils.isStrEmpty(val)){
			return "";
		}
		
		if("男".equals(val)){
			
			return "1";
		}else if("女".equals(val)){
			
			return "0";
		}
		
		return "";
	}
	
}