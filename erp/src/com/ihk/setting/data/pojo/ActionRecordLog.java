package com.ihk.setting.data.pojo;

import java.io.Serializable;
import java.util.Date;

import com.ihk.utils.DescUtils;

/**
 * OperLog的实体类
 * @author peter.kuang
 *
 */
public class ActionRecordLog implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private String logType;
	private String logDesc;
	private int projectId;
	private int userId;
	private Date logTime;
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
	 * 取得LogType(日志类型)
	 */
	public String getLogType() {
		return logType;
	}

	/**
	 * 设置logType(日志类型)
	 * @param logType (日志类型)
	 */
	public void setLogType(String logType) {
		this.logType = logType;
	}
    
	/**
	 * 取得LogDesc(日志描述)
	 */
	public String getLogDesc() {
		return logDesc;
	}

	/**
	 * 设置logDesc(日志描述)
	 * @param logDesc (日志描述)
	 */
	public void setLogDesc(String logDesc) {
		this.logDesc = logDesc;
	}
    
	/**
	 * 取得ProjectId(项目id)
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * 设置projectId(项目id)
	 * @param projectId (项目id)
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
    
	/**
	 * 取得UserId(用户id)
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * 设置userId(用户id)
	 * @param userId (用户id)
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
    
	/**
	 * 取得LogTime(日志时间)
	 */
	public Date getLogTime() {
		return logTime;
	}

	/**
	 * 设置logTime(日志时间)
	 * @param logTime (日志时间)
	 */
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
    
	
	public ActionRecordLog(){};


	/**
	 * 
	 * @param id ()
	 * @param logType (日志类型)
	 * @param logDesc (日志描述)
	 * @param projectId (项目id)
	 * @param userId (用户id)
	 * @param logTime (日志时间)
	 */
	public ActionRecordLog(    
		int id,
        		String devFlag,
        		String logType,
        		String logDesc,
        		int projectId,
        		int userId,
        		Date logTime
        ) {
		super();  
		this.id = id;
		this.logType = logType;
		this.logDesc = logDesc;
		this.projectId = projectId;
		this.userId = userId;
		this.logTime = logTime;
	}
    
	/**
	 * 
	 * @param logType (日志类型)
	 * @param logDesc (日志描述)
	 * @param projectId (项目id)
	 * @param userId (用户id)
	 * @param logTime (日志时间)
	 */
	public ActionRecordLog(    
		String devFlag,
        		String logType,
        		String logDesc,
        		int projectId,
        		int userId,
        		Date logTime
        ) {
		super();		
		this.logType = logType;
		this.logDesc = logDesc;
		this.projectId = projectId;
		this.userId = userId;
		this.logTime = logTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	

	//desc start
	public String getDescProjectId(){
		if(this.projectId == 0)return "";
		return DescUtils.getCompanyProjectRealName(this.projectId);
	}
	
	public String getRealName(){
		if(this.userId == 0)return "";
		return DescUtils.getUserRealName(this.userId);
	}
	
	public String getUserName(){
		if(this.userId == 0)return "";
		return DescUtils.getUserAccountById(this.userId).getUserName();
	}
	
	public String getCompanyName(){
		if(this.userId==0) return "";
		return DescUtils.getCompanyRealName(DescUtils.getUserAccountById(this.userId).getCompanyId());
	}
	//desc end
}
