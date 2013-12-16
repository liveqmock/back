package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * ContractSalesman的实体类
 * @author 
 * 
 */
public class ContractSalesman implements Serializable{
	
    
	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
	private static final long serialVersionUID = 7196411844929392984L;
	
	private int id;
	private String confirmType;
	private int mainId;
	private int salesId;
	private BigDecimal salesPercent;
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
	 * 取得ConfirmType(成交类型)
	 */
	public String getConfirmType() {
		return confirmType;
	}

	/**
	 * 设置confirmType(成交类型)
	 * @param confirmType (成交类型)
	 */
	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
    
	/**
	 * 取得MainId(对应类型的表的id)
	 */
	public int getMainId() {
		return mainId;
	}

	/**
	 * 设置mainId(对应类型的表的id)
	 * @param mainId (对应类型的表的id)
	 */
	public void setMainId(int mainId) {
		this.mainId = mainId;
	}
    
	/**
	 * 取得SalesId(业务员)
	 */
	public int getSalesId() {
		return salesId;
	}

	/**
	 * 设置salesId(业务员)
	 * @param salesId (业务员)
	 */
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
    
	/**
	 * 取得SalesPercent(销售业绩比例)
	 */
	public BigDecimal getSalesPercent() {
		return salesPercent;
	}

	/**
	 * 设置salesPercent(销售业绩比例)
	 * @param salesPercent (销售业绩比例)
	 */
	public void setSalesPercent(BigDecimal salesPercent) {
		this.salesPercent = salesPercent;
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
    
	
	public ContractSalesman(){};


	/**
	 * 
	 * @param id ()
	 * @param confirmType (成交类型)
	 * @param mainId (对应类型的表的id)
	 * @param salesId (业务员)
	 * @param salesPercent (销售业绩比例)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ContractSalesman(    
		int id,
        		String confirmType,
        		int mainId,
        		int salesId,
        		BigDecimal salesPercent,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.confirmType = confirmType;
		this.mainId = mainId;
		this.salesId = salesId;
		this.salesPercent = salesPercent;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param confirmType (成交类型)
	 * @param mainId (对应类型的表的id)
	 * @param salesId (业务员)
	 * @param salesPercent (销售业绩比例)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ContractSalesman(    
		String confirmType,
        		int mainId,
        		int salesId,
        		BigDecimal salesPercent,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.confirmType = confirmType;
		this.mainId = mainId;
		this.salesId = salesId;
		this.salesPercent = salesPercent;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
