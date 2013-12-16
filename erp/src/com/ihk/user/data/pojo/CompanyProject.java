package com.ihk.user.data.pojo;

import java.io.Serializable;
import java.util.Date;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;

/**
 * CompanyProject的实体类
 * @author 
 *
 */
public class CompanyProject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int companyId;
	private String projectName;
	private String devCode;
	private int orderIndex;
	private String isCrm;
	private String isSale;
	private String customerOneSale;
	private String projectState;
	
	private int provinceId;
	private int cityId;
	
	private String pinyin;
	
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
	 * 取得ProjectName()
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * 设置projectName()
	 * @param projectName ()
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
    
	/**
	 * 取得DevCode(开放代号)
	 */
	public String getDevCode() {
		return devCode;
	}

	/**
	 * 设置devCode(开放代号)
	 * @param devCode (开放代号)
	 */
	public void setDevCode(String devCode) {
		this.devCode = devCode;
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
	 * 取得IsCrm(是否具有crm功能)
	 */
	public String getIsCrm() {
		return isCrm;
	}

	/**
	 * 设置isCrm(是否具有crm功能)
	 * @param isCrm (是否具有crm功能)
	 */
	public void setIsCrm(String isCrm) {
		this.isCrm = isCrm;
	}
    
	/**
	 * 取得IsSale(是否具有销售监控功能)
	 */
	public String getIsSale() {
		return isSale;
	}

	/**
	 * 设置isSale(是否具有销售监控功能)
	 * @param isSale (是否具有销售监控功能)
	 */
	public void setIsSale(String isSale) {
		this.isSale = isSale;
	}
    
	/**
	 * 取得CustomerOneSale(一个客户仅允许一个销售)
	 */
	public String getCustomerOneSale() {
		return customerOneSale;
	}

	/**
	 * 设置customerOneSale(一个客户仅允许一个销售)
	 * @param customerOneSale (一个客户仅允许一个销售)
	 */
	public void setCustomerOneSale(String customerOneSale) {
		this.customerOneSale = customerOneSale;
	}
    
	/**
	 * 取得ProjectState(项目状态)
	 */
	public String getProjectState() {
		return projectState;
	}

	/**
	 * 设置projectState(项目状态)
	 * @param projectState (项目状态)
	 */
	public void setProjectState(String projectState) {
		this.projectState = projectState;
	}
	
	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	public String getPinyin() {
		return pinyin;
	}
	
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
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
    
	
	public CompanyProject(){};


	/**
	 * 
	 * @param id ()
	 * @param companyId ()
	 * @param projectName ()
	 * @param devCode (开放代号)
	 * @param orderIndex ()
	 * @param isCrm (是否具有crm功能)
	 * @param isSale (是否具有销售监控功能)
	 * @param customerOneSale (一个客户仅允许一个销售)
	 * @param projectState (项目状态)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public CompanyProject(    
		int id,
        		int companyId,
        		String projectName,
        		String devCode,
        		int orderIndex,
        		String isCrm,
        		String isSale,
        		String customerOneSale,
        		String projectState,
        		int provinceId,
        		int cityId,
        		String pinyin,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.companyId = companyId;
		this.projectName = projectName;
		this.devCode = devCode;
		this.orderIndex = orderIndex;
		this.isCrm = isCrm;
		this.isSale = isSale;
		this.customerOneSale = customerOneSale;
		this.projectState = projectState;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.pinyin = pinyin;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param companyId ()
	 * @param projectName ()
	 * @param devCode (开放代号)
	 * @param orderIndex ()
	 * @param isCrm (是否具有crm功能)
	 * @param isSale (是否具有销售监控功能)
	 * @param customerOneSale (一个客户仅允许一个销售)
	 * @param projectState (项目状态)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public CompanyProject(    
		int companyId,
        		String projectName,
        		String devCode,
        		int orderIndex,
        		String isCrm,
        		String isSale,
        		String customerOneSale,
        		String projectState,
        		int provinceId,
        		int cityId,
        		String pinyin,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.companyId = companyId;
		this.projectName = projectName;
		this.devCode = devCode;
		this.orderIndex = orderIndex;
		this.isCrm = isCrm;
		this.isSale = isSale;
		this.customerOneSale = customerOneSale;
		this.projectState = projectState;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.pinyin = pinyin;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	

	// ////////////////desc
	public String getDescProjectState(){
		return DescUtils.getCodeDesc(EnumCodeTypeName.PROJECT_STATE, this.projectState, SessionUser.getProjectId());
	}
	
	public String getDescCreatedId(){
		return DescUtils.getUserRealName(this.createdId);
	}
	
	public String getDescModId(){
		return DescUtils.getUserRealName(this.getModId());
	}
	
	public String getDescCompanyId(){
		return DescUtils.getCompanyNameByProjectId(id);
	}
	
	//////////////////desc end

}
