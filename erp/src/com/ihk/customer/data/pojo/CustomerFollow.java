package com.ihk.customer.data.pojo;

import java.io.Serializable;
import java.util.Date;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.projectcode.FollowTypeUtils;

/**
 * CustomerFollow的实体类
 * @author 
 *
 */
public class CustomerFollow implements Serializable{
	private static final long serialVersionUID = 1L;
    
	private int id;
	private int customerId;
	private String followType;
	private int followUser;
	private String followDesc;
	private String isDeleted;
	private int createdId;
	private Date createdTime;
	private int modId;
	private Date modTime;

	/**
	 * 取得Id()
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 设置id()
	 * @param id ()
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 取得CustomerId()
	 */
	public int getCustomerId() {
		return customerId;
	}
	
	/**
	 * 设置customerId()
	 * @param customerId ()
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	/**
	 * 取得FollowType(跟进类型)
	 */
	public String getFollowType() {
		return followType;
	}
	
	/**
	 * 设置followType(跟进类型)
	 * @param followType (跟进类型)
	 */
	public void setFollowType(String followType) {
		this.followType = followType;
	}
	
	/**
	 * 取得FollowUser(跟进人)
	 */
	public int getFollowUser() {
		return followUser;
	}
	
	/**
	 * 设置followUser(跟进人)
	 * @param followUser (跟进人)
	 */
	public void setFollowUser(int followUser) {
		this.followUser = followUser;
	}
	
	/**
	 * 取得FollowDesc(跟进情况(洽谈内容))
	 */
	public String getFollowDesc() {
		return followDesc;
	}
	
	/**
	 * 设置followDesc(跟进情况(洽谈内容))
	 * @param followDesc (跟进情况(洽谈内容))
	 */
	public void setFollowDesc(String followDesc) {
		this.followDesc = followDesc;
	}
	
	/**
	 * 取得IsDeleted(是否删除)
	 */
	public String getIsDeleted() {
		return isDeleted;
	}
	
	/**
	 * 设置isDeleted(是否删除)
	 * @param isDeleted (是否删除)
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	/**
	 * 取得CreatedId(创建人)
	 */
	public int getCreatedId() {
		return createdId;
	}
	
	/**
	 * 设置createdId(创建人)
	 * @param createdId (创建人)
	 */
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
	
	/**
	 * 取得CreatedTime(创建时间)
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	
	/**
	 * 设置createdTime(创建时间)
	 * @param createdTime (创建时间)
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	/**
	 * 取得ModId(修改人)
	 */
	public int getModId() {
		return modId;
	}
	
	/**
	 * 设置modId(修改人)
	 * @param modId (修改人)
	 */
	public void setModId(int modId) {
		this.modId = modId;
	}
	
	/**
	 * 取得ModTime(修改时间)
	 */
	public Date getModTime() {
		return modTime;
	}
	
	/**
	 * 设置modTime(修改时间)
	 * @param modTime (修改时间)
	 */
	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}
	
	
	public CustomerFollow(){};
	
	
	/**
	 * 
	 * @param id ()
	 * @param customerId ()
	 * @param followType (跟进类型)
	 * @param followUser (跟进人)
	 * @param followDesc (跟进情况(洽谈内容))
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public CustomerFollow(    
		int id,
	    		int customerId,
	    		String followType,
	    		int followUser,
	    		String followDesc,
	    		String isDeleted,
	    		int createdId,
	    		Date createdTime,
	    		int modId,
	    		Date modTime
	    ) {
		super();  
		this.id = id;
		this.customerId = customerId;
		this.followType = followType;
		this.followUser = followUser;
		this.followDesc = followDesc;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
	
	/**
	 * 
	 * @param customerId ()
	 * @param followType (跟进类型)
	 * @param followUser (跟进人)
	 * @param followDesc (跟进情况(洽谈内容))
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public CustomerFollow(    
		int customerId,
	    		String followType,
	    		int followUser,
	    		String followDesc,
	    		String isDeleted,
	    		int createdId,
	    		Date createdTime,
	    		int modId,
	    		Date modTime
	    ) {
		super();		
		this.customerId = customerId;
		this.followType = followType;
		this.followUser = followUser;
		this.followDesc = followDesc;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖
	
	public String getDescFollowType(){
		
		String tmpFollowType = DescUtils.getCodeDesc(EnumCodeTypeName.FOLLOW_TYPE, followType, 1);
		if(CommonUtils.isStrEmpty(tmpFollowType)){
			
			return FollowTypeUtils.getDescFollowType(this.getFollowType());
		}
		
		return tmpFollowType;
	}
	
	public String getDescUserId(){
		return DescUtils.getUserRealName(this.followUser);
	}
	
	/**
	 * 跟进日期
	 * @return
	 */
	public String getFollowDate(){
		
		return CustomerUtils.getDateString(this.getCreatedTime());
	}
	
}
