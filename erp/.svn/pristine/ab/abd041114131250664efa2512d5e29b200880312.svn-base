package com.ihk.property.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.constanttype.ContProjectId;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.utils.DescUtils;

public class ProjectDiscount implements Serializable{
	private static final long serialVersionUID = 1L;
    
		private int id;
		private int payWayId;
		private String discountType;
		private BigDecimal discountPercent;
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
    
	public int getPayWayId() {
		return payWayId;
	}
	
	public void setPayWayId(int payWayId) {
		this.payWayId = payWayId;
	}
    
	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
    
	public BigDecimal getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
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
    
	
	public ProjectDiscount(){};

	public ProjectDiscount(    
		int id,
        		int payWayId,
        		String discountType,
        		BigDecimal discountPercent,
        		String remark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.payWayId = payWayId;
		this.discountType = discountType;
		this.discountPercent = discountPercent;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
	public ProjectDiscount(    
		int payWayId,
        		String discountType,
        		BigDecimal discountPercent,
        		String remark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.payWayId = payWayId;
		this.discountType = discountType;
		this.discountPercent = discountPercent;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
	
	
	//////////
	public String getDescDiscountType(){
		return DescUtils.getCodeDesc(EnumCodeTypeName.SALEUNIT_DISCOUNT_TYPE, this.getDiscountType(), ContProjectId.GUANG_ZHOU);
	}
}
