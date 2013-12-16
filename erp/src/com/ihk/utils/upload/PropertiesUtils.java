package com.ihk.utils.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * 用来获取properties文件
 * @author dtc
 * 2012-6-27
 */
public class PropertiesUtils {
	
	public static final String PRO_FILE_NAME = "upload.properties";
	
	/**
	 * 根据文件名称获取对应的Properties文件,
	 * @param fileName,应该为.properties文件
	 * @return
	 */
	public static Properties getPropertiesFile(String fileName){
		
		Properties pro = new Properties();
		
		URL url = new PropertiesUtils().getClass().getClassLoader().getResource(fileName);
		String srcFilePath = url.getPath();
		
		File file = new File(srcFilePath);
		InputStream is;
			
		try {
			
			is = new FileInputStream(file);
			pro.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pro;
	}
	
	/**
	 * 根据文件名称及key获取对应的Properties值
	 * @param fileName
	 * @param key
	 * @return
	 */
	public static Object getPropertiesValue(String fileName, String key){
		
		Properties getPro = getPropertiesFile(fileName);
		
		return getPro.get(key) == null ? "" : getPro.get(key);
		
	}
	
}
