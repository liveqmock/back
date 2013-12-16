package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ContractRenovate;
import com.ihk.saleunit.data.pojo.ContractRenovateCond;

/**
 * ContractRenovate的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IContractRenovateServices {
	/**
	 * 新增ContractRenovate
	 * @param contractRenovate
	 */
	public void addContractRenovate(ContractRenovate contractRenovate) throws RuntimeException;

	/**
	 * 删除一条ContractRenovate
	 * @param id
	 */
	public void deleteContractRenovate(int id) throws RuntimeException;

	/**
	 * 修改ContractRenovate
	 * @param contractRenovate
	 */
	public void updateContractRenovate(ContractRenovate contractRenovate) throws RuntimeException;

	/**
	 * 查找一条ContractRenovate
	 * @return ContractRenovate
	 * @param id 主键id
	 */
	public ContractRenovate findContractRenovateById(int id) throws RuntimeException;

	/**
	 * 分页查找ContractRenovate
	 * @param cond 查询条件
	 * @return ContractRenovate列表
	 */
	public List<ContractRenovate> findContractRenovatePage(ContractRenovateCond cond) throws RuntimeException;

	/**
	 * 查找全部ContractRenovate
	 * @param cond 查询条件
	 * @return ContractRenovate列表
	 */
	public List<ContractRenovate> findContractRenovate(ContractRenovateCond cond) throws RuntimeException;
}