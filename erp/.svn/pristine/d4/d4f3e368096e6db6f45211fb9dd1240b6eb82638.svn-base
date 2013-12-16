package com.ihk.saleunit.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCond;

/**
 * Contract的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IContractServices {
	
	/**
	 * 查找符合条件的记录条数Contract
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findContractCount(ContractCond cond) throws RuntimeException;
	
	/**
	 * 新增Contract
	 * @param contract
	 */
	public void addContract(Contract contract) throws RuntimeException;

	/**
	 * 删除一条Contract
	 * @param id
	 */
	public void deleteContract(int id) throws RuntimeException;

	/**
	 * 修改Contract
	 * @param contract
	 */
	public void updateContract(Contract contract) throws RuntimeException;

	/**
	 * 查找一条Contract
	 * @return Contract
	 * @param id 主键id
	 */
	public Contract findContractById(int id) throws RuntimeException;

	/**
	 * 分页查找Contract
	 * @param cond 查询条件
	 * @return Contract列表
	 */
	public List<Contract> findContractPage(ContractCond cond) throws RuntimeException;

	/**
	 * 查找全部Contract
	 * @param cond 查询条件
	 * @return Contract列表
	 */
	public List<Contract> findContract(ContractCond cond) throws RuntimeException;
	
	/**
	 * 查找公司报表
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map<String, Object>> findCompanyReport(ContractCond cond) throws RuntimeException;
	
	/**
	 * 查找报表
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map<String, Object>> findPropertyReport(ContractCond cond) throws RuntimeException;
	
	/**
	 * 根据unitId 查找
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public Contract findContractByUnitId(int unitId) throws RuntimeException;
	
	/**
	 * 根据unitId 查找,包括已删除
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public Contract findContractByUnitIdIncludeIsDelete(int unitId) throws RuntimeException;
	
	/**
	 * 重置一条Contract
	 * @param id
	 */
	public void reloadContract(Contract contract) throws RuntimeException;
	
	/**
	 * 根据客户id获取对应的合同
	 * @param customerId
	 * @return
	 */
	public Contract findContractByCustomerId(int customerId);
	
	 /**
     * 修改对应合同单的payWayId
     * @param id
     * @param payWayId
     * @throws RuntimeException
     */
    public void updateContractPayWayId(int id, int payWayId) throws RuntimeException;
	
	
}