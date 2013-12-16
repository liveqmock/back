package com.ihk.property.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

public class CheckcommissionSec implements Serializable{
    
		private static final long serialVersionUID = -1402548530993399985L;
		private int id;
		private int unitId;
		private int checkfeeId;
		private Date checkcommissionDate;
		private int checkcommissionType;
		private BigDecimal repayMoney;
		private BigDecimal repayAmount;
		private BigDecimal commission;
		private BigDecimal commissionAmount;
		private BigDecimal secCommission;
		private BigDecimal secCommissionAmount;
		private BigDecimal relCommission;
		private BigDecimal relCommissionAmount;
		private BigDecimal paymentAmount;
		private Date commissionTime;
		private String remark;
		private String isDeleted;
		private int createdId;
		private Date createdTime;
		private int modId;
		private Date modTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
    
	public int getCheckfeeId() {
		return checkfeeId;
	}

	public void setCheckfeeId(int checkfeeId) {
		this.checkfeeId = checkfeeId;
	}
    
	public Date getCheckcommissionDate() {
		return checkcommissionDate;
	}

	public void setCheckcommissionDate(Date checkcommissionDate) {
		this.checkcommissionDate = checkcommissionDate;
	}
    
	public int getCheckcommissionType() {
		return checkcommissionType;
	}

	public void setCheckcommissionType(int checkcommissionType) {
		this.checkcommissionType = checkcommissionType;
	}
    
	public BigDecimal getRepayMoney() {
		return repayMoney;
	}

	public void setRepayMoney(BigDecimal repayMoney) {
		this.repayMoney = repayMoney;
	}
    
	public BigDecimal getRepayAmount() {
		return repayAmount;
	}

	public void setRepayAmount(BigDecimal repayAmount) {
		this.repayAmount = repayAmount;
	}
    
	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}
    
	public BigDecimal getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(BigDecimal commissionAmount) {
		this.commissionAmount = commissionAmount;
	}
    
	public BigDecimal getSecCommission() {
		return secCommission;
	}

	public void setSecCommission(BigDecimal secCommission) {
		this.secCommission = secCommission;
	}
    
	public BigDecimal getSecCommissionAmount() {
		return secCommissionAmount;
	}

	public void setSecCommissionAmount(BigDecimal secCommissionAmount) {
		this.secCommissionAmount = secCommissionAmount;
	}
    
	public BigDecimal getRelCommission() {
		return relCommission;
	}

	public void setRelCommission(BigDecimal relCommission) {
		this.relCommission = relCommission;
	}
    
	public BigDecimal getRelCommissionAmount() {
		return relCommissionAmount;
	}

	public void setRelCommissionAmount(BigDecimal relCommissionAmount) {
		this.relCommissionAmount = relCommissionAmount;
	}
    
	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
    
	public Date getCommissionTime() {
		return commissionTime;
	}

	public void setCommissionTime(Date commissionTime) {
		this.commissionTime = commissionTime;
	}
    
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
    
	public int getCreatedId() {
		return createdId;
	}

	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
    
	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
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
    
	
	public CheckcommissionSec(){};

	public CheckcommissionSec(    
		int id,
        		int unitId,
        		int checkfeeId,
        		Date checkcommissionDate,
        		int checkcommissionType,
        		BigDecimal repayMoney,
        		BigDecimal repayAmount,
        		BigDecimal commission,
        		BigDecimal commissionAmount,
        		BigDecimal secCommission,
        		BigDecimal secCommissionAmount,
        		BigDecimal relCommission,
        		BigDecimal relCommissionAmount,
        		BigDecimal paymentAmount,
        		Date commissionTime,
        		String remark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.unitId = unitId;
		this.checkfeeId = checkfeeId;
		this.checkcommissionDate = checkcommissionDate;
		this.checkcommissionType = checkcommissionType;
		this.repayMoney = repayMoney;
		this.repayAmount = repayAmount;
		this.commission = commission;
		this.commissionAmount = commissionAmount;
		this.secCommission = secCommission;
		this.secCommissionAmount = secCommissionAmount;
		this.relCommission = relCommission;
		this.relCommissionAmount = relCommissionAmount;
		this.paymentAmount = paymentAmount;
		this.commissionTime = commissionTime;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
	public CheckcommissionSec(    
		int unitId,
        		int checkfeeId,
        		Date checkcommissionDate,
        		int checkcommissionType,
        		BigDecimal repayMoney,
        		BigDecimal repayAmount,
        		BigDecimal commission,
        		BigDecimal commissionAmount,
        		BigDecimal secCommission,
        		BigDecimal secCommissionAmount,
        		BigDecimal relCommission,
        		BigDecimal relCommissionAmount,
        		BigDecimal paymentAmount,
        		Date commissionTime,
        		String remark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.unitId = unitId;
		this.checkfeeId = checkfeeId;
		this.checkcommissionDate = checkcommissionDate;
		this.checkcommissionType = checkcommissionType;
		this.repayMoney = repayMoney;
		this.repayAmount = repayAmount;
		this.commission = commission;
		this.commissionAmount = commissionAmount;
		this.secCommission = secCommission;
		this.secCommissionAmount = secCommissionAmount;
		this.relCommission = relCommission;
		this.relCommissionAmount = relCommissionAmount;
		this.paymentAmount = paymentAmount;
		this.commissionTime = commissionTime;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
}
