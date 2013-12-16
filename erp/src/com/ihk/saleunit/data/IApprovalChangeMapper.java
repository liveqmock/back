package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.ApprovalChange;
import com.ihk.saleunit.data.pojo.ApprovalChangeCond;

/**
 * ApprovalChange数据访问接口Mapper
 * @author 
 *
 */ 
public interface IApprovalChangeMapper {

	/**
	 * 新增ApprovalChange
	 * @param approvalChange
	 */
	public void addApprovalChange(ApprovalChange approvalChange) ;

	/**
	 * 根据条件删除ApprovalChange
	 * @param cond 删除条件
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
	public List<ApprovalChange> findApprovalChangePage(ApprovalChangeCond cond) ;

	/**
	 * 查找全部ApprovalChange
	 * @param cond 查询条件
	 * @return ApprovalChange列表
	 */
	public List<ApprovalChange> findApprovalChange(ApprovalChangeCond cond) ;

	/**
	 * 查找符合条件的记录条数ApprovalChange
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findApprovalChangeCount(ApprovalChangeCond cond) ;
}
