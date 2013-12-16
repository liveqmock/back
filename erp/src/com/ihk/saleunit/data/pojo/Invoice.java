package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * Invoice的实体类
 * @author 
 *
 */
public class Invoice implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int unitId;
	private String invoiceNo;
	private BigDecimal invoiceMoney;
	private Date invoeceDate;
	private String remark;
	private String receiveMan;
	private Date receiveDate;
	private String receiveManDo;
	private Date receiveDateDo;
	private String isVoid;
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
	 * 取得UnitId(单元id)
	 */
	public int getUnitId() {
		return unitId;
	}

	/**
	 * 设置unitId(单元id)
	 * @param unitId (单元id)
	 */
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
    
	/**
	 * 取得InvoiceNo(发票号码)
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}

	/**
	 * 设置invoiceNo(发票号码)
	 * @param invoiceNo (发票号码)
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
    
	/**
	 * 取得InvoiceMoney(金额)
	 */
	public BigDecimal getInvoiceMoney() {
		return invoiceMoney;
	}

	/**
	 * 设置invoiceMoney(金额)
	 * @param invoiceMoney (金额)
	 */
	public void setInvoiceMoney(BigDecimal invoiceMoney) {
		this.invoiceMoney = invoiceMoney;
	}
    
	/**
	 * 取得InvoeceDate(日期)
	 */
	public Date getInvoeceDate() {
		return invoeceDate;
	}

	/**
	 * 设置invoeceDate(日期)
	 * @param invoeceDate (日期)
	 */
	public void setInvoeceDate(Date invoeceDate) {
		this.invoeceDate = invoeceDate;
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
	 * 取得ReceiveMan(领票人)
	 */
	public String getReceiveMan() {
		return receiveMan;
	}

	/**
	 * 设置receiveMan(领票人)
	 * @param receiveMan (领票人)
	 */
	public void setReceiveMan(String receiveMan) {
		this.receiveMan = receiveMan;
	}
    
	/**
	 * 取得ReceiveDate(领票日期)
	 */
	public Date getReceiveDate() {
		return receiveDate;
	}

	/**
	 * 设置receiveDate(领票日期)
	 * @param receiveDate (领票日期)
	 */
	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}
    
	/**
	 * 取得ReceiveManDo(办证领票人)
	 */
	public String getReceiveManDo() {
		return receiveManDo;
	}

	/**
	 * 设置receiveManDo(办证领票人)
	 * @param receiveManDo (办证领票人)
	 */
	public void setReceiveManDo(String receiveManDo) {
		this.receiveManDo = receiveManDo;
	}
    
	/**
	 * 取得ReceiveDateDo(办证领票日期)
	 */
	public Date getReceiveDateDo() {
		return receiveDateDo;
	}

	/**
	 * 设置receiveDateDo(办证领票日期)
	 * @param receiveDateDo (办证领票日期)
	 */
	public void setReceiveDateDo(Date receiveDateDo) {
		this.receiveDateDo = receiveDateDo;
	}
    
	/**
	 * 取得IsVoid(是否作废)
	 */
	public String getIsVoid() {
		return isVoid;
	}

	/**
	 * 设置isVoid(是否作废)
	 * @param isVoid (是否作废)
	 */
	public void setIsVoid(String isVoid) {
		this.isVoid = isVoid;
	}
    
	/**
	 * 取得IsDeleted()
	 */
	public String getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 设置isDeleted()
	 * @param isDeleted ()
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
    
	/**
	 * 取得CreatedId()
	 */
	public int getCreatedId() {
		return createdId;
	}

	/**
	 * 设置createdId()
	 * @param createdId ()
	 */
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
    
	/**
	 * 取得CreatedTime()
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * 设置createdTime()
	 * @param createdTime ()
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
    
	/**
	 * 取得ModId()
	 */
	public int getModId() {
		return modId;
	}

	/**
	 * 设置modId()
	 * @param modId ()
	 */
	public void setModId(int modId) {
		this.modId = modId;
	}
    
	/**
	 * 取得ModTime()
	 */
	public Date getModTime() {
		return modTime;
	}

	/**
	 * 设置modTime()
	 * @param modTime ()
	 */
	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}
    
	
	public Invoice(){};


	/**
	 * 
	 * @param id ()
	 * @param unitId (单元id)
	 * @param invoiceNo (发票号码)
	 * @param invoiceMoney (金额)
	 * @param invoeceDate (日期)
	 * @param remark (备注)
	 * @param receiveMan (领票人)
	 * @param receiveDate (领票日期)
	 * @param receiveManDo (办证领票人)
	 * @param receiveDateDo (办证领票日期)
	 * @param isVoid (是否作废)
	 * @param isDeleted ()
	 * @param createdId ()
	 * @param createdTime ()
	 * @param modId ()
	 * @param modTime ()
	 */
	public Invoice(    
		int id,
        		int unitId,
        		String invoiceNo,
        		BigDecimal invoiceMoney,
        		Date invoeceDate,
        		String remark,
        		String receiveMan,
        		Date receiveDate,
        		String receiveManDo,
        		Date receiveDateDo,
        		String isVoid,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.unitId = unitId;
		this.invoiceNo = invoiceNo;
		this.invoiceMoney = invoiceMoney;
		this.invoeceDate = invoeceDate;
		this.remark = remark;
		this.receiveMan = receiveMan;
		this.receiveDate = receiveDate;
		this.receiveManDo = receiveManDo;
		this.receiveDateDo = receiveDateDo;
		this.isVoid = isVoid;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param unitId (单元id)
	 * @param invoiceNo (发票号码)
	 * @param invoiceMoney (金额)
	 * @param invoeceDate (日期)
	 * @param remark (备注)
	 * @param receiveMan (领票人)
	 * @param receiveDate (领票日期)
	 * @param receiveManDo (办证领票人)
	 * @param receiveDateDo (办证领票日期)
	 * @param isVoid (是否作废)
	 * @param isDeleted ()
	 * @param createdId ()
	 * @param createdTime ()
	 * @param modId ()
	 * @param modTime ()
	 */
	public Invoice(    
		int unitId,
        		String invoiceNo,
        		BigDecimal invoiceMoney,
        		Date invoeceDate,
        		String remark,
        		String receiveMan,
        		Date receiveDate,
        		String receiveManDo,
        		Date receiveDateDo,
        		String isVoid,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.unitId = unitId;
		this.invoiceNo = invoiceNo;
		this.invoiceMoney = invoiceMoney;
		this.invoeceDate = invoeceDate;
		this.remark = remark;
		this.receiveMan = receiveMan;
		this.receiveDate = receiveDate;
		this.receiveManDo = receiveManDo;
		this.receiveDateDo = receiveDateDo;
		this.isVoid = isVoid;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
