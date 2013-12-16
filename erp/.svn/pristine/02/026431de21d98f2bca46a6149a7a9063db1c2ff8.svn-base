package com.ihk.saleunit.data.services.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.saleunit.data.IConfirmMapper;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.pojo.ConfirmContractGather;
import com.ihk.saleunit.data.pojo.ConfirmContractGatherCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.utils.DescUtils;
import com.ihk.utils.base.PojoDeleteCond;
import com.ihk.utils.contract.sale.SaleUtils;
import com.ihk.utils.exception.UnitChangeException;
import com.ihk.utils.saleunitnew.UnitOperRecordUtils;

/**
 * Confirm的Services实现(业务实现)
 * @author 
 *
 */
@Service("confirmServices")
public class ConfirmServices implements IConfirmServices {
	
	private static final Logger logger = Logger.getLogger(ConfirmServices.class);
	
	/**
	 * confirm数据访问接口
	 */
	@Autowired	 IConfirmMapper confirmMapper;

	/**
	 * 删除一条Confirm
	 * @param id
	 */
	public void deleteConfirm(int id) throws RuntimeException {
		confirmMapper.deleteConfirm(new PojoDeleteCond(id));
	}

	/**
	 * 新增Confirm
	 * @param confirm
	 */
	public void addConfirm(Confirm confirm) throws RuntimeException {
		
		//判断对应的单元是否已经存在正常的成交单
		int unitId = confirm.getUnitId();
		if(unitId <= 0){
			
			logger.error("新增成交,单元id不合法");
			throw new UnitChangeException("单元id不合法");
		}
		
		Confirm oldConfirm = confirmMapper.findConfirmByUnitId(unitId);
		if(oldConfirm != null){
			
			logger.error("该单元已经存在合法成交单");
			throw new UnitChangeException("该单元已经存在合法成交单");
		}
		
		//设置公司项目
		confirm.setCompanyProjectId(DescUtils.findPropertyBuildByUnitId(confirm.getUnitId()).getCompanyProjectId());
		
		//sman,2013.3.18为salesId前后都加上,
		confirm = SaleUtils.initSalesId(confirm);
		
		confirmMapper.addConfirm(confirm);
		
		//sman,2013.7.13增加ContractSalesman,要放到新增后面,要不拿不到对应的主键id
		SaleUtils.addContractSalesman(confirm);
		
		
		//增加记录
		UnitOperRecordUtils.addOperRecord(confirm.getUnitId(), ContUnitSaleState.CONFIRM, confirm.getId());
		
	    //生成付款单
		//PayWayUtils pwu=  new PayWayUtils();
		//pwu.initUnitPayBill(confirm);
		
		//生成日志
		//SaleUnitLogUtils.addConfirmLog(null, confirm, SaleUnitLogUtils.TYPE_NEW);
	}

	/**
	 * 查找一条Confirm
	 * @return Confirm
	 * @param id 主键id
	 */
	@Override
	public Confirm findConfirmById(int id) throws RuntimeException {
		return confirmMapper.findConfirmById(id);
	}

	/**
	 * 修改Confirm
	 * @param confirm
	 */
	@Override
	public void updateConfirm(Confirm confirm) throws RuntimeException {
		//sman,2013.3.18为salesId前后都加上,
		confirm = SaleUtils.initSalesId(confirm);
		
		confirmMapper.updateConfirm(confirm);	
		
		//sman,2013.8.1增加ContractSalesman
		SaleUtils.updateContractSalesman(confirm);
		
	}
	  
	/**
	 * 分页查找Confirm
	 * @param cond 查询条件
	 * @return Confirm列表
	 */
	public List<Confirm> findConfirmPage(ConfirmCond cond) throws RuntimeException {
		int recordCount = confirmMapper.findConfirmCount(cond);
		
		cond.recordCount = recordCount;
				
		return confirmMapper.findConfirmPage(cond);
	}

	/**
	 * 查找全部Confirm
	 * @param cond 查询条件
	 * @return Confirm列表
	 */
	public List<Confirm> findConfirm(ConfirmCond cond) throws RuntimeException {
    	return confirmMapper.findConfirm(cond);
	}

	/**
	 * 更新
	 */
	@Override
	public void updateConfirmSetContractId(int confirmId, int contractId)
			throws RuntimeException {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("confirmId", confirmId);
		map.put("contractId", contractId);
		
		confirmMapper.updateConfirmSetContractId(map);
		
	}

	/**
	 * 查找公司报表
	 */
	@Override
	public List<Map<String, Object>> findCompanyReport(ConfirmCond cond)
			throws RuntimeException {
		
		return confirmMapper.findCompanyReport(cond);
	}

    /**
     * 按公司统计
     * @param cond
     * @return
     * @throws RuntimeException
     */

    @Override
    public List<Map<String, Object>> sumCompanyReport(ConfirmCond cond) throws RuntimeException {
        return confirmMapper.sumCompanyReport(cond);
    }

    /**
     * 按项目统计
     * @param cond
     * @return
     * @throws RuntimeException
     */
    @Override
    public List<Map<String, Object>> listProjectReport(ConfirmCond cond)  throws RuntimeException {
        return confirmMapper.listProjectReport(cond);
    }

	/**
	 * 查找楼盘报表
	 */
	@Override
	public List<Map<String, Object>> findPropertyReport(ConfirmCond cond)
			throws RuntimeException {
		
		return confirmMapper.findPropertyReport(cond);
	}

