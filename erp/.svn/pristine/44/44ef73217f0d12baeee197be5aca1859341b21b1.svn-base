package com.ihk.user.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserAccountCond;

/**
 * UserAccount的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IUserAccountServices {
	/**
	 * 新增UserAccount
	 * @param userAccount
	 */
	public void saveUserAccount(UserAccount userAccount) ;

	/**
	 * 删除一条UserAccount
	 * @param id
	 */
	public void deleteUserAccount(int id) throws RuntimeException;

	/**
	 * 恢复一条UserAccount
	 * @param id
	 */
	public void undoDeleteUserAccount(int id) throws RuntimeException;

	/**
	 * 修改UserAccount
	 * @param userAccount
	 */
	public void updateUserAccount(UserAccount userAccount,String upt) throws RuntimeException;

	/**
	 * 修改UserAccount
	 * @param userAccount
	 */
	public void updateUserAccount(UserAccount userAccount) throws RuntimeException;
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public UserAccount findUserAccountById(int id) throws RuntimeException;
	
	/**
	 * 同名的数量
	 * @param name
	 * @return
	 * @throws RuntimeException
	 */
	public int findUserAccountByName(String  name) throws RuntimeException;
	
	/**
	 * 用户名是否可用
	 * @param user
	 * @return
	 */
	public boolean valUserByName(UserAccount user);

	/**
	 * 分页查找UserAccount
	 * @param cond 查询条件
	 * @return UserAccount列表
	 */
	public List<UserAccount> findUserAccountPage(UserAccountCond userAccountCond)throws RuntimeException ;
	
	/**
	 * 记录数
	 * @param map
	 * @return
	 * @throws RuntimeException
	 */
	public int findUserAccountCount(UserAccountCond map)throws RuntimeException;
	
	/**
	 * 登陆
	 * @param userAccount
	 * @return
	 * @throws RuntimeException
	 */
	public UserAccount loginUserAccount(UserAccount userAccount)throws RuntimeException;
	
	/**
	 * 根据projectId查找
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	public Map<String, String> findUserAccountsByProjectId(int projectId) throws RuntimeException;
	
	/**
	 * 根据projectId查找
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	public List<UserAccount> findUserAccountListByProjectId(int projectId) throws RuntimeException;
	
	//用户拥有的角色
	//用户拥有的项目
	//用户对应项目的权限
	//用户拥有的功能树
	
	/**
	 * 查找恒大用户
	 */
	public List<UserAccount> findHDuser();
	
	/**
	 * 查找用户
	 * @return
	 * @throws Exception
	 */
	public List<UserAccount> findUserAccounts() throws Exception;
	
	/**
	 * 根据name 查找
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<UserAccount> findUserAccountsLikeName(String name) throws Exception; //用于autocomplete
	
	/**
	 * 同一company，根据name 查找
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<UserAccount> findUserAccountsLikeNameByCompanyId(String name) throws Exception; //用于autocomplete,根据公司id
	
	/**
	 * 根据realName 查找
	 * @param realName
	 * @return
	 * @throws Exception
	 */
	public UserAccount findUserAccountByRealName(String realName) throws Exception;
	
	/**
	 * 根据userName 查找
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public UserAccount findUserAccountByUserName(String userName) throws Exception;
	
	/**
	 * 根据userName 查找,不论是否删除
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public UserAccount findUserAccountByUserNameIncludeDelete(String userName) throws Exception;
	
	/**
	 * 查询恒大用户有权限的
	 * @param cond
	 * @return
	 */
	public List<UserAccount> findHDUserByRole(UserAccountCond cond);//查询恒大用户有权限的
	
	/**
	 * 查询恒大用户(没有权限的）
	 * @param cond
	 * @return
	 */
	public List<UserAccount> findHDUserByNoRole(UserAccountCond cond);
	
	/**
	 * 查找广州用户
	 * @param cond
	 * @return
	 */
	public List<UserAccount> findGuangZhouUser(UserAccountCond cond);
	
	/**
	 * 内网用户登陆
	 * @param innerName
	 * @return
	 */
	public UserAccount loginInnerUser(String innerName);
	
	/**
	 * 导数用 p.id
	 * p.userId
	 * */
	@SuppressWarnings("rawtypes")
	public void knUpdateUserIdById(Map p );

	/**
	 * 根据登陆者公司id模糊查询realName所有的用户(包括删除)
	 * @param search
	 * @return
	 */
	public List<UserAccount> findUserAccountsLikeNameByCompanyIdIncludeDelete(String search);
	
	/**
	 * 根据公司id及工号(可能不存在)精确查询realName所有的用户(包括删除)
	 * @param userAccount
	 * @return
	 * @throws Exception
	 */
	public List<UserAccount> findUserAccountByCompanyIdAndRealNameOrJobNumberIncludeDelete(UserAccount userAccount) throws Exception;
	
	/**
	 * 修改用户工号
	 * @param userAccount
	 * @throws RuntimeException
	 */
	public void updateUserAccountJobNumber(UserAccount userAccount) throws RuntimeException;
	
	/**
	 * 根据用户id获取其对应的项目,角色名称
	 * @param userAccountId
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map<String, String>> findProjectAndRoleByUserAccountId(int userAccountId) throws RuntimeException;
	
	public List<UserAccount> findUserAccount(UserAccountCond cond) throws RuntimeException;
	
}