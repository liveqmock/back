package com.ihk.saleunit.data.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * ChangeOwnerDetail的查询条件
 * @author peter.kuang
 *
 */
public class ChangeOwnerDetailCond extends SearchCond{

	private String changeId;	
    
	
	
	public String getSearchName() {
		return changeId;
	}

	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}
}
