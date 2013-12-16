package com.ihk.utils;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

/**
 * ajax 分页接口,包括底部footer总计(利用字段名反射),为了不因为异常而影响正常显示,方法中处理异常
 * @author dtc
 * 2013-1-25,下午06:40:18
 */
public interface ActionAjaxFieldPageByFooterCallback extends ActionAjaxFieldPageCallback{
	
	/**
	 * 底部JSONArray
	 * @param footerMapList,为initRows()方法中反射后的所有参数字段list
	 * @return
	 * @throws Exception
	 */
	public JSONArray initFootor(List<Map<String, String>> footerMapList) throws Exception;
	
	
}
