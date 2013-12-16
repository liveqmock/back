package com.ihk.saleunit.data.pojo;

import java.io.Serializable;
import java.util.Date;

import com.ihk.constanttype.ContProjectId;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.utils.DescUtils;

/**
 * AppointCustomer的实体类
 * @author 
 *
 */
public class AppointCustomer implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private String customerName;
	private String gender;
	private String idcardType;
	private String idcardNo;
	private String phone;
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
	 * 取得CustomerName(客户姓名)
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * 设置customerName(客户姓名)
	 * @param customerName (客户姓名)
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
    
	/**
	 * 取得Gender(性别)
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * 设置gender(性别)
	 * @param gender (性别)
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
    
	/**
	 * 取得IdcardType(证件类型)
	 */
	public String getIdcardType() {
		return idcardType;
	}

	/**
	 * 设置idcardType(证件类型)
	 * @param idcardType (证件类型)
	 */
	public void setIdcardType(String idcardType) {
		this.idcardType = idcardType;
	}
    
	/**
	 * 取得IdcardNo(证件号码)
	 */
	public String getIdcardNo() {
		return idcardNo;
	}

	/**
	 * 设置idcardNo(证件号码)
	 * @param idcardNo (证件号码)
	 */
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
    
	/**
	 * 取得Phone(电话)
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置phone(电话)
	 * @param phone (电话)
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
    
	
	public AppointCustomer(){};


	/**
	 * 
	 * @param id ()
	 * @param customerName (客户姓名)
	 * @param gender (性别)
	 * @param idcardType (证件类型)
	 * @param idcardNo (证件号码)
	 * @param phone (电话)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public AppointCustomer(    
		int id,
        		String customerName,
        		String gender,
        		String idcardType,
        		String idcardNo,
        		String phone,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.customerName = customerName;
		this.gender = gender;
		this.idcardType = idcardType;
		this.idcardNo = idcardNo;
		this.phone = phone;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param customerName (客户姓名)
	 * @param gender (性别)
	 * @param idcardType (证件类型)
	 * @param idcardNo (证件号码)
	 * @param phone (电话)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public AppointCustomer(    
		String customerName,
        		String gender,
        		String idcardType,
        		String idcardNo,
        		String phone,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.customerName = customerName;
		this.gender = gender;
		this.idcardType = idcardType;
		this.idcardNo = idcardNo;
		this.phone = phone;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	
	/////
	
	public String getIdcardTypeStr(){
		
		return DescUtils.getCodeDesc(EnumCodeTypeName.SALEUNIT_IDCARD_TYPE, this.getIdcardType(), ContProjectId.GUANG_ZHOU);
	}
	
	public String getGenderStr(){
		
		return DescUtils.getCodeDesc(EnumCodeTypeName.GENDER, this.getGender(), ContProjectId.GUANG_ZHOU);
	}
	
}
