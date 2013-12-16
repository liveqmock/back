package com.ihk.sale.data.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用于总计
 */
public class SaleMonitorAmount implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int phoneNum;
	private int visitorNum;
	
	private int sumNum;
	private BigDecimal sumArea;
	private BigDecimal sumMoney;
	
	private int undoSumNum;
	private BigDecimal undoSumArea;
	private BigDecimal undoSumMoney;
	
	private int intentionNum;	//认筹数
	
	private int contractSumNum; //签约数
	
	private BigDecimal realSumMoney;//实收金额
	
	public int getContractSumNum() {
		return contractSumNum;
	}

	public void setContractSumNum(int contractSumNum) {
		this.contractSumNum = contractSumNum;
	}

	public BigDecimal getRealSumMoney() {
		return realSumMoney == null ? new BigDecimal(0) : realSumMoney;
	}

	public void setRealSumMoney(BigDecimal realSumMoney) {
		this.realSumMoney = realSumMoney;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getVisitorNum() {
		return visitorNum;
	}

	public void setVisitorNum(int visitorNum) {
		this.visitorNum = visitorNum;
	}

	public int getSumNum() {
		return sumNum;
	}

	public void setSumNum(int sumNum) {
		this.sumNum = sumNum;
	}

	public BigDecimal getSumArea() {
		return sumArea == null ? new BigDecimal(0) : sumArea;
	}

	public void setSumArea(BigDecimal sumArea) {
		this.sumArea = sumArea;
	}

	public BigDecimal getSumMoney() {
		return sumMoney == null ? new BigDecimal(0) : sumMoney;
	}

	public void setSumMoney(BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
	}

	public int getUndoSumNum() {
		return undoSumNum;
	}

	public void setUndoSumNum(int undoSumNum) {
		this.undoSumNum = undoSumNum;
	}

	public BigDecimal getUndoSumArea() {
		return undoSumArea == null ? new BigDecimal(0) : undoSumArea;
	}

	public void setUndoSumArea(BigDecimal undoSumArea) {
		this.undoSumArea = undoSumArea;
	}

	public BigDecimal getUndoSumMoney() {
		return undoSumMoney == null ? new BigDecimal(0) : undoSumMoney;
	}

	public void setUndoSumMoney(BigDecimal undoSumMoney) {
		this.undoSumMoney = undoSumMoney;
	}

	public int getIntentionNum() {
		return intentionNum;
	}

	public void setIntentionNum(int intentionNum) {
		this.intentionNum = intentionNum;
	}
	
	

}
