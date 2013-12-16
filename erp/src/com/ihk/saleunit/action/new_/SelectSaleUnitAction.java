package com.ihk.saleunit.action.new_;

import java.util.List;

import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;



/**
 * 处理有多个销控中心权限的情况
 * 
 * */
public class SelectSaleUnitAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	private int type;
	
	/**
	 * 楼盘建档选择
	 * @return suc 有多个权限
	 * @return onlyone 只有一个销控中心权限
	 * */
	public String saleUnitInitSelect(){
		
		//一个根据权限的跳转,如果拥有多个项目的销控中心权限 则去到选择项目页面 , 如果只有一个的话  直接进入
		List<UserRole> rr = PermissionUtils.getUserRoleListByUserIdAndRoleId(SessionUser.getUserId(),19);
		
		int rolesize = rr.size();
		if(rolesize > 1){
			return type2(rr);
			/*switch (type) {
			case 1:
				return type1(rr);//建档

			case 2:
				return type2(rr);//销控中心
				
			case 3:
				return type3(rr);//财务
			case 4:
				return type4(rr);//组团
			case 5:
				return type5(rr);//认筹
			case 6:
				return type6(rr);//综合
			}*/
		}
		switch (type) {
		case 1:
			return "onlyone1";

		case 2:
			return "onlyone2";
			
		case 3:
			return "onlyone3";
		case 4:
			return "onlyone4";
		case 5:
			return "onlyone5";
		case 6:
			return "onlyone6";
		default:
			return "onlyone1";
		}
		
	}
	
	
	private List<UserRole> userRoleList;
	private String type1(List<UserRole> rr){//建档
	
		userRoleList = rr;
		return "type1";
	}
	
	private String type2(List<UserRole> rr){
		userRoleList = rr;
		return "type2";
	}
	
	private String type3(List<UserRole> rr){
		userRoleList = rr;
		return "type3";
	}
	
	private String type4(List<UserRole> rr){
		userRoleList = rr;
		return "type3";
	}
	
	private String type5(List<UserRole> rr){
		userRoleList = rr;
		return "type3";
	}
	
	private String type6(List<UserRole> rr){
		userRoleList = rr;
		return "type3";
	}
	
	
	private int projectId;
	public String joinSaleunit(){
		SessionUser.getSessionUser().setProjectId(projectId);
		switch (type) {
		case 1:
			return "onlyone1";

		case 2:
			return "onlyone2";
			
		case 3:
			return "onlyone3";
		case 4:
			return "onlyone4";
		case 5:
			return "onlyone5";
		case 6:
			return "onlyone6";
		default:
			return "onlyone1";
		}
	}
	


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<UserRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	
	
}
