package com.ihk.customer.data.pojo;

import java.io.Serializable;
import java.util.Date;

import com.ihk.user.data.pojo.UserAccount;
import com.ihk.utils.saleunit.MyPropertyUtils;

public class OnlyFollow implements Serializable{
    
	private static final long serialVersionUID = 7722458654316927469L;
	
	private int id;
	private int userId;
	private int customerId;
	private String isDeleted;
	private int createdId;
	private Date createdTime;
	private int modId;
	private Date modTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
    
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
    
	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
    
	public int getCreatedId() {
		return createdId;
	}

	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
    
	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
    
	public int getModId() {
		return modId;
	}

	public void setModId(int modId) {
		this.modId = modId;
	}
    
	public Date getModTime() {
		return modTime;
	}

	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}
    
	
	public OnlyFollow(){};

	public OnlyFollow(    
		int id,
        		int userId,
        		int customerId,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.userId = userId;
		this.customerId = customerId;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
	public OnlyFollow(    
		int userId,
        		int customerId,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.userId = userId;
		this.customerId = customerId;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
	
	/**
	 * 返回对应的客户的realName
	 * @return
	 */
	public String getUserRealName(){
		
		if(userId <= 0){
			return "";
		}
		
		UserAccount userAccount = MyPropertyUtils.getUserAccountServices().findUserAccountById(userId);
		
		if(userAccount == null){
			return "";
		}
		
		return userAccount.getRealName();
	}
}
