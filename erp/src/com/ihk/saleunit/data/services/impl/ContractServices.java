package com.ihk.saleunit.data.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.saleunit.data.IContractMapper;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.utils.DescUtils;
import com.ihk.utils.base.PojoDeleteCond;
import com.ihk.utils.contract.sale.SaleUtils;
import com.ihk.utils.saleunitnew.UnitOperRecordUtils;

/**
 * Contract的Services实现(业务实现)
 * @author 
 *
 */
@Service("contractServices")
public class ContractServices implements IContractServices {
	
	private static final Logger logger = Logger.getLogger(ConfirmServices.class);
	
	/**
	 * contract数据访问接口
	 */
	@Autowired	 IContractMapper contractMapper;

	/**
	 * 删除一条Contract
	 * @param id
	 */
	public void deleteContract(int id) throws RuntimeException {
		contractMapper.deleteContract(new PojoDeleteCond(id));
	}

	/**
	 * 新增Contract
	 * @param contract
	 */
	public void addContract(Contract contract) throws RuntimeException {	
		
		//判断对应的单元是否已经存在正常的合同单
		int unitId = contract.getUnitId();
		if(unitId <= 0){
			
			logger.error("新增合同,单元id不合法");
			throw new RuntimeException("单元id不合法");
		}
		
		Contract oldContract = contractMapper.findContractByUnitId(unitId);
		if(oldContract != null){
			
			logger.error("新增合同,合法成交单");
			throw new RuntimeException("该单元已经存在合法合同单");
		}
		
		//设置公司项目
		contract.setCompanyProjectId(DescUtils.findPropertyBuildByUnitId(contract.getUnitId()).getCompanyProjectId());
		
		//sman,2013.5.23为salesId前后都加上,
		contract = SaleUtils.initSalesId(contract);
		
		contractMapper.addContract(contract);
		
		//sman,2013.7.13增加ContractSalesman,要放到新增后面,要不拿不到对应的主键id
		SaleUtils.addContractSalesman(contract);
		
		//增加记录
		UnitOperRecordUtils.addOperRecord(contract.getUnitId(), ContUnitSaleState.CONTRACT, contract.getId());
		
		//生成日志
		//SaleUnitLogUtils.addContractLog(null, contract, SaleUnitLogUtils.TYPE_NEW);
	}

	/**
	 * 查找一条Contract
	 * @return Contract
	 * @param id 主键id
	 */
	@Override
	public Contract findContractById(int id) throws RuntimeException {
		return contractMapper.findContractById(id);
	}

	/**
	 * 修改Contract
	 * @param contract
	 */
	@Override
	public void updateContract(Contract contract) throws RuntimeException {
		
		//sman,2013.3.18为salesId前后都加上,
		contract = SaleUtils.initSalesId(contract);
		
		//sman,2013.8.1增加ContractSalesman
		SaleUtils.updateContractSalesman(contract);
		
		contractMapper.updateContract(contract);		
	}

	/**
	 * 分页查找Contract
	 * @param cond 查询条件
	 * @return Contract列表
	 */
	public List<Contract> findContractPage(ContractCond cond) throws RuntimeException {
		int recordCount = contractMapper.findContractCount(cond);
		
		cond.recordCount = recordCount;
				
		return contractMapper.findContractPage(cond);
	}

	/**
	 * 查找全部Contract
	 * @param cond 查询条件
	 * @return Contract列表
	 */
	public List<Contract> findContract(ContractCond cond) throws RuntimeException {
    	return contractMapper.findContract(cond);
	}

	/**
	 * 查找公司报表
	 */
	@Override
	public List<Map<String, Object>> findCompanyReport(ContractCond cond)
			throws RuntimeException {
		
		return contractMapper.findCompanyReport(cond);
	}

	/**
	 * 查找楼盘报表
	 */
	@Override
	public List<Map<String, Object>> findPropertyReport(ContractCond cond)
			throws RuntimeException {
		
		return contractMapper.findPropertyReport(cond);
	}

	/**
	 * 根据unitId查找
	 */
	@Override
	public Contract findContractByUnitId(int unitId) throws RuntimeException {
		
		return contractMapper.findContractByUnitId(unitId);
	}

	@Override
	public int findContractCount(ContractCond cond) throws RuntimeException {
		return contractMapper.findContractCount(cond);
	}

	@Override
	public Contract findContractByUnitIdIncludeIsDelete(int unitId)
			throws RuntimeException {
		return contractMapper.findContractByUnitIdIncludeIsDelete(unitId);
	}

	@Override
	public void reloadContract(Contract contract) throws RuntimeException {
		contractMapper.reloadContract(contract);
		
	}

	@Override
	public Contract findContractByCustomerId(int customerId) {
		return contractMapper.findContractByCustomerId(customerId);
	}

	@Override
	public void updateContractPayWayId(int id, int payWayId)
			throws RuntimeException {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("id", id);
		map.put("payWayId", payWayId);
		
		contractMapper.updateContractPayWayId(map);
		
	}
	
}
