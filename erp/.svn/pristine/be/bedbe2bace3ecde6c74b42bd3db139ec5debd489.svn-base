package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ApPayment;
import com.ihk.saleunit.data.pojo.ApPaymentCond;

/**
 * ApPayment的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IApPaymentServices {

	/**
	 * 新增ApPayment
	 * @param apPayment
	 */
	public void addApPayment(ApPayment apPayment) throws RuntimeException;

	/**
	 * 删除一条ApPayment
	 * @param id
	 */
	public void deleteApPayment(int id) throws RuntimeException;

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
	 * 查找总数
	 * @param cond
	 * @return
	 */
	public int findApPaymentCount(ApPaymentCond cond) throws RuntimeException;
    
	/**
	 * 分页查找ApPayment
	 * @param cond 查询条件
	 * @return ApPayment列表
	 */
	public List<ApPayment> findApPaymentPage(ApPaymentCond cond) throws RuntimeException;
    
	/**
	 * 查找全部ApPayment
	 * @param cond 查询条件
	 * @return ApPayment列表
	 */
	public List<ApPayment> findApPayment(ApPaymentCond cond) throws RuntimeException;
}