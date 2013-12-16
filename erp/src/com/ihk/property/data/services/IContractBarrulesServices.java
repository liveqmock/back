package com.ihk.property.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.ContractBarrules;
import com.ihk.property.data.pojo.ContractBarrulesCond;

@Transactional 
public interface IContractBarrulesServices {
	public void addContractBarrules(ContractBarrules contractBarrules) throws RuntimeException;

	public void deleteContractBarrules(int id) throws RuntimeException;

	public void updateContractBarrules(ContractBarrules contractBarrules) throws RuntimeException;

	public ContractBarrules findContractBarrulesById(int id) throws RuntimeException;
    
	public List<ContractBarrules> findContractBarrulesPage(ContractBarrulesCond cond) throws RuntimeException;
    
	public List<ContractBarrules> findContractBarrules(ContractBarrulesCond cond) throws RuntimeException;
	
	/**
	 * 设置barRule的managerId
	 * @param managerId
	 * @param barRulesIds
	 * @throws RuntimeException
	 */
	public void updateContractBarrulesSetManagerId(int managerId, List<Integer> barRulesIds) throws RuntimeException;
	
	/**
	 * 根据managerId获取对应的ContractBarrules
	 * @param managerId
	 * @return
	 * @throws RuntimeException
	 */
	public List<ContractBarrules> findContractBarrulesByManagerId(int managerId) throws RuntimeException;
	
	/**
	 * 作废barRule
	 * @param id
	 * @throws RuntimeException
	 */
	public void cancelContractBarrules(int id) throws RuntimeException;
}