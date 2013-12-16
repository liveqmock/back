package com.ihk.junit.import_confirm.utils;

import com.ihk.saleunit.log.pojo.Log;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.log.CompareUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 导入数据的日志帮助类
 * @author dtc
 * 2013-11-22,下午03:21:26
 */
public class LogDataUtils {
	
	/**
	 * 导数日志modul
	 */
	public static String IMPORT_MODUL = "导数";
	
	/**
	 * 导数成交type
	 */
	public static String CONFIRM_TYPE = "成交";
	
	/**
	 * 导数合同type
	 */
	public static String CONTRACT_TYPE = "合同";
	
	/**
	 * 导数售前type
	 */
	public static String CUSTOMER_TYPE = "售前";
	
	/**
	 * 导数售前及问卷
	 */
	public static String CUSTOMER_QUESTION_TYPE = "售前/问卷";
	
	/**
	 * 导数记录
	 * @param type
	 * @param fileName
	 */
	public static void log(String type, String fileName){
		
		try{
			
			Log log = new Log();
			
			log.setModul(IMPORT_MODUL);
			log.setType(type);
			log.setOperationProcedure(fileName);
			log.setComputerInformationl(CompareUtils.getIpAddr());
			
			CommonPojoUtils.initPojoCommonFiled(log);
			
			MyPropertyUtils.getLogService().addLog(log);
			
		}catch (Exception e) {
		}
	}

}
