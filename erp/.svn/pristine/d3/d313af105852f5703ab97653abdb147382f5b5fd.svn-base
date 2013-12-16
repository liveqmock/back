package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ContractRecord;
import com.ihk.saleunit.data.pojo.ContractRecordCond;

/**
 * ContractRecord的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IContractRecordServices {
	/**
	 * 新增ContractRecord
	 * @param contractRecord
	 */
	public void addContractRecord(ContractRecord contractRecord) throws RuntimeException;

	/**
	 * 删除一条ContractRecord
	 * @param id
	 */
	public void deleteContractRecord(int id) throws RuntimeException;

	/**
	 * 修改ContractRecord
	 * @param contractRecord
	 */
	public void updateContractRecord(ContractRecord contractRecord) throws RuntimeException;

	/**
	 * 查找一条ContractRecord
	 * @return ContractRecord
	 * @param id 主键id
	 */
	public ContractRecord findContractRecordById(int id) throws RuntimeException;

	/**
	 * 分页查找ContractRecord
	 * @param cond 查询条件
	 * @return ContractRecord列表
	 */
	public List<ContractRecord> findContractRecordPage(ContractRecordCond cond) throws RuntimeException;

	/**
	 * 查找全部ContractRecord
	 * @param cond 查询条件
	 * @return ContractRecord列表
	 */
	public List<ContractRecord> findContractRecord(ContractRecordCond cond) throws RuntimeException;
}