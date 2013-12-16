package com.ihk.junit.import_cus.dongguan.utils;

import com.ihk.utils.CommonUtils;

/**
 * 东莞客户帮助类
 * @author dtc
 * 2013-8-26,下午05:21:05
 */
public class DongGuanUtils {
	
	/**
	 * 处理电话
	 * @param oldPhone
	 * @return
	 */
	public static String getPhone(String oldPhone){
		
		if(CommonUtils.isStrEmpty(oldPhone)){
			return "";
		}
		
		oldPhone = oldPhone.trim();
		
		if(oldPhone.contains("-")){
			oldPhone = oldPhone.replace("-", "");
		}
		
		if(oldPhone.length() > 11){
			oldPhone = oldPhone.substring(0, 11);
		}
		
		return oldPhone;
	}

}
