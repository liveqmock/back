package com.ihk.user.data.pojo;


import com.ihk.utils.SearchCond;

/**
 * UserPriv的查询条件
 * @author peter.kuang
 *
 */
public class UserPrivCond extends SearchCond{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String userId;
	
	private String userName;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	
}
