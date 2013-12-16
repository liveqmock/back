package com.ihk.user.data.pojo;

import java.io.Serializable;

/**
 * Priv的实体类
 * @author 
 *
 */
public class Priv implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private String privCode;
	private String privName;
	private String devFlag;
	private int orderIndex;
	private String remark;
	private String isDeleted;

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
	 * 取得PrivCode(权限代号)
	 */
	public String getPrivCode() {
		return privCode;
	}

	/**
	 * 设置privCode(权限代号)
	 * @param privCode (权限代号)
	 */
	public void setPrivCode(String privCode) {
		this.privCode = privCode;
	}
    
	/**
	 * 取得PrivName(权限中文名)
	 */
	public String getPrivName() {
		return privName;
	}

	/**
	 * 设置privName(权限中文名)
	 * @param privName (权限中文名)
	 */
	public void setPrivName(String privName) {
		this.privName = privName;
	}
    
	/**
	 * 取得DevFlag(开发标识)
	 */
	public String getDevFlag() {
		return devFlag;
	}

	/**
	 * 设置devFlag(开发标识)
	 * @param devFlag (开发标识)
	 */
	public void setDevFlag(String devFlag) {
		this.devFlag = devFlag;
	}
    
	/**
	 * 取得OrderIndex(顺序)
	 */
	public int getOrderIndex() {
		return orderIndex;
	}

	/**
	 * 设置orderIndex(顺序)
	 * @param orderIndex (顺序)
	 */
	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}
    
	/**
	 * 取得Remark(备注)
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置remark(备注)
	 * @param remark (备注)
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

    public String getDeleted() {
        return isDeleted;
    }

    public void setDeleted(String deleted) {
        isDeleted = deleted;
    }

    public Priv(){};


	/**
	 * 
	 * @param id ()
	 * @param privCode (权限代号)
	 * @param privName (权限中文名)
	 * @param devFlag (开发标识)
	 * @param orderIndex (顺序)
	 * @param remark (备注)
	 */
	public Priv(    
		int id,
        		String privCode,
        		String privName,
        		String devFlag,
        		int orderIndex,
        		String remark
        ) {
		super();  
		this.id = id;
		this.privCode = privCode;
		this.privName = privName;
		this.devFlag = devFlag;
		this.orderIndex = orderIndex;
		this.remark = remark;
	}
    
	/**
	 * 
	 * @param privCode (权限代号)
	 * @param privName (权限中文名)
	 * @param devFlag (开发标识)
	 * @param orderIndex (顺序)
	 * @param remark (备注)
	 */
	public Priv(    
		String privCode,
        		String privName,
        		String devFlag,
        		int orderIndex,
        		String remark
        ) {
		super();		
		this.privCode = privCode;
		this.privName = privName;
		this.devFlag = devFlag;
		this.orderIndex = orderIndex;
		this.remark = remark;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
