package com.ihk.saleunit.data.pojo;

import java.io.Serializable;
import java.util.Date;

import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.utils.DescUtils;

/**
 * AddonProperty的实体类
 * @author 
 *
 */
public class AddonProperty implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private String confirmType;
	private int mainId;
	private int unitId;
	private String isDeleted;
	private int createdId;
	private Date createdTime;
	private int modId;
	private Date modTime;

	/**
	 * 取得Id()
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置id()
	 * @param id ()
	 */
	public void setId(int id) {
		this.id = id;
	}
    
	/**
	 * 取得ConfirmType(认购或合同)
	 */
	public String getConfirmType() {
		return confirmType;
	}

	/**
	 * 设置confirmType(认购或合同)
	 * @param confirmType (认购或合同)
	 */
	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
    
	/**
	 * 取得MainId(主单id)
	 */
	public int getMainId() {
		return mainId;
	}

	/**
	 * 设置mainId(主单id)
	 * @param mainId (主单id)
	 */
	public void setMainId(int mainId) {
		this.mainId = mainId;
	}
    
	/**
	 * 取得UnitId(房间id)
	 */
	public int getUnitId() {
		return unitId;
	}

	/**
	 * 设置unitId(房间id)
	 * @param unitId (房间id)
	 */
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
    
	/**
	 * 取得IsDeleted(是否删除)
	 */
	public String getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 设置isDeleted(是否删除)
	 * @param isDeleted (是否删除)
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
    
	
	public AddonProperty(){};


	/**
	 * 
	 * @param id ()
	 * @param confirmType (认购或合同)
	 * @param mainId (主单id)
	 * @param unitId (房间id)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public AddonProperty(    
		int id,
        		String confirmType,
        		int mainId,
        		int unitId,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.confirmType = confirmType;
		this.mainId = mainId;
		this.unitId = unitId;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param confirmType (认购或合同)
	 * @param mainId (主单id)
	 * @param unitId (房间id)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public AddonProperty(    
		String confirmType,
        		int mainId,
        		int unitId,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.confirmType = confirmType;
		this.mainId = mainId;
		this.unitId = unitId;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	///
	
	public PropertyUnit getUnit(){
		
		return DescUtils.findPropertyUnitByUnitId(this.getUnitId());
	}
	
	public PropertyBuild getBuild(){
		
		return DescUtils.findPropertyBuildByUnitId(this.getUnitId());
	}
	
	public PropertyProject getProject(){
		
		return DescUtils.findPropertyProjectByUnitId(this.getUnitId());
	}
}
