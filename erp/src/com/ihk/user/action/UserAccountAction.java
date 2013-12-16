package com.ihk.user.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContAccountType;
import com.ihk.constanttype.ContCompanyId;
import com.ihk.constanttype.EnumOperLogType;
import com.ihk.setting.data.pojo.OperLog;
import com.ihk.setting.data.services.IOperLogServices;
import com.ihk.user.data.ICompanyProjectMapper;
import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.Team;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserAccountCond;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.Md5Security;
import com.ihk.utils.Pager;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.VildateInnerUserAccount;
import com.opensymphony.xwork2.ActionContext;

/**
 * 用户登录主要类
 * 根据账号判断需要用到那个crm
 * 以及登录的log
 * */
public class UserAccountAction extends SupperAction{
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private IUserAccountServices userServices;
	@Autowired
	private ICompanyProjectMapper projectMapper;
	@Autowired private IOperLogServices iOperLogServices;
	
	private UserAccount userAccount = null;
	private List<UserAccount> userAccountList = null;
	private String tips;
	private String id = null;

	// 下拉列表
	private List<Company> companyList;
	private List<Team> teamList;
	private List<CompanyProject> projectList;

	// 密码验证
	private String pwdValidation;

	//
	private UserAccountCond userCond = new UserAccountCond();
	private UserAccount loginAccount;

	public static final String ISDELETED_YES = "1";
	public static final String ISDELETED_NO = "0";
	public static final String ACCOUNT_TYPE_1 = "1";
	public static final String ACCOUNT_TYPE_2 = "2";
	
	private static final boolean checkUnbind = false;//内网绑定检测开关
	/******* action ********/

	private String actionFront; // action的前部分

	public void setActionFront(String actionFront) {
		this.actionFront = actionFront;
	}

	public String getActionFront() {
		return actionFront;
	}

