package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ApprovalChange;
import com.ihk.saleunit.data.pojo.ApprovalChangeCond;

/**
 * ApprovalChange的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IApprovalChangeServices {
	/**
	 * 新增ApprovalChange
	 * @param approvalChange
	 */
	public void addApprovalChange(ApprovalChange approvalChange) throws RuntimeException;

	/**
	 * 删除一条ApprovalChange
	 * @param id
	 */
	public void deleteApprovalChange(int id) throws RuntimeException;

	/**
	 * 修改ApprovalChange
	 * @param approvalChange
	 */
	public void updateApprovalChange(ApprovalChange approvalChange) throws RuntimeException;

	/**
	 * 查找一条ApprovalChange
	 * @return ApprovalChange
	 * @param id 主键id
	 */
	public ApprovalChange findApprovalChangeById(int id) throws RuntimeException;

	/**
	 * 分页查找ApprovalChange
	 * @param cond 查询条件
	 * @return ApprovalChange列表
	 */
	public List<ApprovalChange> findApprovalChangePage(ApprovalChangeCond cond) throws RuntimeException;

	/**
	 * 查找全部ApprovalChange
	 * @param cond 查询条件
	 * @return ApprovalChange列表
	 */
	public List<ApprovalChange> findApprovalChange(ApprovalChangeCond cond) throws RuntimeException;
	
	/**
	 * 查找符合要求的记录数
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public int findApprovalChangeCount(ApprovalChangeCond cond) throws RuntimeException;
}