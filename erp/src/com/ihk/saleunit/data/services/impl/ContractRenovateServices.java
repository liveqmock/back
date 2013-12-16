package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IContractRenovateMapper;
import com.ihk.saleunit.data.pojo.ContractRenovate;
import com.ihk.saleunit.data.pojo.ContractRenovateCond;
import com.ihk.saleunit.data.services.IContractRenovateServices;

/**
 * ContractRenovate的Services实现(业务实现)
 * @author 
 *
 */
@Service("contractRenovateServices")
public class ContractRenovateServices implements IContractRenovateServices {
	/**
	 * contractRenovate数据访问接口
	 */
	@Autowired	 IContractRenovateMapper contractRenovateMapper;

	/**
	 * 删除一条ContractRenovate
	 * @param id
	 */
	public void deleteContractRenovate(int id) throws RuntimeException {
		contractRenovateMapper.deleteContractRenovate(id);
	}

	/**
	 * 新增ContractRenovate
	 * @param contractRenovate
	 */
	public void addContractRenovate(ContractRenovate contractRenovate) throws RuntimeException {		
		contractRenovateMapper.addContractRenovate(contractRenovate);
	}


	/**
	 * 查找一条ContractRenovate
	 * @return ContractRenovate
	 * @param id 主键id
	 */
	@Override
	public ContractRenovate findContractRenovateById(int id) throws RuntimeException {
		return contractRenovateMapper.findContractRenovateById(id);
	}

	/**
	 * 修改ContractRenovate
	 * @param contractRenovate
	 */
	@Override
	public void updateContractRenovate(ContractRenovate contractRenovate) throws RuntimeException {
		contractRenovateMapper.updateContractRenovate(contractRenovate);		
	}

	/**
	 * 分页查找ContractRenovate
	 * @param cond 查询条件
	 * @return ContractRenovate列表
	 */
	public List<ContractRenovate> findContractRenovatePage(ContractRenovateCond cond) throws RuntimeException {
		int recordCount = contractRenovateMapper.findContractRenovateCount(cond);
		
		cond.recordCount = recordCount;
				
		return contractRenovateMapper.findContractRenovatePage(cond);
	}

	/**
	 * 查找全部ContractRenovate
	 * @param cond 查询条件
	 * @return ContractRenovate列表
	 */
	public List<ContractRenovate> findContractRenovate(ContractRenovateCond cond) throws RuntimeException {
    	return contractRenovateMapper.findContractRenovate(cond);
	}
}
