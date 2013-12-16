package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * PropertyOwner的实体类
 * @author 
 *
 */
public class PropertyOwner implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private String confirmType;
	private int mainId;
	private String customerName;
	private String idcardNo;
	private String phone;
	private BigDecimal rightPercent;
	private String agentName;
	private String agentNation;
	private String cardNum;
	private String agentPhone;
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
	 * 取得ConfirmType(认购或合同)
	 */
	public String getConfirmType() {
		return confirmType;
	}

	/**
	 * 设置confirmType(认购或合同)
	 * @param confirmType (认购或合同)
	 */
	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
    
	/**
	 * 取得MainId(主单id)
	 */
	public int getMainId() {
		return mainId;
	}

	/**
	 * 设置mainId(主单id)
	 * @param mainId (主单id)
	 */
	public void setMainId(int mainId) {
		this.mainId = mainId;
	}
    
	/**
	 * 取得CustomerName(客户名称)
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * 设置customerName(客户名称)
	 * @param customerName (客户名称)
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	 * 取得Phone(联系电话)
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置phone(联系电话)
	 * @param phone (联系电话)
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
	/**
	 * 取得RightPercent(产权比例)
	 */
	public BigDecimal getRightPercent() {
		return rightPercent;
	}

	/**
	 * 设置rightPercent(产权比例)
	 * @param rightPercent (产权比例)
	 */
	public void setRightPercent(BigDecimal rightPercent) {
		this.rightPercent = rightPercent;
	}
    
	/**
	 * 取得AgentName(代理人姓名)
	 */
	public String getAgentName() {
		return agentName;
	}

	/**
	 * 设置agentName(代理人姓名)
	 * @param agentName (代理人姓名)
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
    
	/**
	 * 取得AgentNation(代理人国籍)
	 */
	public String getAgentNation() {
		return agentNation;
	}

	/**
	 * 设置agentNation(代理人国籍)
	 * @param agentNation (代理人国籍)
	 */
	public void setAgentNation(String agentNation) {
		this.agentNation = agentNation;
	}
    
	/**
	 * 取得CardNum(代理人证件号码)
	 */
	public String getCardNum() {
		return cardNum;
	}

	/**
	 * 设置cardNum(代理人证件号码)
	 * @param cardNum (代理人证件号码)
	 */
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
    
	/**
	 * 取得AgentPhone(代理人电话)
	 */
	public String getAgentPhone() {
		return agentPhone;
	}

	/**
	 * 设置agentPhone(代理人电话)
	 * @param agentPhone (代理人电话)
	 */
	public void setAgentPhone(String agentPhone) {
		this.agentPhone = agentPhone;
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
    
	
	public PropertyOwner(){};


	/**
	 * 
	 * @param id ()
	 * @param confirmType (认购或合同)
	 * @param mainId (主单id)
	 * @param customerName (客户名称)
	 * @param idcardNo (证件号码)
	 * @param phone (联系电话)
	 * @param rightPercent (产权比例)
	 * @param agentName (代理人姓名)
	 * @param agentNation (代理人国籍)
	 * @param cardNum (代理人证件号码)
	 * @param agentPhone (代理人电话)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public PropertyOwner(    
		int id,
        		String confirmType,
        		int mainId,
        		String customerName,
        		String idcardNo,
        		String phone,
        		BigDecimal rightPercent,
        		String agentName,
        		String agentNation,
        		String cardNum,
        		String agentPhone,
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
		this.customerName = customerName;
		this.idcardNo = idcardNo;
		this.phone = phone;
		this.rightPercent = rightPercent;
		this.agentName = agentName;
		this.agentNation = agentNation;
		this.cardNum = cardNum;
		this.agentPhone = agentPhone;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param confirmType (认购或合同)
	 * @param mainId (主单id)
	 * @param customerName (客户名称)
	 * @param idcardNo (证件号码)
	 * @param phone (联系电话)
	 * @param rightPercent (产权比例)
	 * @param agentName (代理人姓名)
	 * @param agentNation (代理人国籍)
	 * @param cardNum (代理人证件号码)
	 * @param agentPhone (代理人电话)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public PropertyOwner(    
		String confirmType,
        		int mainId,
        		String customerName,
        		String idcardNo,
        		String phone,
        		BigDecimal rightPercent,
        		String agentName,
        		String agentNation,
        		String cardNum,
        		String agentPhone,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.confirmType = confirmType;
		this.mainId = mainId;
		this.customerName = customerName;
		this.idcardNo = idcardNo;
		this.phone = phone;
		this.rightPercent = rightPercent;
		this.agentName = agentName;
		this.agentNation = agentNation;
		this.cardNum = cardNum;
		this.agentPhone = agentPhone;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
