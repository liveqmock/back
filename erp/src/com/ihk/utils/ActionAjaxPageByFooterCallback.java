package com.ihk.utils;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

/**
 * ajax 分页接口,包括底部footer总计,为了不因为异常而影响正常显示,方法中处理异常
 * @author dtc
 * 2013-1-25,下午06:40:18
 */
public interface ActionAjaxPageByFooterCallback {
	
	/**
	 * 获取总条数,返回0表示不分页
	 * @return
	 * @throws Exception
	 */
	public int initTotal() throws Exception;
	
	/**
	 * 获取table中要显示的json
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> initRows() throws Exception;
	
	/**
	 * 底部JSONArray
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public JSONArray initFootor(List<Map<String, Object>> rows) throws Exception;
	
}
