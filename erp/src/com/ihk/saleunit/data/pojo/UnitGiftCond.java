package com.ihk.saleunit.data.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * UnitGift的查询条件
 * @author peter.kuang
 *
 */
public class UnitGiftCond extends SearchCond{
	private static final long serialVersionUID = 1L;

	private String unitId;
    
	public String getSearchName() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
}
