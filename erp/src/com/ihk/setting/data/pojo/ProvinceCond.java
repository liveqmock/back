package com.ihk.setting.data.pojo;

import com.ihk.utils.SearchCond;

/**
 * ProvinceCond的查询条件
 * @author peter.kuang
 *
 */
public class ProvinceCond extends SearchCond{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String provinceName;	
    
	public String getSearchName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
}
