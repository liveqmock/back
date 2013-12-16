package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.PayBill;
import com.ihk.saleunit.data.pojo.PayBillCond;

/**
 * PayBill数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPayBillMapper {

	/**
	 * 新增PayBill
	 * @param payBill
	 */
	public void addPayBill(PayBill payBill) ;

	/**
	 * 根据条件删除PayBill
	 * @param cond 删除条件
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
	public List<PayBill> findPayBillPage(PayBillCond cond) ;

	/**
	 * 查找全部PayBill
	 * @param cond 查询条件
	 * @return PayBill列表
	 */
	public List<PayBill> findPayBill(PayBillCond cond) ;

	/**
	 * 查找符合条件的记录条数PayBill
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPayBillCount(PayBillCond cond) ;
}
