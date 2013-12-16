package com.ihk.setting.data.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Block的实体类
 * @author 
 *
 */
public class Block implements Serializable{

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private static final long serialVersionUID = 4821071908607140213L;
	private int blockId;
	private int projectId;
	private int regionId;
	private int cityId;
	private String blockName;
	private int orderIndex;
	private String isDeleted;
	private int createdId;
	private Date createdTime;
	private int modId;
	private Date modTime;

	/**
	 * 取得BlockId()
	 */
	public int getBlockId() {
		return blockId;
	}

	/**
	 * 设置blockId()
	 * @param blockId ()
	 */
	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}
    
	/**
	 * 取得ProjectId()
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * 设置projectId()
	 * @param projectId ()
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
    
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
	 * 取得CityId((冗余)选城市的时候,就可以出板块)
	 */
	public int getCityId() {
		return cityId;
	}

	/**
	 * 设置cityId((冗余)选城市的时候,就可以出板块)
	 * @param cityId ((冗余)选城市的时候,就可以出板块)
	 */
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
    
	/**
	 * 取得BlockName()
	 */
	public String getBlockName() {
		return blockName;
	}

	/**
	 * 设置blockName()
	 * @param blockName ()
	 */
	public void setBlockName(String blockName) {
		this.blockName = blockName;
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
    
	/**
	 * 取得CreatedId(创建人)
	 */
	public int getCreatedId() {
		return createdId;
	}

	/**
	 * 设置createdId(创建人)
	 * @param createdId (创建人)
	 */
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
    
	/**
	 * 取得CreatedTime(创建时间)
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * 设置createdTime(创建时间)
	 * @param createdTime (创建时间)
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
    
	/**
	 * 取得ModId(修改人)
	 */
	public int getModId() {
		return modId;
	}

	/**
	 * 设置modId(修改人)
	 * @param modId (修改人)
	 */
	public void setModId(int modId) {
		this.modId = modId;
	}
    
	/**
	 * 取得ModTime(修改时间)
	 */
	public Date getModTime() {
		return modTime;
	}

	/**
	 * 设置modTime(修改时间)
	 * @param modTime (修改时间)
	 */
	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}
    
	
	public Block(){};


	/**
	 * 
	 * @param blockId ()
	 * @param projectId ()
	 * @param regionId ()
	 * @param cityId ((冗余)选城市的时候,就可以出板块)
	 * @param blockName ()
	 * @param orderIndex ()
	 * @param isDeleted ()
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public Block(    
		int blockId,
        		int projectId,
        		int regionId,
        		int cityId,
        		String blockName,
        		int orderIndex,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.blockId = blockId;
		this.projectId = projectId;
		this.regionId = regionId;
		this.cityId = cityId;
		this.blockName = blockName;
		this.orderIndex = orderIndex;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param projectId ()
	 * @param regionId ()
	 * @param cityId ((冗余)选城市的时候,就可以出板块)
	 * @param blockName ()
	 * @param orderIndex ()
	 * @param isDeleted ()
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public Block(    
		int projectId,
        		int regionId,
        		int cityId,
        		String blockName,
        		int orderIndex,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.projectId = projectId;
		this.regionId = regionId;
		this.cityId = cityId;
		this.blockName = blockName;
		this.orderIndex = orderIndex;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
