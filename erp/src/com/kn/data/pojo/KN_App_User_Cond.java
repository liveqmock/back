package com.kn.data.pojo;


import java.util.ArrayList;
import java.util.List;

import com.ihk.permission.PermissionUtils;
import com.ihk.utils.SearchCond;

/**
 * SaleMonitor的查询条件
 */
public class KN_App_User_Cond extends SearchCond{

	private static final long serialVersionUID = 1L;

	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}
