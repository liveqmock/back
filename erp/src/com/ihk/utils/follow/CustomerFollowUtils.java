package com.ihk.utils.follow;

import java.util.Date;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerFollow;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 有关客户跟进的帮助类
 * @author dtc
 * 2013-11-19,下午04:58:24
 */
public class CustomerFollowUtils {
	
	/**
	 * 新增跟进的时候,对应的要修改的客户信息
	 * @param customerFollow
	 */
	public static void modifyCustomerForAddCutomerFollow(CustomerFollow customerFollow){
		
		ICustomerServices customerServices = MyPropertyUtils.getCustomerServices();
		
		Customer customer = customerServices.getCustomerById(customerFollow.getCustomerId());
		
		Integer visitCount = customer.getVisitCount();
		if(visitCount == null){
			visitCount = 0;
		}
		
		customer.setVisitCount(visitCount + 1);
		
		//最后跟进日期,判断该条跟进的跟进日期是否超过customer的follow_time,如果超过就update customer的follow_time
		Date oldFollowTime = customer.getFollowTime();
		if(oldFollowTime == null || customerFollow.getCreatedTime().after(oldFollowTime)){
			customer.setFollowTime(customerFollow.getCreatedTime());
		}
		
		customerServices.updateCustomerNoCheckNolyFollow(customer);
	}

}
