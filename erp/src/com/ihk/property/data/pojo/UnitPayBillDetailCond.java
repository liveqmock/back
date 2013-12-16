package com.ihk.property.data.pojo;

import com.ihk.utils.SearchCond;

/**
 * UnitPayBillDetailCond的查询条件
 * @author peter.kuang
 *
 */
public class UnitPayBillDetailCond extends SearchCond{

	private String billId;	
    
	public String getSearchName() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}
}
