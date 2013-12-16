package com.ihk.utils.saleunitnew;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import com.ihk.utils.CommonUtils;

/**
 * 数据分组帮助类
 * @author dtc
 *
 * 2012-6-29
 */
public class GroupDataUtils {
	
	/**
	 * 获取数据分组左边的操作框
	 * @param listMap(利用有序的LinkedHashMap来显示)
	 * @return
	 */
	public static String initGroupLeft(LinkedHashMap<String, List<GroupDataLeftBean>> listMap){
		
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		
		StringBuffer tmp = new StringBuffer();
		
		Set<String> keys = listMap.keySet();
		for(String key : keys){
			
			List<GroupDataLeftBean> beanList = listMap.get(key);
			if(!CommonUtils.isCollectionEmpty(beanList)){
				
				tmp.append("{\"text\":\"").append(key).append("\",\"state\":\"closed\",\"children\":");
				tmp.append("[");
				
				StringBuffer beanSb = new StringBuffer();
				for(GroupDataLeftBean bean : beanList){
					
					beanSb.append("{\"text\":\"<input type='checkbox' class='_cb' grouptype='")
						.append(bean.getGroupType())
						.append("' groupname='")
						.append(bean.getName())
						.append("'/><span class='check_name'>")
						.append(bean.getName())
						.append("</span><span class='search' id='")
						.append(bean.getId())
						.append("'></span>\",\"attributes\":{\"type\":\"endNode\"}}")
						.append(",")
						;
					
				}
				String beanStr = beanSb.toString();
				int beanLength = beanStr.length();
				if(beanLength > 0){
					tmp.append(beanStr.substring(0, beanLength-1));
				}
				
				tmp.append("]},");
				
			}
			
		}
		
		String tmpStr = tmp.toString();
		int tmpLength = tmpStr.length();
		if(tmpLength > 0){
			sb.append(tmpStr.substring(0, tmpLength-1));
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	

}
