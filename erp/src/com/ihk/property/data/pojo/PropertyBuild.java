package com.ihk.property.data.pojo;

import java.io.Serializable;
import java.util.Date;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.utils.DescUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * PropertyBuild的实体类
 * @author 
 *
 */
public class PropertyBuild implements Serializable{
	private static final long serialVersionUID = 1L;
    
	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int propertyId;
	private String buildName;
	private String saleType;
	private String buildNature;
	private String chipType;
	private String remark;
	private int areaId;
	private int orderIndex;
	private String isDeleted;
	private int createdId;
	private Date createdTime;
	private int modId;
	private Date modTime;
	private int companyProjectId;
	
	public int getCompanyProjectId() {
		return companyProjectId;
	}

	public void setCompanyProjectId(int companyProjectId) {
		this.companyProjectId = companyProjectId;
	}

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
	 * 取得PropertyId(楼盘项目id)
	 */
	public int getPropertyId() {
		return propertyId;
	}

	/**
	 * 设置propertyId(楼盘项目id)
	 * @param propertyId (楼盘项目id)
	 */
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
    
	/**
	 * 取得BuildName(楼栋名称)
	 */
	public String getBuildName() {
		return buildName;
	}

	/**
	 * 设置buildName(楼栋名称)
	 * @param buildName (楼栋名称)
	 */
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
    
	/**
	 * 取得SaleType(租售类型)
	 */
	public String getSaleType() {
		return saleType;
	}

	/**
	 * 设置saleType(租售类型)
	 * @param saleType (租售类型)
	 */
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
    
	/**
	 * 取得BuildNature(建筑性质)
	 */
	public String getBuildNature() {
		return buildNature;
	}

	/**
	 * 设置buildNature(建筑性质)
	 * @param buildNature (建筑性质)
	 */
	public void setBuildNature(String buildNature) {
		this.buildNature = buildNature;
	}
    
	/**
	 * 取得ChipType(认筹类型)
	 */
	public String getChipType() {
		return chipType;
	}

	/**
	 * 设置chipType(认筹类型)
	 * @param chipType (认筹类型)
	 */
	public void setChipType(String chipType) {
		this.chipType = chipType;
	}
    
	/**
	 * 取得Remark(备注)
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置remark(备注)
	 * @param remark (备注)
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
	/**
	 * 取得AreaId(分区id)
	 */
	public int getAreaId() {
		return areaId;
	}

	/**
	 * 设置areaId(分区id)
	 * @param areaId (分区id)
	 */
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
    
	/**
	 * 取得OrderIndex(序号)
	 */
	public int getOrderIndex() {
		return orderIndex;
	}

	/**
	 * 设置orderIndex(序号)
	 * @param orderIndex (序号)
	 */
	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
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
    
	
	public PropertyBuild(){};


	/**
	 * 
	 * @param id ()
	 * @param propertyId (楼盘项目id)
	 * @param buildName (楼栋名称)
	 * @param saleType (租售类型)
	 * @param buildNature (建筑性质)
	 * @param chipType (认筹类型)
	 * @param remark (备注)
	 * @param areaId (分区id)
	 * @param orderIndex (序号)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public PropertyBuild(    
		int id,
        		int propertyId,
        		String buildName,
        		String saleType,
        		String buildNature,
        		String chipType,
        		String remark,
        		int areaId,
        		int orderIndex,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime,
        		int companyProjectId
        ) {
		super();  
		this.id = id;
		this.propertyId = propertyId;
		this.buildName = buildName;
		this.saleType = saleType;
		this.buildNature = buildNature;
		this.chipType = chipType;
		this.remark = remark;
		this.areaId = areaId;
		this.orderIndex = orderIndex;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
		this.companyProjectId = companyProjectId;
	}
    
	/**
	 * 
	 * @param propertyId (楼盘项目id)
	 * @param buildName (楼栋名称)
	 * @param saleType (租售类型)
	 * @param buildNature (建筑性质)
	 * @param chipType (认筹类型)
	 * @param remark (备注)
	 * @param areaId (分区id)
	 * @param orderIndex (序号)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public PropertyBuild(    
		int propertyId,
        		String buildName,
        		String saleType,
        		String buildNature,
        		String chipType,
        		String remark,
        		int areaId,
        		int orderIndex,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime,
        		int companyProjectId
        ) {
		super();		
		this.propertyId = propertyId;
		this.buildName = buildName;
		this.saleType = saleType;
		this.buildNature = buildNature;
		this.chipType = chipType;
		this.remark = remark;
		this.areaId = areaId;
		this.orderIndex = orderIndex;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
		this.companyProjectId = companyProjectId;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
	
	/////
	
	public String getDescSaleType(){
		if(saleType == null)return "";
		return DescUtils.getCodeDesc(EnumCodeTypeName.PROPERTY_SALE_TYPE, this.getSaleType(),0);
		
	}
	
	public String getDescBuildNature(){
		if(buildNature == null)return "";
		return DescUtils.getCodeDesc(EnumCodeTypeName.PROPERTY_BUILD_NATURE, buildNature,0);	
	}
	
	public String getDescBuildType(){
		//if(buildType == null)return "";
		//return DescUtils.getCodeDesc(EnumCodeTypeName.PROPERTY_BUILD_TYPE, this.getBuildType(),0);	
		return "";
	}
	
	public String getDescPropertyId(){
		//楼盘项目名称
		if(propertyId == 0 )return "";
		return DescUtils.findPropertyNameById(propertyId);
	}
	
	public String getDescParentId(){
		if(areaId == 0 )return "";
		PropertyBuild tb = DescUtils.getBuildById(areaId);
		String t = tb.getBuildName();
		return t;
	}
	
	public String getAreaName(){
		
		try{
			
			return DescUtils.getPropertyAreaServices().findPropertyAreaById(this.getAreaId()).getAreaName();
		}catch(Exception e){
			return "";
		}
	}
	
	/**
	 * 获取其全名:项目-分区-楼栋
	 * @return
	 */
	public String getAllName(){
		
		try{
			return MyPropertyUtils.getPropertyBuildServices().findPropertyBuildAllNameByBuildId(this.getId());
		}catch (Exception e) {
			return "";
		}
		
	}
	
}
