package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.utils.saleunit.MyPropertyUtils;

public class OtherExpenses implements Serializable{
	private static final long serialVersionUID = 1L;
    
		private int id;
		private int projectId;
		private String expensesName;
		private BigDecimal expensesMoney;
		private String remark;
		private int enterId;
		private Date enterTime;
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
    
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
    
	public String getExpensesName() {
		return expensesName;
	}

	public void setExpensesName(String expensesName) {
		this.expensesName = expensesName;
	}
    
	public BigDecimal getExpensesMoney() {
		return expensesMoney;
	}

	public void setExpensesMoney(BigDecimal expensesMoney) {
		this.expensesMoney = expensesMoney;
	}
    
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
	public int getEnterId() {
		return enterId;
	}

	public void setEnterId(int enterId) {
		this.enterId = enterId;
	}
    
	public Date getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(Date enterTime) {
		this.enterTime = enterTime;
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
    
	
	public OtherExpenses(){};

	public OtherExpenses(    
		int id,
        		int projectId,
        		String expensesName,
        		BigDecimal expensesMoney,
        		String remark,
        		int enterId,
        		Date enterTime,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.projectId = projectId;
		this.expensesName = expensesName;
		this.expensesMoney = expensesMoney;
		this.remark = remark;
		this.enterId = enterId;
		this.enterTime = enterTime;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
	public OtherExpenses(    
		int projectId,
        		String expensesName,
        		BigDecimal expensesMoney,
        		String remark,
        		int enterId,
        		Date enterTime,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.projectId = projectId;
		this.expensesName = expensesName;
		this.expensesMoney = expensesMoney;
		this.remark = remark;
		this.enterId = enterId;
		this.enterTime = enterTime;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
	
	////
	public String getPropertyName(){
		
		try{
			return MyPropertyUtils.getPropertyProjectServices().findPropertyProjectById(this.getProjectId()).getPropertyName();
		}catch (Exception e) {
			return "";
		}
	}
	
}
