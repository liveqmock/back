package com.ihk.saleunit.data.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.constanttype.EnumChangeType;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.saleunit.data.IChangeOwnerMapper;
import com.ihk.saleunit.data.pojo.ApprovalChange;
import com.ihk.saleunit.data.pojo.ChangeOwner;
import com.ihk.saleunit.data.pojo.ChangeOwnerCond;
import com.ihk.saleunit.data.services.IApprovalChangeServices;
import com.ihk.saleunit.data.services.IChangeOwnerServices;
import com.ihk.utils.SessionUser;

/**
 * ChangeOwner的Services实现(业务实现)
 * @author 
 *
 */
@Service("changeOwnerServices")
@SuppressWarnings("unchecked")
public class ChangeOwnerServices implements IChangeOwnerServices {
	/**
	 * changeOwner数据访问接口
	 */
	@Autowired	 IChangeOwnerMapper changeOwnerMapper;
	@Autowired IApprovalChangeServices iApprovalChangeServices;

	/**
	 * 删除一条ChangeOwner
	 * @param id
	 */
	public void deleteChangeOwner(int id) throws RuntimeException {
		changeOwnerMapper.deleteChangeOwner(id);
	}

	/**
	 * 新增ChangeOwner
	 * @param changeOwner
	 */
	public void addChangeOwner(ChangeOwner changeOwner) throws RuntimeException {	
		//在增加change的同时 增加申请表
		changeOwnerMapper.addChangeOwner(changeOwner);
		ApprovalChange app = new ApprovalChange();
		app.setApplyType(EnumChangeType.CHANGE_OWNER.toString());
		app.setApplyId(changeOwner.getId());
		app.setIsDeleted("0");
		app.setCreatedId(SessionUser.getUserId());
		app.setModId(app.getCreatedId());
		app.setCreatedTime(new Date());
		app.setModTime(app.getCreatedTime());
		iApprovalChangeServices.addApprovalChange(app);
	}

	/**
	 * 查找一条ChangeOwner
	 * @return ChangeOwner
	 * @param id 主键id
	 */
	@Override
	public ChangeOwner findChangeOwnerById(int id) throws RuntimeException {
		return changeOwnerMapper.findChangeOwnerById(id);
	}

	/**
	 * 修改ChangeOwner
	 * @param changeOwner
	 */
	@Override
	public void updateChangeOwner(ChangeOwner changeOwner) throws RuntimeException {
		changeOwnerMapper.updateChangeOwner(changeOwner);		
	}

	/**
	 * 分页查找ChangeOwner
	 * @param cond 查询条件
	 * @return ChangeOwner列表
	 */
	public List<ChangeOwner> findChangeOwnerPage(ChangeOwnerCond cond) throws RuntimeException {
		int recordCount = changeOwnerMapper.findChangeOwnerCount(cond);
		
		cond.recordCount = recordCount;
				
		return changeOwnerMapper.findChangeOwnerPage(cond);
	}

	/**
	 * 查找全部ChangeOwner
	 * @param cond 查询条件
	 * @return ChangeOwner列表
	 */
	public List<ChangeOwner> findChangeOwner(ChangeOwnerCond cond) throws RuntimeException {
    	return changeOwnerMapper.findChangeOwner(cond);
	}
}
