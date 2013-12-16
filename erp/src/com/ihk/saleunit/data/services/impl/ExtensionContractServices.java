package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IExtensionContractMapper;
import com.ihk.saleunit.data.pojo.ExtensionContract;
import com.ihk.saleunit.data.pojo.ExtensionContractCond;
import com.ihk.saleunit.data.services.IExtensionContractServices;

/**
 * ExtensionContract的Services实现(业务实现)
 * @author 
 *
 */
@Service("extensionContractServices")
public class ExtensionContractServices implements IExtensionContractServices {
	/**
	 * extensionContract数据访问接口
	 */
	@Autowired	 IExtensionContractMapper extensionContractMapper;

	/**
	 * 删除一条ExtensionContract
	 * @param id
	 */
	public void deleteExtensionContract(int id) throws RuntimeException {
		extensionContractMapper.deleteExtensionContract(id);
	}

	/**
	 * 新增ExtensionContract
	 * @param extensionContract
	 */
	public void addExtensionContract(ExtensionContract extensionContract) throws RuntimeException {		
		extensionContractMapper.addExtensionContract(extensionContract);
	}

	/**
	 * 查找一条ExtensionContract
	 * @return ExtensionContract
	 * @param id 主键id
	 */
	@Override
	public ExtensionContract findExtensionContractById(int id) throws RuntimeException {
		return extensionContractMapper.findExtensionContractById(id);
	}


	/**
	 * 修改ExtensionContract
	 * @param extensionContract
	 */
	@Override
	public void updateExtensionContract(ExtensionContract extensionContract) throws RuntimeException {
		extensionContractMapper.updateExtensionContract(extensionContract);		
	}

	/**
	 * 分页查找ExtensionContract
	 * @param cond 查询条件
	 * @return ExtensionContract列表
	 */
	public List<ExtensionContract> findExtensionContractPage(ExtensionContractCond cond) throws RuntimeException {
		int recordCount = extensionContractMapper.findExtensionContractCount(cond);
		
		cond.recordCount = recordCount;
				
		return extensionContractMapper.findExtensionContractPage(cond);
	}

	/**
	 * 查找全部ExtensionContract
	 * @param cond 查询条件
	 * @return ExtensionContract列表
	 */
	public List<ExtensionContract> findExtensionContract(ExtensionContractCond cond) throws RuntimeException {
    	return extensionContractMapper.findExtensionContract(cond);
	}

	/**
	 * 根据unitId查找
	 */
	@Override
	public List<ExtensionContract> findExtensionContractByUnitId(int unitId)
			throws RuntimeException {
		
		return extensionContractMapper.findExtensionContractByUnitId(unitId);
	}

	@Override
	public void deleteExtensionContractByUnitId(int unitId)
			throws RuntimeException {
		extensionContractMapper.deleteExtensionContractByUnitId(unitId);
	}
}
