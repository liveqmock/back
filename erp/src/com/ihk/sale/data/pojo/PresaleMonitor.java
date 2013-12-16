package com.ihk.sale.data.pojo;

import java.util.Date;
import java.io.Serializable;

import com.ihk.utils.DescUtils;

/**
 * PresaleMonitor的实体类
 * @author 
 *
 */
public class PresaleMonitor implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private String monitorDate;
	private int projectId;
	private int companyId;
	private int phoneNum;
	private int visitorNum;
	private int intentionNum;
	private int intentionAll;
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
	 * 取得MonitorDate(日期)
	 */
	public String getMonitorDate() {
		return monitorDate;
	}

	/**
	 * 设置monitorDate(日期)
	 * @param monitorDate (日期)
	 */
	public void setMonitorDate(String monitorDate) {
		this.monitorDate = monitorDate;
	}
    
	/**
	 * 取得ProjectId(所属项目)
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * 设置projectId(所属项目)
	 * @param projectId (所属项目)
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
    
	/**
	 * 取得CompanyId(所属公司)
	 */
	public int getCompanyId() {
		return companyId;
	}

	/**
	 * 设置companyId(所属公司)
	 * @param companyId (所属公司)
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
    
	/**
	 * 取得PhoneNum(来电数)
	 */
	public int getPhoneNum() {
		return phoneNum;
	}

	/**
	 * 设置phoneNum(来电数)
	 * @param phoneNum (来电数)
	 */
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
    
	/**
	 * 取得VisitorNum(来访数)
	 */
	public int getVisitorNum() {
		return visitorNum;
	}

	/**
	 * 设置visitorNum(来访数)
	 * @param visitorNum (来访数)
	 */
	public void setVisitorNum(int visitorNum) {
		this.visitorNum = visitorNum;
	}
    
	/**
	 * 取得IntentionNum(当日认筹数)
	 */
	public int getIntentionNum() {
		return intentionNum;
	}

	/**
	 * 设置intentionNum(当日认筹数)
	 * @param intentionNum (当日认筹数)
	 */
	public void setIntentionNum(int intentionNum) {
		this.intentionNum = intentionNum;
	}
    
	/**
	 * 取得IntentionAll(累计认筹数)
	 */
	public int getIntentionAll() {
		return intentionAll;
	}

	/**
	 * 设置intentionAll(累计认筹数)
	 * @param intentionAll (累计认筹数)
	 */
	public void setIntentionAll(int intentionAll) {
		this.intentionAll = intentionAll;
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
    
	
	public PresaleMonitor(){};


	/**
	 * 
	 * @param id ()
	 * @param monitorDate (日期)
	 * @param projectId (所属项目)
	 * @param companyId (所属公司)
	 * @param phoneNum (来电数)
	 * @param visitorNum (来访数)
	 * @param intentionNum (当日认筹数)
	 * @param intentionAll (累计认筹数)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public PresaleMonitor(    
		int id,
        		String monitorDate,
        		int projectId,
        		int companyId,
        		int phoneNum,
        		int visitorNum,
        		int intentionNum,
        		int intentionAll,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.monitorDate = monitorDate;
		this.projectId = projectId;
		this.companyId = companyId;
		this.phoneNum = phoneNum;
		this.visitorNum = visitorNum;
		this.intentionNum = intentionNum;
		this.intentionAll = intentionAll;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param monitorDate (日期)
	 * @param projectId (所属项目)
	 * @param companyId (所属公司)
	 * @param phoneNum (来电数)
	 * @param visitorNum (来访数)
	 * @param intentionNum (当日认筹数)
	 * @param intentionAll (累计认筹数)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public PresaleMonitor(    
		String monitorDate,
        		int projectId,
        		int companyId,
        		int phoneNum,
        		int visitorNum,
        		int intentionNum,
        		int intentionAll,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.monitorDate = monitorDate;
		this.projectId = projectId;
		this.companyId = companyId;
		this.phoneNum = phoneNum;
		this.visitorNum = visitorNum;
		this.intentionNum = intentionNum;
		this.intentionAll = intentionAll;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	
	
	

	public String getProjectId_desc() throws Exception {
		return DescUtils.getCompanyProjectRealName(projectId);
	}

	public String getCompanyId_desc() throws Exception {
		return DescUtils.getCompanyRealName(companyId);
	}
}
