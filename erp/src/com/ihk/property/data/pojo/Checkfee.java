package com.ihk.property.data.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Checkfee的实体类
 * @author 
 * 
 */
public class Checkfee implements Serializable{
	
	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private static final long serialVersionUID = -6557704496805551085L;
	
	private int id;
	private int unitId;
	private Date checkfeeDate;
	private int checkfeeType;
	private int checkcommissionType;
	private BigDecimal repayMoney;
	private BigDecimal repayAmount;
	private String remark;
	private String isDeleted;
	private int createdId;
	private Date createdTime;
	private int modId;
	private Date modTime;

	private Integer isSecCheck;
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
	 * 取得UnitId()
	 */
	public int getUnitId() {
		return unitId;
	}

	/**
	 * 设置unitId()
	 * @param unitId ()
	 */
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
    
	/**
	 * 取得CheckfeeDate()
	 */
	public Date getCheckfeeDate() {
		return checkfeeDate;
	}

	/**
	 * 设置checkfeeDate()
	 * @param checkfeeDate ()
	 */
	public void setCheckfeeDate(Date checkfeeDate) {
		this.checkfeeDate = checkfeeDate;
	}
    
	/**
	 * 取得CheckfeeType()
	 */
	public int getCheckfeeType() {
		return checkfeeType;
	}

	/**
	 * 设置checkfeeType()
	 * @param checkfeeType ()
	 */
	public void setCheckfeeType(int checkfeeType) {
		this.checkfeeType = checkfeeType;
	}

	/**
	 * 取得CheckcommissionType()
	 */
	public int getCheckcommissionType() {
		return checkcommissionType;
	}

	/**
	 * 设置checkcommissionType()
	 * @param checkcommissionType ()
	 */
	public void setCheckcommissionType(int checkcommissionType) {
		this.checkcommissionType = checkcommissionType;
	}

	/**
	 * 取得RepayMoney()
	 */
	public BigDecimal getRepayMoney() {
		return repayMoney;
	}

	/**
	 * 设置repayMoney()
	 * @param repayMoney ()
	 */
	public void setRepayMoney(BigDecimal repayMoney) {
		this.repayMoney = repayMoney;
	}
    
	/**
	 * 取得RepayAmount()
	 */
	public BigDecimal getRepayAmount() {
		return repayAmount;
	}

	/**
	 * 设置repayAmount()
	 * @param repayAmount ()
	 */
	public void setRepayAmount(BigDecimal repayAmount) {
		this.repayAmount = repayAmount;
	}
    
	/**
	 * 取得Remark()
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置remark()
	 * @param remark ()
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
	/**
	 * 取得IsDeleted()
	 */
	public String getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 设置isDeleted()
	 * @param isDeleted ()
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
    
	/**
	 * 取得CreatedId()
	 */
	public int getCreatedId() {
		return createdId;
	}

	/**
	 * 设置createdId()
	 * @param createdId ()
	 */
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
    
	/**
	 * 取得CreatedTime()
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * 设置createdTime()
	 * @param createdTime ()
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
    
	/**
	 * 取得ModId()
	 */
	public int getModId() {
		return modId;
	}

	/**
	 * 设置modId()
	 * @param modId ()
	 */
	public void setModId(int modId) {
		this.modId = modId;
	}
    
	/**
	 * 取得ModTime()
	 */
	public Date getModTime() {
		return modTime;
	}

	/**
	 * 设置modTime()
	 * @param modTime ()
	 */
	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}
    
	
	public Checkfee(){}


	/**
	 * 
	 * @param id ()
	 * @param unitId ()
	 * @param checkfeeDate ()
	 * @param checkfeeType ()
	 * @param checkcommissionType ()
	 * @param repayMoney ()
	 * @param repayAmount ()
	 * @param remark ()
	 * @param isDeleted ()
	 * @param createdId ()
	 * @param createdTime ()
	 * @param modId ()
	 * @param modTime ()
	 */
	public Checkfee(    
		int id,
        		int unitId,
        		Date checkfeeDate,
        		int checkfeeType,
        		int checkcommissionType,
        		BigDecimal repayMoney,
        		BigDecimal repayAmount,
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
		this.checkfeeDate = checkfeeDate;
		this.checkfeeType = checkfeeType;
		this.checkcommissionType = checkcommissionType;
		this.repayMoney = repayMoney;
		this.repayAmount = repayAmount;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param unitId ()
	 * @param checkfeeDate ()
	 * @param checkfeeType ()
	 * @param checkcommissionType ()
	 * @param repayMoney ()
	 * @param repayAmount ()
	 * @param remark ()
	 * @param isDeleted ()
	 * @param createdId ()
	 * @param createdTime ()
	 * @param modId ()
	 * @param modTime ()
	 */
	public Checkfee(    
		int unitId,
        		Date checkfeeDate,
        		int checkfeeType,
        		int checkcommissionType,
        		BigDecimal repayMoney,
        		BigDecimal repayAmount,
        		String remark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.unitId = unitId;
		this.checkfeeDate = checkfeeDate;
		this.checkfeeType = checkfeeType;
		this.checkcommissionType = checkcommissionType;
		this.repayMoney = repayMoney;
		this.repayAmount = repayAmount;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}

	public Integer getIsSecCheck() {
		return isSecCheck;
	}

	public void setIsSecCheck(Integer isSecCheck) {
		this.isSecCheck = isSecCheck;
	}



    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
