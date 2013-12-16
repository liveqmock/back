package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ExtensionContract;
import com.ihk.saleunit.data.pojo.ExtensionContractCond;

/**
 * ExtensionContract的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IExtensionContractServices {
	/**
	 * 新增ExtensionContract
	 * @param extensionContract
	 */
	public void addExtensionContract(ExtensionContract extensionContract) throws RuntimeException;

	/**
	 * 删除一条ExtensionContract
	 * @param id
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
	public List<ExtensionContract> findExtensionContractPage(ExtensionContractCond cond) throws RuntimeException;

	/**
	 * 查找全部ExtensionContract
	 * @param cond 查询条件
	 * @return ExtensionContract列表
	 */
	public List<ExtensionContract> findExtensionContract(ExtensionContractCond cond) throws RuntimeException;
	
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