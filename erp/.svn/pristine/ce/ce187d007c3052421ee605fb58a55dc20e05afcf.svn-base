package com.ihk.utils.cache;

import com.ihk.utils.CacheUtils;

/**
 * 缓存模板使用类
 * @author dtc 2013-3-26,下午02:22:25
 */
public class MyCacheTemplate {

	/**
	 * 缓存对应的内容,如果出异常或者获取不到对应的值,就返回null
	 * @param cacheName
	 * @param key
	 * @param callback
	 * @return
	 */
	public static Object cache(String cacheName, String key, MyCacheTemplateCallback callback) {
		
		Object value = null;

		try {

			value = CacheUtils.getValueByCacheNameAndKey(cacheName, key);

			if (value == null) {

				value = callback.doCache();

				if (value != null) {

					CacheUtils.put(cacheName, key, value);
				}
			}
			
		} catch (Exception e) {
			
			value = new Object();
		}

		return value;

	}

}
