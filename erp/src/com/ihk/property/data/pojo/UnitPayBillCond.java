package com.ihk.property.data.pojo;

import java.math.BigDecimal;
import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * UnitPayBillCond的查询条件
 * @author peter.kuang
 *
 */
public class UnitPayBillCond extends SearchCond{

	private static final long serialVersionUID = 1L;
	
	private String unitId;	
	
	private String typeName;
	
	private String feeType;
	
	//下面四个字段,主要用于修改应收款的已收,未收金额
	private int billId;
	private BigDecimal thisPay; //本次收款
	private int modId;
	private Date modTime;
	
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	
	public String getFeeType() {
		return feeType;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public int getBillId() {
		return billId;
	}
	
	public void setBillId(int billId) {
		this.billId = billId;
	}
	
	public BigDecimal getThisPay() {
		return thisPay;
	}
	
	public void setThisPay(BigDecimal thisPay) {
		this.thisPay = thisPay;
	}

	public int getModId() {
		return modId;
	}

	public void setModId(int modId) {
		this.modId = modId;
	}

	public Date getModTime() {
		return modTime;
	}

	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	
	public String getUnitId() {
		return unitId;
	}
    
}
