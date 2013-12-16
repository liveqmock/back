package com.ihk.utils.projectcode;

import java.util.Properties;

import com.ihk.utils.upload.PropertiesUtils;

/**
 * 兼容CustomerFollow中的DescUtils.getCodeDesc(EnumCodeTypeName.FOLLOW_TYPE,followType,1);写死为1的情况
 * 以后下拉框增加的值要在followType.properties中对应增加
 * @author dtc
 * 2012-9-5
 */
public class FollowTypeUtils {
	
	private static String FILE_NAME = "followType.properties";
	
	private static Properties pro;
	
	static{
		
		pro = PropertiesUtils.getPropertiesFile(FILE_NAME);
	}
	
	/**
	 * 获取followType的中文
	 * @param followType
	 * @return
	 */
	public static String getDescFollowType(String followType){
		
		return pro.get(followType).toString();
		
	}

}
