package com.ihk.customer.data.services.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.ICustomerMapper;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerLogServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.permission.CustomerPermission;
import com.ihk.permission.PermissionUtils;
import com.ihk.utils.CacheUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.base.PojoDeleteCond;
import com.ihk.utils.customer.PhoneUniqueUtils;
import com.ihk.utils.customer.ProjectCodeFieldUtils;
import com.ihk.utils.onlyfollow.CustomerOnlyFollowUtils;

/**
 * Customer的Services实现(业务实现)
 * @author 
 *
 */
@Service("customerServices")
@SuppressWarnings({"rawtypes", "unused"})
public class CustomerServices implements ICustomerServices {
	
	private static final long serialVersionUID = 5211277495440395894L;
	
	/**
	 * customer数据访问接口
	 */
	@Autowired	 ICustomerMapper customerMapper;
	@Autowired   ICustomerLogServices iCustomerLogServices;
	private static final Logger logger = Logger.getLogger(CustomerServices.class); 
	
	private static final String cacheKeyList = "customer.list";
	private static final String cacheKeyOne = "customer.one";

	private void logCustomer(int customerId){
		iCustomerLogServices.addCustomerToCustomerLog(customerId);
	}

	/**
	 * 删除一条Customer
	 * @param id
	 */
	public void removeCustomer(int id) throws RuntimeException {	
		
		Customer customer = getCustomerById(id);
		CustomerPermission.doCheckRemove(customer);
		logCustomer(id);//增加LOG
		
		customerMapper.deleteCustomer(new PojoDeleteCond(id));  //原先的标示删除,只是修改is_deleted,应该同时修改mod_id和mod_time;
		
		CacheUtils.removeCache(cacheKeyOne,id);
	}

	/**
	 * 新增Customer
	 * @param customer
	 */
	public void saveCustomer(Customer customer) throws RuntimeException {	
		//CustomerPermission.doCheckSave();
		
		//TODO 根据当前项目的customerOneSale，是否为1，才进行判断
		//客户来源为来访判断,该项目下电话号码是否重复
		if("2".equals(customer.getCustomerSource())){
			PhoneUniqueUtils.isPhoneRepeat(customer);
		}
		
		//增加号码归属地(可以改成定时器去执行),CustomerPhoneFromQuartz.java
		//customer = PhoneUtils.postPhone(customer);
		
		//根据project_code设置customer的price_num对应的项目的PRICE_AMOUNT值,area_num对应的项目的REQUEST_AREA值
		ProjectCodeFieldUtils.setRriceAndAreaNum(customer);
		
		//如果来访日期为空,就增加默认为当天,2013.8.14
		if(CommonUtils.isStrEmpty(customer.getVisitDate())){
			customer.setVisitDate(CommonUtils.getDateString(new Date()));
		}
		
		//设定follow_time,(因为该字段为后来新增的,所以要在这里增加)
		customer.setFollowTime(CommonUtils.getDateFromString(customer.getVisitDate()));
		
		//实际保存
		customerMapper.saveCustomer(customer);
		
		//CacheUtils.removeCache(cacheKeyOne,customer.getId());
	}
	public void saveKnCustomer(Customer customer) throws RuntimeException {	
		customerMapper.saveCustomer(customer);
	}

	/**
	 * 查找一条Customer
	 * @return Customer
	 * @param id 主键id
	 */
	@Override
	public Customer getCustomerById(int id) throws RuntimeException {
		Customer customer;
		
	    //Cache cache= CacheManager.getInstance().getCache(cacheKeyOne);  //这种方法获取到的cache可能为null
		//Cache cache= CacheUtils.getCacheByName(cacheKeyOne);  //
		
		Object obj = CacheUtils.getValueByCacheNameAndKey(cacheKeyOne, id + "");
		
		if(obj == null){
			
			customer = customerMapper.findCustomerById(id);
			CacheUtils.add(cacheKeyOne, id + "", customer);
		}else{
			
			customer = (Customer) obj;
		}
		if(customer!=null){
			CustomerPermission.doCheckView(customer);
		}
		
				
		return customer;
	}
	
	public Customer getKnCustomerById(int id) throws RuntimeException {
		return  customerMapper.findCustomerById(id);
	}

	/**
	 * 修改Customer
	 * @param customer
	 */
	@Override
	public void updateCustomer(Customer customer) throws RuntimeException {		
		CustomerPermission.doCheckUpdate(customer);
		
		int customerId = customer.getId();
		logCustomer(customerId);//增加LOG
		
		//该项目下电话号码是否重复
		PhoneUniqueUtils.isPhoneRepeat(customer); 
		
		//判断是否为只能跟进的客户
		CustomerOnlyFollowUtils.isOnlyFollowCustomerById(customer.getId());
		
		//根据project_code设置customer的price_num对应的项目的PRICE_AMOUNT值,area_num对应的项目的REQUEST_AREA值
		ProjectCodeFieldUtils.setRriceAndAreaNum(customer);
		
		customerMapper.updateCustomerForPart(customer);	
		
		CacheUtils.removeCache(cacheKeyOne, customerId);
		
	}	
	
