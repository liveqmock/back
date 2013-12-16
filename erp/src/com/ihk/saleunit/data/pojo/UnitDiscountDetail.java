package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * UnitDiscountDetail的实体类
 * @author 
 *
 */
public class UnitDiscountDetail implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int discountId;
	private String discountType;
	private BigDecimal discountPercent;
	private String remark;
	private String isDeleted;
	private int createdId;
	private Date createdTime;
	private int modId;
	private Date modTime;

	/**
	 * 取得Id()
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置id()
	 * @param id ()
	 */
	public void setId(int id) {
		this.id = id;
	}
    
	/**
	 * 取得DiscountId(折扣id)
	 */
	public int getDiscountId() {
		return discountId;
	}

	/**
	 * 设置discountId(折扣id)
	 * @param discountId (折扣id)
	 */
	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}
    
	/**
	 * 取得DiscountType(折扣类型)
	 */
	public String getDiscountType() {
		return discountType;
	}

	/**
	 * 设置discountType(折扣类型)
	 * @param discountType (折扣类型)
	 */
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
    
	/**
	 * 取得DiscountPercent(折扣百分比)
	 */
	public BigDecimal getDiscountPercent() {
		return discountPercent;
	}

	/**
	 * 设置discountPercent(折扣百分比)
	 * @param discountPercent (折扣百分比)
	 */
	public void setDiscountPercent(BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}
    
	/**
	 * 取得Remark(说明)
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置remark(说明)
	 * @param remark (说明)
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
	/**
	 * 取得IsDeleted(是否删除)
	 */
	public String getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 设置isDeleted(是否删除)
	 * @param isDeleted (是否删除)
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
    
	/**
	 * 取得CreatedId(创建人)
	 */
	public int getCreatedId() {
		return createdId;
	}

	/**
	 * 设置createdId(创建人)
	 * @param createdId (创建人)
	 */
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
    
	/**
	 * 取得CreatedTime(创建时间)
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * 设置createdTime(创建时间)
	 * @param createdTime (创建时间)
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
    
	/**
	 * 取得ModId(修改人)
	 */
	public int getModId() {
		return modId;
	}

	/**
	 * 设置modId(修改人)
	 * @param modId (修改人)
	 */
	public void setModId(int modId) {
		this.modId = modId;
	}
    
	/**
	 * 取得ModTime(修改时间)
	 */
	public Date getModTime() {
		return modTime;
	}

	/**
	 * 设置modTime(修改时间)
	 * @param modTime (修改时间)
	 */
	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}
    
	
	public UnitDiscountDetail(){};


	/**
	 * 
	 * @param id ()
	 * @param discountId (折扣id)
	 * @param discountType (折扣类型)
	 * @param discountPercent (折扣百分比)
	 * @param remark (说明)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public UnitDiscountDetail(    
		int id,
        		int discountId,
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
		this.discountId = discountId;
		this.discountType = discountType;
		this.discountPercent = discountPercent;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param discountId (折扣id)
	 * @param discountType (折扣类型)
	 * @param discountPercent (折扣百分比)
	 * @param remark (说明)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public UnitDiscountDetail(    
		int discountId,
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
		this.discountId = discountId;
		this.discountType = discountType;
		this.discountPercent = discountPercent;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
