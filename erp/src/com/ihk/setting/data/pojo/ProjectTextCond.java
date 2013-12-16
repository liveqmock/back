package com.ihk.setting.data.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * ProjectText的查询条件
 * @author peter.kuang
 *
 */
public class ProjectTextCond extends SearchCond{
	
	private static final long serialVersionUID = -2166176118820984466L;

	/**
	 * 公司项目
	 */
	private String projectId;	

	/**
	 * 类型名称
	 */
    private String typeName;
    
    /**
     * text类型
     */
    private int textType;
    
    /**
     * textType对应的表的id
     */
    private int mainId;
    
    private int modId; //操作者的id
	
	private Date modTime;
	
	private int id;
	
	private String codeDesc;
	
	public int getTextType() {
		return textType;
	}

	public void setTextType(int textType) {
		this.textType = textType;
	}

	public int getMainId() {
		return mainId;
	}

	public void setMainId(int mainId) {
		this.mainId = mainId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
	
	
}
