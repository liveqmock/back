package com.ihk.quartz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.phone.PhoneUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 手机归属地定时器
 * @author dtc
 * 2013-7-4,上午10:23:47
 */
public class CustomerPhoneFromQuartz {
	
	/**
	 * 设置当天录入或修改的售前客户的手机归属地
	 */
	@SuppressWarnings("deprecation")
	public void setUpCustomerPhoneFrom(){
		
		ICustomerServices customerServices = MyPropertyUtils.getCustomerServices();
		
		List<Customer> list = customerServices.findThisDayModCustomer();
		
		if(CommonUtils.isCollectionEmpty(list))
			return ;
		
		list = PhoneUtils.postPhoneForcha14(list);
		
		Map<String, String> map = null;
		
		for(Customer cus : list){
			
			map = new HashMap<String, String>();
			
			map.put("id", cus.getId() + "");
			map.put("phoneFrom", cus.getPhoneFrom());

			try{
				customerServices.updateCustomerPhoneFrom(map);
			}catch (Exception e) {
			}
			
		}
		
	}

}
