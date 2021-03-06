package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * ContractRecordDetail的实体类
 * @author 
 *
 */
public class ContractRecordDetail implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private String recordId;
	private Date handoverDate;
	private String handoverUser;
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
	 * 取得RecordId(记录id)
	 */
	public String getRecordId() {
		return recordId;
	}

	/**
	 * 设置recordId(记录id)
	 * @param recordId (记录id)
	 */
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
    
	/**
	 * 取得HandoverDate(交接日期)
	 */
	public Date getHandoverDate() {
		return handoverDate;
	}

	/**
	 * 设置handoverDate(交接日期)
	 * @param handoverDate (交接日期)
	 */
	public void setHandoverDate(Date handoverDate) {
		this.handoverDate = handoverDate;
	}
    
	/**
	 * 取得HandoverUser(交接人)
	 */
	public String getHandoverUser() {
		return handoverUser;
	}

	/**
	 * 设置handoverUser(交接人)
	 * @param handoverUser (交接人)
	 */
	public void setHandoverUser(String handoverUser) {
		this.handoverUser = handoverUser;
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
    
	
	public ContractRecordDetail(){};


	/**
	 * 
	 * @param id ()
	 * @param recordId (记录id)
	 * @param handoverDate (交接日期)
	 * @param handoverUser (交接人)
	 * @param remark (备注)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ContractRecordDetail(    
		int id,
        		String recordId,
        		Date handoverDate,
        		String handoverUser,
        		String remark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.recordId = recordId;
		this.handoverDate = handoverDate;
		this.handoverUser = handoverUser;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param recordId (记录id)
	 * @param handoverDate (交接日期)
	 * @param handoverUser (交接人)
	 * @param remark (备注)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ContractRecordDetail(    
		String recordId,
        		Date handoverDate,
        		String handoverUser,
        		String remark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.recordId = recordId;
		this.handoverDate = handoverDate;
		this.handoverUser = handoverUser;
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
