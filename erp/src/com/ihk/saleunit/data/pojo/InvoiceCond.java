package com.ihk.saleunit.data.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * Invoice的查询条件
 * @author peter.kuang
 *
 */
public class InvoiceCond extends SearchCond{

	private String unitId;	
    
	public String getSearchName() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
}
