package com.ihk.constanttype;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 取整方式,SetPayWayForProjectAction.java中使用
 * @author dtc
 * 2013-6-5,上午10:34:21
 */
public enum EnumRoundingType {
	
	/**
	 * 尾数保留到千位
	 */
	THOUSAND(1, "尾数保留到千位"),
	
	/**
	 * 尾数保留到万位
	 */
	TEN_THOUSAND(2, "尾数保留到万位");
	
	/**
	 * 类型的数值
	 */
	private int value;
	
	/**
	 * 类型的文本
	 */
	private String text;
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	private EnumRoundingType(int value, String text){
		this.value = value;
		this.text = text;
	}
	
	/**
	 * 初始化取整方式
	 * @return
	 */
	public static Map<Integer, String> initRoundingTypeMap(){
		
		Map<Integer, String> roundingMap = new LinkedHashMap<Integer, String>();
		
		EnumRoundingType[] enums = values();
		
        for(EnumRoundingType _enums : enums){
        	
            roundingMap.put(_enums.getValue(), _enums.getText());
        }
		
		return roundingMap;
	}
	
}
