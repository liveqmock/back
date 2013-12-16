package com.ihk.utils.customer;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.exception.CustomerException;

/**
 * 同个项目号码不能重复
 * @author dtc
 * 2012-9-12
 */
public class PhoneUniqueUtils {

	/**
	 * 判断要新增或修改的号码是否重复,如果重复就抛出异常
	 * @param customer
	 */
	@SuppressWarnings("deprecation")
	public static void isPhoneRepeat(Customer customer) throws RuntimeException{
		
		if(customer.getId() > 0){
			//表示为修改
			
			Customer oldCus = DescUtils.getCustomerServices().getCustomerById(customer.getId());
			if(customer.getPhone()==null||customer.getPhone().equals(oldCus.getPhone())){
				//表示没有修改号码
				return;
			}
			
		}
		
		String phone = customer.getPhone(); //新的要增加或修改的号码
		
		if(CommonUtils.isStrEmpty(phone))
			return ;
				
		String projectId = customer.getProjectId() + "";
		
		if(DescUtils.isExistPhoneByProjectId(phone, projectId)){
			throw new CustomerException("该项目下,该号码已经存在来访客户,不能重复录入");
			
		}
		
	}

}
