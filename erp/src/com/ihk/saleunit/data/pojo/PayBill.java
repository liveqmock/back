package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * PayBill的实体类
 * @author 
 *
 */
public class PayBill implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private String confirmType;
	private int mainId;
	private Date startSaleDate;
	private String billType;
	private String paperType;
	private String billNo;
	private BigDecimal payMoney;
	private String payMan;
	private int writerId;
	private Date approvalDate;
	private String state;
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
	 * 取得StartSaleDate(开盘日期)
	 */
	public Date getStartSaleDate() {
		return startSaleDate;
	}

	/**
	 * 设置startSaleDate(开盘日期)
	 * @param startSaleDate (开盘日期)
	 */
	public void setStartSaleDate(Date startSaleDate) {
		this.startSaleDate = startSaleDate;
	}
    
	/**
	 * 取得BillType(单据类型)
	 */
	public String getBillType() {
		return billType;
	}

	/**
	 * 设置billType(单据类型)
	 * @param billType (单据类型)
	 */
	public void setBillType(String billType) {
		this.billType = billType;
	}
    
	/**
	 * 取得PaperType(票据类型)
	 */
	public String getPaperType() {
		return paperType;
	}

	/**
	 * 设置paperType(票据类型)
	 * @param paperType (票据类型)
	 */
	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}
    
	/**
	 * 取得BillNo(票据编号)
	 */
	public String getBillNo() {
		return billNo;
	}

	/**
	 * 设置billNo(票据编号)
	 * @param billNo (票据编号)
	 */
	public void setBillNo(String billNo) {
		this.billNo = billNo;
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
	 * 取得PayMan(交款人)
	 */
	public String getPayMan() {
		return payMan;
	}

	/**
	 * 设置payMan(交款人)
	 * @param payMan (交款人)
	 */
	public void setPayMan(String payMan) {
		this.payMan = payMan;
	}
    
	/**
	 * 取得WriterId(开票人id)
	 */
	public int getWriterId() {
		return writerId;
	}

	/**
	 * 设置writerId(开票人id)
	 * @param writerId (开票人id)
	 */
	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}
    
	/**
	 * 取得ApprovalDate(审核日期)
	 */
	public Date getApprovalDate() {
		return approvalDate;
	}

	/**
	 * 设置approvalDate(审核日期)
	 * @param approvalDate (审核日期)
	 */
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}
    
	/**
	 * 取得State(状态)
	 */
	public String getState() {
		return state;
	}

	/**
	 * 设置state(状态)
	 * @param state (状态)
	 */
	public void setState(String state) {
		this.state = state;
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
    
	
	public PayBill(){};


	/**
	 * 
	 * @param id ()
	 * @param confirmType (认购或合同)
	 * @param mainId (主单id)
	 * @param startSaleDate (开盘日期)
	 * @param billType (单据类型)
	 * @param paperType (票据类型)
	 * @param billNo (票据编号)
	 * @param payMoney (金额)
	 * @param payMan (交款人)
	 * @param writerId (开票人id)
	 * @param approvalDate (审核日期)
	 * @param state (状态)
	 * @param remark (备注)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public PayBill(    
		int id,
        		String confirmType,
        		int mainId,
        		Date startSaleDate,
        		String billType,
        		String paperType,
        		String billNo,
        		BigDecimal payMoney,
        		String payMan,
        		int writerId,
        		Date approvalDate,
        		String state,
        		String remark,
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
		this.startSaleDate = startSaleDate;
		this.billType = billType;
		this.paperType = paperType;
		this.billNo = billNo;
		this.payMoney = payMoney;
		this.payMan = payMan;
		this.writerId = writerId;
		this.approvalDate = approvalDate;
		this.state = state;
		this.remark = remark;
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
	 * @param startSaleDate (开盘日期)
	 * @param billType (单据类型)
	 * @param paperType (票据类型)
	 * @param billNo (票据编号)
	 * @param payMoney (金额)
	 * @param payMan (交款人)
	 * @param writerId (开票人id)
	 * @param approvalDate (审核日期)
	 * @param state (状态)
	 * @param remark (备注)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public PayBill(    
		String confirmType,
        		int mainId,
        		Date startSaleDate,
        		String billType,
        		String paperType,
        		String billNo,
        		BigDecimal payMoney,
        		String payMan,
        		int writerId,
        		Date approvalDate,
        		String state,
        		String remark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.confirmType = confirmType;
		this.mainId = mainId;
		this.startSaleDate = startSaleDate;
		this.billType = billType;
		this.paperType = paperType;
		this.billNo = billNo;
		this.payMoney = payMoney;
		this.payMan = payMan;
		this.writerId = writerId;
		this.approvalDate = approvalDate;
		this.state = state;
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
