package com.ihk.utils.left;

import java.io.Serializable;

/**
 * 公司项目排序树bean
 * @author dtc
 * 2013-4-10,上午10:42:18
 */
public class OrderTreeBean implements Serializable{

	private static final long serialVersionUID = 6685604392680264242L;

	/**
	 * 项目id
	 */
	private int projectId;
	
	/**
	 * 项目中文名称及拼音(用于查找)
	 */
	private String projectNameAndPinyin;
	
	/**
	 * 用于显示
	 */
	private String projectName;
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectNameAndPinyin() {
		return projectNameAndPinyin;
	}

	public void setProjectNameAndPinyin(String projectNameAndPinyin) {
		this.projectNameAndPinyin = projectNameAndPinyin;
	}
	
}
