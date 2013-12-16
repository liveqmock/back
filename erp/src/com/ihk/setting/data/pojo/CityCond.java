package com.ihk.setting.data.pojo;


import com.ihk.utils.SearchCond;

/**
 * City的查询条件
 * @author peter.kuang
 *
 */
public class CityCond extends SearchCond{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String provinceId;
	
	private String cityName;
    
	public String getSearchName() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
