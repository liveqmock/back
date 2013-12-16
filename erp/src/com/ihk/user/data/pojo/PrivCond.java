package com.ihk.user.data.pojo;


import com.ihk.utils.SearchCond;

/**
 * Priv的查询条件
 * @author peter.kuang
 *
 */
public class PrivCond extends SearchCond{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String privName;	

	private String privCode;
	
	private String devFlag;

	public String getPrivCode() {
		return privCode;
	}

	public void setPrivCode(String privCode) {
		this.privCode = privCode;
	}

	public String getDevFlag() {
		return devFlag;
	}

	public void setDevFlag(String devFlag) {
		this.devFlag = devFlag;
	}
	
	
}
