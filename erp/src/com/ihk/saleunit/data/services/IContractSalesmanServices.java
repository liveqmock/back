package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ContractSalesman;
import com.ihk.saleunit.data.pojo.ContractSalesmanCond;

/**
 * ContractSalesman的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IContractSalesmanServices {

	/**
	 * 新增ContractSalesman
	 * @param contractSalesman
	 */
	public void addContractSalesman(ContractSalesman contractSalesman) throws RuntimeException;

	/**
	 * 删除一条ContractSalesman
	 * @param id
	 */
	public void deleteContractSalesman(int id) throws RuntimeException;

	/**
	 * 修改ContractSalesman
	 * @param contractSalesman
	 */
	public void updateContractSalesman(ContractSalesman contractSalesman) throws RuntimeException;

	/**
	 * 查找一条ContractSalesman
	 * @return ContractSalesman
	 * @param id 主键id
	 */
	public ContractSalesman findContractSalesmanById(int id) throws RuntimeException;
    
	/**
	 * 分页查找ContractSalesman
	 * @param cond 查询条件
	 * @return ContractSalesman列表
	 */
	public List<ContractSalesman> findContractSalesmanPage(ContractSalesmanCond cond) throws RuntimeException;
    
	/**
	 * 查找全部ContractSalesman
	 * @param cond 查询条件
	 * @return ContractSalesman列表
	 */
	public List<ContractSalesman> findContractSalesman(ContractSalesmanCond cond) throws RuntimeException;
    
     /**
	 * ajax分页查找ContractSalesman
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public List<ContractSalesman> findContractSalesmanForAjax(ContractSalesmanCond cond) throws RuntimeException;
    
    /**
	 * ajax分页查找ContractSalesman总数
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public int findContractSalesmanCountForAjax(ContractSalesmanCond cond) throws RuntimeException;
}