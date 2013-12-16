package com.ihk.saleunit.data.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * Receipt的实体类
 * @author 
 *
 */
public class Receipt implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private Date receiptDate;
	private String billNo;
	private String payMan;
	private int unitId;
	private String typeName;
	private String feeType;
	private BigDecimal receiptMoney;
	private BigDecimal cashMoney;
	private BigDecimal cardMoney;
	private BigDecimal transferMoney;
	private BigDecimal checkMoney;
	private BigDecimal intoMoney;
	private BigDecimal sincerityMoney;
	private BigDecimal couponMoney;
	private BigDecimal otherMoney;
	private String receiptAddress;
	private String checkNo;
	private String payType;
	private String billType;
	private String financeCert;
	private Date certDate;
	private String recordedBank;
	private String remark;
	private String isKeep;
	private String accountMan;
	private String cashierMan;
	private String inputMan;
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
	 * 取得ReceiptDate(收款日期)
	 */
	public Date getReceiptDate() {
		return receiptDate;
	}

	/**
	 * 设置receiptDate(收款日期)
	 * @param receiptDate (收款日期)
	 */
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}
    
	/**
	 * 取得BillNo(单据编号)
	 */
	public String getBillNo() {
		return billNo;
	}

	/**
	 * 设置billNo(单据编号)
	 * @param billNo (单据编号)
	 */
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
    
	/**
	 * 取得PayMan(缴款人名称)
	 */
	public String getPayMan() {
		return payMan;
	}

	/**
	 * 设置payMan(缴款人名称)
	 * @param payMan (缴款人名称)
	 */
	public void setPayMan(String payMan) {
		this.payMan = payMan;
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
	 * 收费类别
	 * @return
	 */
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
    
	/**
	 * 取得FeeType()
	 */
	public String getFeeType() {
		return feeType;
	}

	/**
	 * 设置feeType()
	 * @param feeType ()
	 */
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
    
	/**
	 * 取得ReceiptMoney(开票金额)
	 */
	public BigDecimal getReceiptMoney() {
		return receiptMoney;
	}

	/**
	 * 设置receiptMoney(开票金额)
	 * @param receiptMoney (开票金额)
	 */
	public void setReceiptMoney(BigDecimal receiptMoney) {
		this.receiptMoney = receiptMoney;
	}
    
	/**
	 * 取得CashMoney(现金)
	 */
	public BigDecimal getCashMoney() {
		return cashMoney;
	}

	/**
	 * 设置cashMoney(现金)
	 * @param cashMoney (现金)
	 */
	public void setCashMoney(BigDecimal cashMoney) {
		this.cashMoney = cashMoney;
	}
    
	/**
	 * 取得CardMoney(刷卡)
	 */
	public BigDecimal getCardMoney() {
		return cardMoney;
	}

	/**
	 * 设置cardMoney(刷卡)
	 * @param cardMoney (刷卡)
	 */
	public void setCardMoney(BigDecimal cardMoney) {
		this.cardMoney = cardMoney;
	}
    
	/**
	 * 取得TransferMoney(转账)
	 */
	public BigDecimal getTransferMoney() {
		return transferMoney;
	}

	/**
	 * 设置transferMoney(转账)
	 * @param transferMoney (转账)
	 */
	public void setTransferMoney(BigDecimal transferMoney) {
		this.transferMoney = transferMoney;
	}
    
	/**
	 * 取得CheckMoney(支票)
	 */
	public BigDecimal getCheckMoney() {
		return checkMoney;
	}

	/**
	 * 设置checkMoney(支票)
	 * @param checkMoney (支票)
	 */
	public void setCheckMoney(BigDecimal checkMoney) {
		this.checkMoney = checkMoney;
	}
    
	/**
	 * 取得IntoMoney(转入金额)
	 */
	public BigDecimal getIntoMoney() {
		return intoMoney;
	}

	/**
	 * 设置intoMoney(转入金额)
	 * @param intoMoney (转入金额)
	 */
	public void setIntoMoney(BigDecimal intoMoney) {
		this.intoMoney = intoMoney;
	}
    
	/**
	 * 取得SincerityMoney(诚意金)
	 */
	public BigDecimal getSincerityMoney() {
		return sincerityMoney;
	}

	/**
	 * 设置sincerityMoney(诚意金)
	 * @param sincerityMoney (诚意金)
	 */
	public void setSincerityMoney(BigDecimal sincerityMoney) {
		this.sincerityMoney = sincerityMoney;
	}
    
	/**
	 * 取得CouponMoney(购房券)
	 */
	public BigDecimal getCouponMoney() {
		return couponMoney;
	}

	/**
	 * 设置couponMoney(购房券)
	 * @param couponMoney (购房券)
	 */
	public void setCouponMoney(BigDecimal couponMoney) {
		this.couponMoney = couponMoney;
	}
    
	/**
	 * 取得OtherMoney(其他)
	 */
	public BigDecimal getOtherMoney() {
		return otherMoney;
	}

	/**
	 * 设置otherMoney(其他)
	 * @param otherMoney (其他)
	 */
	public void setOtherMoney(BigDecimal otherMoney) {
		this.otherMoney = otherMoney;
	}
    
	/**
	 * 取得ReceiptAddress(收款地点)
	 */
	public String getReceiptAddress() {
		return receiptAddress;
	}

	/**
	 * 设置receiptAddress(收款地点)
	 * @param receiptAddress (收款地点)
	 */
	public void setReceiptAddress(String receiptAddress) {
		this.receiptAddress = receiptAddress;
	}
    
	/**
	 * 取得CheckNo(支票号码)
	 */
	public String getCheckNo() {
		return checkNo;
	}

	/**
	 * 设置checkNo(支票号码)
	 * @param checkNo (支票号码)
	 */
	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}
    
	/**
	 * 取得PayType(付款类型)
	 */
	public String getPayType() {
		return payType;
	}

	/**
	 * 设置payType(付款类型)
	 * @param payType (付款类型)
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
    
	/**
	 * 取得BillType(单据类别)
	 */
	public String getBillType() {
		return billType;
	}

	/**
	 * 设置billType(单据类别)
	 * @param billType (单据类别)
	 */
	public void setBillType(String billType) {
		this.billType = billType;
	}
    
	/**
	 * 取得FinanceCert(财务凭证号)
	 */
	public String getFinanceCert() {
		return financeCert;
	}

	/**
	 * 设置financeCert(财务凭证号)
	 * @param financeCert (财务凭证号)
	 */
	public void setFinanceCert(String financeCert) {
		this.financeCert = financeCert;
	}
    
	/**
	 * 取得CertDate(凭证日期)
	 */
	public Date getCertDate() {
		return certDate;
	}

	/**
	 * 设置certDate(凭证日期)
	 * @param certDate (凭证日期)
	 */
	public void setCertDate(Date certDate) {
		this.certDate = certDate;
	}
    
	/**
	 * 取得RecordedBank(入账银行)
	 */
	public String getRecordedBank() {
		return recordedBank;
	}

	/**
	 * 设置recordedBank(入账银行)
	 * @param recordedBank (入账银行)
	 */
	public void setRecordedBank(String recordedBank) {
		this.recordedBank = recordedBank;
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
	 * 取得IsKeep(是否记账)
	 */
	public String getIsKeep() {
		return isKeep;
	}

	/**
	 * 设置isKeep(是否记账)
	 * @param isKeep (是否记账)
	 */
	public void setIsKeep(String isKeep) {
		this.isKeep = isKeep;
	}
    
	/**
	 * 取得AccountMan(会计)
	 */
	public String getAccountMan() {
		return accountMan;
	}

	/**
	 * 设置accountMan(会计)
	 * @param accountMan (会计)
	 */
	public void setAccountMan(String accountMan) {
		this.accountMan = accountMan;
	}
    
	/**
	 * 取得CashierMan(出纳)
	 */
	public String getCashierMan() {
		return cashierMan;
	}

	/**
	 * 设置cashierMan(出纳)
	 * @param cashierMan (出纳)
	 */
	public void setCashierMan(String cashierMan) {
		this.cashierMan = cashierMan;
	}
    
	/**
	 * 取得InputMan(经办)
	 */
	public String getInputMan() {
		return inputMan;
	}

	/**
	 * 设置inputMan(经办)
	 * @param inputMan (经办)
	 */
	public void setInputMan(String inputMan) {
		this.inputMan = inputMan;
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
    
	
	public Receipt(){};


	/**
	 * 
	 * @param id ()
	 * @param receiptDate (收款日期)
	 * @param billNo (单据编号)
	 * @param payMan (缴款人名称)
	 * @param unitId (房间id)
	 * @param feeType ()
	 * @param receiptMoney (开票金额)
	 * @param cashMoney (现金)
	 * @param cardMoney (刷卡)
	 * @param transferMoney (转账)
	 * @param checkMoney (支票)
	 * @param intoMoney (转入金额)
	 * @param sincerityMoney (诚意金)
	 * @param couponMoney (购房券)
	 * @param otherMoney (其他)
	 * @param receiptAddress (收款地点)
	 * @param checkNo (支票号码)
	 * @param payType (付款类型)
	 * @param billType (单据类别)
	 * @param financeCert (财务凭证号)
	 * @param certDate (凭证日期)
	 * @param recordedBank (入账银行)
	 * @param remark (备注)
	 * @param isKeep (是否记账)
	 * @param accountMan (会计)
	 * @param cashierMan (出纳)
	 * @param inputMan (经办)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public Receipt(    
		int id,
        		Date receiptDate,
        		String billNo,
        		String payMan,
        		int unitId,
        		String feeType,
        		BigDecimal receiptMoney,
        		BigDecimal cashMoney,
        		BigDecimal cardMoney,
        		BigDecimal transferMoney,
        		BigDecimal checkMoney,
        		BigDecimal intoMoney,
        		BigDecimal sincerityMoney,
        		BigDecimal couponMoney,
        		BigDecimal otherMoney,
        		String receiptAddress,
        		String checkNo,
        		String payType,
        		String billType,
        		String financeCert,
        		Date certDate,
        		String recordedBank,
        		String remark,
        		String isKeep,
        		String accountMan,
        		String cashierMan,
        		String inputMan,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.receiptDate = receiptDate;
		this.billNo = billNo;
		this.payMan = payMan;
		this.unitId = unitId;
		this.feeType = feeType;
		this.receiptMoney = receiptMoney;
		this.cashMoney = cashMoney;
		this.cardMoney = cardMoney;
		this.transferMoney = transferMoney;
		this.checkMoney = checkMoney;
		this.intoMoney = intoMoney;
		this.sincerityMoney = sincerityMoney;
		this.couponMoney = couponMoney;
		this.otherMoney = otherMoney;
		this.receiptAddress = receiptAddress;
		this.checkNo = checkNo;
		this.payType = payType;
		this.billType = billType;
		this.financeCert = financeCert;
		this.certDate = certDate;
		this.recordedBank = recordedBank;
		this.remark = remark;
		this.isKeep = isKeep;
		this.accountMan = accountMan;
		this.cashierMan = cashierMan;
		this.inputMan = inputMan;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param receiptDate (收款日期)
	 * @param billNo (单据编号)
	 * @param payMan (缴款人名称)
	 * @param unitId (房间id)
	 * @param feeType ()
	 * @param receiptMoney (开票金额)
	 * @param cashMoney (现金)
	 * @param cardMoney (刷卡)
	 * @param transferMoney (转账)
	 * @param checkMoney (支票)
	 * @param intoMoney (转入金额)
	 * @param sincerityMoney (诚意金)
	 * @param couponMoney (购房券)
	 * @param otherMoney (其他)
	 * @param receiptAddress (收款地点)
	 * @param checkNo (支票号码)
	 * @param payType (付款类型)
	 * @param billType (单据类别)
	 * @param financeCert (财务凭证号)
	 * @param certDate (凭证日期)
	 * @param recordedBank (入账银行)
	 * @param remark (备注)
	 * @param isKeep (是否记账)
	 * @param accountMan (会计)
	 * @param cashierMan (出纳)
	 * @param inputMan (经办)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public Receipt(    
		Date receiptDate,
        		String billNo,
        		String payMan,
        		int unitId,
        		String feeType,
        		BigDecimal receiptMoney,
        		BigDecimal cashMoney,
        		BigDecimal cardMoney,
        		BigDecimal transferMoney,
        		BigDecimal checkMoney,
        		BigDecimal intoMoney,
        		BigDecimal sincerityMoney,
        		BigDecimal couponMoney,
        		BigDecimal otherMoney,
        		String receiptAddress,
        		String checkNo,
        		String payType,
        		String billType,
        		String financeCert,
        		Date certDate,
        		String recordedBank,
        		String remark,
        		String isKeep,
        		String accountMan,
        		String cashierMan,
        		String inputMan,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.receiptDate = receiptDate;
		this.billNo = billNo;
		this.payMan = payMan;
		this.unitId = unitId;
		this.feeType = feeType;
		this.receiptMoney = receiptMoney;
		this.cashMoney = cashMoney;
		this.cardMoney = cardMoney;
		this.transferMoney = transferMoney;
		this.checkMoney = checkMoney;
		this.intoMoney = intoMoney;
		this.sincerityMoney = sincerityMoney;
		this.couponMoney = couponMoney;
		this.otherMoney = otherMoney;
		this.receiptAddress = receiptAddress;
		this.checkNo = checkNo;
		this.payType = payType;
		this.billType = billType;
		this.financeCert = financeCert;
		this.certDate = certDate;
		this.recordedBank = recordedBank;
		this.remark = remark;
		this.isKeep = isKeep;
		this.accountMan = accountMan;
		this.cashierMan = cashierMan;
		this.inputMan = inputMan;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	
	////
	public PropertyUnit getUnit(){
		
		PropertyUnit unit = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(this.getUnitId());
		
		return unit == null ? new PropertyUnit() : unit;
	}
	
}
