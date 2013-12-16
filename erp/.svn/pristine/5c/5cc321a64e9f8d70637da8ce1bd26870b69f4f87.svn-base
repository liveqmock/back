package com.ihk.customer.data;

import java.util.List;
import java.util.Map;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.utils.base.PojoDeleteCond;
 
/**
 * Customer数据访问接口Mapper
 * @author 
 *
 */ 
@SuppressWarnings("rawtypes")
public interface ICustomerMapper {

	/**
	 * 新增Customer
	 * @param customer
	 */
	public void saveCustomer(Customer customer) ;

	/**
	 * 根据条件删除Customer
	 * @param cond 删除条件
	 */
	public void deleteCustomer(PojoDeleteCond cond) throws RuntimeException;

	/**
	 * 修改Customer
	 * @param customer
	 */
	public void updateCustomer(Customer customer) throws RuntimeException;

	/**
	 * 查找一条Customer
	 * @return Customer
	 * @param id 主键id
	 */
	public Customer findCustomerById(int id) throws RuntimeException;
		
	/**
	 * 查找客户总数,用于分页
	 * @param cond
	 * @return
	 */
	public int findCustomerCount(CustomerCond cond);
	
	/**
	 * 查找客户
	 * @param cond
	 * @return
	 */
	public List<Customer> findCustomerSearch(CustomerCond cond);
	
	/**
	 * 根据map查找客户总数
	 * @param map
	 * @return
	 */
	public int findCustomerCount(Map map) ;
	
	/**
	 * 判断该号码是否存在,返回其所属用户
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,String>> findPhoneIsExistsByProjectId(Map<String, String> map) throws Exception; //判断该号码是否存在,返回其所属用户
	
	/**
	 * 跟进查询条件下载
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<Customer> findCustomerForDownload(CustomerCond cond) throws Exception; //跟进查询条件下载
	
	/**
	 * 恒大项目下的汇总查询
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<Customer> findCustomerForHengDa(CustomerCond cond) throws Exception; //恒大项目下的汇总查询
	
	/**
	 * 判断电话是否存在
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Customer> findPhoneIsExistsByUserId(Map<String, String> map) throws Exception; //根据用户id,判断该号码是否存在
	
	/**
	 * 根据用户id,判断该号码是否存在
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Customer> findHomePhoneIsExistsByUserId(Map<String, String> map) throws Exception; //根据用户id,判断该号码是否存在
	
	/**
	 * 根据项目id判断该号码是否存在
	 * @param map
	 * @return
	 * @throws RuntimeException
	 */
	public List<Customer> findCustomerPhoneIsExistsByProjectId(Map<String, String> map) throws RuntimeException; //根据项目id判断该号码是否存在
	
	/**
	 * 根据项目id判断该号码是否存在
	 * @param map
	 * @return
	 * @throws RuntimeException
	 */
	public List<Customer> findCustomerHomePhoneIsExistsByProjectId(Map<String, String> map) throws RuntimeException; //根据项目id判断该号码是否存在
	
	/**
	 * 广州项目主页临时最新录入
	 * @param cond
	 * @return
	 */
	public List<Map<String, Object>> findTmpNotice(CustomerCond cond); //广州项目主页临时最新录入
	
	/**
	 * 交叉分析组合
	 * @param cond
	 * @return
	 */
	public List<Map<String, Object>> findCustomerDoublePie(CustomerCond cond); //交叉分析组合

	/**
	 * 分组
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
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map> findCustomerGroupNum(CustomerCond cond) throws RuntimeException;
	
	/**
	 * 项目分析
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<Map> findCustomerForChartProjectCustomerNumAction(CustomerCond cond)  throws Exception;//ChartProjectCustomerNumAction.java
	
	/**
	 * 客户分析
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<Map> findCustomerForChartUserAccountCustomerNumAction(CustomerCond cond)  throws Exception;//ChartUserAccountCustomerNumAction.java
	
	/**
	 * 录入质量分析(字段不为空的录入数量)
	 * Map的格式为[fieldName,inputCount] 说明为:[记录项,录入数量]
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map> findAllFiledInputCount(CustomerCond cond) throws RuntimeException;
	
	/**
	 * customer表选填内容:录入质量分析(字段不为空的录入数量)
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
	public List<Customer> findCustomersForContract(Map<String, String> map) throws RuntimeException;
	
	/**
	 * 根据号码获取客户
	 * @param map
	 * @return
	 * @throws RuntimeException
	 */
	public List<Customer> findCustomersFromPhoneForContract(Map<String, String> map) throws RuntimeException;
		
	/**
	 * 下面四个为temp
	 * @return
	 */
	public int tmpCount();
	public List<Customer> tmpList(CustomerCond cond);
	public void updateCustomerPhoneFrom(Map<String, String> map);
	public List<Customer> findCustomerListBySql(String sql) throws RuntimeException; //根据sql获取客户列表
	
	/**
	 * 获取当天修改的客户
	 * @return
	 * @throws RuntimeException
	 */
	public List<Customer> findThisDayModCustomer() throws RuntimeException;
	
	/**
	 * 分页查询
	 * @param cond
	 * @return
	 */
	public List<Customer> findCustomerPage(CustomerCond cond) ;// 分页查询
	
	/**
	 * map结构
	 * time1:3月 
	 * time2:3-6月
	 * time3:6-12月
	 * time4:一年以上
	 * project_id:项目
	 * 
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
	 * 
	 *  
	 * @param date1 date2
	 * @projectIds:项目范围 =行的数量
	 * */
	public List<Map> countByVisitCountGroupByProjectId(CustomerCond cond)  throws RuntimeException;
	

	public void knUpdateXqmj(Map p );
	public void knUpdateXqjg(Map p );
	
	

	/**
	 * 客户来源统计
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map<String, Object>> findCustomerSourceAndVisit(CustomerCond cond) throws RuntimeException;

	public void knAddRemark(Map<String,String> p );
	
	public List<Map> findCustomerGroupQuestionTopic(CustomerCond cond) throws RuntimeException;

	public List<Map> findCustomerPageReport(CustomerCond customerCond);

	public List<Map<String, Object>> findCustomerCountGroupByVisitDate(CustomerCond customerCond);

	public int findCustomerCountGroupByVisitDateCount(CustomerCond customerCond);

	public List<Map<String, Object>> findCustomerProductAndConfirmInfo(
			CustomerCond customerCond);

	public int findCustomerProductAndConfirmInfoCount(CustomerCond customerCond);

	public List<Map<String, Object>> findCustomerAndQuestionForDownload(
			CustomerCond customerCond);

	public List<Customer> findCustomerSearchDeleted(CustomerCond cond);

	public int findCustomerCountDeleted(CustomerCond cond);

	public void updateCustomerForPart(Customer customer);
	
	

	
}
