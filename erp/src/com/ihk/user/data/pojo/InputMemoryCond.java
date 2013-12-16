package com.ihk.user.data.pojo;


import com.ihk.utils.SearchCond;

/**
 * InputMemory的查询条件
 * @author peter.kuang
 *
 */
public class InputMemoryCond extends SearchCond{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId;	
	
	private String memoryType;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMemoryType() {
		return memoryType;
	}

	public void setMemoryType(String memoryType) {
		this.memoryType = memoryType;
	}
	
    
}
