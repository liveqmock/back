package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IApprovalChangeMapper;
import com.ihk.saleunit.data.pojo.ApprovalChange;
import com.ihk.saleunit.data.pojo.ApprovalChangeCond;
import com.ihk.saleunit.data.services.IApprovalChangeServices;

/**
 * ApprovalChange的Services实现(业务实现)
 * @author 
 *
 */
@Service("approvalChangeServices")
@SuppressWarnings("unchecked")
public class ApprovalChangeServices implements IApprovalChangeServices {
	/**
	 * approvalChange数据访问接口
	 */
	@Autowired	 IApprovalChangeMapper approvalChangeMapper;

	/**
	 * 删除一条ApprovalChange
	 * @param id
	 */
	public void deleteApprovalChange(int id) throws RuntimeException {
		approvalChangeMapper.deleteApprovalChange(id);
	}

	/**
	 * 新增ApprovalChange
	 * @param approvalChange
	 */
	public void addApprovalChange(ApprovalChange approvalChange) throws RuntimeException {		
		approvalChangeMapper.addApprovalChange(approvalChange);
	}

	/**
	 * 查找一条ApprovalChange
	 * @return ApprovalChange
	 * @param id 主键id
	 */
	@Override
	public ApprovalChange findApprovalChangeById(int id) throws RuntimeException {
		return approvalChangeMapper.findApprovalChangeById(id);
	}

	/**
	 * 修改ApprovalChange
	 * @param approvalChange
	 */
	@Override
	public void updateApprovalChange(ApprovalChange approvalChange) throws RuntimeException {
		approvalChangeMapper.updateApprovalChange(approvalChange);		
	}

	/**
	 * 分页查找ApprovalChange
	 * @param cond 查询条件
	 * @return ApprovalChange列表
	 */
	public List<ApprovalChange> findApprovalChangePage(ApprovalChangeCond cond) throws RuntimeException {
		int recordCount = approvalChangeMapper.findApprovalChangeCount(cond);
		
		cond.recordCount = recordCount;
				
		return approvalChangeMapper.findApprovalChangePage(cond);
	}

	/**
	 * 查找全部ApprovalChange
	 * @param cond 查询条件
	 * @return ApprovalChange列表
	 */
	public List<ApprovalChange> findApprovalChange(ApprovalChangeCond cond) throws RuntimeException {
    	return approvalChangeMapper.findApprovalChange(cond);
	}

	/**
	 * 记录条数
	 */
	@Override
	public int findApprovalChangeCount(ApprovalChangeCond cond)
			throws RuntimeException {
		return approvalChangeMapper.findApprovalChangeCount(cond);
	}
}
