package com.ihk.customer.data.pojo;

import java.io.Serializable;
import java.util.Date;

import com.ihk.utils.DescUtils;

/**
 * ProjectRange的实体类
 * @author 
 *
 */
public class ProjectRange implements Serializable{
	private static final long serialVersionUID = 1L;
    
	private int id;
	private int companyId;
	private int projectId;
	private String houseType;
	private String rangeType;
	private String rangeName;
	private int startNum;
	private int endNum;
	private int orderIndex;
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
	 * 取得CompanyId()
	 */
	public int getCompanyId() {
		return companyId;
	}

	/**
	 * 设置companyId()
	 * @param companyId ()
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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
	 * 取得HouseType(产品类型)
	 */
	public String getHouseType() {
		return houseType;
	}

	/**
	 * 设置houseType(产品类型)
	 * @param houseType (产品类型)
	 */
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
    
	/**
	 * 取得RangeType()
	 */
	public String getRangeType() {
		return rangeType;
	}

	/**
	 * 设置rangeType()
	 * @param rangeType ()
	 */
	public void setRangeType(String rangeType) {
		this.rangeType = rangeType;
	}
    
	/**
	 * 取得RangeName(名称)
	 */
	public String getRangeName() {
		return rangeName;
	}

	/**
	 * 设置rangeName(名称)
	 * @param rangeName (名称)
	 */
	public void setRangeName(String rangeName) {
		this.rangeName = rangeName;
	}
    
	/**
	 * 取得StartNum(开始数量)
	 */
	public int getStartNum() {
		return startNum;
	}

	/**
	 * 设置startNum(开始数量)
	 * @param startNum (开始数量)
	 */
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
    
	/**
	 * 取得EndNum(结束数量)
	 */
	public int getEndNum() {
		return endNum;
	}

	/**
	 * 设置endNum(结束数量)
	 * @param endNum (结束数量)
	 */
	public void setEndNum(int endNum) {
		this.endNum = endNum;
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
    
	
	public ProjectRange(){};


	/**
	 * 
	 * @param id ()
	 * @param companyId ()
	 * @param projectId ()
	 * @param houseType (产品类型)
	 * @param rangeType ()
	 * @param rangeName (名称)
	 * @param startNum (开始数量)
	 * @param endNum (结束数量)
	 * @param orderIndex (序号)
	 * @param isDeleted ()
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ProjectRange(    
		int id,
        		int companyId,
        		int projectId,
        		String houseType,
        		String rangeType,
        		String rangeName,
        		int startNum,
        		int endNum,
        		int orderIndex,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.companyId = companyId;
		this.projectId = projectId;
		this.houseType = houseType;
		this.rangeType = rangeType;
		this.rangeName = rangeName;
		this.startNum = startNum;
		this.endNum = endNum;
		this.orderIndex = orderIndex;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param companyId ()
	 * @param projectId ()
	 * @param houseType (产品类型)
	 * @param rangeType ()
	 * @param rangeName (名称)
	 * @param startNum (开始数量)
	 * @param endNum (结束数量)
	 * @param orderIndex (序号)
	 * @param isDeleted ()
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ProjectRange(    
		int companyId,
        		int projectId,
        		String houseType,
        		String rangeType,
        		String rangeName,
        		int startNum,
        		int endNum,
        		int orderIndex,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.companyId = companyId;
		this.projectId = projectId;
		this.houseType = houseType;
		this.rangeType = rangeType;
		this.rangeName = rangeName;
		this.startNum = startNum;
		this.endNum = endNum;
		this.orderIndex = orderIndex;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖
	

	public String getDescProjectId(){//porjectId > Name
		return DescUtils.getCompanyProjectRealName(this.projectId);
	}
}
