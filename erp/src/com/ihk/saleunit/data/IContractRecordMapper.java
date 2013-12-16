package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.ContractRecord;
import com.ihk.saleunit.data.pojo.ContractRecordCond;

/**
 * ContractRecord数据访问接口Mapper
 * @author 
 *
 */ 
public interface IContractRecordMapper {

	/**
	 * 新增ContractRecord
	 * @param contractRecord
	 */
	public void addContractRecord(ContractRecord contractRecord) ;

	/**
	 * 根据条件删除ContractRecord
	 * @param cond 删除条件
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
	public List<ContractRecord> findContractRecordPage(ContractRecordCond cond) ;

	/**
	 * 查找全部ContractRecord
	 * @param cond 查询条件
	 * @return ContractRecord列表
	 */
	public List<ContractRecord> findContractRecord(ContractRecordCond cond) ;

	/**
	 * 查找符合条件的记录条数ContractRecord
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findContractRecordCount(ContractRecordCond cond) ;
}
