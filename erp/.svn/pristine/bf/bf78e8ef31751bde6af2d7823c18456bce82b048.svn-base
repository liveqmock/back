package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IContractRecordDetailMapper;
import com.ihk.saleunit.data.pojo.ContractRecordDetail;
import com.ihk.saleunit.data.pojo.ContractRecordDetailCond;
import com.ihk.saleunit.data.services.IContractRecordDetailServices;

/**
 * ContractRecordDetail的Services实现(业务实现)
 * @author 
 *
 */
@Service("contractRecordDetailServices")
@SuppressWarnings("unchecked")
public class ContractRecordDetailServices implements IContractRecordDetailServices {
	/**
	 * contractRecordDetail数据访问接口
	 */
	@Autowired	 IContractRecordDetailMapper contractRecordDetailMapper;

	/**
	 * 删除一条ContractRecordDetail
	 * @param id
	 */
	public void deleteContractRecordDetail(int id) throws RuntimeException {
		contractRecordDetailMapper.deleteContractRecordDetail(id);
	}

	/**
	 * 新增ContractRecordDetail
	 * @param contractRecordDetail
	 */
	public void addContractRecordDetail(ContractRecordDetail contractRecordDetail) throws RuntimeException {		
		contractRecordDetailMapper.addContractRecordDetail(contractRecordDetail);
	}

	/**
	 * 查找一条ContractRecordDetail
	 * @return ContractRecordDetail
	 * @param id 主键id
	 */
	@Override
	public ContractRecordDetail findContractRecordDetailById(int id) throws RuntimeException {
		return contractRecordDetailMapper.findContractRecordDetailById(id);
	}

	/**
	 * 修改ContractRecordDetail
	 * @param contractRecordDetail
	 */
	@Override
	public void updateContractRecordDetail(ContractRecordDetail contractRecordDetail) throws RuntimeException {
		contractRecordDetailMapper.updateContractRecordDetail(contractRecordDetail);		
	}

	/**
	 * 分页查找ContractRecordDetail
	 * @param cond 查询条件
	 * @return ContractRecordDetail列表
	 */
	public List<ContractRecordDetail> findContractRecordDetailPage(ContractRecordDetailCond cond) throws RuntimeException {
		int recordCount = contractRecordDetailMapper.findContractRecordDetailCount(cond);
		
		cond.recordCount = recordCount;
				
		return contractRecordDetailMapper.findContractRecordDetailPage(cond);
	}

	/**
	 * 查找全部ContractRecordDetail
	 * @param cond 查询条件
	 * @return ContractRecordDetail列表
	 */
	public List<ContractRecordDetail> findContractRecordDetail(ContractRecordDetailCond cond) throws RuntimeException {
    	return contractRecordDetailMapper.findContractRecordDetail(cond);
	}
}
