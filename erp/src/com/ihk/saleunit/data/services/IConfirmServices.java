package com.ihk.saleunit.data.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.pojo.ConfirmContractGather;

/**
 * Confirm的Services接口(业务接口)
 * @author
 *
 */
@Transactional
public interface IConfirmServices {

    public int findConfirmCount(ConfirmCond cond) throws RuntimeException;;

    /**
     * 新增Confirm
     * @param confirm
     */
    public void addConfirm(Confirm confirm) throws RuntimeException;

    /**
     * 删除一条Confirm
     * @param id
     */
    public void deleteConfirm(int id) throws RuntimeException;

    /**
     * 重置一条Confirm
     * @param id
     */
    public void reloadConfirm(Confirm confirm) throws RuntimeException;

    /**
     * 修改Confirm
     * @param confirm
     */
    public void updateConfirm(Confirm confirm) throws RuntimeException;

    /**
     * 查找一条Confirm
     * @return Confirm
     * @param id 主键id
     */
    public Confirm findConfirmById(int id) throws RuntimeException;

    /**
     * 分页查找Confirm
     * @param cond 查询条件
     * @return Confirm列表
     */
    public List<Confirm> findConfirmPage(ConfirmCond cond) throws RuntimeException;

    /**
     * 查找全部Confirm
     * @param cond 查询条件
     * @return Confirm列表
     */
    public List<Confirm> findConfirm(ConfirmCond cond) throws RuntimeException;

    /**
     * 修改,设置contractId
     * @param confirmId
     * @param contractId
     * @throws RuntimeException
     */
    public void updateConfirmSetContractId(int confirmId, int contractId) throws RuntimeException;

    /**
     * 查找公司报表
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> findCompanyReport(ConfirmCond cond) throws RuntimeException;

    /**
     * 业绩报表 - 公司统计报表
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> sumCompanyReport(ConfirmCond cond)throws RuntimeException;

    /**
     * 业绩报表 - 按项目统计
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> listProjectReport(ConfirmCond cond)throws RuntimeException;

    /**
     * 查找报表
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> findPropertyReport(ConfirmCond cond) throws RuntimeException;

    /**
     * 根据单元id获取对应的认购,正确只有一条
     * @param unitId
     * @return
     * @throws RuntimeException
     */
    public Confirm findConfirmByUnitId(int unitId) throws RuntimeException; //根据单元id获取对应的认购,正确只有一条
    
    /**
     * 根据项目id获取对应的认购,正确只有一条
     * @param unitId
     * @return
     * @throws RuntimeException
     */
    public List<Confirm> findConfirmByProjectId(int projectId) throws RuntimeException; //根据单元id获取对应的认购,正确只有一条

    /**
     * 根据单元id获取对应的认购,正确只有一条,包括删除的
     * @param unitId
     * @return
     * @throws RuntimeException
     */
    public Confirm findConfirmByUnitIdIncludeIsDeleted(int unitId) throws RuntimeException; //根据单元id获取对应的认购,正确只有一条,包括删除的


    /**
     * 导数需求 根据ID 更新customer_id
     * */
    public void updateConfirmSetCustomerIdById(Map<String,Integer> p ) throws RuntimeException;

    /**
     * 成交单元管理的汇总,根据楼盘项目id,saleState
     * @param propertyProjectId
     * @param saleState
     * @return
     * @throws RuntimeException
     */
    public List<ConfirmContractGather> findGatherByPropertyProjectIdAndSaleState(String propertyProjectId, String saleState) throws RuntimeException;
    public List<ConfirmContractGather> findGatherByConfirmContract(String propertyProjectId, String saleState) throws RuntimeException;

    public List<Confirm> findConfirmUnit(ConfirmCond cond) throws RuntimeException ;

    /**
     * 结佣明细表按单元列表
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> commissionReportByUnit(ConfirmCond cond) throws RuntimeException;

    /**
     * 结佣明细表按项目列表
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> commissionReportByPrj(ConfirmCond cond) throws RuntimeException;

    /**
     * 结佣明细表按公司列表
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> commissionReportByCompany(ConfirmCond cond) throws RuntimeException;

    /**
     * 按公司列项目
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> listCompanyProject(ConfirmCond cond) throws RuntimeException;

    /**
     * 销售住宅建筑面积总和
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public BigDecimal getSumBuildArea(ConfirmCond cond) throws RuntimeException;

    /**
     * 推货面积
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public BigDecimal getTotalBuildArea(ConfirmCond cond) throws RuntimeException;

    /**
     * 销售面积
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public BigDecimal getContractBuildArea(ConfirmCond cond) throws RuntimeException;

    /**
     * 销售金额
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public BigDecimal getContractPrice(ConfirmCond cond) throws RuntimeException;

    /**
     * 签约销售套数
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public int getContractSets(ConfirmCond cond) throws RuntimeException;

    /**
     * 成交销售套数
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public int getConfirmSets(ConfirmCond cond) throws RuntimeException;

    /**
     * 可售货量总套数
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public int getAllUnitSets(ConfirmCond cond) throws RuntimeException;

    /**
     * 对数筛选列表
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> checkFeeList(ConfirmCond cond) throws RuntimeException;

    /**
     * 对数查询（对数中、已对数）
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> checkFeeListByType(ConfirmCond cond) throws RuntimeException;

    /**
     * 新增对数表筛选
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> checkFeeListByAdd(ConfirmCond cond) throws RuntimeException;

    /**
     * 对数中的对数日期列表
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> checkFeeDateList(ConfirmCond cond) throws RuntimeException;

    /**
     * 根据单元id获取视图v_confirm_contract
     * @param unitId
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> findCheckFeeDataByUnitId(int unitId) throws RuntimeException;
    
    /**
     * 修改对应成交单的payWayId
     * @param id
     * @param payWayId
     * @throws RuntimeException
     */
    public void updateConfirmPayWayId(int id, int payWayId) throws RuntimeException;

}