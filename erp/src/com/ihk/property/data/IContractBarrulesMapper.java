package com.ihk.property.data;

import java.util.List;

import com.ihk.property.data.pojo.ContractBarrules;
import com.ihk.property.data.pojo.ContractBarrulesCond;

import com.ihk.utils.base.PojoDeleteCond;
 
public interface IContractBarrulesMapper {

	public void addContractBarrules(ContractBarrules contractBarrules) ;

	public void deleteContractBarrules(PojoDeleteCond cond) throws RuntimeException;

	public void updateContractBarrules(ContractBarrules contractBarrules) throws RuntimeException;
	
	public ContractBarrules findContractBarrulesById(int id) throws RuntimeException;
	
	public List<ContractBarrules> findContractBarrulesPage(ContractBarrulesCond cond) ;
    
	public List<ContractBarrules> findContractBarrules(ContractBarrulesCond cond) ;
    
	public int findContractBarrulesCount(ContractBarrulesCond cond) ;
	
	/**
	 * 设置barRule的managerId
	 * @param cond
	 * @throws RuntimeException
	 */
	public void updateContractBarrulesSetManagerId(ContractBarrulesCond cond) throws RuntimeException;
	
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
	public void cancelContractBarrules(PojoDeleteCond cond) throws RuntimeException;
}
