package com.ihk.property.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IContractManagerMapper;
import com.ihk.property.data.pojo.ContractManager;
import com.ihk.property.data.pojo.ContractManagerCond;
import com.ihk.property.data.services.IContractManagerServices;

import com.ihk.utils.base.PojoDeleteCond;

@Service("contractManagerServices")
public class ContractManagerServices implements IContractManagerServices {
	@Autowired	 IContractManagerMapper contractManagerMapper;

	public void deleteContractManager(int id) throws RuntimeException {
		contractManagerMapper.deleteContractManager(new PojoDeleteCond(id));
	}

	public void addContractManager(ContractManager contractManager) throws RuntimeException {		
		contractManagerMapper.addContractManager(contractManager);
	}

	@Override
	public ContractManager findContractManagerById(int id) throws RuntimeException {
		return contractManagerMapper.findContractManagerById(id);
	}

	@Override
	public void updateContractManager(ContractManager contractManager) throws RuntimeException {
		contractManagerMapper.updateContractManager(contractManager);		
	}
	
	public List<ContractManager> findContractManagerPage(ContractManagerCond cond) throws RuntimeException {
		int recordCount = contractManagerMapper.findContractManagerCount(cond);
		
		cond.recordCount = recordCount;
				
		return contractManagerMapper.findContractManagerPage(cond);
	}
    
	public List<ContractManager> findContractManager(ContractManagerCond cond) throws RuntimeException {
    	return contractManagerMapper.findContractManager(cond);
	}

	@Override
	public List<ContractManager> findContractManagerByBuildId(int buildId)
			throws RuntimeException {
		return contractManagerMapper.findContractManagerByBuildId(buildId);
	}
	
	@Override
	public List<ContractManager> findContractManagerByAreaId(int areaId)
			throws RuntimeException {
		return contractManagerMapper.findContractManagerByAreaId(areaId);
	}

	@Override
	public List<ContractManager> findContractManagerByProId(int proId)
			throws RuntimeException {
		return contractManagerMapper.findContractManagerByProId(proId);
	}

	@Override
	public void cancelContractManager(int id) throws RuntimeException {
		contractManagerMapper.cancelContractManager(new PojoDeleteCond(id));
	}

}
