package com.ihk.user.data.services.impl;


import com.ihk.constanttype.EnumOperLogType;
import com.ihk.setting.data.IOperLogMapper;
import com.ihk.setting.data.pojo.OperLog;
import com.ihk.user.data.IUserAccountMapper;
import com.ihk.user.data.IUserRoleMapper;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserAccountCond;
import com.ihk.user.data.pojo.UserRoleCond;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CacheUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.cache.MyCacheTemplate;
import com.ihk.utils.cache.MyCacheTemplateCallback;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userAccountServices")
@SuppressWarnings({"unchecked","unused","rawtypes"})
public class UserAccountServices implements IUserAccountServices {
	@Autowired
	IUserAccountMapper userAccountMapper;
	@Autowired
	IUserRoleMapper userRoleMapper;
	@Autowired
	IOperLogMapper IOperLogMapper;

	private static final Logger logger = Logger
			.getLogger(UserAccountServices.class);

	private static final String cacheKeyList = "useraccount.list";
	private static final String cacheKeyOne = "useraccount.one";

	public static final String UPDATE_USER_ACCOUNT_TYPE_PWD = "pwd";
	@Override
	public void updateUserAccount(UserAccount userAccount, String upt)
			throws RuntimeException {
		
		String temp = "";

		if (upt.equalsIgnoreCase("pwd")) {
			temp = com.ihk.utils.Md5Security
					.encString(userAccount.getUserPwd());
			userAccount.setUserPwd(temp);
		} else if (upt.equalsIgnoreCase("type")) {

		}
		userAccount.setModTime(new Date());
		userAccount.setModId(SessionUser.getUserId());
		userAccountMapper.updateUserAccount(userAccount);
		
		OperLog oper= new OperLog();
		oper.setLogType(EnumOperLogType.CHANGE_USER_ACCOUNT.toString());
		oper.setLogTime(new Date());
		oper.setUserId(SessionUser.getUserId());
		oper.setProjectId(0);
		oper.setLogDesc("");
		oper.setDevFlag("");
		IOperLogMapper.addOperLog(oper);
		CacheUtils.removeCache(cacheKeyOne, userAccount.getId());
	}
	@Override
	public void updateUserAccount(UserAccount userAccount)
			throws RuntimeException {
		String temp = "";
		if(userAccount.getUserPwd() == null || userAccount.getUserPwd().trim().equals("")){
			userAccountMapper.updateUserAccount(userAccount);
			return ;
		}
		temp = com.ihk.utils.Md5Security
				.encString(userAccount.getUserPwd());
		userAccount.setUserPwd(temp.toUpperCase());

		userAccount.setModTime(new Date());
		userAccount.setModId(SessionUser.getUserId());
		
		userAccountMapper.updateUserAccount(userAccount);
		OperLog oper= new OperLog();
		oper.setLogType(EnumOperLogType.CHANGE_USER_ACCOUNT.toString());
		oper.setLogTime(new Date());
		oper.setUserId(SessionUser.getUserId());
		oper.setProjectId(0);
		oper.setLogDesc("");
		oper.setDevFlag("");
		
		IOperLogMapper.addOperLog(oper);
		CacheUtils.removeCache(cacheKeyOne, userAccount.getId());
	}

	@Override
	public List findUserAccountPage(UserAccountCond cond)
			throws RuntimeException {
		//使用permission控制搜索条件 UserAccountPermission.doCheckFind(cond);
		// Map<String, Integer> map = new HashMap<String, Integer>();
		// //map.put("resultSize", resultSize);
		// //map.put("resultSize", resultSize);
		//		
		// map.put("beginResult", 1);
		// map.put("resultSize", 10);
		
		return userAccountMapper.findUserAccountPage(cond);
	}

	@Override
	public void deleteUserAccount(int id) throws RuntimeException {
		UserAccountCond cond = new UserAccountCond();
		cond.setRecordId(id);
		userAccountMapper.deleteUserAccount(cond);
		
		UserRoleCond condRole = new UserRoleCond();
		condRole.setUserId(String.valueOf(id));
		userRoleMapper.deleteUserRoleByCond(condRole);

		CacheUtils.removeCache(cacheKeyOne, id);
	}

	@Override
	public void undoDeleteUserAccount(int id) throws RuntimeException {
		UserAccountCond cond = new UserAccountCond();
		cond.setRecordId(id);
		userAccountMapper.undoDeleteUserAccount(cond);

		CacheUtils.removeCache(cacheKeyOne, id);
	}


	@Override
	public UserAccount findUserAccountById(final int id) throws RuntimeException {
		
		return (UserAccount) MyCacheTemplate.cache(cacheKeyOne, id+"", new MyCacheTemplateCallback() {
			
			@Override
			public Object doCache() throws Exception {
				return userAccountMapper.findUserAccountById(id);
			}
		});

	}

	

	@Override
	public int findUserAccountCount(UserAccountCond map)
			throws RuntimeException {
		return userAccountMapper.findUserAccountCount(map);
	}

