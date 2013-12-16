package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IContractServiceMapper;
import com.ihk.saleunit.data.pojo.ContractService;
import com.ihk.saleunit.data.pojo.ContractServiceCond;
import com.ihk.saleunit.data.services.IContractServiceServices;

/**
 * ContractService的Services实现(业务实现)
 * @author 
 *
 */
@Service("contractServiceServices")
public class ContractServiceServices implements IContractServiceServices {
	/**
	 * contractService数据访问接口
	 */
	@Autowired	 IContractServiceMapper contractServiceMapper;

	/**
	 * 删除一条ContractService
	 * @param id
	 */
	public void deleteContractService(int id) throws RuntimeException {
		contractServiceMapper.deleteContractService(id);
	}

	/**
	 * 新增ContractService
	 * @param contractService
	 */
	public void addContractService(ContractService contractService) throws RuntimeException {		
		contractServiceMapper.addContractService(contractService);
	}

	/**
	 * 查找一条ContractService
	 * @return ContractService
	 * @param id 主键id
	 */
	@Override
	public ContractService findContractServiceById(int id) throws RuntimeException {
		return contractServiceMapper.findContractServiceById(id);
	}

	/**
	 * 修改ContractService
	 * @param contractService
	 */
	@Override
	public void updateContractService(ContractService contractService) throws RuntimeException {
		contractServiceMapper.updateContractService(contractService);		
	}

	/**
	 * 分页查找ContractService
	 * @param cond 查询条件
	 * @return ContractService列表
	 */
	public List<ContractService> findContractServicePage(ContractServiceCond cond) throws RuntimeException {
		int recordCount = contractServiceMapper.findContractServiceCount(cond);
		
		cond.recordCount = recordCount;
				
		return contractServiceMapper.findContractServicePage(cond);
	}

	/**
	 * 查找全部ContractService
	 * @param cond 查询条件
	 * @return ContractService列表
	 */
	public List<ContractService> findContractService(ContractServiceCond cond) throws RuntimeException {
    	return contractServiceMapper.findContractService(cond);
	}
}
