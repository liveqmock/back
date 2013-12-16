package com.ihk.constanttype;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 单元的对数类型,0-未对数、1-对数中、2-已对数、3-不对数
 * @author dtc
 * 2013-5-27,下午02:05:04
 */
public enum EnumUnitCheckSecType {
	
	
	/**
	 * 0-未进行一二手对佣
	 */
	HaveNotCheckSec(0,"未进行一二手对佣"),
	
	/**
	 * 1-一二手对佣中
	 */
	CheckSecIng(1,"一二手对佣中"),
	
	/**
	 * 2-已一二手对佣
	 */
	CheckSecEd(2,"已一二手对佣");
	
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
	
	private  EnumUnitCheckSecType(int value, String text) {
		// TODO Auto-generated constructor stub
		this.value = value;
		this.text = text;
	}
	
	/**
	 * 默认返回对应的int值
	 */
	@Override
	public String toString() {
		return this.getValue() + "";
	}
	
	/**
	 * 根据text值获取对应的int值
	 * @param value
	 * @return
	 */
	public static String getTextByValue(int value){
		
		String text = "未知类型";
		
		EnumUnitCheckSecType[] enums = values();
		
		for(EnumUnitCheckSecType _enums : enums){
			
			int _value = _enums.getValue();
			if(value == _value){
				
				text = _enums.getText();
			}
		}
		
		return text;
	}

	/**
	 * 获取所有对数类型
	 * @return
	 */
    public static Map<String, String> getCheckfeeType(){

        Map<String, String> checkfeeType = new LinkedHashMap<String, String>();

        EnumUnitCheckSecType[] enums = values();

        for(EnumUnitCheckSecType _enums : enums){
            String _value = Integer.toString(_enums.getValue());
            String _text = _enums.getText();
            checkfeeType.put(_value, _text);
        }

        return checkfeeType;
    }

}
