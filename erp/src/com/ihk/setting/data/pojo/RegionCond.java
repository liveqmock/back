package com.ihk.setting.data.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * Region的查询条件
 * @author peter.kuang
 *
 */
public class RegionCond extends SearchCond{
	private static final long serialVersionUID = 1L;

	private String cityId;
	
	private String regionName;
    
	public String getSearchName() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
}
