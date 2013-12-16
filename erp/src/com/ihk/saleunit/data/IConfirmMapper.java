package com.ihk.saleunit.data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.pojo.ConfirmContractGather;
import com.ihk.saleunit.data.pojo.ConfirmContractGatherCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * Confirm数据访问接口Mapper
 * @author 
 *
 */ 
public interface IConfirmMapper {

	/**
	 * 新增Confirm
	 * @param confirm
	 */
	public void addConfirm(Confirm confirm) ;

	/**
	 * 根据条件删除Confirm
	 * @param cond 删除条件
	 */
	public void deleteConfirm(PojoDeleteCond cond) throws RuntimeException;

	/**
	 * 修改Confirm
	 * @param confirm
	 */
	public void updateConfirm(Confirm confirm) throws RuntimeException;
	
	/**
	 * 重置Confirm
	 * @param confirm
	 */
	public void reloadConfirm(Confirm confirm) throws RuntimeException;

	/**
	 * 查找一条Confirm
	 * @return Confirm
	 * @param id 主键id
	 */
	public Confirm findConfirmById(int id) throws RuntimeException;
	
	public List<Confirm> findConfirmByProjectId(int id) throws RuntimeException;

	/**
	 * 分页查找Confirm
	 * @param cond 查询条件
	 * @return Confirm列表
	 */
	public List<Confirm> findConfirmPage(ConfirmCond cond) ;

	/**
	 * 查找全部Confirm
	 * @param cond 查询条件
	 * @return Confirm列表
	 */
	public List<Confirm> findConfirm(ConfirmCond cond) ;

	/**
	 * 查找符合条件的记录条数Confirm
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findConfirmCount(ConfirmCond cond) ;
	
	/**
	 * 更新confirm设置ContractId
	 * @param map
	 * @throws RuntimeException
	 */
	public void updateConfirmSetContractId(Map<String, Integer> map) throws RuntimeException;
	
	/**
	 * 查找公司报表
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map<String, Object>> findCompanyReport(ConfirmCond cond) throws RuntimeException;

    /**
     * 首页-统计公司业绩
     * @param cond
     * @return
     * @throws RuntimeException
     */
	public List<Map<String, Object>> sumCompanyReport(ConfirmCond cond) throws RuntimeException;

    /**
     * 首页-统计公司项目业绩
     * @param cond
     * @return
     * @throws RuntimeException
     */
	public List<Map<String, Object>> listProjectReport(ConfirmCond cond) throws RuntimeException;

	/**
	 * 查找项目报表
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map<String, Object>> findPropertyReport(ConfirmCond cond) throws RuntimeException;
	
	/**
	 * 查找认购,根据unitId
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public Confirm findConfirmByUnitId(int unitId) throws RuntimeException;
	
	/**
	 * 查找认购,根据unitId,包括已删除的
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public Confirm findConfirmByUnitIdIncludeIsDeleted(int unitId) throws RuntimeException;
	
	
	/**
	 * 导数需求 根据ID 更新customer_id
	 * */
	public void updateConfirmSetCustomerIdById(Map<String,Integer> p );
	
	/**
	 * 成交单元管理的汇总,根据楼盘项目id,saleState
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ConfirmContractGather> findGatherByPropertyProjectIdAndSaleState(ConfirmContractGatherCond cond) throws RuntimeException;
	public List<ConfirmContractGather> findGatherByConfirmContract(ConfirmContractGatherCond cond) throws RuntimeException;

    /**
     * 查找全部PropertyUnit
     * @param cond 查询条件
     * @return PropertyUnit列表
     */
    public List<Confirm> findConfirmUnit(ConfirmCond cond) ;

    /**
     * 结佣明细表按单元列表
     * @param cond
     * @return
     */
    public List<Map<String, Object>> commissionReportUnit(ConfirmCond cond) ;

    /**
     * 结佣明细表按项目列表
     * @param cond
     * @return
     */
    public List<Map<String, Object>> commissionReportPrj(ConfirmCond cond) ;

    /**
     * 结佣明细表按公司列表
     * @param cond
     * @return
     */
    public List<Map<String, Object>> commissionReportCompany(ConfirmCond cond) ;

    /**
     * 按公司列项目
     * @param cond
     * @return
     */
    public List<Map<String, Object>> listCompanyProject(ConfirmCond cond) ;

    /**
     * 销售住宅建筑面积总和
     * @param cond
     * @return
     */
    public BigDecimal getSumBuildArea(ConfirmCond cond) ;

    /**
     * 推货面积
     * @param cond
     * @return
     */
    public BigDecimal getTotalBuildArea(ConfirmCond cond) ;

    /**
     * 销售面积
     * @param cond
     * @return
     */
    public BigDecimal getContractBuildArea(ConfirmCond cond) ;

    /**
     * 销售金额
     * @param cond
     * @return
     */
    public BigDecimal getContractPrice(ConfirmCond cond) ;

    /**
     * 签约销售套数
     * @param cond
     * @return
     */
    public Integer getContractSets(ConfirmCond cond) ;

    /**
     * 成交销售套数
     * @param cond
     * @return
     */
    public Integer getConfirmSets(ConfirmCond cond) ;

    /**
     * 可售货量套数
     * @param cond
     * @return
     */
    public Integer getAllUnitSets(ConfirmCond cond) ;

    /**
     * 对数筛选列表
     * @param cond
     * @return
     */
    public List<Map<String, Object>> checkFeeList(ConfirmCond cond) ;

    /**
     * 对数查询（对数中、已对数）
     * @param cond
     * @return
     */
    public List<Map<String, Object>> checkFeeListByType(ConfirmCond cond) ;

    /**
     * 新增对数表筛选
     * @param cond
     * @return
     */
    public List<Map<String, Object>> checkFeeListByAdd(ConfirmCond cond) ;

    /**
     * 根据单元id获取视图v_confirm_contract
     * @param unitId
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> findCheckFeeDataByUnitId(int unitId) throws RuntimeException;

    /**
     * 对数中的对数日期列表
     * @param cond
     * @return
     */
    public List<Map<String, Object>> checkFeeDateList(ConfirmCond cond) ;
    
    /**
     * 修改对应成交单的payWayId
     * @param map
     * @throws RuntimeException
     */
    public void updateConfirmPayWayId(Map<String, Integer> map) throws RuntimeException;
}
