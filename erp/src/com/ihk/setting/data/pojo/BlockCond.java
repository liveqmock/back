package com.ihk.setting.data.pojo;

import com.ihk.utils.SearchCond;

/**
 * Block的查询条件
 * @author peter.kuang
 *
 */
public class BlockCond extends SearchCond{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int regionId;	
    
	private int projectId;

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	
}
