package com.ihk.utils.financial;

import java.io.Serializable;

/**
 * 获取佣金点数的pojo
 * 主要用于旧的方案,只有一个佣金点数的情况
 * @author dtc
 * 2013-3-19,上午09:51:37
 */
public class CommissionPojo implements Serializable{
	
	private static final long serialVersionUID = -4932529232435949297L;

	private int propertyId;
	
	private int areaId;
	
	private int buildId;
	
	private String managerType;
	
	public void setManagerType(String managerType) {
		this.managerType = managerType;
	}
	
	public String getManagerType() {
		return managerType;
	}
	
	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}
	
	public CommissionPojo(int propertyId, int areaId, int buildId) {
		super();
		this.propertyId = propertyId;
		this.areaId = areaId;
		this.buildId = buildId;
	}

	public CommissionPojo(int propertyId, int areaId, int buildId, String managerType) {
		super();
		this.propertyId = propertyId;
		this.areaId = areaId;
		this.buildId = buildId;
		this.managerType = managerType;
	}

}
