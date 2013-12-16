package com.ihk.saleunit.data.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * AppointBillDetail的查询条件
 * @author peter.kuang
 *
 */
public class AppointBillDetailCond extends SearchCond{

	private String billId;	
    
	public String getSearchName() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}
}
