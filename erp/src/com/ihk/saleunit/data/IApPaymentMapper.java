package com.ihk.saleunit.data;

import java.util.List;
import java.util.Map;

import com.ihk.saleunit.data.pojo.ApPayment;
import com.ihk.saleunit.data.pojo.ApPaymentCond;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * ApPayment数据访问接口Mapper
 * @author 
 *
 */ 
public interface IApPaymentMapper {

	/**
	 * 新增ApPayment
	 * @param apPayment
	 */
	public void addApPayment(ApPayment apPayment) ;

	/**
	 * 根据条件删除ApPayment
	 * @param cond 删除条件
	 */
	public void deleteApPayment(PojoDeleteCond cond) throws RuntimeException;


	/**
	 * 修改ApPayment
	 * @param apPayment
	 */
	public void updateApPayment(ApPayment apPayment) throws RuntimeException;
	
    
	/**
	 * 查找一条ApPayment
	 * @return ApPayment
	 * @param id 主键id
	 */
	public ApPayment findApPaymentById(int id) throws RuntimeException;
	    
	/**
	 * 分页查找ApPayment
	 * @param cond 查询条件
	 * @return ApPayment列表
	 */
	public List<ApPayment> findApPaymentPage(ApPaymentCond cond) ;
        
	/**
	 * 查找全部ApPayment
	 * @param cond 查询条件
	 * @return ApPayment列表
	 */
	public List<ApPayment> findApPayment(ApPaymentCond cond) ;
    
	/**
	 * 查找符合条件的记录条数ApPayment
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findApPaymentCount(ApPaymentCond cond) ;
}