	public void updateKnCustomer(Customer customer) throws RuntimeException {
		customerMapper.updateCustomer(customer);	
	}
	
	/**
	 * 修改客户,但是不用判断是否只能更新,不能修改的情况
	 * @param customer
	 */
	@Override
	public void updateCustomerNoCheckNolyFollow(Customer customer) throws RuntimeException {		
		CustomerPermission.doCheckUpdate(customer);
		
		int customerId = customer.getId();
		logCustomer(customerId);//增加LOG
		
		//该项目下电话号码是否重复
		PhoneUniqueUtils.isPhoneRepeat(customer); 
		
		//根据project_code设置customer的price_num对应的项目的PRICE_AMOUNT值,area_num对应的项目的REQUEST_AREA值
		ProjectCodeFieldUtils.setRriceAndAreaNum(customer);
		
		customerMapper.updateCustomer(customer);	
		
		CacheUtils.removeCache(cacheKeyOne, customerId);
		
	}	
	
	/**
	 * 更新
	 */
	@Override
	public void updateUserIdByCustomerId(int userId, int customerId) throws RuntimeException {
		
		logCustomer(customerId);//增加LOG
		
		Customer customer = getCustomerById(customerId);
		customer.setUserId(userId);
		customer.setModId(SessionUser.getUserId());
		customer.setModTime(new Date());
		
		customerMapper.updateCustomer(customer);	
		
		CacheUtils.removeCache(cacheKeyOne, customerId);
		
	}

	/**
	 * 查找全部Customer
	 * @param cond 查询条件
	 * @return Customer列表
	 */
	@Override
	public List<Customer> findCustomerSearch(CustomerCond cond) throws RuntimeException{		
		//System.out.println("findCustomerSearch");
		//System.out.println("结果："+PermissionUtils.findUserPriv(164));
		
		CustomerPermission.doCheckFind(cond);
			
		/*
		List<Customer> list;	
		
		Cache cache= CacheUtils.getCacheByName(cacheKeyList);
		
		if(cache.get(cond.getCacheKey())==null){
			int recordCount = customerMapper.findCustomerCount(cond);
			
			cond.recordCount = recordCount;
				
			list = customerMapper.findCustomerSearch(cond);
			cache.put(new Element(cond.getCacheKey(), list)); 
			cache.put(new Element(cond.getCacheKeyListCount(), recordCount)); 			
		}	
		else{			
			list = (List<Customer>)cache.get(cond.getCacheKey()).getValue();
			cond.recordCount = (Integer)(cache.get(cond.getCacheKeyListCount()).getValue() );			
		}
		
		return list;	
		*/
		
		/**
		 * 当ids的size为0,表示没有符合条件的记录,用于跟进日期,2011.11.8
		 */
		if(cond.getIds() != null && cond.getIds().size() == 0){
			
			return null;
		}
		
		int recordCount = customerMapper.findCustomerCount(cond);
		
		cond.recordCount = recordCount;
		
		return customerMapper.findCustomerSearch(cond);
	}

