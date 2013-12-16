package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.PayDetail;
import com.ihk.saleunit.data.pojo.PayDetailCond;

/**
 * PayDetail的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IPayDetailServices {
	/**
	 * 新增PayDetail
	 * @param payDetail
	 */
	public void addPayDetail(PayDetail payDetail) throws RuntimeException;

	/**
	 * 删除一条PayDetail
	 * @param id
	 */
	public void deletePayDetail(int id) throws RuntimeException;

	/**
	 * 修改PayDetail
	 * @param payDetail
	 */
	public void updatePayDetail(PayDetail payDetail) throws RuntimeException;

	/**
	 * 查找一条PayDetail
	 * @return PayDetail
	 * @param id 主键id
	 */
	public PayDetail findPayDetailById(int id) throws RuntimeException;

	/**
	 * 分页查找PayDetail
	 * @param cond 查询条件
	 * @return PayDetail列表
	 */
	public List<PayDetail> findPayDetailPage(PayDetailCond cond) throws RuntimeException;

	/**
	 * 查找全部PayDetail
	 * @param cond 查询条件
	 * @return PayDetail列表
	 */
	public List<PayDetail> findPayDetail(PayDetailCond cond) throws RuntimeException;
	
	/**
	 * 得到最新排序
	 * @return
	 * @throws RuntimeException
	 */
	public Integer findPayDetailMaxOrderIndex() throws RuntimeException;
}