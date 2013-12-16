package com.ihk.sale.action.guangzhou;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.pojo.UserRoleCond;
import com.ihk.user.data.services.IUserRoleServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 显示我的角色
 */
public class ShowMyRoleAction extends SupperAction{

	private static final long serialVersionUID = 1L;

	@Autowired IUserRoleServices IUserRoleServices;
	
	private List<UserRole> myRoleList; 
	
	/**
	 * @param myRoleList 我的角色列表
	 * */
	public String showMyRole(){
		
		try {
			this.myRoleList = this.IUserRoleServices.findUserRoleByUserId(SessionUser.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "suc";
	}

	public List<UserRole> getMyRoleList() {
		return myRoleList;
	}
	
	
}
