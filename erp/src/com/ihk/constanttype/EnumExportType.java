package com.ihk.constanttype;

public enum EnumExportType {

	
	
	afterSale("afterSales", "售后客户"),
	
	beforeSale("beforeSale","售前客户");
	
	private String key;
	private String value;
	
	private EnumExportType(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getTextByValue(String value) {

		String text = "未知类型";

		EnumExportType[] enums = values();

		for (EnumExportType _enums : enums) {

			String _value = _enums.getValue();
			if (value.equals(_value)) {

				text = _enums.getValue();
			}
		}

		return text;
	}
	
	public static boolean contains(String key){
		EnumExportType[] enums = values();
		for (EnumExportType enumExportType : enums) {
			if(enumExportType.getValue().equals(key))
				return true;
		}
		return false;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