	/**
	 * 判断该号码是否存在,返回其所属用户
	 * @param phone
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String,String>> findPhoneIsExistsByProjectId(String phone, int projectId) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("phone", phone);
		map.put("projectId", projectId + "");
		return customerMapper.findPhoneIsExistsByProjectId(map);
	}

	/**
	 * 下载
	 */
	@Override
	public List<Customer> findCustomerForDownload(CustomerCond cond)
			throws Exception {
		List<Integer> projectIds = PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD);
		if(projectIds!=null && projectIds.size()>0){
			//表示为有多个项目的人员，增加能跟进不能修改的客户的判断(管理员是可以忽略的)
			cond.setProjectIds(projectIds);
		}else{
			int sessionUserId = SessionUser.getUserId();
			cond.setUserId(sessionUserId+"");
		}
		return customerMapper.findCustomerForDownload(cond);
	}

	/**
	 * 查找恒大客户
	 */
	@Override
	public List<Customer> findCustomerForHengDa(CustomerCond cond)
			throws Exception {
		
		return customerMapper.findCustomerForHengDa(cond);
	}

	/**
	 * 分组
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	@Override
	public List<Map> findCustomerGroup(CustomerCond cond)
			throws RuntimeException {
		//追加权限限制
		
		logger.info("cond.getDate1()"+cond.getDate1());
		cond.addPermissionChartProjectIds();		
		return customerMapper.findCustomerGroup(cond);
	}

	/**
	 * 分析区域
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	@Override
	public List<Map> findCustomerGroupByCategory(CustomerCond cond)
			throws RuntimeException {
		//追加权限限制
		cond.addPermissionChartProjectIds();
		return customerMapper.findCustomerGroupByCategory(cond);
	}

	/**
	 * 分组(日期)后的数据
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	@Override
	public List<Map> findCustomerGroupNum(CustomerCond cond)
			throws RuntimeException {
		//追加权限限制
		cond.addPermissionChartProjectIds();
		return customerMapper.findCustomerGroupNum(cond);
	}
	
	/**
	 * 根据用户id,判断该号码是否存在
	 * @param phone
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Customer> findPhoneIsExistsByUserId(String phone, int userId)
			throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("phone", phone);
		map.put("userId", userId + "");
		
		List<Customer> list = customerMapper.findPhoneIsExistsByUserId(map);
		
		return list;
	}

	/**
	 * 根据用户id,判断该号码是否存在
	 * @param homePhone
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Customer> findHomePhoneIsExistsByUserId(String homePhone,
			int userId) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("homePhone", homePhone);
		map.put("userId", userId + "");
		
		List<Customer> list = customerMapper.findHomePhoneIsExistsByUserId(map);
		
		return list;
	}

	/**
	 * 判断电话是否存在
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Customer> findPhoneIsExistsByUserId(String phone,
			int userId, String projectId) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("phone", phone);
		map.put("userId", userId + "");
		map.put("projectId", projectId);
		
		List<Customer> list = customerMapper.findPhoneIsExistsByUserId(map);
		
		return list;
	}

	/**
	 * 判断电话是否存在
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Customer> findHomePhoneIsExistsByUserId(String homePhone,
			int userId, String projectId) throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		map.put("homePhone", homePhone);
		map.put("userId", userId + "");
		map.put("projectId", projectId);
		
		List<Customer> list = customerMapper.findHomePhoneIsExistsByUserId(map);
		
		return list;
		
	}
	
	@Override
	public List<Map> findAllFiledInputCount(CustomerCond cond){
		//追加权限限制
		cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
		return customerMapper.findAllFiledInputCount(cond);
	}
	
	@Override
	public List<Map> findOptionFieldInputCount(CustomerCond cond){		
		return customerMapper.findOptionFieldInputCount(cond);
	}
	
	/**
	 * 广州项目主页临时通告
	 * @param cond
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findTmpNotice(CustomerCond cond) {
		
		return customerMapper.findTmpNotice(cond);
	}
	
	/**
	 * 交叉分析组合
	 * @param cond
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findCustomerDoublePie(CustomerCond cond){
		
		return customerMapper.findCustomerDoublePie(cond);
	}

	@Override
	public List<Customer> tmpList(CustomerCond cond) {
		return customerMapper.tmpList(cond);
	}

	@Override
	public void updateCustomerPhoneFrom(Map<String, String> map) {
		
		customerMapper.updateCustomerPhoneFrom(map);
	}

	@Override
	public int tmpCount() {
		return customerMapper.tmpCount();
	}
	
	/**
	 * 根据合同相关条件获取客户
	 * @param map
	 * @return
	 * @throws RuntimeException
	 */
	@Override
	public List<Customer> findCustomersForContract(String name)
			throws RuntimeException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("userId", SessionUser.getUserIdStr());
		
		return customerMapper.findCustomersForContract(map);
	}

	/**
	 * 根据号码获取客户
	 * @param map
	 * @return
	 * @throws RuntimeException
	 */
	@Override
	public List<Customer> findCustomersFromPhoneForContract(String phone)
			throws RuntimeException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("phone", phone);
		map.put("userId", SessionUser.getUserIdStr());
		
		return customerMapper.findCustomersFromPhoneForContract(map);
	}

	@Override
	public List<Customer> findCustomerListBySql(String sql)
			throws RuntimeException {
		
		return customerMapper.findCustomerListBySql(sql);
	}

	/**
	 * 根据项目id判断该号码是否存在
	 * @param phone
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	@Override
	public List<Customer> findCustomerPhoneIsExistsByProjectId(String phone,
			String projectId) throws RuntimeException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("phone", phone);
		map.put("projectId", projectId);
		
		return customerMapper.findCustomerPhoneIsExistsByProjectId(map);
	}

	/**
	 * 根据项目id判断该号码是否存在
	 * @param homePhone
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	@Override
	public List<Customer> findCustomerHomePhoneIsExistsByProjectId(
			String homePhone, String projectId) throws RuntimeException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("homePhone", homePhone);
		map.put("projectId", projectId);
		
		return customerMapper.findCustomerHomePhoneIsExistsByProjectId(map);
	}

	/**
	 * 根据查询条件分页查找customer	
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Customer> findCustomerPage(CustomerCond cond) throws RuntimeException {
		int recordCount = customerMapper.findCustomerCount(cond);
		
		cond.recordCount = recordCount;
				
		return customerMapper.findCustomerPage(cond);
	}

	@Override
	public int findCustomerCount(CustomerCond cond) throws RuntimeException {
		
		/**
		 * 当ids的size为0,表示没有符合条件的记录,用于跟进日期,2011.11.19,dtc
		 */
		if(cond.getIds() != null && cond.getIds().size() == 0){
			
			return 0;
		}
		
		return customerMapper.findCustomerCount(cond);
	}

	@Override
	public List<Map> countByTimeGroupByProjectId(CustomerCond cond)
			throws RuntimeException {
		return customerMapper.countByTimeGroupByProjectId(cond);
	}

	@Override
	public List<Map> countByVisitCountGroupByProjectId(CustomerCond cond)
			throws RuntimeException {
		return customerMapper.countByVisitCountGroupByProjectId(cond);
	}

	@Override
	public void knUpdateXqmj(Map p) throws RuntimeException {
		customerMapper.knUpdateXqmj(p);
	}

	@Override
	public void knUpdateXqjg(Map p) throws RuntimeException {
		customerMapper.knUpdateXqjg(p);
		
	}

	@Override
	public List<Map<String, Object>> findCustomerSourceAndVisit(CustomerCond cond)
			throws RuntimeException {
		
		return customerMapper.findCustomerSourceAndVisit(cond);
	}

	@Override
	public void knAddRemark(Map<String, String> p) {
		customerMapper.knAddRemark(p);
		
	}

	@Override
	public List<Customer> findThisDayModCustomer() throws RuntimeException {
		return customerMapper.findThisDayModCustomer();
	}
	
	@Override
	public List<Map> findCustomerGroupQuestionTopic(CustomerCond cond)
			throws RuntimeException {
		//追加权限限制
		cond.addPermissionChartProjectIds();		
		return customerMapper.findCustomerGroupQuestionTopic(cond);
	}

	@Override
	public List<Customer> findCustomerForMobile(CustomerCond cond)
			throws RuntimeException {
		
		/**
		 * 当ids的size为0,表示没有符合条件的记录,用于跟进日期,2011.11.19,dtc
		 */
		if(cond.getIds() != null && cond.getIds().size() == 0){
			
			return null;
		}
		
		return customerMapper.findCustomerSearch(cond);
	}

	@Override
	public List<Map> findCustomerPageReport(CustomerCond customerCond) {
		int recordCount = customerMapper.findCustomerCount(customerCond);
		customerCond.recordCount = recordCount;
		return customerMapper.findCustomerPageReport(customerCond);
	}

	@Override
	public List<Map<String, Object>> findCustomerCountGroupByVisitDate(CustomerCond customerCond) {
		customerCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
		return customerMapper.findCustomerCountGroupByVisitDate(customerCond);
	}

	@Override
	public int findCustomerCountGroupByVisitDateCount(CustomerCond customerCond) {
		customerCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
		return customerMapper.findCustomerCountGroupByVisitDateCount(customerCond);
	}

	@Override
	public List<Map<String, Object>> findCustomerProductAndConfirmInfo(
			CustomerCond customerCond) {
		customerCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
		return customerMapper.findCustomerProductAndConfirmInfo(customerCond);
	}

	@Override
	public int findCustomerProductAndConfirmInfoCount(CustomerCond customerCond) {
		customerCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
		return customerMapper.findCustomerProductAndConfirmInfoCount(customerCond);
	}

	@Override
	public List<Map<String, Object>> findCustomerAndQuestionForDownload(
			CustomerCond customerCond) {
		return customerMapper.findCustomerAndQuestionForDownload(customerCond);
	}

	@Override
	public List<Customer> findCustomerSearchDeleted(CustomerCond cond) {
				
		CustomerPermission.doCheckFind(cond);

		/**
		 * 当ids的size为0,表示没有符合条件的记录,用于跟进日期,2011.11.8
		 */
		if(cond.getIds() != null && cond.getIds().size() == 0){
			
			return null;
		}
		
		int recordCount = customerMapper.findCustomerCountDeleted(cond);
		
		cond.recordCount = recordCount;
		return customerMapper.findCustomerSearchDeleted(cond);
	}


}
