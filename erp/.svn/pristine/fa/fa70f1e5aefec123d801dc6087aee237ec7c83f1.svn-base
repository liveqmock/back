package com.ihk.saleunit.action.contract_customer;

import java.io.Serializable;

/**
 * 供copy的客户资料(选择及新增)
 * @author dtc
 * 2013-5-20,下午05:27:19
 */
public class CopyCustomerPojo implements Serializable{

	private static final long serialVersionUID = 2407731968773796857L;
	
	/**
	 * 客户id
	 */
	private int customerId;
	
	/**
	 * 客户姓名
	 */
	private String customerName;
	
	/**
	 * 来源客户类型
	 */
	private String preCustomerType;
	
	/**
	 * 对应的单元名称:分区,楼栋,单元编号
	 */
	private String unitName;
	
	/**
	 * 销售id
	 */
	private String salesId;
	
	/**
	 * 对应的销售
	 */
	private String salesName;
	
	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
	
	public String getSalesId() {
		return salesId;
	}
	
	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}
	
	public String getSalesName() {
		return salesName;
	}
	
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	public String getUnitName() {
		return unitName;
	}
	
	public String getPreCustomerType() {
		return preCustomerType;
	}
	
	public void setPreCustomerType(String preCustomerType) {
		this.preCustomerType = preCustomerType;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public CopyCustomerPojo(int customerId, String customerName, String preCustomerType) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.preCustomerType = preCustomerType;
	}
	
	public CopyCustomerPojo(int customerId, String customerName,
			String preCustomerType, String unitName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.preCustomerType = preCustomerType;
		this.unitName = unitName;
	}
	
	public CopyCustomerPojo(int customerId, String customerName,
			String preCustomerType, String unitName, String salesName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.preCustomerType = preCustomerType;
		this.unitName = unitName;
		this.salesName = salesName;
	}
	
	public CopyCustomerPojo(int customerId, String customerName,
			String preCustomerType, String unitName, String salesId,
			String salesName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.preCustomerType = preCustomerType;
		this.unitName = unitName;
		this.salesId = salesId;
		this.salesName = salesName;
	}

	public CopyCustomerPojo() {
		super();
	}
	
}
