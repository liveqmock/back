package com.ihk.saleunit.data.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.saleunit.data.IContractCustomerMapper;
import com.ihk.saleunit.data.pojo.ContractCustConfirm;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.ContractCustomerCond;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * ContractCustomer的Services实现(业务实现)
 * @author 
 *
 */
@Service("contractCustomerServices")
public class ContractCustomerServices implements IContractCustomerServices {
	/**
	 * contractCustomer数据访问接口
	 */
	@Autowired	 IContractCustomerMapper contractCustomerMapper;
	@Autowired   ICustomerServices customerServices;

	/**
	 * 删除一条ContractCustomer
	 * @param id
	 */
	public void deleteContractCustomer(int id) throws RuntimeException {
		contractCustomerMapper.deleteContractCustomer(new PojoDeleteCond(id));
	}

	/**
	 * 新增ContractCustomer
	 * 检查相同项目中，该客户是否已经在售前项目录入过，如果有，则记录下来
	 * @param contractCustomer
	 */
	public void addContractCustomer(ContractCustomer contractCustomer) throws RuntimeException {
		
		//检查相同项目中，该客户是否已经在售前项目录入过，如果有，则记录下来
		/*CustomerCond cond = new CustomerCond();
		cond.pageSize = 1;
		cond.setCompanyId(String.valueOf(contractCustomer.getCompanyId()));
		cond.setProjectId(contractCustomer.getProjectId());
		cond.setEqPhone(contractCustomer.getPhone());
		List<Customer> listCustomer = customerServices.findCustomerPage(cond);
		
		if(listCustomer!=null && listCustomer.size()>0){
			contractCustomer.setPreCustomerId(listCustomer.get(0).getId());
		}		
		
		String customerName = contractCustomer.getCustomerName();
		customerName = customerName.replaceAll("，", ",");
		contractCustomer.setCustomerName(customerName);
		
		String phone = contractCustomer.getPhone();
		phone = phone.replaceAll("，", ",");
		contractCustomer.setPhone(phone);*/
		
		contractCustomerMapper.addContractCustomer(contractCustomer);
	}
	public void addKnContractCustomer(ContractCustomer contractCustomer) throws RuntimeException {
		contractCustomerMapper.addContractCustomer(contractCustomer);
	}
	/**
	 * 查找一条ContractCustomer
	 * @return ContractCustomer
	 * @param id 主键id
	 */
	@Override
	public ContractCustomer findContractCustomerById(int id) throws RuntimeException {
		return contractCustomerMapper.findContractCustomerById(id);
	}

	/**
	 * 修改ContractCustomer
	 * @param contractCustomer
	 */
	@Override
	public void updateContractCustomer(ContractCustomer contractCustomer) throws RuntimeException {
		contractCustomerMapper.updateContractCustomer(contractCustomer);		
	}
	
	/**
	 * 查找符合条件的记录条数ContractCustomer
	 */
	@Override
	public int findContractCustomerCount(ContractCustomerCond cond) {
		return contractCustomerMapper.findContractCustomerCount(cond);
	}

	/**
	 * 分页查找ContractCustomer
	 * @param cond 查询条件
	 * @return ContractCustomer列表
	 */
	public List<ContractCustomer> findContractCustomerPage(ContractCustomerCond cond) throws RuntimeException {
		int recordCount = contractCustomerMapper.findContractCustomerCount(cond);
		
		cond.recordCount = recordCount;
				
		return contractCustomerMapper.findContractCustomerPage(cond);
	}

	/**
	 * 查找全部ContractCustomer
	 * @param cond 查询条件
	 * @return ContractCustomer列表
	 */
	public List<ContractCustomer> findContractCustomer(ContractCustomerCond cond) throws RuntimeException {
    	return contractCustomerMapper.findContractCustomer(cond);
	}
	
	@Override
	public List<ContractCustomer> findContractCustomerForAjax(
			ContractCustomerCond cond) throws RuntimeException {
		return contractCustomerMapper.findContractCustomerForAjax(cond);
	}

	@Override
	public int findContractCustomerCountForAjax(ContractCustomerCond cond)
			throws RuntimeException {
		return contractCustomerMapper.findContractCustomerCountForAjax(cond);
	}

	/**
	 * 根据name 模糊查找
	 */
	@Override
	public List<ContractCustomer> findConfirmCustomerLikeName(
			ContractCustomerCond cond) throws RuntimeException {
		
		return contractCustomerMapper.findConfirmCustomerLikeName(cond);
	}

	/**
	 * 根据名称查找
	 */
	@Override
	public List<ContractCustomer> findCustomersForChip(String name)
			throws RuntimeException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("type", ContConfirmType.CHIP);
		map.put("createdId", SessionUser.getUserIdStr());
		
