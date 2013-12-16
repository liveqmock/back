package com.ihk.saleunit.data.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * ExtensionContract的查询条件
 * @author peter.kuang
 *
 */
public class ExtensionContractCond extends SearchCond{

	private String uid;	
    
	public String getSearchName() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
}
