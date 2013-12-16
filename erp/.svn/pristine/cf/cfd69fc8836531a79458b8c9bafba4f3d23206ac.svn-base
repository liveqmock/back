package com.ihk.property.data.services;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.PayWayDetail;
import com.ihk.property.data.pojo.PayWayDetailCond;

/**
 * PayWayDetail的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IPayWayDetailServices {

	/**
	 * 新增PayWayDetail
	 * @param payWayDetail
	 */
	public void addPayWayDetail(PayWayDetail payWayDetail) throws RuntimeException;

	/**
	 * 删除一条PayWayDetail
	 * @param id
	 */
	public void deletePayWayDetail(int id) throws RuntimeException;

	/**
	 * 修改PayWayDetail
	 * @param payWayDetail
	 */
	public void updatePayWayDetail(PayWayDetail payWayDetail) throws RuntimeException;

	/**
	 * 查找一条PayWayDetail
	 * @return PayWayDetail
	 * @param id 主键id
	 */
	public PayWayDetail findPayWayDetailById(int id) throws RuntimeException;

	/**
	 * 分页查找PayWayDetail
	 * @param cond 查询条件
	 * @return PayWayDetail列表
	 */
	public List<PayWayDetail> findPayWayDetailPage(PayWayDetailCond cond) throws RuntimeException;

	/**
	 * 查找全部PayWayDetail
	 * @param cond 查询条件
	 * @return PayWayDetail列表
	 */
	public List<PayWayDetail> findPayWayDetail(PayWayDetailCond cond) throws RuntimeException;
	
	/**
	 * 根据wayId查找
	 * @param wayId
	 * @return
	 * @throws RuntimeException
	 */
	public List<PayWayDetail> findPayWayDetailByWayId(int wayId) throws RuntimeException;
	
	/**
	 * 根据payType,wayId查找
	 * @param wayId
	 * @param payType
	 * @return
	 * @throws RuntimeException
	 */
	public List<PayWayDetail> findPayWayDetailByWayIdAndPayType(int wayId, String payType) throws RuntimeException;
	
}