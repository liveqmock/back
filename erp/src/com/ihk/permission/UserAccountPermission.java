package com.ihk.permission;


import org.apache.log4j.Logger; 

import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserAccountCond;
import com.ihk.utils.SessionUser;
import com.ihk.customer.data.pojo.Customer;

import com.ihk.customer.data.pojo.CustomerCond;

/**
 * 用户账户的权限
 * 仿customerPermission
 * @author peter.kuang
 *
 */
public class UserAccountPermission {
	private static final Logger logger = Logger.getLogger(CustomerPermission.class); 	
		
	public static void doCheckView(UserAccount user) throws RuntimeException{	
		UserAccountPermissionUtils.doCheckAdminOrOwner(user.getAccountType())	;
	}
//	
//	public static void doCheckSave() throws RuntimeException{
//		PermissionUtils.doCheckLogin("customer-save")	;
//	}
//	
//	public static void doCheckUpdate(Customer customer) throws RuntimeException{	
//		PermissionUtils.doCheckAdminOrOwner("customer-view",customer.getUserId())	;
//	}
//	
//	public static void doCheckRemove(Customer customer) throws RuntimeException{
//		PermissionUtils.doCheckAdminOrOwner("customer-view",customer.getUserId())	;
//	}
//	
	public static void doCheckFind(UserAccountCond cond) throws RuntimeException{	
		//根据权限改变搜索条件cond
		cond.setUserName("1");

		
		logger.info(cond.getUserName());
	}
	
}