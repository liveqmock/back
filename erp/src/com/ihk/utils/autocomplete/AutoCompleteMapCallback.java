package com.ihk.utils.autocomplete;

import java.util.Map;

/**
 * 返回map格式
 * @author dtc
 * 2013-2-4,上午11:05:04
 */
public interface AutoCompleteMapCallback {
	
	/**
	 * 具体业务要实现的方法
	 * @param search
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> complete(String search) throws Exception;

}
