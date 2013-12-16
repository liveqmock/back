package com.ihk.utils.cache;

/**
 * 缓存模板的回调接口
 * @author dtc
 * 2013-3-26,下午02:28:45
 */
public interface MyCacheTemplateCallback {
	
	/**
	 * 缓存模板中要返回的业务值
	 * @return
	 * @throws Exception
	 */
	public Object doCache() throws Exception;
}
