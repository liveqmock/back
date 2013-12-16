package com.ihk.saleunit.data.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * UnitPayDelay查询条件
 * @author peter.kuang
 *
 */
public class UnitPayDelayCond extends SearchCond{
	private static final long serialVersionUID = 1L;

	private String billId;	
    
	public String getSearchName() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}
}