	/**
	 * 根据unitId查找
	 */
	@Override
	public Confirm findConfirmByUnitId(int unitId) throws RuntimeException {
		
		return confirmMapper.findConfirmByUnitId(unitId);
	}

	/**
	 * 查找合适资料的数量
	 */
	@Override
	public int findConfirmCount(ConfirmCond cond) throws RuntimeException {
		return confirmMapper.findConfirmCount(cond);
	}

	@Override
	public void updateConfirmSetCustomerIdById(Map<String, Integer> p)
			throws RuntimeException {
		confirmMapper.updateConfirmSetCustomerIdById(p);
		
	}

	@Override
	public List<ConfirmContractGather> findGatherByPropertyProjectIdAndSaleState(
			String propertyProjectId, String saleState) throws RuntimeException {
		
		ConfirmContractGatherCond cond = new ConfirmContractGatherCond(propertyProjectId, saleState); 
		
		return confirmMapper.findGatherByPropertyProjectIdAndSaleState(cond);
	}
    @Override
    public List<ConfirmContractGather> findGatherByConfirmContract(
            String propertyProjectId, String saleState) throws RuntimeException {

        ConfirmContractGatherCond cond = new ConfirmContractGatherCond(propertyProjectId, saleState);

        return confirmMapper.findGatherByConfirmContract(cond);
    }

    /**
     * 查找全部PropertyUnit
     * @param cond 查询条件
     * @return PropertyUnit列表
     */
    public List<Confirm> findConfirmUnit(ConfirmCond cond) throws RuntimeException {
        //追加当前用户能查看的权限
        //	cond.addPermissionProjectIds();
        return confirmMapper.findConfirmUnit(cond);
    }

    /**
     * 结佣明细表按单元列表
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> commissionReportByUnit(ConfirmCond cond) throws RuntimeException {
        return confirmMapper.commissionReportUnit(cond);
    }

    /**
     * 结佣明细表按项目列表
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> commissionReportByPrj(ConfirmCond cond) throws RuntimeException {
        return confirmMapper.commissionReportPrj(cond);
    }

    /**
     * 结佣明细表按公司列表
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> commissionReportByCompany(ConfirmCond cond) throws RuntimeException {
        return confirmMapper.commissionReportCompany(cond);
    }

    /**
     * 按公司列项目
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> listCompanyProject(ConfirmCond cond) throws RuntimeException {
        return confirmMapper.listCompanyProject(cond);
    }

    public BigDecimal getSumBuildArea(ConfirmCond cond) throws RuntimeException {
        confirmMapper.getSumBuildArea(cond);
        return cond.getSUM_salesBuildArea();
    }
    public BigDecimal getTotalBuildArea(ConfirmCond cond) throws RuntimeException {
        confirmMapper.getTotalBuildArea(cond);
        return cond.getSUM_totalBuildArea();
    }

    public BigDecimal getContractBuildArea(ConfirmCond cond) throws RuntimeException {
        confirmMapper.getContractBuildArea(cond);
        return cond.getSUM_contractBuildArea();
    }

    public BigDecimal getContractPrice(ConfirmCond cond) throws RuntimeException {
        confirmMapper.getContractPrice(cond);
        return cond.getSUM_contractPrice();
    }

    public int getContractSets(ConfirmCond cond) throws RuntimeException {
        confirmMapper.getContractSets(cond);
        return cond.getCount_Sets();
    }

    public int getConfirmSets(ConfirmCond cond) throws RuntimeException {
        confirmMapper.getConfirmSets(cond);
        return cond.getCount_ConfirmSets();
    }

    public int getAllUnitSets(ConfirmCond cond) throws RuntimeException {
        confirmMapper.getAllUnitSets(cond);
        return cond.getCount_AllUnit();
    }

	@Override
	public Confirm findConfirmByUnitIdIncludeIsDeleted(int unitId)
			throws RuntimeException {
		return confirmMapper.findConfirmByUnitIdIncludeIsDeleted(unitId);
	}

	@Override
	public void reloadConfirm(Confirm confirm) throws RuntimeException {
		confirmMapper.reloadConfirm(confirm);
		
	}

    /**
     * 对数筛选列表
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> checkFeeList(ConfirmCond cond) throws RuntimeException {
        return confirmMapper.checkFeeList(cond);
    }

    /**
     * 对数查询（对数中、已对数）
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> checkFeeListByType(ConfirmCond cond) throws RuntimeException {
        return confirmMapper.checkFeeListByType(cond);
    }

    /**
     * 新增对数表筛选
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> checkFeeListByAdd(ConfirmCond cond) throws RuntimeException {
        return confirmMapper.checkFeeListByAdd(cond);
    }

	@Override
	public List<Map<String, Object>> findCheckFeeDataByUnitId(int unitId)
			throws RuntimeException {
		return confirmMapper.findCheckFeeDataByUnitId(unitId);
	}

    /**
     * 对数中的对数日期列表
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> checkFeeDateList(ConfirmCond cond) throws RuntimeException {
        return confirmMapper.checkFeeDateList(cond);
    }

	@Override
	public List<Confirm> findConfirmByProjectId(int projectId)
			throws RuntimeException {
		return confirmMapper.findConfirmByProjectId(projectId);
	}

	@Override
	public void updateConfirmPayWayId(int id, int payWayId)
			throws RuntimeException {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("id", id);
		map.put("payWayId", payWayId);
		
		confirmMapper.updateConfirmPayWayId(map);
		
	}

}
