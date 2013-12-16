package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * MortgageUnit的实体类
 * @author 
 *
 */
public class MortgageUnit implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int mortgageId;
	private int unitId;
	private BigDecimal mortgagePrice;
	private String remark;
	private String cancelNo;
	private Date cancelDate;
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
	 * 取得MortgageId(抵押合同id)
	 */
	public int getMortgageId() {
		return mortgageId;
	}

	/**
	 * 设置mortgageId(抵押合同id)
	 * @param mortgageId (抵押合同id)
	 */
	public void setMortgageId(int mortgageId) {
		this.mortgageId = mortgageId;
	}
    
	/**
	 * 取得UnitId(房间id)
	 */
	public int getUnitId() {
		return unitId;
	}

	/**
	 * 设置unitId(房间id)
	 * @param unitId (房间id)
	 */
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
    
	/**
	 * 取得MortgagePrice(抵押价格)
	 */
	public BigDecimal getMortgagePrice() {
		return mortgagePrice;
	}

	/**
	 * 设置mortgagePrice(抵押价格)
	 * @param mortgagePrice (抵押价格)
	 */
	public void setMortgagePrice(BigDecimal mortgagePrice) {
		this.mortgagePrice = mortgagePrice;
	}
    
	/**
	 * 取得Remark(备注)
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置remark(备注)
	 * @param remark (备注)
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
	/**
	 * 取得CancelNo(注销号)
	 */
	public String getCancelNo() {
		return cancelNo;
	}

	/**
	 * 设置cancelNo(注销号)
	 * @param cancelNo (注销号)
	 */
	public void setCancelNo(String cancelNo) {
		this.cancelNo = cancelNo;
	}
    
	/**
	 * 取得CancelDate(注销日期)
	 */
	public Date getCancelDate() {
		return cancelDate;
	}

	/**
	 * 设置cancelDate(注销日期)
	 * @param cancelDate (注销日期)
	 */
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
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
    
	
	public MortgageUnit(){};


	/**
	 * 
	 * @param id ()
	 * @param mortgageId (抵押合同id)
	 * @param unitId (房间id)
	 * @param mortgagePrice (抵押价格)
	 * @param remark (备注)
	 * @param cancelNo (注销号)
	 * @param cancelDate (注销日期)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public MortgageUnit(    
		int id,
        		int mortgageId,
        		int unitId,
        		BigDecimal mortgagePrice,
        		String remark,
        		String cancelNo,
        		Date cancelDate,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.mortgageId = mortgageId;
		this.unitId = unitId;
		this.mortgagePrice = mortgagePrice;
		this.remark = remark;
		this.cancelNo = cancelNo;
		this.cancelDate = cancelDate;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param mortgageId (抵押合同id)
	 * @param unitId (房间id)
	 * @param mortgagePrice (抵押价格)
	 * @param remark (备注)
	 * @param cancelNo (注销号)
	 * @param cancelDate (注销日期)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public MortgageUnit(    
		int mortgageId,
        		int unitId,
        		BigDecimal mortgagePrice,
        		String remark,
        		String cancelNo,
        		Date cancelDate,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.mortgageId = mortgageId;
		this.unitId = unitId;
		this.mortgagePrice = mortgagePrice;
		this.remark = remark;
		this.cancelNo = cancelNo;
		this.cancelDate = cancelDate;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
