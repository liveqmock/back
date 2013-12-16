package com.ihk.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * 新建,修改bean都要操作的字段
 * @author dtc
 * 2012-7-4
 */
public class CommonPojoUtils {
	
	private static List<String> commonFiled = null;
	
	static{
		commonFiled = new ArrayList<String>();
		
		commonFiled.add("isDeleted");
		commonFiled.add("createdId");
		commonFiled.add("createdTime");
		
	}
	
	/**
	 * 把每个新的pojo都有的字段设置值
	 * @param pojo
	 * @throws Exception
	 */
	public static void initPojoCommonFiled(Serializable pojo) throws Exception{
		
		Date date = new Date();
		int userId = -1;
		try{
			userId = SessionUser.getUserId();
		}catch (NullPointerException e) {
		}
		
		PropertyUtils.setProperty(pojo, "isDeleted", CommonUtils.NORMAL);
		PropertyUtils.setProperty(pojo, "createdId", userId);
		PropertyUtils.setProperty(pojo, "createdTime", date);
		PropertyUtils.setProperty(pojo, "modId", userId);
		PropertyUtils.setProperty(pojo, "modTime", date);
		
	}
	
	/**
	 * 获取oldPojo的相关数据设置到newPojo中
	 * @param oldPojo
	 * @param newPojo
	 * @throws Exception
	 */
	public static void initPojoForUpdate(Serializable oldPojo, Serializable newPojo) throws Exception{
		
		Date date = new Date();
		int userId = SessionUser.getUserId();
		
		for(String field : commonFiled){
			
			PropertyUtils.setProperty(newPojo, field, PropertyUtils.getProperty(oldPojo, field));
		}
		
		PropertyUtils.setProperty(newPojo, "modId", userId);
		PropertyUtils.setProperty(newPojo, "modTime", date);
		
	}


}
