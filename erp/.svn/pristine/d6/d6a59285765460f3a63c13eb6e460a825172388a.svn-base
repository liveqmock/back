package com.ihk.utils.common.listener;

import java.io.Serializable;
import java.util.Date;

import com.ihk.utils.CommonUtils;

/**
 * 用在MyHttpSessionBindingListener中作为key
 * @author dtc
 * 2013-4-2,下午03:32:39
 */
public class HttpSessionBindingListenerKeyBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * sessionId
	 */
	private String sessionId;
	
	/**
	 * session创建时间
	 */
	private long creationTime;
	
	/**
	 * session最后访问时间
	 */
	private long lastAccessedTime;
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}

	public long getLastAccessedTime() {
		return lastAccessedTime;
	}

	public void setLastAccessedTime(long lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}

	public HttpSessionBindingListenerKeyBean() {
		super();
	}
	
	public HttpSessionBindingListenerKeyBean(String sessionId){
		super();
		this.sessionId = sessionId;
	}

	public HttpSessionBindingListenerKeyBean(String sessionId,
			long creationTime, long lastAccessedTime) {
		super();
		this.sessionId = sessionId;
		this.creationTime = creationTime;
		this.lastAccessedTime = lastAccessedTime;
	}
	
	@Override
	public int hashCode() {
		
		return sessionId.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null || !(obj instanceof HttpSessionBindingListenerKeyBean)){
			
			return false;
		}
		
		HttpSessionBindingListenerKeyBean bean = (HttpSessionBindingListenerKeyBean) obj;
		
		if(this.getSessionId().equals(bean.getSessionId())){
			
			return true;
		}
		
		return false;
	}
	
	////
	/**
	 * 创建时间的String
	 */
	public String getCreationTimeStr(){
		
		Date date = new Date(this.getCreationTime());
		
		return CommonUtils.getDateLocalString(date);
	}
	
	/**
	 * 最后访问时间的String ???
	 * @return
	 */
	public String getLastAccessedTimeStr(){
		
		Date date = new Date(this.getLastAccessedTime());
		
		return CommonUtils.getDateLocalString(date);
	}
	
	/**
	 * 持续时间(分钟) ???
	 * @return
	 */
	public long getUsedTimeStr(){
		
		long usedTime = this.getLastAccessedTime() - this.getCreationTime();
		
		return usedTime / 1000 / 60;
		
	}

}
