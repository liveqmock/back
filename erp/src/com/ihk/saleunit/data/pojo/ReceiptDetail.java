package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * ReceiptDetail的实体类
 * @author 
 *
 */
public class ReceiptDetail implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int receiptId;
	private int billId;
	private BigDecimal payMoney;
	private String payMan;
	private Date payDate;
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
	 * 取得ReceiptId(主单id)
	 */
	public int getReceiptId() {
		return receiptId;
	}

	/**
	 * 设置receiptId(主单id)
	 * @param receiptId (主单id)
	 */
	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
    
	/**
	 * 取得BillId(应付款明细id)
	 */
	public int getBillId() {
		return billId;
	}

	/**
	 * 设置billId(应付款明细id)
	 * @param billId (应付款明细id)
	 */
	public void setBillId(int billId) {
		this.billId = billId;
	}
    
	/**
	 * 取得PayMoney(本次付款)
	 */
	public BigDecimal getPayMoney() {
		return payMoney;
	}

	/**
	 * 设置payMoney(本次付款)
	 * @param payMoney (本次付款)
	 */
	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}
    
	/**
	 * 取得PayMan(付款人)
	 */
	public String getPayMan() {
		return payMan;
	}

	/**
	 * 设置payMan(付款人)
	 * @param payMan (付款人)
	 */
	public void setPayMan(String payMan) {
		this.payMan = payMan;
	}
    
	/**
	 * 取得PayDate(付款日期)
	 */
	public Date getPayDate() {
		return payDate;
	}

	/**
	 * 设置payDate(付款日期)
	 * @param payDate (付款日期)
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
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
    
	
	public ReceiptDetail(){};


	/**
	 * 
	 * @param id ()
	 * @param receiptId (主单id)
	 * @param billId (应付款明细id)
	 * @param payMoney (本次付款)
	 * @param payMan (付款人)
	 * @param payDate (付款日期)
	 * @param isDeleted ()
	 * @param createdId ()
	 * @param createdTime ()
	 * @param modId ()
	 * @param modTime ()
	 */
	public ReceiptDetail(    
		int id,
        		int receiptId,
        		int billId,
        		BigDecimal payMoney,
        		String payMan,
        		Date payDate,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.receiptId = receiptId;
		this.billId = billId;
		this.payMoney = payMoney;
		this.payMan = payMan;
		this.payDate = payDate;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param receiptId (主单id)
	 * @param billId (应付款明细id)
	 * @param payMoney (本次付款)
	 * @param payMan (付款人)
	 * @param payDate (付款日期)
	 * @param isDeleted ()
	 * @param createdId ()
	 * @param createdTime ()
	 * @param modId ()
	 * @param modTime ()
	 */
	public ReceiptDetail(    
		int receiptId,
        		int billId,
        		BigDecimal payMoney,
        		String payMan,
        		Date payDate,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.receiptId = receiptId;
		this.billId = billId;
		this.payMoney = payMoney;
		this.payMan = payMan;
		this.payDate = payDate;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
