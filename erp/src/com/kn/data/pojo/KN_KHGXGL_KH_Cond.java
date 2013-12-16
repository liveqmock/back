package com.kn.data.pojo;

import com.ihk.utils.SearchCond;

public class KN_KHGXGL_KH_Cond extends SearchCond{
	private int begId;
	private int idlength;
	
	private int limitmin ;
	private int limitmax ;
	
	
	
	public int getLimitmin() {
		return limitmin;
	}
	public void setLimitmin(int limitmin) {
		this.limitmin = limitmin;
	}
	public int getLimitmax() {
		return limitmax;
	}
	public void setLimitmax(int limitmax) {
		this.limitmax = limitmax;
	}
	public int getBegId() {
		return begId;
	}
	public void setBegId(int begId) {
		this.begId = begId;
	}
	public int getIdlength() {
		return idlength;
	}
	public void setIdlength(int idlength) {
		this.idlength = idlength;
	}
	
	

}
