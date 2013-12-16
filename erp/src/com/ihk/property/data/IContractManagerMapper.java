package com.ihk.property.data;

import java.util.List;

import com.ihk.property.data.pojo.ContractManager;
import com.ihk.property.data.pojo.ContractManagerCond;

import com.ihk.utils.base.PojoDeleteCond;
 
public interface IContractManagerMapper {

	public void addContractManager(ContractManager contractManager) ;

	public void deleteContractManager(PojoDeleteCond cond) throws RuntimeException;

	public void updateContractManager(ContractManager contractManager) throws RuntimeException;
	
	public ContractManager findContractManagerById(int id) throws RuntimeException;
	
	public List<ContractManager> findContractManagerPage(ContractManagerCond cond) ;
    
	public List<ContractManager> findContractManager(ContractManagerCond cond) ;
    
	public int findContractManagerCount(ContractManagerCond cond) ;
	
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
	 * @param cond
	 * @throws RuntimeException
	 */
	public void cancelContractManager(PojoDeleteCond cond) throws RuntimeException;
}
