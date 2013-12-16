package com.ihk.customer.data.services;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.data.pojo.CustomerFollow;
import com.ihk.customer.data.pojo.CustomerFollowCond;

/**
 * CustomerFollow的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface ICustomerFollowServices extends Serializable {
	/**
	 * 新增CustomerFollow
	 * @param customerFollow
	 */
	public void addCustomerFollow(CustomerFollow customerFollow) throws RuntimeException;

	/**
	 * 删除一条CustomerFollow
	 * @param id
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
	@SuppressWarnings("rawtypes")
	public List findCustomerFollowPage(CustomerFollowCond cond) throws RuntimeException;

	/**
	 * 根据customer id获取其对应的跟进内容
	 * @param id customer_id
	 * @return CustomerFollow列表
	 */
	public List<CustomerFollow> findCustomerFollowByCustomerId(int id) throws Exception; //根据customer id获取其对应的跟进内容 
	
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
	 * 获取customer的id的集合
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<Integer> findCustomerFollowCustomerIds(CustomerFollowCond cond) throws Exception;
	
	//追加
	/**
	 * 指定销售人员id、日期段及跟进类型，得到相关客户的信息
	 * @param cond
	 * @return
	 */
	public List<Map> findCustomerListByCustomerFollowUser(CustomerFollowCond cond) throws Exception;

	/**
	 * 指定公司id、日期段及跟进类型，得到相关客户的信息
	 * @param cond
	 * @return
	 */	
	public List<Map> findCustomerListByCustomer(CustomerFollowCond cond) throws Exception;
	
	/**
	 * 指定项目id、日期段及跟进类型，得到相关客户的信息
	 * @param cond
	 * @return
	 */		
	public List<Map> findCustomerListByProject(CustomerFollowCond cond) throws Exception;

	public CustomerFollow findCustomerFollowByCustomerIdNewestRecord(int customerId);
}