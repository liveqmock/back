package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.ContractRecordDetail;
import com.ihk.saleunit.data.pojo.ContractRecordDetailCond;

/**
 * ContractRecordDetail数据访问接口Mapper
 * @author 
 *
 */ 
public interface IContractRecordDetailMapper {

	/**
	 * 新增ContractRecordDetail
	 * @param contractRecordDetail
	 */
	public void addContractRecordDetail(ContractRecordDetail contractRecordDetail) ;

	/**
	 * 根据条件删除ContractRecordDetail
	 * @param cond 删除条件
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
	public List<ContractRecordDetail> findContractRecordDetailPage(ContractRecordDetailCond cond) ;

	/**
	 * 查找全部ContractRecordDetail
	 * @param cond 查询条件
	 * @return ContractRecordDetail列表
	 */
	public List<ContractRecordDetail> findContractRecordDetail(ContractRecordDetailCond cond) ;

	/**
	 * 查找符合条件的记录条数ContractRecordDetail
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findContractRecordDetailCount(ContractRecordDetailCond cond) ;
}
