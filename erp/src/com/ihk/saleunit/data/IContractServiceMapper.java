package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.ContractService;
import com.ihk.saleunit.data.pojo.ContractServiceCond;

/**
 * ContractService数据访问接口Mapper
 * @author 
 *
 */ 
public interface IContractServiceMapper {

	/**
	 * 新增ContractService
	 * @param contractService
	 */
	public void addContractService(ContractService contractService) ;

	/**
	 * 根据条件删除ContractService
	 * @param cond 删除条件
	 */
	public void deleteContractService(int id) throws RuntimeException;

	/**
	 * 修改ContractService
	 * @param contractService
	 */
	public void updateContractService(ContractService contractService) throws RuntimeException;

	/**
	 * 查找一条ContractService
	 * @return ContractService
	 * @param id 主键id
	 */
	public ContractService findContractServiceById(int id) throws RuntimeException;

	/**
	 * 分页查找ContractService
	 * @param cond 查询条件
	 * @return ContractService列表
	 */
	public List<ContractService> findContractServicePage(ContractServiceCond cond) ;

	/**
	 * 查找全部ContractService
	 * @param cond 查询条件
	 * @return ContractService列表
	 */
	public List<ContractService> findContractService(ContractServiceCond cond) ;

	/**
	 * 查找符合条件的记录条数ContractService
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findContractServiceCount(ContractServiceCond cond) ;
}
