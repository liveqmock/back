package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.util.Map;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.constanttype.SaleUnitLogCode;
import com.ihk.utils.DescUtils;

/**
 * SaleUnitLog的实体类
 * @author 
 *
 */
public class SaleUnitLog implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int unitId;
	private String type;
	private String mainClass;
	private int mainId;
	private int conCustomerId;
	private int userId;
	private String mark;
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
	 * 取得UnitId(单元ID;)
	 */
	public int getUnitId() {
		return unitId;
	}

	/**
	 * 设置unitId(单元ID;)
	 * @param unitId (单元ID;)
	 */
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
    
	/**
	 * 取得Type(修改类型;)
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置type(修改类型;)
	 * @param type (修改类型;)
	 */
	public void setType(String type) {
		this.type = type;
	}
    
	/**
	 * 取得MainClass(修改种类;)
	 */
	public String getMainClass() {
		return mainClass;
	}

	/**
	 * 设置mainClass(修改种类;)
	 * @param mainClass (修改种类;)
	 */
	public void setMainClass(String mainClass) {
		this.mainClass = mainClass;
	}
    
	/**
	 * 取得MainId(主ID;)
	 */
	public int getMainId() {
		return mainId;
	}

	/**
	 * 设置mainId(主ID;)
	 * @param mainId (主ID;)
	 */
	public void setMainId(int mainId) {
		this.mainId = mainId;
	}
    
	/**
	 * 取得ConCustomerId(客户ID;)
	 */
	public int getConCustomerId() {
		return conCustomerId;
	}

	/**
	 * 设置conCustomerId(客户ID;)
	 * @param conCustomerId (客户ID;)
	 */
	public void setConCustomerId(int conCustomerId) {
		this.conCustomerId = conCustomerId;
	}
    
	/**
	 * 取得UserId(业务员)
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * 设置userId(业务员)
	 * @param userId (业务员)
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
    
	/**
	 * 取得Mark(备注;)
	 */
	public String getMark() {
		return mark;
	}

	/**
	 * 设置mark(备注;)
	 * @param mark (备注;)
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}
    
	/**
	 * 取得IsDeleted(是否删除;)
	 */
	public String getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 设置isDeleted(是否删除;)
	 * @param isDeleted (是否删除;)
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
    
	/**
	 * 取得CreatedId(创建人;)
	 */
	public int getCreatedId() {
		return createdId;
	}

	/**
	 * 设置createdId(创建人;)
	 * @param createdId (创建人;)
	 */
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
    
	/**
	 * 取得CreatedTime(创建时间;)
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * 设置createdTime(创建时间;)
	 * @param createdTime (创建时间;)
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
    
	/**
	 * 取得ModId(修改人;)
	 */
	public int getModId() {
		return modId;
	}

	/**
	 * 设置modId(修改人;)
	 * @param modId (修改人;)
	 */
	public void setModId(int modId) {
		this.modId = modId;
	}
    
	/**
	 * 取得ModTime(修改时间;)
	 */
	public Date getModTime() {
		return modTime;
	}

	/**
	 * 设置modTime(修改时间;)
	 * @param modTime (修改时间;)
	 */
	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}
    
	
	public SaleUnitLog(){};


	/**
	 * 
	 * @param id ()
	 * @param unitId (单元ID;)
	 * @param type (修改类型;)
	 * @param mainClass (修改种类;)
	 * @param mainId (主ID;)
	 * @param conCustomerId (客户ID;)
	 * @param userId (业务员)
	 * @param mark (备注;)
	 * @param isDeleted (是否删除;)
	 * @param createdId (创建人;)
	 * @param createdTime (创建时间;)
	 * @param modId (修改人;)
	 * @param modTime (修改时间;)
	 */
	public SaleUnitLog(    
		int id,
        		int unitId,
        		String type,
        		String mainClass,
        		int mainId,
        		int conCustomerId,
        		int userId,
        		String mark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.unitId = unitId;
		this.type = type;
		this.mainClass = mainClass;
		this.mainId = mainId;
		this.conCustomerId = conCustomerId;
		this.userId = userId;
		this.mark = mark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param unitId (单元ID;)
	 * @param type (修改类型;)
	 * @param mainClass (修改种类;)
	 * @param mainId (主ID;)
	 * @param conCustomerId (客户ID;)
	 * @param userId (业务员)
	 * @param mark (备注;)
	 * @param isDeleted (是否删除;)
	 * @param createdId (创建人;)
	 * @param createdTime (创建时间;)
	 * @param modId (修改人;)
	 * @param modTime (修改时间;)
	 */
	public SaleUnitLog(    
		int unitId,
        		String type,
        		String mainClass,
        		int mainId,
        		int conCustomerId,
        		int userId,
        		String mark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.unitId = unitId;
		this.type = type;
		this.mainClass = mainClass;
		this.mainId = mainId;
		this.conCustomerId = conCustomerId;
		this.userId = userId;
		this.mark = mark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	
	////////////
	public String getUserIdStr(){
		String uname =  DescUtils.getUserRealName(this.getUserId());
		return uname;
	}
	
	public String getMainClassStr() {
		String hh = SaleUnitLogCode.getMainClassMap().get(this.mainClass);
		return hh;
	}
	
	public String getTypeStr(){
		String hh = SaleUnitLogCode.getTypeMap().get(this.type);
		return hh;
	}
}
