package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.ContractSalesman;
import com.ihk.saleunit.data.pojo.ContractSalesmanCond;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * ContractSalesman数据访问接口Mapper
 * @author 
 *
 */ 
public interface IContractSalesmanMapper {

	/**
	 * 新增ContractSalesman
	 * @param contractSalesman
	 */
	public void addContractSalesman(ContractSalesman contractSalesman) ;

	/**
	 * 根据条件删除ContractSalesman
	 * @param cond 删除条件
	 */
	public void deleteContractSalesman(PojoDeleteCond cond) throws RuntimeException;


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
	 * 查找符合条件的记录条数ContractSalesman
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findContractSalesmanCount(ContractSalesmanCond cond) throws RuntimeException;
    
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
