package com.ihk.utils.common.setup;

import java.util.List;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;

/**
 * 新建售前用户可以跨公司的用户id
 * @author dtc
 * 2013-12-9,上午10:19:17
 */
public class IgnoreCompanyUserAccountIdUtils {
	
	/**
	 * id list
	 */
	private static List<Integer> ids;
	
	public void setIds(List<Integer> ids) {
		IgnoreCompanyUserAccountIdUtils.ids = ids;
	}
	
	public static List<Integer> getIds() {
		return ids;
	}
	
	/**
	 * 判断当前用户是否为忽略公司的用户
	 * @return
	 */
	public static boolean isIgnore(){
		
		if(CommonUtils.isCollectionEmpty(ids)){
			
			return false;
		}
		
		boolean is = false;
		for(int id : ids){
			
			if(id == SessionUser.getUserId()){
				
				is = true;
				break;
			}
		}
		
		return is;
	}

}
