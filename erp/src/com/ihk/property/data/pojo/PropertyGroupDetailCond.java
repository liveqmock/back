package com.ihk.property.data.pojo;

import java.util.List;

import com.ihk.utils.SearchCond;

/**
 * PropertyGroupDetailCond的查询条件
 * @author peter.kuang
 *
 */
public class PropertyGroupDetailCond extends SearchCond{

	private String buildId;	
    private String groupId;
    private String unitId;
    private List<Integer> ids;
	private PropertyGroupDetail pojo;

	public String getBuildId() {
		return buildId;
	}

	public PropertyGroupDetailCond setBuildId(String buildId) {
		this.buildId = buildId;
		return this;
	}

	public String getGroupId() {
		return groupId;
	}

	public PropertyGroupDetailCond setGroupId(String groupId) {
		this.groupId = groupId;
		return this;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public PropertyGroupDetailCond setIds(List<Integer> ids) {
		this.ids = ids;
		return this;
	}

	public PropertyGroupDetail getPojo() {
		return pojo;
	}

	public PropertyGroupDetailCond setPojo(PropertyGroupDetail pojo) {
		this.pojo = pojo;
		return this;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	
	
	
}