		return contractCustomerMapper.findCustomersForChip(map);
		
	}

	/**
	 * 根据phone查找
	 */
	@Override
	public List<ContractCustomer> findCustomersFromPhoneForChip(String phone)
			throws RuntimeException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("phone", phone);
		map.put("type", ContConfirmType.CHIP);
		map.put("createdId", SessionUser.getUserIdStr());
		
		return contractCustomerMapper.findCustomersFromPhoneForChip(map);
	}

	/**
	 * 修改ConfirmType
	 */
	@Override
	public void updateContractCustomerConfirmType(int customerId,
			String confirmType) throws RuntimeException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("customerId", customerId + "");
		map.put("confirmType", confirmType);
		
		contractCustomerMapper.updateContractCustomerConfirmType(map);
		
	}

	@Override
	public List<ContractCustomer> findContractCustomerByBuildIds(ContractCustomerCond cond) throws RuntimeException {
		
		return contractCustomerMapper.findContractCustomerByBuildIds(cond);
	}

	@Override
	public int findContractCustomerCountByBuildIds(
			ContractCustomerCond cond) throws RuntimeException {
		
		return contractCustomerMapper.findContractCustomerCountByBuildIds(cond);
	}
	
	@Override
	public List<ContractCustConfirm> findcontractCustAndConfirm(ContractCustomerCond cond) throws RuntimeException {
		return contractCustomerMapper.findcontractCustAndConfirm(cond);
	}
	
	@Override
	public int findcontractCustAndConfirmCount(ContractCustomerCond cond) throws RuntimeException {
		return contractCustomerMapper.findcontractCustAndConfirmCount(cond);
	}

	@Override
	public void updateContractCustomerMainId(int customerId, int mainId)
			throws RuntimeException {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("customerId", customerId);
		map.put("mainId", mainId);
		
		contractCustomerMapper.updateContractCustomerMainId(map);
	}
	
	@Override
	public List<ContractCustomer> findContractCustomerByMainIdAndConfirmType(
			int mainId, String confirmType) throws RuntimeException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("mainId", mainId + "");
		map.put("confirmType", confirmType);
		
		return contractCustomerMapper.findContractCustomerByMainIdAndConfirmType(map);
	}

	@Override
	public List<ContractCustomer> findContractCustomerByMainIdAndConfirmTypeNotValid(
			int mainId, String confirmType) throws RuntimeException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mainId", mainId + "");
		map.put("confirmType", confirmType);
		
		return contractCustomerMapper.findContractCustomerByMainIdAndConfirmTypeNotValid(map);
	}
	
	@Override
	public List<ContractCustomer> findValidCustomerByProjectIdPhoneType(
			ContractCustomerCond cond) throws RuntimeException {
		return contractCustomerMapper.findValidCustomerByProjectIdPhoneType(cond);
	}
	
	@Override
	public void updateContractCustomerConfirmTypeAndMainId(int customerId,
			String confirmType, int mainId) throws RuntimeException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("customerId", customerId + "");
		map.put("confirmType", confirmType);
		map.put("mainId", mainId + "");
		
		contractCustomerMapper.updateContractCustomerConfirmTypeAndMainId(map);
	}
	
	//////

	@Override
	public List<ContractCustomer> findContractCustomer2()
			throws RuntimeException {
		
		return contractCustomerMapper.findContractCustomer2();
	}

	@Override
	public List<Map<String, Integer>> findConfirmCustomer() {
		return contractCustomerMapper.findConfirmCustomer();
	}

	@Override
	public List<Map<String, Integer>> findUnitContractCustomerConfirm() {
		return contractCustomerMapper.findUnitContractCustomerConfirm();
	}

	@Override
	public List<Map<String, Integer>> findUnitContractCustomerConfirmForUpdate() {
		return contractCustomerMapper.findUnitContractCustomerConfirmForUpdate();
	}
	
	/**
	 * 查找全部Customer
	 * @param cond 查询条件
	 * @return Customer列表
	 */
	@Override
	public List<ContractCustomer> findContractCustomerSearch(ContractCustomerCond cond) throws RuntimeException{		
		//System.out.println("findCustomerSearch");
		//System.out.println("结果："+PermissionUtils.findUserPriv(164));
		
		//CustomerPermission.doCheckFind(cond);   暂时删除
			
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
//		if(cond.getIds() != null && cond.getIds().size() == 0){
//			
//			return null;
//		}
		
		int recordCount = contractCustomerMapper.findContractCustomerCountSearch(cond);
		
		cond.recordCount = recordCount;
		return contractCustomerMapper.findContractCustomerSearch(cond);
	}

	/**
	 * 查找全部Customer
	 * @param cond 查询条件
	 * @return Customer列表
	 */
	@Override
	public List<ContractCustomer> findContractCustomerDownload(ContractCustomerCond cond) throws RuntimeException{		
		return contractCustomerMapper.findContractCustomerDownload(cond);
	}

	/**
	 * 查找成交+合同
	 */
	@Override
	public List<ContractCustConfirm> findContractConfirmCust(
			ContractCustomerCond contractCustomerCond) {
		return contractCustomerMapper.findContractConfirmCust(contractCustomerCond);
	}

	@Override
	public int findContractConfirmCustCount(
			ContractCustomerCond contractCustomerCond) {
		// TODO Auto-generated method stub
		return contractCustomerMapper.findContractConfirmCustCount(contractCustomerCond);
	}
	
	/**
	 * 查找成交+合同
	 */
	@Override
	public List<ContractCustomer> findContractConfirmCustomer(
			ContractCustomerCond contractCustomerCond) {
		contractCustomerCond.recordCount = contractCustomerMapper.findContractConfirmCustomerCount(contractCustomerCond);
		return contractCustomerMapper.findContractConfirmCustomer(contractCustomerCond);
	}

    /**
     * 按项目id查询
     * @param id
     * @return
     * @throws RuntimeException
     */
    public  List<Map<String, Object>> findContractCustomerByPropertyId(int id)  throws RuntimeException {

        return contractCustomerMapper.findContractCustomerByPropertyId(id);

    }
}
