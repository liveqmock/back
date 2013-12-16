package com.ihk.property.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IContractBarrulesMapper;
import com.ihk.property.data.pojo.ContractBarrules;
import com.ihk.property.data.pojo.ContractBarrulesCond;
import com.ihk.property.data.services.IContractBarrulesServices;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.base.PojoDeleteCond;

@Service("contractBarrulesServices")
public class ContractBarrulesServices implements IContractBarrulesServices {
	@Autowired	 IContractBarrulesMapper contractBarrulesMapper;

	public void deleteContractBarrules(int id) throws RuntimeException {
		contractBarrulesMapper.deleteContractBarrules(new PojoDeleteCond(id));
	}

	public void addContractBarrules(ContractBarrules contractBarrules) throws RuntimeException {		
		contractBarrulesMapper.addContractBarrules(contractBarrules);
	}

	@Override
	public ContractBarrules findContractBarrulesById(int id) throws RuntimeException {
		return contractBarrulesMapper.findContractBarrulesById(id);
	}

	@Override
	public void updateContractBarrules(ContractBarrules contractBarrules) throws RuntimeException {
		contractBarrulesMapper.updateContractBarrules(contractBarrules);		
	}
	
	public List<ContractBarrules> findContractBarrulesPage(ContractBarrulesCond cond) throws RuntimeException {
		int recordCount = contractBarrulesMapper.findContractBarrulesCount(cond);
		
		cond.recordCount = recordCount;
				
		return contractBarrulesMapper.findContractBarrulesPage(cond);
	}
    
	public List<ContractBarrules> findContractBarrules(ContractBarrulesCond cond) throws RuntimeException {
    	return contractBarrulesMapper.findContractBarrules(cond);
	}

	@Override
	public void updateContractBarrulesSetManagerId(int managerId,
			List<Integer> barRulesIds) throws RuntimeException {
		
		if(CommonUtils.isCollectionEmpty(barRulesIds))
			
			return ;
		
		ContractBarrulesCond cond = new ContractBarrulesCond();
		
		cond.setManagerId(managerId);
		cond.setBarRulesIds(barRulesIds);
		
		contractBarrulesMapper.updateContractBarrulesSetManagerId(cond);
	}

	@Override
	public List<ContractBarrules> findContractBarrulesByManagerId(int managerId)
			throws RuntimeException {
		
		return contractBarrulesMapper.findContractBarrulesByManagerId(managerId);
	}

	@Override
	public void cancelContractBarrules(int id) throws RuntimeException {
		contractBarrulesMapper.cancelContractBarrules(new PojoDeleteCond(id));
	}
}
