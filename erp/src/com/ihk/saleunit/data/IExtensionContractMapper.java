package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.ExtensionContract;
import com.ihk.saleunit.data.pojo.ExtensionContractCond;

/**
 * ExtensionContract数据访问接口Mapper
 * @author 
 *
 */ 
public interface IExtensionContractMapper {

	/**
	 * 新增ExtensionContract
	 * @param extensionContract
	 */
	public void addExtensionContract(ExtensionContract extensionContract) ;

	/**
	 * 根据条件删除ExtensionContract
	 * @param cond 删除条件
	 */
	public void deleteExtensionContract(int id) throws RuntimeException;

	/**
	 * 修改ExtensionContract
	 * @param extensionContract
	 */
	public void updateExtensionContract(ExtensionContract extensionContract) throws RuntimeException;

    
	/**
	 * 查找一条ExtensionContract
	 * @return ExtensionContract
	 * @param id 主键id
	 */
	public ExtensionContract findExtensionContractById(int id) throws RuntimeException;

	/**
	 * 分页查找ExtensionContract
	 * @param cond 查询条件
	 * @return ExtensionContract列表
	 */
	public List<ExtensionContract> findExtensionContractPage(ExtensionContractCond cond) ;

	/**
	 * 查找全部ExtensionContract
	 * @param cond 查询条件
	 * @return ExtensionContract列表
	 */
	public List<ExtensionContract> findExtensionContract(ExtensionContractCond cond) ;

	/**
	 * 查找符合条件的记录条数ExtensionContract
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findExtensionContractCount(ExtensionContractCond cond) ;
	
	/**
	 * 根据unitId查找
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public List<ExtensionContract> findExtensionContractByUnitId(int unitId) throws RuntimeException;

	/**
	 * 根据单元id删除对应的延期签约	
	 * @param unitId
	 * @throws RuntimeException
	 */
	public void deleteExtensionContractByUnitId(int unitId) throws RuntimeException;
}
