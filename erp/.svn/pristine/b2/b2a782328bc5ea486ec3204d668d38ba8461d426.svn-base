package com.ihk.sale.action.guangzhou;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.Md5Security;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 重置密码
 */
public class SetMyPwdAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	@Autowired IUserAccountServices iUserAccountServices;
    @Autowired
    private IUserAccountServices userServices;

	private String oldPwd;
	private String newPwd;
	private String vilPwd;
	private UserAccount updateUser ;
	
	public SetMyPwdAction(){
		super();
		updateUser = SessionUser.getSessionUser();
		
	}
	
	public String setPwd(){
		
		return "setpwd";
	}
	
	
	public String setPwdForm(){
		if(vil()){

			updateUser.setUserPwd(newPwd.trim());
			iUserAccountServices.updateUserAccount(updateUser);
			addActionMessage("修改成功");
		}
		return "setpwd";
	}
	
	//验证表单
	public boolean vil(){
        UserAccount ua = new UserAccount();
        ua.setUserName(updateUser.getUserName());
        ua.setUserPwd(oldPwd.trim());

        UserAccount loginUser = userServices.loginUserAccount(ua);

		if(vilPwd == null || vilPwd.trim() == ""
			|| newPwd == null || newPwd == null ||
			newPwd.trim().equals("")){
			addActionMessage("不能为空");
			return false;
		}else if(!newPwd.trim().equals(vilPwd.trim())){
			addActionMessage("两次输入密码不相等");
			return false;
		}else if(newPwd.trim().length() < 6){
			addActionMessage("密码最少为6位");
			return false;
		}else if(loginUser==null){
			addActionMessage("旧密码错误");
			return false;
		}
		
		return true;
	}


	public String getOldPwd() {
		return oldPwd;
	}


	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}


	public String getNewPwd() {
		return newPwd;
	}


	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}


	public String getVilPwd() {
		return vilPwd;
	}


	public void setVilPwd(String vilPwd) {
		this.vilPwd = vilPwd;
	}
	
	
}
