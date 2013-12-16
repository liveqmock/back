package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ContractService;
import com.ihk.saleunit.data.pojo.ContractServiceCond;

/**
 * ContractService的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IContractServiceServices {
	/**
	 * 新增ContractService
	 * @param contractService
	 */
	public void addContractService(ContractService contractService) throws RuntimeException;

	/**
	 * 删除一条ContractService
	 * @param id
	 */
	public void deleteContractService(int id) throws RuntimeException;

	/**
	 * 修改ContractService
	 * @param contractService
	 */
	public void updateContractService(ContractService contractService) throws RuntimeException;

	/**
	 * 查找一条ContractService
	 * @return ContractService
	 * @param id 主键id
	 */
	public ContractService findContractServiceById(int id) throws RuntimeException;

	/**
	 * 分页查找ContractService
	 * @param cond 查询条件
	 * @return ContractService列表
	 */
	public List<ContractService> findContractServicePage(ContractServiceCond cond) throws RuntimeException;

	/**
	 * 查找全部ContractService
	 * @param cond 查询条件
	 * @return ContractService列表
	 */
	public List<ContractService> findContractService(ContractServiceCond cond) throws RuntimeException;
}