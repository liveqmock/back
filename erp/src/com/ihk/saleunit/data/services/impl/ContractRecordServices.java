package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IContractRecordMapper;
import com.ihk.saleunit.data.pojo.ContractRecord;
import com.ihk.saleunit.data.pojo.ContractRecordCond;
import com.ihk.saleunit.data.services.IContractRecordServices;

/**
 * ContractRecord的Services实现(业务实现)
 * @author 
 *
 */
@Service("contractRecordServices")
@SuppressWarnings("unchecked")
public class ContractRecordServices implements IContractRecordServices {
	/**
	 * contractRecord数据访问接口
	 */
	@Autowired	 IContractRecordMapper contractRecordMapper;

	/**
	 * 删除一条ContractRecord
	 * @param id
	 */
	public void deleteContractRecord(int id) throws RuntimeException {
		contractRecordMapper.deleteContractRecord(id);
	}

	/**
	 * 新增ContractRecord
	 * @param contractRecord
	 */
	public void addContractRecord(ContractRecord contractRecord) throws RuntimeException {		
		contractRecordMapper.addContractRecord(contractRecord);
	}

	/**
	 * 查找一条ContractRecord
	 * @return ContractRecord
	 * @param id 主键id
	 */
	@Override
	public ContractRecord findContractRecordById(int id) throws RuntimeException {
		return contractRecordMapper.findContractRecordById(id);
	}

	/**
	 * 修改ContractRecord
	 * @param contractRecord
	 */
	@Override
	public void updateContractRecord(ContractRecord contractRecord) throws RuntimeException {
		contractRecordMapper.updateContractRecord(contractRecord);		
	}

	/**
	 * 分页查找ContractRecord
	 * @param cond 查询条件
	 * @return ContractRecord列表
	 */
	public List<ContractRecord> findContractRecordPage(ContractRecordCond cond) throws RuntimeException {
		int recordCount = contractRecordMapper.findContractRecordCount(cond);
		
		cond.recordCount = recordCount;
				
		return contractRecordMapper.findContractRecordPage(cond);
	}

	/**
	 * 查找全部ContractRecord
	 * @param cond 查询条件
	 * @return ContractRecord列表
	 */
	public List<ContractRecord> findContractRecord(ContractRecordCond cond) throws RuntimeException {
    	return contractRecordMapper.findContractRecord(cond);
	}
}
