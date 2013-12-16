package com.ihk.sale.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 重置密码
 * @author peter.kuang
 *
 */
public class SetPWD extends SupperAction{
	private static final long serialVersionUID = 1L;
	
	@Autowired IUserAccountServices iUserAccountServices;
	
	private String RESULT_SETPWD = "setPWD";
	private int PWDLENTH = 6;
	private String MASSG1 = "请设置至少 6 位的密码";
	private String MASSG2 = "两次输入密码不相等";
	
	private String oldPWD;
	private String vilPWD;
	private UserAccount updateUser;
	/*************************setPWD***************************************************/
	
	/**初始化修改密码页面*/
	public String indexPWD(){
		return RESULT_SETPWD;
	}
	
	/**修改自己的密码*/
	public String updatePWD(){
		if(!vilRoleByUpdatePWD()){			
			return RESULT_SETPWD;
		}
		iUserAccountServices.updateUserAccount(updateUser, "");
		return RESULT_SETPWD;
	}
	
	private boolean vilRoleByUpdatePWD(){
		boolean vil = true;
		if(updateUser.getUserPwd() == null || updateUser.getUserPwd().length() < this.PWDLENTH){
			addActionMessage(this.MASSG1);
			return false;
		}
		if(!vilPWD.equals(updateUser.getUserPwd())){
			addActionMessage(this.MASSG2);
			return false;
		}
		if(!oldPWD.equals(SessionUser.getSessionUser().getUserPwd())){
			return false;
		}
		return vil;
	}	
}
