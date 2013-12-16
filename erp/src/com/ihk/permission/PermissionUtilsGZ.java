package com.ihk.permission;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ihk.utils.SessionUser;

/**
 * 广州权限的静态工具类
 * @author peter.kuang
 *
 */
public class PermissionUtilsGZ {

	private static final Logger logger = Logger.getLogger(PermissionUtilsGZ.class); 	

//	public static final int ROLE_ID_SALES = 11;//销售人员
//	public static final int ROLE_ID_HEAD = 12;//销售主管
//	public static final int ROLE_ID_MANAGER = 13;//销售经理
//	public static final int ROLE_ID_PROJECT_MANAGER = 14;//项目经理
//	public static final int ROLE_ID_GENERAL_MANAGER = 15;//总经理
//	public static final int ROLE_ID_MAINTAIN = 16;//后台维护人员
//		
//
//	//当前用户管理的项目id列表
//	public static List<Integer> getManageProjectIds()  {
//		return getManageProjectIdsByUid(SessionUser.getUserId());
//	}
//	
//	//指定用户管理的项目id列表
//	//得到这个以后，sql是增加or条件
//	public static List<Integer> getManageProjectIdsByUid(int userId)  {
//
//		List<Integer> listProjectIds = new ArrayList();
//		
//		return listProjectIds;
//	}
}
