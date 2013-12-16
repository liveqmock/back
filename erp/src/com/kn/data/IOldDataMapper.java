package com.kn.data;

import java.util.List;
import java.util.Map;

import com.kn.data.pojo.KN_App_User;
import com.kn.data.pojo.KN_App_User_Cond;

/**
 * @author 
 *
 */ 
public interface IOldDataMapper {

	/**
	 * 
	 * @param cond
	 * @return
	 */
	public List<KN_App_User> findKN_App_User(KN_App_User_Cond cond) ;

	public List<Map> findIdMapByTableName(String tableName);
	//public List<Map> find楼盘初始_单元(O楼盘初始_单元Cond cond) ;
}
