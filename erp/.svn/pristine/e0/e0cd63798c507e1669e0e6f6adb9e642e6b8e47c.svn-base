package com.ihk.constanttype;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * "收款情况"下,"使用公式",中的"设置方式"
 * @author dtc
 * 2013-6-24,下午04:18:02
 */
public enum EnumUnitPayBillFormula {
	
	/**
	 * 固定比例
	 */
	Fixed_Proportion(1, "固定比例"),
	
	/**
	 * 自定义比例
	 */
	Own_Proportion(2, "自定义比例"),
	
	/**
	 * 自定义金额
	 */
	Own_Money(3, "自定义金额");
	
	/**
	 * 值
	 */
	private int value;
	
	/**
	 * 文本
	 */
	private String text;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	private EnumUnitPayBillFormula() {
	}
	
	EnumUnitPayBillFormula(int value, String text){
		this.value = value;
		this.text = text;
	}
	
	EnumUnitPayBillFormula(int value){
		this.value = value;
	}
	
	/**
	 * 返回所有的设置方式
	 * @return
	 */
	public static Map<Integer, String> getAllFormula(){
		
		Map<Integer, String> retMap = new LinkedHashMap<Integer, String>();
		
		EnumUnitPayBillFormula[] vals = values();
		
		for(EnumUnitPayBillFormula val : vals){
			
			retMap.put(val.getValue(), val.getText());
		}
		
		return retMap;
	}
	
	/**
	 * 根据value返回对应的枚举
	 * @param value
	 * @return
	 */
	public static EnumUnitPayBillFormula getEnumByValue(int value){
		
		EnumUnitPayBillFormula ret = null;
		
		EnumUnitPayBillFormula[] vals = values();
		
		for(EnumUnitPayBillFormula val : vals){
			
			if(value == val.getValue()){
				
				ret = val;
				break;
			}
			
		}
		
		return ret;
	}

}
