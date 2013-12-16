package com.ihk.user.data.pojo;

import java.io.Serializable;
import java.sql.Date;

/**
 * Company的实体类
 * @author 
 *
 */
public class Company implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private String companyName;
	private int parentId;
	private String devCode;
	private int orderIndex;
	private String isCrm;
	private String isSale;
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
	 * 取得CompanyName()
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 设置companyName()
	 * @param companyName ()
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
    
	/**
	 * 取得ParentId()
	 */
	public int getParentId() {
		return parentId;
	}

	/**
	 * 设置parentId()
	 * @param parentId ()
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
    
	/**
	 * 取得DevCode(开发代号)
	 */
	public String getDevCode() {
		return devCode;
	}

	/**
	 * 设置devCode(开发代号)
	 * @param devCode (开发代号)
	 */
	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}
    
	/**
	 * 取得OrderIndex(顺序)
	 */
	public int getOrderIndex() {
		return orderIndex;
	}

	/**
	 * 设置orderIndex(顺序)
	 * @param orderIndex (顺序)
	 */
	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}
    
	/**
	 * 取得IsCrm(是否具有crm功能)
	 */
	public String getIsCrm() {
		return isCrm;
	}

	/**
	 * 设置isCrm(是否具有crm功能)
	 * @param isCrm (是否具有crm功能)
	 */
	public void setIsCrm(String isCrm) {
		this.isCrm = isCrm;
	}
    
	/**
	 * 取得IsSale(是否具有销售监控功能)
	 */
	public String getIsSale() {
		return isSale;
	}

	/**
	 * 设置isSale(是否具有销售监控功能)
	 * @param isSale (是否具有销售监控功能)
	 */
	public void setIsSale(String isSale) {
		this.isSale = isSale;
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
    
	
	public Company(){};


	/**
	 * 
	 * @param id ()
	 * @param companyName ()
	 * @param parentId ()
	 * @param devCode (开发代号)
	 * @param orderIndex (顺序)
	 * @param isCrm (是否具有crm功能)
	 * @param isSale (是否具有销售监控功能)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public Company(    
		int id,
        		String companyName,
        		int parentId,
        		String devCode,
        		int orderIndex,
        		String isCrm,
        		String isSale,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.companyName = companyName;
		this.parentId = parentId;
		this.devCode = devCode;
		this.orderIndex = orderIndex;
		this.isCrm = isCrm;
		this.isSale = isSale;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param companyName ()
	 * @param parentId ()
	 * @param devCode (开发代号)
	 * @param orderIndex (顺序)
	 * @param isCrm (是否具有crm功能)
	 * @param isSale (是否具有销售监控功能)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public Company(    
		String companyName,
        		int parentId,
        		String devCode,
        		int orderIndex,
        		String isCrm,
        		String isSale,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.companyName = companyName;
		this.parentId = parentId;
		this.devCode = devCode;
		this.orderIndex = orderIndex;
		this.isCrm = isCrm;
		this.isSale = isSale;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Company)){
			
			return false;
		}
		
		Company tmp = (Company) obj;
		
		if(this.getId() == tmp.getId())
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.getId();
	}
    
}
