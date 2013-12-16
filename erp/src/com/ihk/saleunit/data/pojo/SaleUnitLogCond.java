package com.ihk.saleunit.data.pojo;

import com.ihk.utils.SearchCond;

/**
 * SaleUnitLog的查询条件
 * @author peter.kuang
 *
 */
public class SaleUnitLogCond extends SearchCond{
	
	private static final long serialVersionUID = 1L;
	
	private int unitId;

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	
}
