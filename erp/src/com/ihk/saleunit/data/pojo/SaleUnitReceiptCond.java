package com.ihk.saleunit.data.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * 实收cond
 * @author dtc
 * 2013-6-14,上午11:26:17
 */
public class SaleUnitReceiptCond extends SearchCond{

	private static final long serialVersionUID = 7815042369041061220L;
	
	/**
	 * 实收id
	 */
	private int receiptId;
	
	/**
	 * 对数id
	 */
	private int checkFeeId;
	
	/**
	 * 修改者id
	 */
	private int modId;
	
	/**
	 * 修改时间
	 */
	private Date modTime;

	public int getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}

	public int getCheckFeeId() {
		return checkFeeId;
	}

	public void setCheckFeeId(int checkFeeId) {
		this.checkFeeId = checkFeeId;
	}

	public int getModId() {
		return modId;
	}

	public void setModId(int modId) {
		this.modId = modId;
	}

	public Date getModTime() {
		return modTime;
	}

	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

}
