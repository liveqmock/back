package com.ihk.constanttype;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 单元的对佣类型,0-未对佣、1-对佣中、2-已对佣未结佣、3-已结佣、4-部分对佣
 * @author dtc
 * 2013-7-12,下午03:33:44
 */
public enum EnumUnitCheckCommissionType {
	
	/**
	 * 0-未对佣
	 */
	HaveNotCheckFee(0, "未对佣"),
	
	/**
	 * 1-对佣中
	 */
	CheckFeeIng(1, "对佣中"),
	
	/**
	 * 2-已对佣未结佣
	 */
	CheckFeeEd(2, "已对佣未结佣"),

	/**
	 * 3-已结佣
	 */
	ClosedCommission(3, "已结佣"),

    /**
     * 4-部分对佣
     */
    PartCommission(4,"部分对佣");

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
	
	private EnumUnitCheckCommissionType(int value, String text){
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
		
		EnumUnitCheckCommissionType[] enums = values();
		
		for(EnumUnitCheckCommissionType _enums : enums){
			
			int _value = _enums.getValue();
			if(value == _value){
				
				text = _enums.getText();
			}
		}
		
		return text;
	}

	/**
	 * 获取所有对佣类型
	 * @return
	 */
    public static Map<String, String> getCheckfeeType(){

        Map<String, String> checkfeeType = new LinkedHashMap<String, String>();

        EnumUnitCheckCommissionType[] enums = values();

        for(EnumUnitCheckCommissionType _enums : enums){
            String _value = Integer.toString(_enums.getValue());
            String _text = _enums.getText();
            checkfeeType.put(_value, _text);
        }

        return checkfeeType;
    }

}
