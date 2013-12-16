package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IContractSalesmanMapper;
import com.ihk.saleunit.data.pojo.ContractSalesman;
import com.ihk.saleunit.data.pojo.ContractSalesmanCond;
import com.ihk.saleunit.data.services.IContractSalesmanServices;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * ContractSalesman的Services实现(业务实现)
 * @author 
 *
 */
@Service("contractSalesmanServices")
public class ContractSalesmanServices implements IContractSalesmanServices {
	/**
	 * contractSalesman数据访问接口
	 */
	@Autowired	 IContractSalesmanMapper contractSalesmanMapper;

	/**
	 * 删除一条ContractSalesman
	 * @param id
	 */
    @Override
	public void deleteContractSalesman(int id) throws RuntimeException {
		contractSalesmanMapper.deleteContractSalesman(new PojoDeleteCond(id));
	}

	/**
	 * 新增ContractSalesman
	 * @param contractSalesman
	 */
    @Override
	public void addContractSalesman(ContractSalesman contractSalesman) throws RuntimeException {		
		contractSalesmanMapper.addContractSalesman(contractSalesman);
	}

	/**
	 * 查找一条ContractSalesman
	 * @return ContractSalesman
	 * @param id 主键id
	 */
	@Override
	public ContractSalesman findContractSalesmanById(int id) throws RuntimeException {
		return contractSalesmanMapper.findContractSalesmanById(id);
	}

	/**
	 * 修改ContractSalesman
	 * @param contractSalesman
	 */
	@Override
	public void updateContractSalesman(ContractSalesman contractSalesman) throws RuntimeException {
		contractSalesmanMapper.updateContractSalesman(contractSalesman);		
	}
	    
	/**
	 * 分页查找ContractSalesman
	 * @param cond 查询条件
	 * @return ContractSalesman列表
	 */
    @Override
	public List<ContractSalesman> findContractSalesmanPage(ContractSalesmanCond cond) throws RuntimeException {
		int recordCount = contractSalesmanMapper.findContractSalesmanCount(cond);
		
		cond.recordCount = recordCount;
				
		return contractSalesmanMapper.findContractSalesmanPage(cond);
	}
        
	/**
	 * 查找全部ContractSalesman
	 * @param cond 查询条件
	 * @return ContractSalesman列表
	 */
    @Override
	public List<ContractSalesman> findContractSalesman(ContractSalesmanCond cond) throws RuntimeException {
    	return contractSalesmanMapper.findContractSalesman(cond);
	}
    
    /**
	 * ajax分页查找ContractSalesman
	 * @param cond 查询条件
	 * @return ContractSalesman列表
	 */
    @Override
	public List<ContractSalesman> findContractSalesmanForAjax(ContractSalesmanCond cond) throws RuntimeException {
        return contractSalesmanMapper.findContractSalesmanForAjax(cond);
	}
    
     /**
	 * ajax分页查找ContractSalesman总数
	 * @param cond 查询条件
	 * @return int
	 */
    @Override
    public int findContractSalesmanCountForAjax(ContractSalesmanCond cond) throws RuntimeException {
        return contractSalesmanMapper.findContractSalesmanCountForAjax(cond);
    }
}
