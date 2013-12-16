package com.ihk.utils.reflect;

import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ihk.utils.CommonUtils;

/**
 * 有关反射的帮助类
 * @author dtc
 * 2013-9-25,下午05:36:27
 */
public class ReflectUtils {

	/**
	 * 获取bean list指定字段的JSONArray
	 * @param beanList
	 * @param fields
	 * @return
	 */
	public static JSONArray getBeanListJSONArrayByField(List<?> beanList, String ... fields){
		
		JSONArray array = new JSONArray();
		
		if(CommonUtils.isCollectionEmpty(beanList) || CommonUtils.isCollectionEmpty(fields)){
			
			return array;
		}
		
		for(Object bean : beanList){
			
			array.add(getBeanJSONObjectByField(bean, fields));
		}
		
		return array;
	}
	
	/**
	 * 获取bean指定字段的json
	 * @param bean
	 * @param fields
	 * @return
	 */
	public static JSONObject getBeanJSONObjectByField(Object bean, String ... fields){
		
		JSONObject json = new JSONObject();
		
		if(CommonUtils.isCollectionEmpty(fields)){
			return json;
		}
		
		for(String field : fields){
			
			Object obj = new Object();
			
			try {
				obj = PropertyUtils.getProperty(bean, field);
			} catch (Exception e) {
			} 
			
			json.put(field, obj);
		}
		
		return json;
	}

}
