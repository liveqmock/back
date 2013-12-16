package com.ihk.user.action;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.useraccount.UserAccountUtils;

/**
 * 广州用户如果密码是123456
 * 需要进入设置密码再使用
 * 
 * 已经不需要再使用 密码初始已经是默认a123456
 * @author Administrator
 *
 */

public class GuangZhouFirstAction extends SupperAction {
	
	private static final long serialVersionUID = -2945764789478973561L;
	
	@Autowired 
	IUserAccountServices IUserAccountServices;
	
	private String pwd;
	private String vpwd;
	private String tip;
	
	/**
	 * 广州项目 使用123456密码登陆 需要在此修改密码
	 * */
	public String firstLogin(){
		request.getSession().removeAttribute("tip");
		return "indexForSale";
	}
	
	
	/**
	 * 修改密码
	 */
	public String form(){
		if(UserAccountUtils.rightfulPwd(pwd) && UserAccountUtils.rightfulPwd(vpwd)){
			
			UserAccount temp = SessionUser.getSessionUser();
			temp.setUserPwd(this.pwd.trim());
			temp.setModId(SessionUser.getUserId());
			temp.setModTime(new Date());
			IUserAccountServices.updateUserAccount(temp);
			tip = "suc";
			return "success";
			
		}else{
			tip = "fla";
		}
		
		return "indexForSale";
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getVpwd() {
		return vpwd;
	}

	public void setVpwd(String vpwd) {
		this.vpwd = vpwd;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	
	
}
