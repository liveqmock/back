package com.ihk.utils.listpage;

import java.util.List;

/**
 * ajax列表页面工具类
 * @author dtc
 * 2012-11-7,上午09:48:43
 */
public class ListPageUtils {
	
	private final static String TR_START = "<tr onMouseOver=\"this.style.backgroundColor='#f1f9fe'\" " +
			"onMouseOut=\"this.style.backgroundColor=''\" bgcolor=\"#FFFFFF\";>";
	
	private final static String TR_END = "</tr>";
	
	private final static String TD_START = "<td>";
	
	private final static String TD_EDN = "</td>";
	
	public static String page(List<List<Object>> dataList, int pageNo, int pageCount){
		
		StringBuffer sb = new StringBuffer();
		
		for(List<Object> data : dataList){
			
			sb.append(TR_START);
			
			for(Object d : data){
				
				sb.append(TD_START).append(d).append(TD_EDN);
			}
			
			sb.append(TR_END);
		}
		
		int tdCount = dataList.get(0).size();
		
		StringBuilder btBack = new StringBuilder();
		btBack.append("<a href=\"#\" onclick=\"return listPage(")
			.append(pageNo-1)
			.append(",'./customer_guangzhou/cache/ajaxShowCaches.action', 'listPage')\"><<</a>");
		
		StringBuilder btGo = new StringBuilder();
		btGo.append("<a href=\"#\" onclick=\"return listPage(")
			.append(pageNo+1)
			.append(",'./customer_guangzhou/cache/ajaxShowCaches.action', 'listPage')\">>></a>");
		
		sb.append(TR_START)
			.append("<td colspan=\"")
			.append(tdCount)
			.append("\" style=\"text-align:center\">")
			.append(btBack)
			.append("&nbsp;")
			.append(pageNo).append("/").append(pageCount)
			.append("&nbsp;")
			.append(btGo)
			.append(TD_EDN)
			.append(TR_END)
			;
			
		return sb.toString();
	}
	
	

}
