package com.ihk.customer.data;

import java.util.List;
import java.util.Map;

import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.pojo.CustomerFollow;
import com.ihk.customer.data.pojo.CustomerFollowCond;

/**
 * CustomerFollow数据访问接口Mapper
 * @author 
 *
 */ 
public interface ICustomerFollowMapper {

	/**
	 * 新增CustomerFollow
	 * @param customerFollow
	 */
	public void addCustomerFollow(CustomerFollow customerFollow) ;

	/**
	 * 根据条件删除CustomerFollow
	 * @param cond 删除条件
	 */
	public void deleteCustomerFollow(int id) throws RuntimeException;

	/**
	 * 修改CustomerFollow
	 * @param customerFollow
	 */
	public void updateCustomerFollow(CustomerFollow customerFollow) throws RuntimeException;

	/**
	 * 查找一条CustomerFollow
	 * @return CustomerFollow
	 * @param id 主键id
	 */
	public CustomerFollow findCustomerFollowById(int id) throws RuntimeException;

	/**
	 * 分页查找CustomerFollow
	 * @param cond 查询条件
	 * @return CustomerFollow列表
	 */
	public List<CustomerFollow> findCustomerFollowPage(CustomerFollowCond cond) ;

	/**
	 * 查找符合条件的记录条数CustomerFollow
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findCustomerFollowCount(CustomerFollowCond cond) ;
	
	/**
	 * 跟进customerid查找该客户的跟进
	 * @param id
	 * @return
	 */
	public List<CustomerFollow> findCustomerFollowByCustomerId(int id);

	/**
	 * 用户的跟进条数
	 * @return 记录条数
	 */
	public int findCountByFollowUser(int followUser);
	
	/**
	 * 查询前3条,根据修改时间
	 * @param customerId
	 * @return
	 */
	public List<CustomerFollow> findCustomerFollowByCustomerIdForIndex(int customerId); //查询前3条,根据修改时间

	/**
	 * 取得报表,公司跟进情况
	 * Map[companyId,companyName,phoneCount,visitCount]
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<Map> findReportSumGroupByCompany(CustomerFollowCond cond)  throws Exception;
	
	/**
	 * 取得报表,项目跟进情况
	 * Map[projectId,projectName,phoneCount,visitCount]
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<Map> findReportSumGroupByProject(CustomerFollowCond cond)  throws Exception;

	/**
	 * 取得报表,销售人员跟进情况
	 * Map[userId,realName,phoneCount,visitCount]
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<Map> findReportSumGroupByUser(CustomerFollowCond cond)  throws Exception;
	
	/**
	 * customer的id的集合
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<Integer> findCustomerFollowCustomerIds(CustomerFollowCond cond) throws Exception;
	
	
	//追加
	public List<Map> findCustomerListByCustomerFollowUser(CustomerFollowCond cond);
	
	
	public List<Map> findCustomerListByCustomer(CustomerFollowCond cond);
	
	public List<Map> findCustomerListByProject(CustomerFollowCond cond);

	public CustomerFollow findCustomerFollowByCustomerIdNewestRecord(int customerId);
}
