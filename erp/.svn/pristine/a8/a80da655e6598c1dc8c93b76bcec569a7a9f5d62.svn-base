package com.ihk.utils.projectid;

import java.util.Properties;

import com.ihk.utils.upload.PropertiesUtils;

/**
 * 获取对应的项目id
 * @author dtc
 * 2012-8-10
 */
public class ProjectIdUtils {
	
	private static String PROJECT_FILE_NAME = "contProjectId.properties";
	private static String COMPANY_FILE_NAME = "contCompanyId.properties";
	private static String COMPANY_DEFAULT_PROJECTID_FILE_NAME = "companyDefaultProjectId.properties";
	
	private static Properties projectPro;
	private static Properties companyPro;
	private static Properties comDefPro;
	
	static{
		
		projectPro = PropertiesUtils.getPropertiesFile(PROJECT_FILE_NAME);
		companyPro = PropertiesUtils.getPropertiesFile(COMPANY_FILE_NAME);
		comDefPro = PropertiesUtils.getPropertiesFile(COMPANY_DEFAULT_PROJECTID_FILE_NAME);
	}
	
	/**
	 * 获取对应的项目id
	 * @param key
	 * @return
	 */
	public static Integer getProjectId(String key){
		
		return Integer.parseInt(projectPro.getProperty(key).trim());
		
	}
	
	/**
	 * 获取对应的公司id
	 * @param key
	 * @return
	 */
	public static Integer getCompanyId(String key){
		
		return Integer.parseInt(companyPro.getProperty(key).trim());
	}
	
	/**
	 * 获取公司的默认项目id
	 * @param key
	 * @return
	 */
	public static Integer getCompanyDefaultProjectId(String key){
		
		try{
			return Integer.parseInt(comDefPro.getProperty(key).trim());
		}catch (Exception e) {
			return 0;
		}
	}

}
