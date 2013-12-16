package com.ihk.utils.tag;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;

/**
 * 标签工具类
 * @author peter.kuang
 *
 */
public class TagUtils {
	
	/**
	 * 根据map来组成<select/>标签的<option/>,map的key为<option/>的value,map的value为<option/>显示内容
	 * @param map
	 * @param isPutEmpty
	 * @return
	 */
	public static String getSelectContent(Map<String, String> map, boolean isPutEmpty){
		
		String content = "<option value=\'\'>" + CommonUtils.EMPTY + "</option>"; //默认值
		
		StringBuffer sb = new StringBuffer();
		
		if(map.keySet().size() > 0){
			
			if(isPutEmpty){
				sb.append(content);
			}
			
			Set<String> keys = map.keySet();
			for(String key : keys){
				String value = map.get(key);
				sb.append("<option value=\'")
					.append(key)
					.append("\'>")
					.append(value)
					.append("</option>")
					;
			}
			
		}
		
		String getContent = sb.toString();
		if(!CustomerUtils.isStrEmpty(getContent)){
			content = getContent;
		}
		
		return content;
	}
	
	public static String getSelectContent(Map<String, String> map){
		
		return getSelectContent(map, false);
	}
	
	/**
	 * 根据字段及pojo,组成map,key为字段,value为pojo对应的值
	 * @param pojo
	 * @param fields
	 * @return
	 */
	public static Map<String, String> getPojoMap(Serializable pojo, List<String> fields){
		
		Map<String, String> map = new HashMap<String, String>();
		for(String field : fields){
			String value = "";
			try {
				Object obj = PropertyUtils.getProperty(pojo, field);
				if(obj != null){
					value = obj.toString();
				}
				
			} catch (Exception e) {
			}
			
			map.put(field, value);
			
		}
		
		return map;
	}
	
	/**
	 * 根据map来组成json
	 * @param map
	 * @return
	 */
	public static String getMapJson(Map<String, String> map){
		
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		
		StringBuffer tmp = new StringBuffer();
		for(String key : map.keySet()){
			String value = map.get(key);
			
			tmp.append("\"")
				.append(key)
				.append("\":\"")
				.append(value == null ? "" : value)
				.append("\",")
				;
			
		}
		
		String tmpStr = tmp.toString();
		int length = tmpStr.length();
		
		if(length > 0){
			tmpStr = tmpStr.substring(0, length-1);
		}
		
		sb.append(tmpStr)
			.append("}")
			;
		
		return sb.toString();
	}

}
