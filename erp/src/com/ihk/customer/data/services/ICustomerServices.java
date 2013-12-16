package com.ihk.customer.data.services;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerCond;

/**
 * Customer的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("rawtypes")
public interface ICustomerServices extends Serializable{
	
	public int findCustomerCount(CustomerCond cond)throws RuntimeException;
	
	/**
	 * 新增Customer
	 * @param customer
	 */
	public void saveCustomer(Customer customer) throws RuntimeException;
	public void saveKnCustomer(Customer customer) throws RuntimeException;
	/**
	 * 删除一条Customer
	 * @param id
	 */
	public void removeCustomer(int id) throws RuntimeException;

	/**
	 * 修改Customer
	 * @param customer
	 */
	public void updateCustomer(Customer customer) throws RuntimeException;
	
	/**
	 * 修改客户的所属销售
	 * @param userId
	 * @param customerId
	 * @throws RuntimeException
	 */
	public void updateUserIdByCustomerId(int userId, int customerId) throws RuntimeException; //修改客户的所属销售
	
	/**
	 * 修改客户,但是不用判断是否只能更新,不能修改的情况
	 * @param customer
	 * @throws RuntimeException
	 */
	public void updateCustomerNoCheckNolyFollow(Customer customer) throws RuntimeException;

	/**
	 * 根据id获取客户
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Customer getCustomerById(int id) throws RuntimeException;
    	
	/**
	 * 根据查询条件查找customer
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Customer> findCustomerSearch(CustomerCond cond) throws RuntimeException; //根据查询条件查找customer
	
	/**
	 * 手机查询
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Customer> findCustomerForMobile(CustomerCond cond) throws RuntimeException;
	
	/**
	 * 判断该号码是否存在,返回其所属用户
	 * @param phone
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,String>> findPhoneIsExistsByProjectId(String phone, int projectId) throws Exception; //判断该号码是否存在,返回其所属用户
	
	/**
	 * 根据查询条件下载
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<Customer> findCustomerForDownload(CustomerCond cond) throws Exception; //根据查询条件下载
	
	/**
	 * 恒大项目下的汇总查询
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<Customer> findCustomerForHengDa(CustomerCond cond) throws Exception; //恒大项目下的汇总查询
	
	/**
	 * 根据用户id,判断该号码是否存在
	 * @param phone
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<Customer> findPhoneIsExistsByUserId(String phone, int userId) throws Exception; //根据用户id,判断该号码是否存在
	
	/**
	 * 根据用户id,判断该号码是否存在
	 * @param homePhone
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<Customer> findHomePhoneIsExistsByUserId(String homePhone, int userId) throws Exception; //根据用户id,判断该号码是否存在
	
	/**
	 * 判断电话是否存在
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Customer> findPhoneIsExistsByUserId(String phone, int userId, String projectId) throws Exception; //广州项目
	
	/**
	 * 根据用户id,判断该号码是否存在
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Customer> findHomePhoneIsExistsByUserId(String homePhone, int userId, String projectId) throws Exception; //广州项目
	
	/**
	 * 根据项目id判断该号码是否存在
	 * @param phone
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	public List<Customer> findCustomerPhoneIsExistsByProjectId(String phone, String projectId) throws RuntimeException; //根据项目id判断该号码是否存在
	
	/**
	 * 根据项目id判断该号码是否存在
	 * @param homePhone
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	public List<Customer> findCustomerHomePhoneIsExistsByProjectId(String homePhone, String projectId) throws RuntimeException; //根据项目id判断该号码是否存在
	
	/**
	 * 广州项目主页临时通告
	 * @param cond
	 * @return
	 */
	public List<Map<String, Object>> findTmpNotice(CustomerCond cond); //广州项目主页临时通告
	
	/**
	 * 交叉分析组合
	 * @param cond
	 * @return
	 */
	public List<Map<String, Object>> findCustomerDoublePie(CustomerCond cond); //交叉分析组合
	
	/**
	 * 分组<br>
	 * Map的格式为[categoryDate,category,num] 说明为:[日期,分类,数量]
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map> findCustomerGroup(CustomerCond cond) throws RuntimeException; 

	/**
	 * 分析区域
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map> findCustomerGroupByCategory(CustomerCond cond) throws RuntimeException; 

	/**
	 * 分组(日期)后的数据
	 * @deprecated 修改为ReportPreCustomerServices,groupByProjectDate
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map> findCustomerGroupNum(CustomerCond cond) throws RuntimeException;
	
	/**
	 * 录入质量分析(字段不为空的录入数量)
	 * Map的格式为[fieldName,inputCount] 说明为:[记录项,录入数量]
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map> findAllFiledInputCount(CustomerCond cond) throws RuntimeException;

	/**
	 * customer选填内容:录入质量分析(字段不为空的录入数量)
	 * Map的格式为[fieldName,inputCount] 说明为:[记录项,录入数量]
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map> findOptionFieldInputCount(CustomerCond cond) throws RuntimeException;
	
	/**
	 * 根据合同相关条件获取客户
	 * @param map
	 * @return
	 * @throws RuntimeException
	 */
	public List<Customer> findCustomersForContract(String name) throws RuntimeException;
	
	/**
	 * 根据号码获取客户
	 * @param map
	 * @return
	 * @throws RuntimeException
	 */
	public List<Customer> findCustomersFromPhoneForContract(String phone) throws RuntimeException;
	
	//下面三个方法只是批量获取电话归属地的,已经废弃
	@Deprecated
	public int tmpCount();
	@Deprecated
	public List<Customer> tmpList(CustomerCond cond);
	@Deprecated
	public void updateCustomerPhoneFrom(Map<String, String> map);
	
	/**
	 * 获取当天修改的客户
	 * @return
	 * @throws RuntimeException
	 */
	public List<Customer> findThisDayModCustomer() throws RuntimeException;
	
	/**
	 * 根据sql获取客户列表
	 * @param sql
	 * @return
	 * @throws RuntimeException
	 */
	public List<Customer> findCustomerListBySql(String sql) throws RuntimeException; //根据sql获取客户列表

	/**
	 * 根据查询条件分页查找customer	
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Customer> findCustomerPage(CustomerCond cond) throws RuntimeException; //根据查询条件分页查找customer	
	
	/**
	 * time1:3月 
	 * time2:3-6月
	 * time3:6-12月
	 * time4:一年以上
	 * project_id:项目
	 * @param date1 时间基准
	 * @projectIds:项目范围 =行的数量
	 * */
	public List<Map> countByTimeGroupByProjectId(CustomerCond cond)  throws RuntimeException;
	
	/**
	 * map结构
	 * con1:首次 
	 * con2:2次
	 * con3:3次即以上
	 * project_id:项目
	 * @param date1 date2
	 * @projectIds:项目范围 =行的数量
	 * */
	public List<Map> countByVisitCountGroupByProjectId(CustomerCond cond)  throws RuntimeException;
	
	/**	
	 * 客户来源统计
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map<String, Object>> findCustomerSourceAndVisit(CustomerCond cond) throws RuntimeException;
	
	
	public Customer getKnCustomerById(int id) throws RuntimeException;
	public void updateKnCustomer(Customer customer) throws RuntimeException;
	
	
	public void knUpdateXqmj(Map p )throws RuntimeException;
	
	public void knUpdateXqjg(Map p )throws RuntimeException;
	
	public void knAddRemark(Map<String,String> p )throws RuntimeException;

	/**
	 * 自定义问卷回答的具体详细内容<br>
	 * Map的格式[categoryDate,customerId,questionId,topicId,topicName,anwserContent]
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	List<Map> findCustomerGroupQuestionTopic(CustomerCond cond)
			throws RuntimeException;

	public List<Map> findCustomerPageReport(CustomerCond customerCond);
	
	public List<Map<String, Object>> findCustomerCountGroupByVisitDate(CustomerCond customerCond);

	public int findCustomerCountGroupByVisitDateCount(CustomerCond customerCond);

	public List<Map<String, Object>> findCustomerProductAndConfirmInfo(CustomerCond customerCond);

	public int findCustomerProductAndConfirmInfoCount(CustomerCond customerCond);
	
	public List<Map<String, Object>> findCustomerAndQuestionForDownload(CustomerCond customerCond);

	public List<Customer> findCustomerSearchDeleted(CustomerCond cond);
	

	
}