package com.ihk.property.data.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * UnitImage的实体类
 * @author 
 *
 */
public class UnitImage implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int uid;
	private String type;
	private String context;
	private String url;
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
	 * 取得Uid()
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * 设置uid()
	 * @param uid ()
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
    
	/**
	 * 取得Type()
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置type()
	 * @param type ()
	 */
	public void setType(String type) {
		this.type = type;
	}
    
	/**
	 * 取得Context()
	 */
	public String getContext() {
		return context;
	}

	/**
	 * 设置context()
	 * @param context ()
	 */
	public void setContext(String context) {
		this.context = context;
	}
    
	/**
	 * 取得Url()
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置url()
	 * @param url ()
	 */
	public void setUrl(String url) {
		this.url = url;
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
    
	
	public UnitImage(){};


	/**
	 * 
	 * @param id ()
	 * @param uid ()
	 * @param type ()
	 * @param context ()
	 * @param url ()
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public UnitImage(    
		int id,
        		int uid,
        		String type,
        		String context,
        		String url,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.uid = uid;
		this.type = type;
		this.context = context;
		this.url = url;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param uid ()
	 * @param type ()
	 * @param context ()
	 * @param url ()
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public UnitImage(    
		int uid,
        		String type,
        		String context,
        		String url,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.uid = uid;
		this.type = type;
		this.context = context;
		this.url = url;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
