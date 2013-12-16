package com.ihk.property.data.pojo;

import java.io.Serializable;
import java.util.Date;

public class CheckcommissionListSec implements Serializable{
    
		private static final long serialVersionUID = 6277866736420662058L;
		private int id;
		private int propertyProjectId;
		private Date checkcommissionDate;
		private int repayType;
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
    
	public int getPropertyProjectId() {
		return propertyProjectId;
	}

	public void setPropertyProjectId(int propertyProjectId) {
		this.propertyProjectId = propertyProjectId;
	}
    
	public Date getCheckcommissionDate() {
		return checkcommissionDate;
	}

	public void setCheckcommissionDate(Date checkcommissionDate) {
		this.checkcommissionDate = checkcommissionDate;
	}
    
	public int getRepayType() {
		return repayType;
	}

	public void setRepayType(int repayType) {
		this.repayType = repayType;
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
    
	
	public CheckcommissionListSec(){};

	public CheckcommissionListSec(    
		int id,
        		int propertyProjectId,
        		Date checkcommissionDate,
        		int repayType,
        		String remark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.propertyProjectId = propertyProjectId;
		this.checkcommissionDate = checkcommissionDate;
		this.repayType = repayType;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
	public CheckcommissionListSec(    
		int propertyProjectId,
        		Date checkcommissionDate,
        		int repayType,
        		String remark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.propertyProjectId = propertyProjectId;
		this.checkcommissionDate = checkcommissionDate;
		this.repayType = repayType;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
}
