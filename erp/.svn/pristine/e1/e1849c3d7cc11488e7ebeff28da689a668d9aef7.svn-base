package com.ihk.user.data;

import java.util.List;
import java.util.Map;

import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserAccountCond;

/**
 * UserAccount数据访问接口Mapper
 * @author 
 *
 */ 
public interface IUserAccountMapper {

	/**
	 * 新增UserAccount
	 * @param userAccount
	 */
	public void saveUserAccount(UserAccount userAccount) ;

	/**
	 * 根据条件删除UserAccount
	 * @param cond 删除条件
	 */
	public void deleteUserAccount(UserAccountCond cond) throws RuntimeException;

	/**
	 * 根据条件恢复UserAccount
	 * @param cond 删除条件
	 */
	public void undoDeleteUserAccount(UserAccountCond cond) throws RuntimeException;

	/**
	 * 修改UserAccount
	 * @param userAccount
	 */
	public void updateUserAccount(UserAccount userAccount) throws RuntimeException;

	/**
	 * 查找一条UserAccount
	 * @return UserAccount
	 * @param id 主键id
	 */
	public UserAccount findUserAccountById(int id) throws RuntimeException;
	
	/**
	 * 根据name查找
	 * @param name
	 * @return
	 * @throws RuntimeException
	 */
	public int findUserAccountByName(String  name) throws RuntimeException;
	
	/**
	 * 根据userName 查找,不论是否删除
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public UserAccount findUserAccountByUserNameIncludeDelete(String userName) throws Exception;

	/**
	 * 分页查找UserAccount
	 * @param cond 查询条件
	 * @return UserAccount列表
	 */
	public List<UserAccount> findUserAccountPage(UserAccountCond userAccountCond)throws RuntimeException ;

	/**
	 * 查找全部UserAccount
	 * @param cond 查询条件
	 * @return UserAccount列表
	 */
	public List<UserAccount> findAllUserAccount()throws RuntimeException;
//	//select crm company
//	public List<Company> findCompany()throws RuntimeException;
//	//select crm company_project
//	public List<CompanyProject> findCompanyProject()throws RuntimeException;
//	//select crm team
//	public List<Team> findTeam()throws RuntimeException;

	/**
	 * 查找符合条件的记录条数UserAccount
	 * @param cond 查询条件
	 * @return 记录条数
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
	public List<UserAccount> findUserAccountsByProjectId(int projectId) throws RuntimeException;
	
	/**
	 * 根据companyId 查找
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	public List<UserAccount> findUserAccountsByCompanyId(int projectId) throws RuntimeException;
	
	/**
	 * 查找全部
	 * @return
	 * @throws Exception
	 */
	public List<UserAccount> findUserAccounts() throws Exception;
	
	/**
	 * 根据name 模糊查找
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<UserAccount> findUserAccountsLikeName(String name) throws Exception; //用于autocomplete
	
	/**
	 * 根据companyId与name 模糊查找
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<UserAccount> findUserAccountsLikeNameByCompanyId(Map<String, String> map) throws Exception;
	
	/**
	 * 根据name 查找
	 * @param raalName
	 * @return
	 * @throws Exception
	 */
	public UserAccount findUserAccountByRealName(String raalName) throws Exception;
	
	/**
	 * 根据name 查找
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public UserAccount findUserAccountByUserName(String userName) throws Exception;
	
	/**
	 * 查找恒大的用户
	 * @return
	 */
	public List<UserAccount> findHDuser();
	
	/**
	 * 查找恒大的用户
	 * @return
	 */
	public List<UserAccount> findHDUserByRole();
	
	/**
	 * 查找广州用户
	 * @param cond
	 * @return
	 */
	public List<UserAccount> findGuangZhouUser(UserAccountCond cond);
	
	/**
	 * 根据内网用户名登陆
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

	public List<UserAccount> findUserAccountsLikeNameByCompanyIdIncludeDelete(
			Map<String, String> map);
	
	/**
	 * 根据公司id精确查询realName所有的用户(包括删除)
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
