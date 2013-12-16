package com.ihk.utils.common.setup;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import com.ihk.utils.CommonUtils;

/**
 * 应收款的收款类别
 * @author dtc
 * 2013-1-5,下午03:37:54
 */
public class PayTypeUtils {
	
	/**
	 * 收费类别
	 */
	private static LinkedHashMap<String, String> payTypeMap;
	
	/**
	 * 收费类别对应的固定收款内容
	 */
	private static LinkedHashMap<String, List<String>> payTypeFixedFeeMap;
	
	public void setPayTypeFixedFeeMap(
			LinkedHashMap<String, List<String>> payTypeFixedFeeMap) {
		PayTypeUtils.payTypeFixedFeeMap = payTypeFixedFeeMap;
	}
	
	public static LinkedHashMap<String, List<String>> getPayTypeFixedFeeMap() {
		return payTypeFixedFeeMap;
	}
	
	public void setPayTypeMap(LinkedHashMap<String, String> payTypeMap) {
		PayTypeUtils.payTypeMap = payTypeMap;
	}
	
	public static LinkedHashMap<String, String> getPayTypeMap() {
		return payTypeMap;
	}
	
	/**
	 * 获取payType的值map(key及value都为中文)
	 * @return
	 */
	public static LinkedHashMap<String, String> getPayTypeValueMap(){
		
		LinkedHashMap<String, String> retMap = new LinkedHashMap<String, String>();
		
		Collection<String> vals = payTypeMap.values();
		
		for(String val : vals){
			
			if(CommonUtils.EMPTY.equals(val)){
				retMap.put("", val);				
			}else{
				retMap.put(val, val);
			}
			
		}
		
		return retMap;
	}
	
	/**
	 * 根据其key获取对应的中文值,key-->value
	 * @param key
	 * @return
	 */
	public static String getPayTypeValueByKey(String key){
		
		if(CommonUtils.isStrEmpty(key)){
			
			return "";
		}
		
		String value = payTypeMap.get(key);
		
		if(CommonUtils.isStrEmpty(value)){
			
			return "";
		}
		
		return value;
	}
	
	/**
	 * 根据其value获取对应的英文key,value-->key
	 * @param valie
	 * @return
	 */
	public static String getPayTypeKeyByValue(String value){
		
		if(CommonUtils.isStrEmpty(value))
			return "";
		
		if(!payTypeMap.containsValue(value))
			return value;
		
		Set<String> keys = payTypeMap.keySet();
		
		for(String key : keys){
			
			String getValue = payTypeMap.get(key);
			if(value.equals(getValue)){
				
				return key;
			}
			
		}
		
		return value;
	}
	
	/**
	 * 根据收费类别获取固定的收款内容(radio html),选中feeValue
	 * @param type
	 * @param feeValue
	 * @return
	 */
	public static String getFixedFeeRadioHtmlByType(String type, String feeValue){
		
		if(CommonUtils.isStrEmpty(type) || !payTypeFixedFeeMap.containsKey(type)){
			return "";
		}
		
		List<String> valList = payTypeFixedFeeMap.get(type);
		
		if(CommonUtils.isCollectionEmpty(valList)){
			return "";
		}
		
		StringBuffer sb = new StringBuffer();
		int size = valList.size();
		for(int i=0; i<size; i++){
			
			String val = valList.get(i);
			
			sb.append("<input type='radio' onclick='changeRadio(").append(i)
				.append(")' name='payWayDetail.feeType' value='")
				.append(val).append("'")
				;
			
			sb.append(" id='radio_type_").append(i).append("'");
			
			//判断是否选中
			if(val.equals(feeValue)){
				sb.append(" checked='checked'");
			}
			
			sb.append("/>")
				.append("<label for='radio_type_").append(i).append("'>")
				.append(val).append("</label>")
				;
		}
		
		/*if(sb.length() > 0){
			sb.append("<a href='javascript:void(0)' style='color:#5482DE;' onclick='cancelRadio()'>(取消选择)</a>");
		}*/
		
		return sb.toString();
	}
	
}
