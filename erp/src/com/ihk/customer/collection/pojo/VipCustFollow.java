package com.ihk.customer.collection.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;

/**
 * VipCustFollow的实体类
 * @author 
 *
 */
public class VipCustFollow implements Serializable{
	private static final long serialVersionUID = 1L;
    
	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private String followType;
	private String content;
	private Date followDate;
	private int refId;
	private String isDeleted;
	private int regUserId;
	
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
	 * 取得Content(跟进内容)
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置content(跟进内容)
	 * @param content (跟进内容)
	 */
	public void setContent(String content) {
		this.content = content;
	}
    
	/**
	 * 取得FollowDate(跟进日期)
	 */
	public Date getFollowDate() {
		return followDate;
	}

	/**
	 * 设置followDate(跟进日期)
	 * @param followDate (跟进日期)
	 */
	public void setFollowDate(Date followDate) {
		this.followDate = followDate;
	}
    
	/**
	 * 取得RefId(关联id)
	 */
	public int getRefId() {
		return refId;
	}

	/**
	 * 设置refId(关联id)
	 * @param refId (关联id)
	 */
	public void setRefId(int refId) {
		this.refId = refId;
	}
    
	/**
	 * 取得IsDeleted()
	 */
	public String getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 设置isDeleted()
	 * @param isDeleted ()
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
    
	/**
	 * 取得RegUserId(跟进人)
	 */
	public int getRegUserId() {
		return regUserId;
	}

	/**
	 * 设置regUserId(跟进人)
	 * @param regUserId (跟进人)
	 */
	public void setRegUserId(int regUserId) {
		this.regUserId = regUserId;
	}
    
	
	public VipCustFollow(){};


	/**
	 * 
	 * @param id ()
	 * @param followType (跟进类型)
	 * @param content (跟进内容)
	 * @param followDate (跟进日期)
	 * @param refId (关联id)
	 * @param isDeleted ()
	 * @param regUserId (跟进人)
	 */
	public VipCustFollow(    
		int id,
        		String followType,
        		String content,
        		Date followDate,
        		int refId,
        		String isDeleted,
        		int regUserId
        ) {
		super();  
		this.id = id;
		this.followType = followType;
		this.content = content;
		this.followDate = followDate;
		this.refId = refId;
		this.isDeleted = isDeleted;
		this.regUserId = regUserId;
	}
    
	/**
	 * 
	 * @param followType (跟进类型)
	 * @param content (跟进内容)
	 * @param followDate (跟进日期)
	 * @param refId (关联id)
	 * @param isDeleted ()
	 * @param regUserId (跟进人)
	 */
	public VipCustFollow(    
		String followType,
        		String content,
        		Date followDate,
        		int refId,
        		String isDeleted,
        		int regUserId
        ) {
		super();		
		this.followType = followType;
		this.content = content;
		this.followDate = followDate;
		this.refId = refId;
		this.isDeleted = isDeleted;
		this.regUserId = regUserId;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
	public String getDescUser() {
		return DescUtils.getUserRealName(this.regUserId);
	}
	
	public String getCreateDateStr() {
		return CommonUtils.getDateString(this.followDate);
	}
	
	public String getFollowTypeStr() {
		
		return DescUtils.getCodeDesc(EnumCodeTypeName.RATING, this.followType, SessionUser.getProjectId());
	}
    
}
