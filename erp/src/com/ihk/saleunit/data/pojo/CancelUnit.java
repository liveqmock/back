package com.ihk.saleunit.data.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * CancelUnit的实体类
 * @author 
 * 
 */
public class CancelUnit implements Serializable{
	
    
	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private static final long serialVersionUID = -9148741714804378483L;
	
	private int id;
	private int companyProjectId;
	private int propertyProjectId;
	private int areaId;
	private int buildId;
	private int unitId;
	private String confirmType;
	private int mainId;
	private Date cancelTime;
	private BigDecimal overdueFine;
	private String approverMan;
	private String inputMan;
	private String remark;
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
	 * 取得CompanyProjectId(公司项目id)
	 */
	public int getCompanyProjectId() {
		return companyProjectId;
	}

	/**
	 * 设置companyProjectId(公司项目id)
	 * @param companyProjectId (公司项目id)
	 */
	public void setCompanyProjectId(int companyProjectId) {
		this.companyProjectId = companyProjectId;
	}
    
	/**
	 * 取得PropertyProjectId(楼盘项目id)
	 */
	public int getPropertyProjectId() {
		return propertyProjectId;
	}

	/**
	 * 设置propertyProjectId(楼盘项目id)
	 * @param propertyProjectId (楼盘项目id)
	 */
	public void setPropertyProjectId(int propertyProjectId) {
		this.propertyProjectId = propertyProjectId;
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
	 * 取得BuildId(楼栋id)
	 */
	public int getBuildId() {
		return buildId;
	}

	/**
	 * 设置buildId(楼栋id)
	 * @param buildId (楼栋id)
	 */
	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}
    
	/**
	 * 取得UnitId(单元id)
	 */
	public int getUnitId() {
		return unitId;
	}

	/**
	 * 设置unitId(单元id)
	 * @param unitId (单元id)
	 */
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
    
	/**
	 * 取得ConfirmType(成交或合同类型,com.ihk.constanttype.ContConfirmType.java)
	 */
	public String getConfirmType() {
		return confirmType;
	}

	/**
	 * 设置confirmType(成交或合同类型,com.ihk.constanttype.ContConfirmType.java)
	 * @param confirmType (成交或合同类型,com.ihk.constanttype.ContConfirmType.java)
	 */
	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
    
	/**
	 * 取得MainId(成交或合同id)
	 */
	public int getMainId() {
		return mainId;
	}

	/**
	 * 设置mainId(成交或合同id)
	 * @param mainId (成交或合同id)
	 */
	public void setMainId(int mainId) {
		this.mainId = mainId;
	}
    
	/**
	 * 取得CancelTime(退房日期)
	 */
	public Date getCancelTime() {
		return cancelTime;
	}

	/**
	 * 设置cancelTime(退房日期)
	 * @param cancelTime (退房日期)
	 */
	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}
    
	/**
	 * 取得OverdueFine(滞纳金)
	 */
	public BigDecimal getOverdueFine() {
		return overdueFine;
	}

	/**
	 * 设置overdueFine(滞纳金)
	 * @param overdueFine (滞纳金)
	 */
	public void setOverdueFine(BigDecimal overdueFine) {
		this.overdueFine = overdueFine;
	}
    
	/**
	 * 取得ApproverMan(批准人)
	 */
	public String getApproverMan() {
		return approverMan;
	}

	/**
	 * 设置approverMan(批准人)
	 * @param approverMan (批准人)
	 */
	public void setApproverMan(String approverMan) {
		this.approverMan = approverMan;
	}
    
	/**
	 * 取得InputMan(经办人)
	 */
	public String getInputMan() {
		return inputMan;
	}

	/**
	 * 设置inputMan(经办人)
	 * @param inputMan (经办人)
	 */
	public void setInputMan(String inputMan) {
		this.inputMan = inputMan;
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
    
	
	public CancelUnit(){};


	/**
	 * 
	 * @param id ()
	 * @param companyProjectId (公司项目id)
	 * @param propertyProjectId (楼盘项目id)
	 * @param areaId (分区id)
	 * @param buildId (楼栋id)
	 * @param unitId (单元id)
	 * @param confirmType (成交或合同类型,com.ihk.constanttype.ContConfirmType.java)
	 * @param mainId (成交或合同id)
	 * @param cancelTime (退房日期)
	 * @param overdueFine (滞纳金)
	 * @param approverMan (批准人)
	 * @param inputMan (经办人)
	 * @param remark (备注)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public CancelUnit(    
		int id,
        		int companyProjectId,
        		int propertyProjectId,
        		int areaId,
        		int buildId,
        		int unitId,
        		String confirmType,
        		int mainId,
        		Date cancelTime,
        		BigDecimal overdueFine,
        		String approverMan,
        		String inputMan,
        		String remark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.companyProjectId = companyProjectId;
		this.propertyProjectId = propertyProjectId;
		this.areaId = areaId;
		this.buildId = buildId;
		this.unitId = unitId;
		this.confirmType = confirmType;
		this.mainId = mainId;
		this.cancelTime = cancelTime;
		this.overdueFine = overdueFine;
		this.approverMan = approverMan;
		this.inputMan = inputMan;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param companyProjectId (公司项目id)
	 * @param propertyProjectId (楼盘项目id)
	 * @param areaId (分区id)
	 * @param buildId (楼栋id)
	 * @param unitId (单元id)
	 * @param confirmType (成交或合同类型,com.ihk.constanttype.ContConfirmType.java)
	 * @param mainId (成交或合同id)
	 * @param cancelTime (退房日期)
	 * @param overdueFine (滞纳金)
	 * @param approverMan (批准人)
	 * @param inputMan (经办人)
	 * @param remark (备注)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public CancelUnit(    
		int companyProjectId,
        		int propertyProjectId,
        		int areaId,
        		int buildId,
        		int unitId,
        		String confirmType,
        		int mainId,
        		Date cancelTime,
        		BigDecimal overdueFine,
        		String approverMan,
        		String inputMan,
        		String remark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.companyProjectId = companyProjectId;
		this.propertyProjectId = propertyProjectId;
		this.areaId = areaId;
		this.buildId = buildId;
		this.unitId = unitId;
		this.confirmType = confirmType;
		this.mainId = mainId;
		this.cancelTime = cancelTime;
		this.overdueFine = overdueFine;
		this.approverMan = approverMan;
		this.inputMan = inputMan;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
