package com.ihk.utils;

import java.util.List;

/**
 * ajax 分页接口(利用字段名反射),为了不因为异常而影响正常显示,方法中处理异常
 * @author dtc
 * 2012-12-20,下午05:39:13
 */
public interface ActionAjaxFieldPageCallback {
	
	/**
	 * 获取总条数
	 * @return
	 * @throws Exception
	 */
	public int initTotal() throws Exception;
	
	/**
	 * 获取table中要显示的json
	 * @return
	 * @throws Exception
	 */
	public List<?> initRows() throws Exception;
	
}
