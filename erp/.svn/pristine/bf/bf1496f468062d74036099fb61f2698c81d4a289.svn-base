package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.PayBill;
import com.ihk.saleunit.data.pojo.PayBillCond;

/**
 * PayBill的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IPayBillServices {
	/**
	 * 新增PayBill
	 * @param payBill
	 */
	public void addPayBill(PayBill payBill) throws RuntimeException;

	/**
	 * 删除一条PayBill
	 * @param id
	 */
	public void deletePayBill(int id) throws RuntimeException;

	/**
	 * 修改PayBill
	 * @param payBill
	 */
	public void updatePayBill(PayBill payBill) throws RuntimeException;

	/**
	 * 查找一条PayBill
	 * @return PayBill
	 * @param id 主键id
	 */
	public PayBill findPayBillById(int id) throws RuntimeException;

	/**
	 * 分页查找PayBill
	 * @param cond 查询条件
	 * @return PayBill列表
	 */
	public List<PayBill> findPayBillPage(PayBillCond cond) throws RuntimeException;

	/**
	 * 查找全部PayBill
	 * @param cond 查询条件
	 * @return PayBill列表
	 */
	public List<PayBill> findPayBill(PayBillCond cond) throws RuntimeException;
}