package com.ihk.property.data.pojo;

import com.ihk.utils.SearchCond;

public class ContractManagerCond extends SearchCond{

	private static final long serialVersionUID = 1L;
	
	private int propertyId;
	
	private int areaId;
	
	private int buildId;
	
	private String managerType;

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

	public String getManagerType() {
		return managerType;
	}

	public void setManagerType(String managerType) {
		this.managerType = managerType;
	}
	
	public ContractManagerCond(int propertyId, int areaId, int buildId) {
		super();
		this.propertyId = propertyId;
		this.areaId = areaId;
		this.buildId = buildId;
	}

	public ContractManagerCond(int propertyId, int areaId, int buildId,
			String managerType) {
		super();
		this.propertyId = propertyId;
		this.areaId = areaId;
		this.buildId = buildId;
		this.managerType = managerType;
	}

	public ContractManagerCond() {
		super();
	}

}
