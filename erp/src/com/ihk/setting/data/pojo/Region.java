package com.ihk.setting.data.pojo;

import java.io.Serializable;

/**
 * Region的实体类
 * @author 
 *
 */
public class Region implements Serializable{

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private static final long serialVersionUID = -7969760762964152334L;
	private int regionId;
	private int cityId;
	private String regionName;
	private int orderIndex;
	private String isDeleted;

	/**
	 * 取得RegionId()
	 */
	public int getRegionId() {
		return regionId;
	}

	/**
	 * 设置regionId()
	 * @param regionId ()
	 */
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
    
	/**
	 * 取得CityId()
	 */
	public int getCityId() {
		return cityId;
	}

	/**
	 * 设置cityId()
	 * @param cityId ()
	 */
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
    
	/**
	 * 取得RegionName()
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * 设置regionName()
	 * @param regionName ()
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
    
	/**
	 * 取得OrderIndex()
	 */
	public int getOrderIndex() {
		return orderIndex;
	}

	/**
	 * 设置orderIndex()
	 * @param orderIndex ()
	 */
	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}
    
	/**
	 * 取得IsDeleted()
	 */
	public String getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 设置isDeleted()
	 * @param isDeleted ()
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
    
	
	public Region(){};


	/**
	 * 
	 * @param regionId ()
	 * @param cityId ()
	 * @param regionName ()
	 * @param orderIndex ()
	 * @param isDeleted ()
	 */
	public Region(    
		int regionId,
        		int cityId,
        		String regionName,
        		int orderIndex,
        		String isDeleted
        ) {
		super();  
		this.regionId = regionId;
		this.cityId = cityId;
		this.regionName = regionName;
		this.orderIndex = orderIndex;
		this.isDeleted = isDeleted;
	}
    
	/**
	 * 
	 * @param cityId ()
	 * @param regionName ()
	 * @param orderIndex ()
	 * @param isDeleted ()
	 */
	public Region(    
		int cityId,
        		String regionName,
        		int orderIndex,
        		String isDeleted
        ) {
		super();		
		this.cityId = cityId;
		this.regionName = regionName;
		this.orderIndex = orderIndex;
		this.isDeleted = isDeleted;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
