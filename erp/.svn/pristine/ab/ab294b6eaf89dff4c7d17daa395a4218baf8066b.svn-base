package com.ihk.saleunit.data;

import java.util.List;
import java.util.Map;

import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * Contract数据访问接口Mapper
 * @author 
 *
 */ 
public interface IContractMapper {

	/**
	 * 新增Contract
	 * @param contract
	 */
	public void addContract(Contract contract) ;

	/**
	 * 根据条件删除Contract
	 * @param cond 删除条件
	 */
	public void deleteContract(PojoDeleteCond cond) throws RuntimeException;

	/**
	 * 修改Contract
	 * @param contract
	 */
	public void updateContract(Contract contract) throws RuntimeException;

	/**
	 * 查找一条Contract
	 * @return Contract
	 * @param id 主键id
	 */
	public Contract findContractById(int id) throws RuntimeException;

	/**
	 * 分页查找Contract
	 * @param cond 查询条件
	 * @return Contract列表
	 */
	public List<Contract> findContractPage(ContractCond cond) ;

	/**
	 * 查找全部Contract
	 * @param cond 查询条件
	 * @return Contract列表
	 */
	public List<Contract> findContract(ContractCond cond) ;

	/**
	 * 查找符合条件的记录条数Contract
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findContractCount(ContractCond cond) ;
	
	/**
	 * 查找公司报表
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map<String, Object>> findCompanyReport(ContractCond cond) throws RuntimeException;
	
	/**
	 * 查找项目报表
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map<String, Object>> findPropertyReport(ContractCond cond) throws RuntimeException;
	
	/**
	 * 根据unitId 查找
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public Contract findContractByUnitId(int unitId) throws RuntimeException;
	
	/**
	 * 根据unitId 查找,包括已删除
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public Contract findContractByUnitIdIncludeIsDelete(int unitId) throws RuntimeException;
	
	/**
	 * 重置Contract
	 * @param contract
	 */
	public void reloadContract(Contract contract) throws RuntimeException;
	
	/**
	 * 根据客户id获取对应的合同
	 * @param customerId
	 * @return
	 */
	public Contract findContractByCustomerId(int customerId);
	
	/**
	 * 修改对应合同单的payWayId
	 * @param map
	 * @throws RuntimeException
	 */
    public void updateContractPayWayId(Map<String, Integer> map) throws RuntimeException;
	
}
