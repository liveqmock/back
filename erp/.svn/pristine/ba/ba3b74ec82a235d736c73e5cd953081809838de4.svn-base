package com.ihk.saleunit.data;

import java.util.List;
import java.util.Map;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.saleunit.data.pojo.ContractCustConfirm;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.ContractCustomerCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * ContractCustomer数据访问接口Mapper
 * @author 
 *
 */ 
public interface IContractCustomerMapper {

	/**
	 * 新增ContractCustomer
	 * @param contractCustomer
	 */
	public void addContractCustomer(ContractCustomer contractCustomer) ;

	/**
	 * 根据条件删除ContractCustomer
	 * @param cond 删除条件
	 */
	public void deleteContractCustomer(PojoDeleteCond cond) throws RuntimeException;

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
	 * 根据mainId及confirmType获取对应的成交客户
	 * @return
	 */
	public List<ContractCustomer> findContractCustomerByMainIdAndConfirmType(Map<String, String> map) throws RuntimeException;

	/**
	 * 分页查找ContractCustomer
	 * @param cond 查询条件
	 * @return ContractCustomer列表
	 */
	public List<ContractCustomer> findContractCustomerPage(ContractCustomerCond cond) ;

	/**
	 * 查找全部ContractCustomer
	 * @param cond 查询条件
	 * @return ContractCustomer列表
	 */
	public List<ContractCustomer> findContractCustomer(ContractCustomerCond cond) ;

	/**
	 * 查找符合条件的记录条数ContractCustomer
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findContractCustomerCount(ContractCustomerCond cond) ;
	
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
	 * 查找客户，用于认筹
	 * @param map
	 * @return
	 * @throws RuntimeException
	 */
	public List<ContractCustomer> findCustomersForChip(Map<String, String> map) throws RuntimeException; //通过姓名查找认筹客户
	
	/**
	 * 查找客户，根据电话，用于认筹
	 * @param map
	 * @return
	 * @throws RuntimeException
	 */
	public List<ContractCustomer> findCustomersFromPhoneForChip(Map<String, String> map) throws RuntimeException; //通过电话查找认筹客户
	
	/**
	 * 修改客户认购类型
	 * @param map
	 * @throws RuntimeException
	 */
	public void updateContractCustomerConfirmType(Map<String, String> map) throws RuntimeException; //修改用户状态
	
	
	
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
	 * 客户成交明细报表
	 */
	public List<ContractCustConfirm> findcontractCustAndConfirm(ContractCustomerCond cond) throws RuntimeException;
	
	public int findcontractCustAndConfirmCount(ContractCustomerCond cond) throws RuntimeException;
	
	/**
	 * 设置对应customer的mainId
	 * @param map
	 * @throws RuntimeException
	 */
	public void updateContractCustomerMainId(Map<String, Integer> map) throws RuntimeException;
	
	public List<ContractCustomer> findContractCustomerByMainIdAndConfirmTypeNotValid(Map<String,String> map) throws RuntimeException;
	
	/**
	 * 根据项目id,电话及类型获取对应的成交客户
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ContractCustomer> findValidCustomerByProjectIdPhoneType(ContractCustomerCond cond) throws RuntimeException;
	
	/**
	 * 设置对应customer的confirmType及mainId
	 * @param map
	 * @throws RuntimeException
	 */
	public void updateContractCustomerConfirmTypeAndMainId(Map<String, String> map) throws RuntimeException;
	
	//////
	
	
	public List<ContractCustomer> findContractCustomer2() throws RuntimeException;
	
	public List<Map<String, Integer>> findConfirmCustomer() ;
	
	public List<Map<String, Integer>> findUnitContractCustomerConfirm() ;
	
	public List<Map<String, Integer>> findUnitContractCustomerConfirmForUpdate() ;
	
	/**
	 * 查找售后客户
	 * @param cond
	 * @return
	 */
	public List<ContractCustomer> findContractCustomerSearch(ContractCustomerCond cond);
	
	/**
	 * 查找客户数量
	 * @param cond
	 * @return
	 */
	public int findContractCustomerCountSearch(ContractCustomerCond cond);
	
	public List<ContractCustomer> findContractCustomerDownload(ContractCustomerCond cond);

	public List<ContractCustConfirm> findContractConfirmCust(
			ContractCustomerCond contractCustomerCond);

	public int findContractConfirmCustCount(
			ContractCustomerCond contractCustomerCond);

	public List<ContractCustomer> findContractConfirmCustomer(
			ContractCustomerCond contractCustomerCond);

	public int findContractConfirmCustomerCount(
			ContractCustomerCond contractCustomerCond);


    public List<Map<String, Object>> findContractCustomerByPropertyId(int id) throws RuntimeException;
}
