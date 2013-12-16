package com.ihk.saleunit.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ContractCustConfirm;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.ContractCustomerCond;

/**
 * ContractCustomer的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IContractCustomerServices {
	/**
	 * 新增ContractCustomer
	 * @param contractCustomer
	 */
	public void addContractCustomer(ContractCustomer contractCustomer) throws RuntimeException;
	public void addKnContractCustomer(ContractCustomer contractCustomer) throws RuntimeException;
	
	/**
	 * 删除一条ContractCustomer
	 * @param id
	 */
	public void deleteContractCustomer(int id) throws RuntimeException;

	/**
	 * 修改ContractCustomer
	 * @param contractCustomer
	 */
	public void updateContractCustomer(ContractCustomer contractCustomer) throws RuntimeException;

	/**
	 * 查找一条ContractCustomer
	 * @return ContractCustomer
	 * @param id 主键id
	 */
	public ContractCustomer findContractCustomerById(int id) throws RuntimeException;
	
	
	/**
	 * 查找多条ContractCustomer
	 * @return List<ContractCustomer>
	 * @param mainId,ConfirmType
	 */
	public List<ContractCustomer> findContractCustomerByMainIdAndConfirmType(int mainId,String confirmType) throws RuntimeException;
	
	/**
	 * 查找多条ContractCustomer，已标记为非法的
	 * @return List<ContractCustomer>
	 * @param mainId,ConfirmType
	 */
	public List<ContractCustomer> findContractCustomerByMainIdAndConfirmTypeNotValid(int mainId,String confirmType) throws RuntimeException;
	
	/**
	 * 查找符合条件的记录条数ContractCustomer
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findContractCustomerCount(ContractCustomerCond cond) ;

	/**
	 * 分页查找ContractCustomer
	 * @param cond 查询条件
	 * @return ContractCustomer列表
	 */
	public List<ContractCustomer> findContractCustomerPage(ContractCustomerCond cond) throws RuntimeException;

	/**
	 * 查找全部ContractCustomer
	 * @param cond 查询条件
	 * @return ContractCustomer列表
	 */
	public List<ContractCustomer> findContractCustomer(ContractCustomerCond cond) throws RuntimeException;
	
	 /**
	 * ajax分页查找ContractCustomer
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public List<ContractCustomer> findContractCustomerForAjax(ContractCustomerCond cond) throws RuntimeException;
    
    /**
	 * ajax分页查找ContractCustomer总数
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public int findContractCustomerCountForAjax(ContractCustomerCond cond) throws RuntimeException;
	
	/**
	 * 根据name 模糊查找
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ContractCustomer> findConfirmCustomerLikeName(ContractCustomerCond cond) throws RuntimeException;
	
	/**
	 * 查找,用于认筹
	 * @param name
	 * @return
	 * @throws RuntimeException
	 */
	public List<ContractCustomer> findCustomersForChip(String name) throws RuntimeException; //通过姓名查找认筹客户
	
	/**
	 * 根据电话查找,用于认筹
	 * @param phone
	 * @return
	 * @throws RuntimeException
	 */
	public List<ContractCustomer> findCustomersFromPhoneForChip(String phone) throws RuntimeException; //通过电话查找认筹客户
	
	/**
	 * 修改ConfirmType
	 * @param customerId
	 * @param confirmType
	 * @throws RuntimeException
	 */
	public void updateContractCustomerConfirmType(int customerId, String confirmType) throws RuntimeException; //修改用户状态
	
	/**
	 * 根据楼栋id list获取对应的ContractCustomer
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ContractCustomer> findContractCustomerByBuildIds(ContractCustomerCond cond) throws RuntimeException;
	
	/**
	 * 根据楼栋id list获取对应的ContractCustomer总条数
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public int findContractCustomerCountByBuildIds(ContractCustomerCond cond) throws RuntimeException;
	
	/**
	 * 客户成交明细
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ContractCustConfirm> findcontractCustAndConfirm(ContractCustomerCond cond) throws RuntimeException;
	
	public int findcontractCustAndConfirmCount(ContractCustomerCond cond) throws RuntimeException;
	
	/**
	 * 设置对应customer的mainId
	 * @param customerId
	 * @param mainId
	 * @throws RuntimeException
	 */
	public void updateContractCustomerMainId(int customerId, int mainId) throws RuntimeException;
	
	/**
	 * 根据项目id,电话及类型获取对应的成交客户
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ContractCustomer> findValidCustomerByProjectIdPhoneType(ContractCustomerCond cond) throws RuntimeException;
	
	/**
	 * 设置对应customer的confirmType及mainId
	 * @param cutomerId
	 * @param confirmType
	 * @param mainId
	 * @throws RuntimeException
	 */
	public void updateContractCustomerConfirmTypeAndMainId(int customerId, String confirmType, int mainId) throws RuntimeException;
	
	
	//////
	/**
	 * 获取所有的合同客户
	 */
	public List<ContractCustomer> findContractCustomer2() throws RuntimeException;
	
	public List<Map<String, Integer>> findConfirmCustomer() ;
	
	public List<Map<String, Integer>> findUnitContractCustomerConfirm() ; //insert
	
	public List<Map<String, Integer>> findUnitContractCustomerConfirmForUpdate() ;

	/**
	 * 查找全部Customer
	 * @param cond 查询条件
	 * @return Customer列表
	 */
	public List<ContractCustomer> findContractCustomerSearch(ContractCustomerCond cond) throws RuntimeException;
	
	/**
	 * 查找下载的数据
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ContractCustomer> findContractCustomerDownload(ContractCustomerCond cond) throws RuntimeException;
	/**
	 * 查找成交+合同
	 * @param contractCustomerCond
	 * @return
	 */
	public List<ContractCustConfirm> findContractConfirmCust(ContractCustomerCond contractCustomerCond);
	
	/**
	 * 查找成交+合同数量
	 * @param contractCustomerCond
	 * @return
	 */
	public int findContractConfirmCustCount(
			ContractCustomerCond contractCustomerCond);
	
	List<ContractCustomer> findContractConfirmCustomer(
			ContractCustomerCond contractCustomerCond);

    public  List<Map<String, Object>> findContractCustomerByPropertyId(int id)  throws RuntimeException;
}