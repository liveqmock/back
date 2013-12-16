package com.ihk.permission;

import com.ihk.utils.SearchCond;
import com.ihk.utils.SessionUser;
import org.apache.log4j.Logger; 

/**
 * 用户账户权限的工具类
 * @author peter.kuang
 *
 */
public class UserAccountPermissionUtils {
	private static final Logger logger = Logger.getLogger(PermissionUtils.class); 	
	
	/**
	 * 是否管理员
	 * @return
	 */
	public static boolean isAdminOrOwner(){		
		if(SessionUser.isAdmin()==true){
			return true;
		}
		return false;
	}
	
	/**
	 * 检验是否管理员
	 * @param userType
	 */
	public static void doCheckAdminOrOwner(String userType){	
		if(isAdminOrOwner()==false){
			String messageTips = "permission.doCheckAdminOrOwner:"+"-userType"+userType+"-loginUserId"+SessionUser.getUserIdStr();
			logger.error(messageTips);
			throw new RuntimeException(messageTips);
		}
	}
	
	
	/**
	 * 检验是否已经登录
	 * @param loggerMessage
	 */
	public static void doCheckLogin(String loggerMessage){	
		if(SessionUser.isLogined()==false){
			String messageTips = "permission.doCheckLogin:"+loggerMessage+"-loginUserId"+SessionUser.getUserIdStr();
			logger.error(messageTips);
			throw new RuntimeException(messageTips);
		}
	}
}