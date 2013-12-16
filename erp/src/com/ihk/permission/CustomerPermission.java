package com.ihk.permission;

import org.apache.log4j.Logger;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.utils.SessionUser;

/**
 * 客户相关的数据权限的静态类
 * @author peter.kuang
 *
 */
public class CustomerPermission {
	
	
	private static final Logger logger = Logger.getLogger(CustomerPermission.class); 	
		
	public static void doCheckView(Customer customer) throws RuntimeException{
		
		System.out.println("doCheckView执行");
		PermissionUtils.doCheckAdminOrOwner("customer-view",customer.getUserId())	;
	}
	
	public static void doCheckSave() throws RuntimeException{
		PermissionUtils.doCheckLogin("customer-save")	;
	}
	
	public static void doCheckUpdate(Customer customer) throws RuntimeException{	
		PermissionUtils.doCheckAdminOrOwner("customer-view",customer.getUserId())	;
	}
	
	public static void doCheckRemove(Customer customer) throws RuntimeException{
		PermissionUtils.doCheckAdminOrOwner("customer-view",customer.getUserId())	;
	}
	
	@SuppressWarnings("deprecation")
	public static void doCheckFind(CustomerCond cond) throws RuntimeException{	
		//追加用户的条件	
		if(SessionUser.isAdmin()==false){
		logger.info("in-heere");
			//cond.setUserId(SessionUser.getUserIdStr());
		}
		
		logger.info(cond.getUserId());
	}
	
}