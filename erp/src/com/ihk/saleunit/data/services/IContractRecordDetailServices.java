package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ContractRecordDetail;
import com.ihk.saleunit.data.pojo.ContractRecordDetailCond;

/**
 * ContractRecordDetail的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IContractRecordDetailServices {
	/**
	 * 新增ContractRecordDetail
	 * @param contractRecordDetail
	 */
	public void addContractRecordDetail(ContractRecordDetail contractRecordDetail) throws RuntimeException;

	/**
	 * 删除一条ContractRecordDetail
	 * @param id
	 */
	public void deleteContractRecordDetail(int id) throws RuntimeException;

	/**
	 * 修改ContractRecordDetail
	 * @param contractRecordDetail
	 */
	public void updateContractRecordDetail(ContractRecordDetail contractRecordDetail) throws RuntimeException;

	/**
	 * 查找一条ContractRecordDetail
	 * @return ContractRecordDetail
	 * @param id 主键id
	 */
	public ContractRecordDetail findContractRecordDetailById(int id) throws RuntimeException;

	/**
	 * 分页查找ContractRecordDetail
	 * @param cond 查询条件
	 * @return ContractRecordDetail列表
	 */
	public List<ContractRecordDetail> findContractRecordDetailPage(ContractRecordDetailCond cond) throws RuntimeException;

	/**
	 * 查找全部ContractRecordDetail
	 * @param cond 查询条件
	 * @return ContractRecordDetail列表
	 */
	public List<ContractRecordDetail> findContractRecordDetail(ContractRecordDetailCond cond) throws RuntimeException;
}