package com.ihk.property.data.pojo;

import com.ihk.utils.SearchCond;

/**
 * PropertyAreaCond的查询条件
 * @author peter.kuang
 *
 */
public class PropertyAreaCond extends SearchCond{

	private static final long serialVersionUID = 1L;
	
	private int propertyId;	
    private String propertyName;
    private String areaName;
	private String likeAreaName;
	
	public String getLikeAreaName() {
		return likeAreaName;
	}

	public void setLikeAreaName(String likeAreaName) {
		this.likeAreaName = likeAreaName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}


	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	
}
