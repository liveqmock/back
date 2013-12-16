package com.ihk.saleunit.data.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * ReportDefineColumn的实体类
 * @author 
 *
 */
public class ReportDefineColumn implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int typeId;
	private String showName;
	private String methodSql;
	private int orderIndex;
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
	 * 取得TypeId(父id)
	 */
	public int getTypeId() {
		return typeId;
	}

	/**
	 * 设置typeId(父id)
	 * @param typeId (父id)
	 */
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
    
	/**
	 * 取得ShowName(中文)
	 */
	public String getShowName() {
		return showName;
	}

	/**
	 * 设置showName(中文)
	 * @param showName (中文)
	 */
	public void setShowName(String showName) {
		this.showName = showName;
	}
    
	/**
	 * 取得MethodSql(范围定义)
	 */
	public String getMethodSql() {
		return methodSql;
	}

	/**
	 * 设置methodSql(范围定义)
	 * @param methodSql (范围定义)
	 */
	public void setMethodSql(String methodSql) {
		this.methodSql = methodSql;
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
    
	
	public ReportDefineColumn(){};


	/**
	 * 
	 * @param id ()
	 * @param typeId (父id)
	 * @param showName (中文)
	 * @param methodSql (范围定义)
	 * @param orderIndex (顺序)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ReportDefineColumn(    
		int id,
        		int typeId,
        		String showName,
        		String methodSql,
        		int orderIndex,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.typeId = typeId;
		this.showName = showName;
		this.methodSql = methodSql;
		this.orderIndex = orderIndex;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param typeId (父id)
	 * @param showName (中文)
	 * @param methodSql (范围定义)
	 * @param orderIndex (顺序)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ReportDefineColumn(    
		int typeId,
        		String showName,
        		String methodSql,
        		int orderIndex,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.typeId = typeId;
		this.showName = showName;
		this.methodSql = methodSql;
		this.orderIndex = orderIndex;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	

	private String typeName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
