package com.kn.data.pojo;

import com.ihk.utils.SearchCond;

public class KN_LPCS_DY_Cond extends SearchCond{
	
	private int 楼阁ID;
	private String 状态;
	
	
	public String get状态() {
		return 状态;
	}

	public void set状态(String 状态) {
		this.状态 = 状态;
	}

	public int get楼阁ID() {
		return 楼阁ID;
	}

	public void set楼阁ID(int 楼阁id) {
		楼阁ID = 楼阁id;
	}
	

}
