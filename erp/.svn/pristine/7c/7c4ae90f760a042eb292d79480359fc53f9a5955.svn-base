package com.ihk.utils;

import java.util.Date;

import com.ihk.saleunit.data.pojo.Appoint;

/**
 * 预约帮助类
 * @author dtc
 * 2012-9-29
 */
public class AppointUtils {
	
	public static Appoint initOther(Appoint appoint){
		
		Date date = new Date();
		int userId = SessionUser.getUserId();
		
		appoint.setIsDeleted(CommonUtils.NORMAL);
		appoint.setCreatedId(userId);
		appoint.setCreatedTime(date);
		appoint.setModId(userId);
		appoint.setModTime(date);
		
		return appoint;
	}
	
	public static Appoint initOtherForUpdate(Appoint oldAppoint, Appoint newAppoint){
		
		Date date = new Date();
		
		newAppoint.setIsDeleted(oldAppoint.getIsDeleted());
		newAppoint.setCreatedId(newAppoint.getCreatedId());
		newAppoint.setCreatedTime(oldAppoint.getCreatedTime());
		newAppoint.setModId(SessionUser.getUserId());
		newAppoint.setModTime(date);
		
		return newAppoint;
	}

}
