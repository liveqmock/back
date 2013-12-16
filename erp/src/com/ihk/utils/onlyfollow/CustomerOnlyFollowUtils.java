package com.ihk.utils.onlyfollow;

import java.util.ArrayList;
import java.util.List;

import com.ihk.customer.data.pojo.OnlyFollow;
import com.ihk.customer.data.services.IOnlyFollowServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.exception.CustomerException;

/**
 * 针对只能跟进不能修改的客户
 * @author dtc
 * 2012-11-28,下午04:48:02
 */
public class CustomerOnlyFollowUtils {
	
	private static IOnlyFollowServices onlyFollowServices;
	
	public void setOnlyFollowServices(
			IOnlyFollowServices onlyFollowServices) {
		CustomerOnlyFollowUtils.onlyFollowServices = onlyFollowServices;
	}
	
	public static IOnlyFollowServices getOnlyFollowServices() {
		return onlyFollowServices;
	}
	
	/**
	 * 获取登陆者只能跟进的客户的id list
	 * @return
	 */
	public static List<Integer> getFollowCustomerIds(){
		
		List<Integer> retList = new ArrayList<Integer>();
		
		List<OnlyFollow> onlyList = onlyFollowServices.findOnlyFollowByUserId(SessionUser.getUserId());
		
		if(!CommonUtils.isCollectionEmpty(onlyList)){
			
			for(OnlyFollow only : onlyList){
				
				//去除重复
				if(!retList.contains(only.getCustomerId())){
				
					retList.add(only.getCustomerId());
				}
			}
		}
		
		return retList;
	}
	
	/**
	 * 判断是否为只能跟进的客户
	 * @param customerId
	 * @return
	 */
	public static boolean isOnlyFollowCustomerById(int customerId){
		
		if(getFollowCustomerIds().contains(customerId)){
			
			throw new CustomerException("对该客户只能跟进查看,不能修改");
		}
		
		return false;
	}

}
