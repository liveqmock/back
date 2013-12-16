package com.ihk.setting.data.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * ProjectText的实体类
 * @author 
 * 
 */
public class ProjectText implements Serializable{
	
	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
	private static final long serialVersionUID = 3185811114747068766L;
	
	private int id;
	private int projectId;
	private int textType;
	private int mainId;
	private String typeName;
	private String codeDesc;
	private int codeOrder;
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
	 * 取得ProjectId(公司项目id(text如果跟项目id,那么text_type为空及main_id为0))
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * 设置projectId(公司项目id(text如果跟项目id,那么text_type为空及main_id为0))
	 * @param projectId (公司项目id(text如果跟项目id,那么text_type为空及main_id为0))
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
    
	/**
	 * 取得TextType(text类型,(有些text不是跟公司项目,而是对应某个表,就用该字段去标示))
	 */
	public int getTextType() {
		return textType;
	}

	/**
	 * 设置textType(text类型,(有些text不是跟公司项目,而是对应某个表,就用该字段去标示))
	 * @param textType (text类型,(有些text不是跟公司项目,而是对应某个表,就用该字段去标示))
	 */
	public void setTextType(int textType) {
		this.textType = textType;
	}
    
	/**
	 * 取得MainId(对应类型的表的id)
	 */
	public int getMainId() {
		return mainId;
	}

	/**
	 * 设置mainId(对应类型的表的id)
	 * @param mainId (对应类型的表的id)
	 */
	public void setMainId(int mainId) {
		this.mainId = mainId;
	}
    
	/**
	 * 取得TypeName(类型名称)
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * 设置typeName(类型名称)
	 * @param typeName (类型名称)
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
    
	/**
	 * 取得CodeDesc(字典描述)
	 */
	public String getCodeDesc() {
		return codeDesc;
	}

	/**
	 * 设置codeDesc(字典描述)
	 * @param codeDesc (字典描述)
	 */
	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}
    
	/**
	 * 取得CodeOrder(顺序)
	 */
	public int getCodeOrder() {
		return codeOrder;
	}

	/**
	 * 设置codeOrder(顺序)
	 * @param codeOrder (顺序)
	 */
	public void setCodeOrder(int codeOrder) {
		this.codeOrder = codeOrder;
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
    
	
	public ProjectText(){};


	/**
	 * 
	 * @param id ()
	 * @param projectId (公司项目id(text如果跟项目id,那么text_type为空及main_id为0))
	 * @param textType (text类型,(有些text不是跟公司项目,而是对应某个表,就用该字段去标示))
	 * @param mainId (对应类型的表的id)
	 * @param typeName (类型名称)
	 * @param codeDesc (字典描述)
	 * @param codeOrder (顺序)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ProjectText(    
		int id,
		int projectId,
		int textType,
		int mainId,
		String typeName,
		String codeDesc,
		int codeOrder,
		String isDeleted,
		int createdId,
		Date createdTime,
		int modId,
		Date modTime
        ) {
		super();  
		this.id = id;
		this.projectId = projectId;
		this.textType = textType;
		this.mainId = mainId;
		this.typeName = typeName;
		this.codeDesc = codeDesc;
		this.codeOrder = codeOrder;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param projectId (公司项目id(text如果跟项目id,那么text_type为空及main_id为0))
	 * @param textType (text类型,(有些text不是跟公司项目,而是对应某个表,就用该字段去标示))
	 * @param mainId (对应类型的表的id)
	 * @param typeName (类型名称)
	 * @param codeDesc (字典描述)
	 * @param codeOrder (顺序)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ProjectText(    
		int projectId,
		int textType,
		int mainId,
		String typeName,
		String codeDesc,
		int codeOrder,
		String isDeleted,
		int createdId,
		Date createdTime,
		int modId,
		Date modTime
        ) {
		super();		
		this.projectId = projectId;
		this.textType = textType;
		this.mainId = mainId;
		this.typeName = typeName;
		this.codeDesc = codeDesc;
		this.codeOrder = codeOrder;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
