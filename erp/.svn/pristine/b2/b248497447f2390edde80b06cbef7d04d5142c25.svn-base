package com.ihk.constanttype;

/**
 * 左边导航树的项目ssession key,枚举
 * @author dtc
 * 2013-4-16,上午10:41:22
 */
public enum EnumSelectTypeSessionKey {
	
	/**
	 * 楼盘初始
	 */
	Init("__init__"),
	
	/**
	 * 付款方式
	 */
	Setup("__setup__"),
	
	/**
	 * 组团管理
	 */
	Group("__group__"),
	
	/**
	 * 认筹管理
	 */
	Chip("__chip__"),
	
	/**
	 * 现场销控情况
	 */
	Scene("__scene__"),
	
	/**
	 * 销售中心
	 */
	Appoint("__appoint__"),
	
	/**
	 * 成交单元管理
	 */
	ContractManager("__contractManager__"),
	
	/**
	 * 财务管理
	 */
	Financial("__financial__");
	
	/**
	 * 值
	 */
	private String value;
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	/**
	 * 此种类型的枚举,一定要定义构造函数(enum的构造函数只能为private),
	 * @param value
	 */
	private EnumSelectTypeSessionKey(String value) {
		this.value = value;
	}
	
	/**
	 * 重写toString(),返回枚举的实际值
	 */
	@Override
	public String toString() {
		return getValue();
	}
	
}
