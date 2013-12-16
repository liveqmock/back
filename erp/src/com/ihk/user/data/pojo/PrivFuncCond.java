package com.ihk.user.data.pojo;

import java.util.List;

import com.ihk.utils.SearchCond;

/**
 * PrivFunc的查询条件
 * @author peter.kuang
 *
 */
public class PrivFuncCond extends SearchCond{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> privCodes;	
	
	public List<String> getPrivCodes() {
		return privCodes;
	}
	
	public void setPrivCodes(List<String> privCodes) {
		this.privCodes = privCodes;
	}
}
