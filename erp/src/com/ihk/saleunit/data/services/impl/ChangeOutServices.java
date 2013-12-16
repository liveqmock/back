package com.ihk.saleunit.data.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.constanttype.EnumChangeType;
import com.ihk.saleunit.data.IChangeOutMapper;
import com.ihk.saleunit.data.pojo.ApprovalChange;
import com.ihk.saleunit.data.pojo.ChangeOut;
import com.ihk.saleunit.data.pojo.ChangeOutCond;
import com.ihk.saleunit.data.services.IApprovalChangeServices;
import com.ihk.saleunit.data.services.IChangeOutServices;
import com.ihk.utils.SessionUser;

/**
 * ChangeOut的Services实现(业务实现)
 * @author 
 *
 */
@Service("changeOutServices")
@SuppressWarnings("unchecked")
public class ChangeOutServices implements IChangeOutServices {
	/**
	 * changeOut数据访问接口
	 */
	@Autowired	 IChangeOutMapper changeOutMapper;
	@Autowired IApprovalChangeServices iApprovalChangeServices;

	/**
	 * 删除一条ChangeOut
	 * @param id
	 */
	public void deleteChangeOut(int id) throws RuntimeException {
		changeOutMapper.deleteChangeOut(id);
	}

	/**
	 * 新增ChangeOut
	 * @param changeOut
	 */
	public void addChangeOut(ChangeOut changeOut) throws RuntimeException {		
		changeOutMapper.addChangeOut(changeOut);
		ApprovalChange app = new ApprovalChange();
		app.setApplyType(EnumChangeType.CHANGE_OUT.toString());
		app.setApplyId(changeOut.getId());
		app.setIsDeleted("0");
		app.setCreatedId(SessionUser.getUserId());
		app.setModId(app.getCreatedId());
		app.setCreatedTime(new Date());
		app.setModTime(app.getCreatedTime());
		iApprovalChangeServices.addApprovalChange(app);
	}

	/**
	 * 查找一条ChangeOut
	 * @return ChangeOut
	 * @param id 主键id
	 */
	@Override
	public ChangeOut findChangeOutById(int id) throws RuntimeException {
		return changeOutMapper.findChangeOutById(id);
	}

	/**
	 * 修改ChangeOut
	 * @param changeOut
	 */
	@Override
	public void updateChangeOut(ChangeOut changeOut) throws RuntimeException {
		changeOutMapper.updateChangeOut(changeOut);		
	}

	/**
	 * 分页查找ChangeOut
	 * @param cond 查询条件
	 * @return ChangeOut列表
	 */
	public List<ChangeOut> findChangeOutPage(ChangeOutCond cond) throws RuntimeException {
		int recordCount = changeOutMapper.findChangeOutCount(cond);
		
		cond.recordCount = recordCount;
				
		return changeOutMapper.findChangeOutPage(cond);
	}

	/**
	 * 查找全部ChangeOut
	 * @param cond 查询条件
	 * @return ChangeOut列表
	 */
	public List<ChangeOut> findChangeOut(ChangeOutCond cond) throws RuntimeException {
    	return changeOutMapper.findChangeOut(cond);
	}
}
