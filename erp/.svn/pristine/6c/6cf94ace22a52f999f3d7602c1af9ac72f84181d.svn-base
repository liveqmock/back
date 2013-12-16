package com.ihk.utils.log;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.ihk.constanttype.EnumOperLogType;
import com.ihk.setting.data.pojo.OperLog;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.utils.common.log.BaseLogger;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 操作日志帮助类
 * @author dtc
 * 2013-7-25,下午12:27:40
 */
public class OperLogUtils {

	/**
	 * 增加登陆日志
	 * @param loginUser
	 * @param devFlag
	 * @param type
	 * @param request
	 */
	public static void addLoginLog(UserAccount loginUser, String devFlag, EnumOperLogType type, HttpServletRequest request) {
		
		try{
			
			OperLog oper = new OperLog();
			
			if(loginUser == null){
				
				oper.setLogType(EnumOperLogType.LOGIN_ERR_UNAME_PWD.toString());
				oper.setLogDesc("ip = " + getRemoteAddr(request));
		
				oper.setLogTime(new Date());
		
			}else{

				oper.setLogType(type.toString());
				oper.setLogDesc("ip = " + getRemoteAddr(request) + ";username = " + loginUser.getUserName());
		
				oper.setProjectId(loginUser.getProjectId());
				oper.setUserId(loginUser.getId());
		
				oper.setLogTime(new Date());
			}
	
			oper.setDevFlag(devFlag);
			MyPropertyUtils.getOperLogServices().addOperLog(oper);
			
		}catch (Exception e) {
			e.printStackTrace();
			BaseLogger.error(OperLogUtils.class, "记录日志出错");
		}

	}

	/**
	 * 获取登陆者ip
	 * @param request
	 * @return
	 */
	private static String getRemoteAddr(HttpServletRequest request) {

		if (request.getHeader("x-forwarded-for") == null) {
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");
	}

}
