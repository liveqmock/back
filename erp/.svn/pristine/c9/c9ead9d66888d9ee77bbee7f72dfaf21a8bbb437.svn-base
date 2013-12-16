package com.ihk.customer.data.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.ICustomerFollowMapper;
import com.ihk.customer.data.pojo.CustomerFollow;
import com.ihk.customer.data.pojo.CustomerFollowCond;
import com.ihk.customer.data.services.ICustomerFollowServices;
import com.ihk.permission.PermissionUtils;

/**
 * CustomerFollow的Services实现(业务实现)
 * @author 
 *
 */
@Service("customerFollowServices")
public class CustomerFollowServices implements ICustomerFollowServices {

	private static final long serialVersionUID = 1L;

	/**
	 * customerFollow数据访问接口
	 */
	@Autowired	 ICustomerFollowMapper customerFollowMapper;

	/**
	 * 删除一条CustomerFollow
	 * @param id
	 */
	public void deleteCustomerFollow(int id) throws RuntimeException {
		customerFollowMapper.deleteCustomerFollow(id);
	}

	/**
	 * 新增CustomerFollow
	 * @param customerFollow
	 */
	public void addCustomerFollow(CustomerFollow customerFollow) throws RuntimeException {		
		customerFollowMapper.addCustomerFollow(customerFollow);
	}

	/**
	 * 查找一条CustomerFollow
	 * @return CustomerFollow
	 * @param id 主键id
	 */
	@Override
	public CustomerFollow findCustomerFollowById(int id) throws RuntimeException {
		return customerFollowMapper.findCustomerFollowById(id);
	}

	/**
	 * 修改CustomerFollow
	 * @param customerFollow
	 */
	@Override
	public void updateCustomerFollow(CustomerFollow customerFollow) throws RuntimeException {
		customerFollowMapper.updateCustomerFollow(customerFollow);		
	}

	/**
	 * 分页查找CustomerFollow
	 * @param cond 查询条件
	 * @return CustomerFollow列表
	 */
	@SuppressWarnings("rawtypes")
	public List findCustomerFollowPage(CustomerFollowCond cond) throws RuntimeException {
		int recordCount = customerFollowMapper.findCustomerFollowCount(cond);
		
		cond.recordCount = recordCount;
				
		return customerFollowMapper.findCustomerFollowPage(cond);
	}

	/**
	 * 查找全部CustomerFollow
	 * @param cond 查询条件
	 * @return CustomerFollow列表
	 */
	@Override
	public List<CustomerFollow> findCustomerFollowByCustomerId(int id)
			throws Exception {
		return customerFollowMapper.findCustomerFollowByCustomerId(id);
	}

	@Override
	public List<CustomerFollow> findCustomerFollowByCustomerIdForIndex(
			int customerId) {
		return customerFollowMapper.findCustomerFollowByCustomerIdForIndex(customerId);
	}

	/**
	 * 取得报表,公司跟进情况
	 * Map[companyId,companyName,phoneCount,visitCount]
	 */
	@Override
	public List<Map> findReportSumGroupByCompany(CustomerFollowCond cond) throws Exception {
		//追加权限限制
		cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
		return customerFollowMapper.findReportSumGroupByCompany(cond);
	}

	/**
	 * 取得报表,项目跟进情况
	 * Map[project_id,project_name,phone_count,visit_count]
	 */
	@Override
	public List<Map> findReportSumGroupByProject(CustomerFollowCond cond) throws Exception {
		//追加权限限制
		cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
		return customerFollowMapper.findReportSumGroupByProject(cond);
	}

	/**
	 * 取得报表,销售人员跟进情况
	 * Map[user_id,real_name,phone_count,visit_count]
	 */
	@Override
	public List<Map> findReportSumGroupByUser(CustomerFollowCond cond) throws Exception {
		//追加权限限制
		cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
		return customerFollowMapper.findReportSumGroupByUser(cond);
	}
	
	/**
	 * customer的id集合
	 */
	@Override
	public List<Integer> findCustomerFollowCustomerIds(CustomerFollowCond cond) throws Exception{
		return customerFollowMapper.findCustomerFollowCustomerIds(cond);
	}
	
	
	@Override
	public List<Map> findCustomerListByCustomerFollowUser(CustomerFollowCond cond) throws Exception{
		
		return customerFollowMapper.findCustomerListByCustomerFollowUser(cond);
	}
	
	@Override
	public List<Map> findCustomerListByCustomer(CustomerFollowCond cond)
			throws Exception {
		// TODO Auto-generated method stub
		return customerFollowMapper.findCustomerListByCustomer(cond);
	}

	@Override
	public List<Map> findCustomerListByProject(CustomerFollowCond cond)
			throws Exception {
		// TODO Auto-generated method stub
		return customerFollowMapper.findCustomerListByProject(cond);
	}

	@Override
	public CustomerFollow findCustomerFollowByCustomerIdNewestRecord(int customerId) {
		return customerFollowMapper.findCustomerFollowByCustomerIdNewestRecord(customerId);
		
	}
}
