package com.ihk.saleunit.data.pojo;

import java.io.Serializable;

import com.ihk.constanttype.ContUnitSaleState;

/**
 * 成交合同汇总bean,cond
 * @author dtc
 * 2013-1-31,下午03:13:23
 */
public class ConfirmContractGatherCond implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 楼盘项目id
	 */
	private String propertyProjectId;
	
	/**
	 * confirm 或 contract
	 */
	private String type;
	
	/**
	 * 单元销售状态 confirm对应8,contract对应9
	 */
	private String saleState;
	
	public void setSaleState(String saleState) {
		this.saleState = saleState;
	}
	
	public String getSaleState() {
		return saleState;
	}

	public String getPropertyProjectId() {
		return propertyProjectId;
	}

	public void setPropertyProjectId(String propertyProjectId) {
		this.propertyProjectId = propertyProjectId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public ConfirmContractGatherCond() {
	}
	
	public ConfirmContractGatherCond(String propertyProjectId, String saleState){
		
		this.propertyProjectId = propertyProjectId;
		this.saleState = saleState;
		
		if(ContUnitSaleState.CONFIRM.equals(saleState)){
			type = "confirm";
		}else if(ContUnitSaleState.CONTRACT.equals(saleState)){
			type = "contract";
		}
	}
	

}
