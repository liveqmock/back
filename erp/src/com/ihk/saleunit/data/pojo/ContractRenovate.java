package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.constanttype.ContProjectId;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.utils.DescUtils;

/**
 * ContractRenovate的实体类
 * @author 
 *
 */
public class ContractRenovate implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int contractId;
	private Date payDate;
	private String payType;
	private String payName;
	private BigDecimal payMoney;
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
	 * 取得ContractId(合同id)
	 */
	public int getContractId() {
		return contractId;
	}

	/**
	 * 设置contractId(合同id)
	 * @param contractId (合同id)
	 */
	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
    
	/**
	 * 取得PayDate(应收日期)
	 */
	public Date getPayDate() {
		return payDate;
	}

	/**
	 * 设置payDate(应收日期)
	 * @param payDate (应收日期)
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
    
	/**
	 * 取得PayType(款项类型)
	 */
	public String getPayType() {
		return payType;
	}

	/**
	 * 设置payType(款项类型)
	 * @param payType (款项类型)
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
    
	/**
	 * 取得PayName(款项名称)
	 */
	public String getPayName() {
		return payName;
	}

	/**
	 * 设置payName(款项名称)
	 * @param payName (款项名称)
	 */
	public void setPayName(String payName) {
		this.payName = payName;
	}
    
	/**
	 * 取得PayMoney(金额)
	 */
	public BigDecimal getPayMoney() {
		return payMoney;
	}

	/**
	 * 设置payMoney(金额)
	 * @param payMoney (金额)
	 */
	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
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
    
	
	public ContractRenovate(){};


	/**
	 * 
	 * @param id ()
	 * @param contractId (合同id)
	 * @param payDate (应收日期)
	 * @param payType (款项类型)
	 * @param payName (款项名称)
	 * @param payMoney (金额)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ContractRenovate(    
		int id,
        		int contractId,
        		Date payDate,
        		String payType,
        		String payName,
        		BigDecimal payMoney,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.contractId = contractId;
		this.payDate = payDate;
		this.payType = payType;
		this.payName = payName;
		this.payMoney = payMoney;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param contractId (合同id)
	 * @param payDate (应收日期)
	 * @param payType (款项类型)
	 * @param payName (款项名称)
	 * @param payMoney (金额)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ContractRenovate(    
		int contractId,
        		Date payDate,
        		String payType,
        		String payName,
        		BigDecimal payMoney,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.contractId = contractId;
		this.payDate = payDate;
		this.payType = payType;
		this.payName = payName;
		this.payMoney = payMoney;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	
	public String getPayTypeStr(){
		
		return DescUtils.getCodeDesc(EnumCodeTypeName.SALEUNIT_PAY_TYPE, this.getPayType(), ContProjectId.GUANG_ZHOU);
	}
}