	@Override
	public UserAccount loginUserAccount(UserAccount userAccount)
			throws RuntimeException {
		String temp = com.ihk.utils.Md5Security.encString(userAccount
				.getUserPwd());

		userAccount.setUserPwd(temp);
		return userAccountMapper.loginUserAccount(userAccount);
	}

	@Override
	public void saveUserAccount(UserAccount userAccount) {
		/**
		 * permission.doChick
		 * */
		String temp = com.ihk.utils.Md5Security.encString(userAccount
				.getUserPwd());
		userAccount.setUserPwd(temp);
		userAccountMapper.saveUserAccount(userAccount);

	//	CacheUtils.removeCache(cacheKeyOne, userAccount.getId());
	}

	@Override
	public Map<String, String> findUserAccountsByProjectId(int projectId) throws RuntimeException {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("", CommonUtils.ALL);

		List<UserAccount> userList = userAccountMapper.findUserAccountsByProjectId(projectId);
		for (UserAccount user : userList) {
			int id = user.getId();
			String realName = user.getRealName();
			map.put(id+"", realName);

		}

		return map;
	}

	@Override
	public boolean valUserByName(UserAccount user) {
		if(userAccountMapper.findUserAccountByName(user.getUserName()) == 0){
			return false;
		}
		return true;
	}

	@Override
	public int findUserAccountByName(String name) throws RuntimeException {
		return userAccountMapper.findUserAccountByName(name);
	}

	@Override
	public List<UserAccount> findUserAccounts() throws Exception {
		return userAccountMapper.findUserAccounts();
	}

	@Override
	public List<UserAccount> findUserAccountsLikeName(String name)
			throws Exception {
		return userAccountMapper.findUserAccountsLikeName(name);
	}
	
	@Override
	public UserAccount findUserAccountByRealName(String realName)
			throws Exception {
		return userAccountMapper.findUserAccountByRealName(realName);
	}

	@Override
	public UserAccount findUserAccountByUserName(String userName)
			throws Exception {
		return userAccountMapper.findUserAccountByUserName(userName);
	}

	@Override
	public List<UserAccount> findHDuser() {
		return userAccountMapper.findHDuser();
	}
	@Override
	public List<UserAccount> findHDUserByNoRole(UserAccountCond cond) {
		return null;
	}
	@Override
	public List<UserAccount> findHDUserByRole(UserAccountCond cond) {
		return null;
	}
	@Override
	public List<UserAccount> findGuangZhouUser(UserAccountCond cond) {
		//cond.setCompanyId(ContCompanyId.GUANG_ZHOU);
		cond.setCompanyId(SessionUser.getCompanyId()); //登陆者所属公司
		return this.userAccountMapper.findGuangZhouUser(cond);
	}
	@Override
	public UserAccount loginInnerUser(String userAccount) {
		return this.userAccountMapper.loginInnerUser(userAccount);
	}
	@Override
	public List<UserAccount> findUserAccountsLikeNameByCompanyId(String name) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("companyId", SessionUser.getCompanyId() + "");
		
		return userAccountMapper.findUserAccountsLikeNameByCompanyId(map);
		
	}
	@Override
	public List<UserAccount> findUserAccountListByProjectId(int projectId)
			throws RuntimeException {
		
		return userAccountMapper.findUserAccountsByProjectId(projectId);
	}
	
	@Override
	public void knUpdateUserIdById(Map p ){
		userAccountMapper.knUpdateUserIdById(p);
	}
	@Override
	public UserAccount findUserAccountByUserNameIncludeDelete(String userName)
			throws Exception {
		return userAccountMapper.findUserAccountByUserNameIncludeDelete(userName);
	}
	@Override
	public List<UserAccount> findUserAccountsLikeNameByCompanyIdIncludeDelete(
			String search) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", search);
		map.put("companyId", SessionUser.getCompanyId() + "");
		return userAccountMapper.findUserAccountsLikeNameByCompanyIdIncludeDelete(map);
	}
	
	/**
	 * 修改用户工号
	 */
	@Override
	public void updateUserAccountJobNumber(UserAccount userAccount)
			throws RuntimeException {
		
		userAccountMapper.updateUserAccountJobNumber(userAccount);
	}
	

	@Override
	public List<UserAccount> findUserAccountByCompanyIdAndRealNameOrJobNumberIncludeDelete(
			UserAccount userAccount) throws Exception {
		
		return userAccountMapper.findUserAccountByCompanyIdAndRealNameOrJobNumberIncludeDelete(userAccount);
	}
	
	public List<UserAccount> findUserAccount(UserAccountCond cond) throws RuntimeException{
		return userAccountMapper.findUserAccount(cond);
	}
	
	@Override
	public List<Map<String, String>> findProjectAndRoleByUserAccountId(
			int userAccountId) throws RuntimeException {
		
		return userAccountMapper.findProjectAndRoleByUserAccountId(userAccountId);
	}


}
