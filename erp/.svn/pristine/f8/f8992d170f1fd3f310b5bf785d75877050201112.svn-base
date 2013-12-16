package com.ihk.mobile.jquery;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumOperLogType;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.log.OperLogUtils;
import com.ihk.utils.useraccount.UserAccountUtils;

/**
 * jquery mobile的登陆action
 * @author dtc
 * 2013-7-25,上午11:43:58
 */
public class MobileLoginAction extends SupperAction{

	private static final long serialVersionUID = 1137874420509399966L;
	
	@Autowired
	IUserAccountServices userAccountServices;
	
	/**
	 * 跳到登陆界面
	 * @return
	 * @throws Exception
	 */
	public String loginUserAccount() throws Exception{
		
		return "loginUserAccount";
	}
	
	/**
	 * 登陆
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception{
		
		try {
			
			userAccount = userAccountServices.loginUserAccount(userAccount);
			
			if(userAccount == null){
				
				title = "用户名或密码错误";
				OperLogUtils.addLoginLog(userAccount, "customer_guangzhou", EnumOperLogType.LOGIN_ERR_UNAME_PWD_MOBILE, request);
				return "fail";
			}
			
			HttpSession session = request.getSession();
			session.setAttribute(CommonUtils.USER_SESSION_KEY, userAccount);
			
			//如果密码为123456或a123456,提示改密码
			if (userAccount.getUserPwd().equalsIgnoreCase("e10adc3949ba59abbe56e057f20f883e")
                    || userAccount.getUserPwd().equalsIgnoreCase("dc483e80a7a0bd9ef71d8cf973673924")) {
				
				return "toModifyPwd";
			}
			
			OperLogUtils.addLoginLog(userAccount, "customer_guangzhou", EnumOperLogType.LOGIN_MOBILE, request);
			
		}catch (Exception e) {
			
			title = "用户名或密码错误";
			OperLogUtils.addLoginLog(userAccount, "customer_guangzhou", EnumOperLogType.LOGIN_ERR_UNAME_PWD_MOBILE, request);
		}
		
		return "succ";
	}
	
	/**
	 * 修改密码
	 */
	public String modifyPwd() throws Exception{
		
		String ret = "succ";
		
		try{
			
			String pwd1 = request.getParameter("pwd1");
			String pwd2 = request.getParameter("pwd2");
			
			if(!UserAccountUtils.rightfulPwd(pwd1) || !UserAccountUtils.rightfulPwd(pwd2)){
				
				title = "密码不合法";
				return "fail";
			}
			
			if(!pwd1.equals(pwd2)){
				
				title = "两次密码不一致";
				return "fail";
			}
			
			if("123456".equals(pwd1) || "a123456".equals(pwd1)){
				
				title = "密码不合法";
				return "fail";
			}
			
			UserAccount userAccount = SessionUser.getSessionUser();
			userAccount.setUserPwd(pwd1);
			userAccount.setModId(userAccount.getId());
			userAccount.setModTime(new Date());
			
			userAccountServices.updateUserAccount(userAccount);
			
		}catch (Exception e) {
			title = "修改失败,请重试";
			ret = "fail";
		}
		
		return ret;
	}
	
	/**
	 * 退出
	 * @return
	 * @throws Exception
	 */
	public String loginOut() throws Exception{
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "loginOut";
	}
	
	/**
	 * 返回
	 * @return
	 * @throws Exception
	 */
	public String back() throws Exception{
		
		return "back";
	}
	
	////
	/**
	 * 用户
	 */
	private UserAccount userAccount;
	
	/**
	 * 登陆提示
	 */
	private String title;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
}
