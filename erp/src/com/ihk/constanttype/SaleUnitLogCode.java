package com.ihk.constanttype;

import java.util.HashMap;
import java.util.Map;

/**
 * 单元销售日志类型
 * @author dtc
 * 2012-9-27
 */
public class SaleUnitLogCode {
	
	/**
	 * 单元状态
	 */
	public static Map<String,String> mainClassMap;
	static {
		mainClassMap = new HashMap<String, String>();
		mainClassMap.put("1", "单元");
		mainClassMap.put("2", "认购");
		mainClassMap.put("3", "合同");
	}
	public static Map<String, String> getMainClassMap() {
		return mainClassMap;
	}
	
	/**
	 * 操作类型
	 */
	public static Map<String,String> typeMap;
	static {
		typeMap = new HashMap<String, String>();
		typeMap.put("1", "新建");
		typeMap.put("2", "修改");
	}
	public static Map<String, String> getTypeMap() {
		return typeMap;
	}
}
