package com.ihk.utils.code;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.ihk.constanttype.ContCacheAndCode;
import com.ihk.utils.CacheUtils;

/**
 * 
 * get请求的参数编解码,主要解决ie6下get方法传递中文的问题
 * @author dtc
 *
 */
public class UrlCodeUtils {
	
	/**
	 * 对HttpServletRequest的get进行编码
	 * @param request
	 * @return
	 */
	public static String encode(HttpServletRequest request){
		
		String method = request.getMethod();
		
		StringBuffer queryString = new StringBuffer();
		
		if("get".equalsIgnoreCase(method)){
			
			Enumeration<?> names = request.getParameterNames();
			
			while(names.hasMoreElements()){
				Object obj = names.nextElement();
				if(obj == null || ContCacheAndCode.PAGE_SIGN.equals(obj.toString()))
					continue;
				
				String name = obj.toString();
				
				String[] values = request.getParameterValues(name);
				for(String value : values){
					queryString.append(name + "=" + myEncode(value) + "&");
				}
				
			}
			
		}
		
		String ret = queryString.toString();
		return trimEndChar(ret);
		
	}
	
	/**
	 * 对指定的参数编码
	 * @param params,请求参数
	 * @param exParams,不进行编码的值
	 * @return
	 */
	public static String encode(Map<String, Object> params, List<String> exParams){
		
		StringBuffer sb = new StringBuffer();
		
		Set<String> keys = params.keySet();
		
		for(String key : keys){
			
			if(exParams.contains(key))
				continue;
			
			String[] values = (String[]) params.get(key);
			for(String value : values){
				
				//避免代理服务器的缓存
				if(ContCacheAndCode.NO_CACHE_SIGN.equals(key)){
					value = CacheUtils.getUrlTimeStamp();
				}
				sb.append(key + "=" + myEncode(value) + "&");
			}
			
		}
		
		return trimEndChar(sb.toString());
	}
	
	/**
	 * 
	 * 对分页的请求参数进行HttpServletRequest转换
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static HttpServletRequest pageDecode(HttpServletRequest request){
				
		/*Enumeration<String> em = request.getHeaderNames();
		while(em.hasMoreElements()){
			String key = em.nextElement();
			
			String value = request.getHeader(key);
			
			System.out.println(key + ":" + value);
			
		}*/
		
		String method = request.getMethod();
		Map<String, String[]> map = request.getParameterMap();
		if("get".equalsIgnoreCase(method) && map.containsKey(ContCacheAndCode.PAGE_SIGN)){
			
			request = new UrlCodeHttpServletRequestWrapper(request);
		}
		
		return request;
		
	}
	
	/**
	 * 去除末尾空格
	 * @param value
	 * @return
	 */
	private static String trimEndChar(String value){
		
		return value.length() > 0 ? value.substring(0, value.length()-1) : value;
	}
	
	/**
	 * 自定义编码
	 * @param value
	 * @return
	 */
	public static String myEncode(String value){
		
		try {
			
			return URLEncoder.encode(value, ContCacheAndCode.ENCODING);
		} catch (Exception e) {
			
			return value;
		}
		
	}
	
	/**
	 * 自定义解码
	 * @param value
	 * @return
	 */
	public static String myDecode(String value){
		
		try {
			
			return URLDecoder.decode(value, ContCacheAndCode.ENCODING);
		} catch (Exception e) {
			
			return value;
		}
		
		
	}

}