	/**
	 * login.jsp 用户登录
	 * @return
	 */
	public String loginUserAccount() {
		UserAccount loginUser = null;
		String result = "error";
		String logPwd = userAccount.getUserPwd();
		// name password validation

		// 先进行验证码的判断
		String getRand = request.getParameter("code");
		if (request.getSession().getAttribute("rand") == null) {
			this.setTips("验证码错误");
			return result;
		}

		// 测试使用 top
		String localAddr = getRemoteAddr();// http://172.16.6.40:8080
		int port = request.getLocalPort();
		if (("172.16.6.40".equals(localAddr) && port == 8080) || "10.10.3.33".equals(localAddr) 
				||"172.16.6.22".equals(localAddr)|| "172.16.6.61".equals(localAddr) || "172.16.6.62".equals(localAddr) || "127.0.0.1".equals(localAddr)) { //10.10.3.33:8081
			// 表示为本地测试,不用去判断验证码
			getRand = request.getSession().getAttribute("rand").toString();
		}
		// 测试使用end

		String rand = request.getSession().getAttribute("rand").toString();
		if (!rand.equalsIgnoreCase(getRand)) {
			this.setTips("验证码错误");
			return result;
		}

		try {
			String tempPwd = userAccount.getUserPwd();
			loginUser = userServices.loginUserAccount(userAccount);
			//如果验证没有通过 尝试验证内网账户密码     userAccount.getUserName   userAccount.getUserPassWord
			//如果通过了 根据内网账户找到  useraccount 模拟登陆
			
			if (loginUser == null) {
				UserAccount ac ;
				ac = userServices.loginInnerUser(userAccount.getUserName());
				if(ac == null){
					this.setTips("账号密码错误");
					//记录登陆失败记录 
					operLog(userAccount,localAddr,logPwd);
					return result;
				}
				VildateInnerUserAccount vi = new VildateInnerUserAccount();
				if(vi.valiPwdForBandAccount(userAccount.getUserName(), tempPwd, "URL_1", request)){
					loginUser = userServices.loginInnerUser(userAccount.getUserName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips(e.toString());
		}
		if (loginUser == null) {
			this.setTips("账号密码错误");
			//记录登陆失败记录 
			operLog(userAccount,localAddr,logPwd);
			return result;
		} else if (loginUser.getIsDeleted().equals(ISDELETED_YES)) {
			this.setTips("账号过期");
			return result;
		} else {
			// 内网判断
			if (checkUnbind) {
				if (!ContAccountType.UNBIND_CHECK.equals(loginUser
						.getAccountType())) {
					if (loginUser.getInnerUserName() == null) {
						Date today = new Date();
						Date createdTime = loginUser.getCreatedTime();
						Date flagDate = CommonUtils
								.getDateFromString("2013-09-01");
						if (flagDate.compareTo(createdTime) < 0) {
							int count = DateTimeUtils
									.getDaysBetween(DateTimeUtils
											.getDateFormatStr(createdTime),
											DateTimeUtils
													.getDateFormatStr(today));
							if (count > 60) {
								this.setTips("账号未在60天内绑定内网帐号，已被停用，请联系您公司的管理员");
								return result;
							}
							request.getSession().setAttribute("count",
									60 - count);
						}
					}
				}
			}
				
			result = "success";
			
			// set loginuser
			loginAccount = loginUser;
			HttpSession session = request.getSession();

			// 跟进projectId,查出其对应的actionFront

			int projectId = loginAccount.getProjectId();
			// 广州项目的project id 为0,company id 为17
			int companyId = loginAccount.getCompanyId();

			CompanyProject cProject = new CompanyProject();
			String devCode = "";

			if (companyId == ContCompanyId.GUANG_ZHOU) {

				devCode = "customer_guangzhou";
			} else {

				cProject = projectMapper.findCompanyProjectById(projectId);
				devCode = cProject.getDevCode();

			}

			if ("customer_guangzhou".equalsIgnoreCase(devCode)) {
				result = "guangzhou";

				if (loginUser.getUserPwd().equalsIgnoreCase("e10adc3949ba59abbe56e057f20f883e")
                        || loginUser.getUserPwd().equalsIgnoreCase("dc483e80a7a0bd9ef71d8cf973673924")) {

					result = "guangzhoufirstlogin";
				}

			}

//			if (projectId == 30) {
//				result = "tree";
//			}

			String filterProject = "";
			if (!CustomerUtils.isStrEmpty(devCode)) {

				setActionFront(devCode);
				filterProject = devCode.substring(devCode.lastIndexOf('_') + 1);

			} else {
				// 暂时表示为恒大
				filterProject = "hengda";

				result = "hengda";
				// 判断密码是否是123456
				if (loginUser.getUserPwd().equalsIgnoreCase("e10adc3949ba59abbe56e057f20f883e")) {

					result = "hengdafirstlogin";
				}

				// 测试使用 top
				if ("172.16.6.40".equals(localAddr) && port == 8080) {
					result = "hengda";
				}
				// 测试使用 end
			}
			
			session.setAttribute("filterProject", filterProject); // 在过滤器中使用,避免登陆成功后利用地址栏跳到别的项目
			
			//记录登陆成功记录
			OperLog oper = new OperLog();
			oper.setLogTime(new Date());
			if(devCode == null){
				oper.setDevFlag("");
			}else{
				oper.setDevFlag(devCode);
			}
			
			oper.setUserId(loginUser.getId());
			oper.setProjectId(loginUser.getProjectId());
			oper.setLogType(EnumOperLogType.LOGIN.toString());
			oper.setLogDesc("ip = "+localAddr);
			iOperLogServices.addOperLog(oper);
		}

		HttpSession session = request.getSession();
		
		session.setAttribute(CommonUtils.USER_SESSION_KEY, loginUser);
		
		//session.setAttribute(CommonUtils.USER_SESSION_KEY, loginUser);
//
//		if (loginAccount.getProjectId() == 99) {
//			result = "permission"; // 调试权限管理界面使用
//			// result = "article";
//		}
		
		
		this.setTips("");
		return result;
	}

	/** 新建用户 */
	public String addUserAccountJsp() {
		projectList = this.projectMapper.findCompanyProject();

		return "addUserAccountJsp";
	}

	/** 新建用户action 必要权限manager */
	@SuppressWarnings("deprecation")
	public String addUserAccount() {
		String result = "error";
		if (!SessionUser.isAdmin()) {
			this.tips = "没有权限，请重新登录";
			return result;
		}
		if (userServices.valUserByName(userAccount)) {
			this.setTips("已经有此账户，请选择另外账户名");
			return result;
		}
		try {
			if (userAccount.getUserPwd().length() < 6) {
				this.setTips("没有输入或者输入过短（密码至少6位）");
				return result;
			}
			for (CompanyProject c : this.projectMapper.findCompanyProject()) {
				if (c.getId() == userAccount.getProjectId())
					userAccount.setCompanyId(c.getCompanyId());
			}
			userAccount.setIsDeleted(ISDELETED_NO);
			userAccount.setAccountType(ContAccountType.MANAGER);
			userAccount.setModId(SessionUser.getUserId());
			userAccount.setCreatedId(SessionUser.getUserId());
			userAccount.setCreatedTime(new Date(System.currentTimeMillis()));
			userAccount.setModTime(new Date(System.currentTimeMillis()));
			this.userServices.saveUserAccount(userAccount);
			result = "addUserAccount";
			this.setTips("已保存");
		} catch (Exception e) {
			this.setTips("system error");
			e.printStackTrace();
		}
		return result;
	}

	@Deprecated
	@SuppressWarnings("unchecked")
	public String indexUserAccount() {
		String result = "error";
		try {
			if (!SessionUser.isAdmin()) {
				this.tips = "没有权限，请重新登录";
				return result;
			}
		} catch (Exception e) {
			this.tips = "没有权限，请重新登录";
			return result;
		}

		HttpSession session = request.getSession();
		try {
			if (tips.equals("reset")) {
				session.removeAttribute("userCond");
			}
		} catch (Exception e) {
		}
		try {
			Object getCond = session.getAttribute("userCond");
			if (getCond == null) {
				if (userCond == null) {
					userCond = new UserAccountCond();
				}
			} else {
				if (userCond.getUserName() == "") {
					try {
						HashMap<String, String> map = (HashMap<String, String>) getCond;
						String searchName = map.get("userName");
						userCond = new UserAccountCond();
						userCond.setUserName(searchName);
					} catch (Exception e) {
						UserAccountCond getUserCond = (UserAccountCond) getCond;
						userCond = getUserCond;
					}
				}
			}

			String action = CustomerUtils.getActionNameFromRequest(request);
			Pager page = new Pager(ActionContext.getContext(), 10, action);
			userCond.setProId(SessionUser.getProjectId());
			userCond.recordCount = userServices.findUserAccountCount(userCond);
			page.setCond(userCond);
			userAccountList = userServices.findUserAccountPage(userCond);
			this.setShowPage(page.toHtmlString());
			session.setAttribute("userCond", userCond);
			result = "indexUserAccount";
		} catch (Exception e) {
			result = "error";
			this.tips = "系统错误";
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 2012/09/27已重做用户管  这里已经弃用
	 * */
	public String updateUserAccountJsp() {
		String result = "error";
		try {
			loginAccount = (UserAccount) request.getSession().getAttribute(
					CommonUtils.USER_SESSION_KEY);
			UserAccount tempUser = userServices.findUserAccountById(Integer
					.parseInt(this.getId()));
			request.getSession().setAttribute(CommonUtils.USER_SESSION_KEY, loginAccount);
			request.getSession().setAttribute("tempUser", tempUser);
			request.getSession().setAttribute("updateUserId", this.getId());
			if (null == this.getId()) {
				result = "updateUserAccountJsp_user";
			} else {
				result = "updateUserAccountJsp_manager";
			}

		} catch (Exception e) {
			e.printStackTrace();
			this.tips = "权限丢失";
		}
		this.tips = "操作成功";
		return result;
	}

	public String updateUserAccountJsp_user() {
		String result = "error";
		try {
			loginAccount = (UserAccount) request.getSession().getAttribute(
					CommonUtils.USER_SESSION_KEY);
			request.getSession().setAttribute(CommonUtils.USER_SESSION_KEY, loginAccount);
			request.getSession().setAttribute("updateUserId", this.getId());
			result = "updateUserAccountJsp_user";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Deprecated
	public String updateUserAccount() {
		String result = "error";
		String type = "0";
		try {
			loginAccount = (UserAccount) request.getSession().getAttribute(
					CommonUtils.USER_SESSION_KEY);
			type = this.userAccountType(loginAccount);
			if (!type.equals(ACCOUNT_TYPE_2)) {
				this.tips = "没有权限，请重新登录";
				return result;
			}
		} catch (Exception e) {
			this.tips = "没有权限，请重新登录";
			return result;
		}

		try {
			UserAccount tempUser = (UserAccount) request.getSession()
					.getAttribute("tempUser");
			loginAccount = (UserAccount) request.getSession().getAttribute(
					CommonUtils.USER_SESSION_KEY);
			tempUser.setId(Integer.parseInt((String) request.getSession()
					.getAttribute("updateUserId")));
			tempUser.setUserName(userAccount.getUserName());
			tempUser.setUserPwd(userAccount.getUserPwd());
			tempUser.setModId(loginAccount.getId());
			tempUser.setCreatedId(loginAccount.getId());
			tempUser.setModTime(new Date(System.currentTimeMillis()));
			this.userServices.updateUserAccount(tempUser, "pwd");
			result = "success";
			this.setTips("已修改");
		} catch (Exception e) {
			this.setTips("system error");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 
	 * 修改密码页面action
	 * */
	String oldPwd; // 旧密码

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = Md5Security.encString(oldPwd);
	}

	public String updatePwd() {
		String result = "error";
		// System.out.println("oldPwd="+oldPwd);
		// System.out.println("pwd="+SessionUser.getSessionUser().getUserPwd());
		if (oldPwd != null) {
			if (!oldPwd.equals(SessionUser.getSessionUser().getUserPwd())) {
				this.tips = "旧密码错误。";
				return result;
			}
		}
		if (userAccount.getUserPwd().length() < 6
				|| !userAccount.getUserPwd().equals(pwdValidation)) {
			this.tips = "密码太短，或者两次输入不同";
			return result;
		}
		try {
			loginAccount = (UserAccount) request.getSession().getAttribute(
					CommonUtils.USER_SESSION_KEY);
			loginAccount.setUserPwd(userAccount.getUserPwd());
			loginAccount.setModId(loginAccount.getId());
			loginAccount.setModTime(new Date(System.currentTimeMillis()));
			this.userServices.updateUserAccount(loginAccount, "pwd");
			result = "updatePwd";
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.tips = "修改成功";
		return result;
	}

	/**
	 * 管理员修改普通用户信息action 检查权限 只能修改所属用户
	 * */
	public String updatePwdByManager() {
		String result = "error";
		String type = "0";
		try {
			loginAccount = (UserAccount) request.getSession().getAttribute(
					CommonUtils.USER_SESSION_KEY);
			type = this.userAccountType(loginAccount);
			if (!type.equals(ACCOUNT_TYPE_2)) {
				this.tips = "没有权限，请重新登录";
				return result;
			}
		} catch (Exception e) {
			this.tips = "没有权限，请重新登录";
			return result;
		}
		UserAccount updateUser = this.userServices
				.findUserAccountById(userAccount.getId());
		boolean setPwd = false;
		if (userAccount.getIsDeleted().equals(updateUser.getIsDeleted())) {
			if (userAccount.getUserPwd().length() < 6) {
				this.tips = "密码太短，或者两次输入不等";
				return result;
			}
			setPwd = true;
		} else {
			setPwd = false;
		}
		try {
			if (!updateUser.getAccountType().equals(ACCOUNT_TYPE_1)) {
				this.tips = "没有权限，请重新登录";
				return result;
			}
			loginAccount = (UserAccount) request.getSession().getAttribute(
					CommonUtils.USER_SESSION_KEY);
			updateUser.setIsDeleted(userAccount.getIsDeleted());
			String upt = "type";
			if (setPwd) {
				upt = "pwd";
				updateUser.setUserPwd(userAccount.getUserPwd());
			} else {
				upt = "type";
			}
			updateUser.setModId(loginAccount.getId());
			updateUser.setModTime(new Date(System.currentTimeMillis()));
			this.userServices.updateUserAccount(updateUser, upt);
			this.tips = "操作成功，请返回";
			result = "updatePwdByManager";
		} catch (Exception e) {
			this.tips = "系统错误，请重新登录";
			e.printStackTrace();
		}
		return result;
	}

	/********* util ***********/

	/**
	 * 查询用户状态
	 * */
	public String userAccountType(UserAccount user) throws Exception {
		String type = ISDELETED_YES;

		UserAccount temp = this.userServices.findUserAccountById(user.getId());
		if (temp.getIsDeleted().equals(ISDELETED_YES)) {
			// 禁用账户
			return type;
		}
		type = temp.getAccountType();
		return type;
	}

	// 分页查询 user_account
	public List<UserAccount> findUserAccount() throws RuntimeException {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginResult", 0);
		map.put("resultSize", 10);
		// userAccountList = userServices.findUserAccountPage(map);
		return null;
	}

	/**
	 * 记录登陆记录
	 * */
	private void operLog(UserAccount userAccount,String localAddr,String logPwd){
		UserAccount temp = DescUtils.getUserAccountByUserName(userAccount.getUserName());
		
		
		OperLog oper = new OperLog();
		oper.setLogTime(new Date());
		oper.setDevFlag("");
		if(temp != null){
			if(temp.getProjectId() == 0){
				oper.setDevFlag("");
			}else{
				oper.setDevFlag(DescUtils.getCompanyProjectByProjectId(temp.getProjectId()).getDevCode());
			}
			oper.setUserId(temp.getId());
			oper.setProjectId(temp.getProjectId());
		}else{
			oper.setUserId(0);
			oper.setProjectId(0);
		}
		
		oper.setLogType(EnumOperLogType.LOGIN_ERR_PWD.toString());
		oper.setLogDesc("ip = "+localAddr+";username = "+userAccount.getUserName());
		iOperLogServices.addOperLog(oper);
	}
	
	
	// public void findAllUserAccount() {
	// // 加载所有userACCOUNT数据
	// try {
	// userAccountList = userServices.findAllUserAccount();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/* =========== */
	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public List<UserAccount> getUserAccountList() {
		return userAccountList;
	}

	public void setUserAccountList(List<UserAccount> userAccountList) {
		this.userAccountList = userAccountList;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
		request.getSession().setAttribute("tips", tips);
		request.getSession().setAttribute("loginName",
				userAccount.getUserName());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

	public List<Team> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}

	public UserAccount getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(UserAccount loginAccount) {
		this.loginAccount = loginAccount;
	}

	public List<CompanyProject> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<CompanyProject> projectList) {
		this.projectList = projectList;
	}

	public String getPwdValidation() {
		return pwdValidation;
	}

	public void setPwdValidation(String pwdValidation) {
		this.pwdValidation = pwdValidation;
	}

	public UserAccountCond getUserCond() {
		return userCond;
	}

	public void setUserCond(UserAccountCond userCond) {
		this.userCond = userCond;
	}

    private String getRemoteAddr() {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

}
