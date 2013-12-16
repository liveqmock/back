package com.ihk.property.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.ContractManager;
import com.ihk.property.data.pojo.ContractManagerCond;

@Transactional 
public interface IContractManagerServices {
	public void addContractManager(ContractManager contractManager) throws RuntimeException;

	public void deleteContractManager(int id) throws RuntimeException;

	public void updateContractManager(ContractManager contractManager) throws RuntimeException;

	public ContractManager findContractManagerById(int id) throws RuntimeException;
    
	public List<ContractManager> findContractManagerPage(ContractManagerCond cond) throws RuntimeException;
    
	public List<ContractManager> findContractManager(ContractManagerCond cond) throws RuntimeException;
	
	/**
	 * 根据楼栋id获取对应的ContractManager list
	 * @param buildId
	 * @return
	 * @throws RuntimeException
	 */
	public List<ContractManager> findContractManagerByBuildId(int buildId) throws RuntimeException;
	
	/**
	 * 根据分区id获取对应的ContractManager list
	 * @param areaId
	 * @return
	 * @throws RuntimeException
	 */
	public List<ContractManager> findContractManagerByAreaId(int areaId) throws RuntimeException;
	
	/**
	 * 根据项目id获取对应的ContractManager list
	 * @param proId
	 * @return
	 * @throws RuntimeException
	 */
	public List<ContractManager> findContractManagerByProId(int proId) throws RuntimeException;
	
	/**
	 * 作废ContractManager
	 * @param id
	 * @throws RuntimeException
	 */
	public void cancelContractManager(int id) throws RuntimeException;
}