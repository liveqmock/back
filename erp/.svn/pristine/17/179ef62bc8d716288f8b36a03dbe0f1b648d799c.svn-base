package com.ihk.saleunit.data.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.constanttype.EnumChangeType;
import com.ihk.saleunit.data.IChangeUnitMapper;
import com.ihk.saleunit.data.pojo.ApprovalChange;
import com.ihk.saleunit.data.pojo.ChangeUnit;
import com.ihk.saleunit.data.pojo.ChangeUnitCond;
import com.ihk.saleunit.data.services.IApprovalChangeServices;
import com.ihk.saleunit.data.services.IChangeUnitServices;
import com.ihk.utils.SessionUser;

/**
 * ChangeUnit的Services实现(业务实现)
 * @author 
 *
 */
@Service("changeUnitServices")
@SuppressWarnings("unchecked")
public class ChangeUnitServices implements IChangeUnitServices {
	/**
	 * changeUnit数据访问接口
	 */
	@Autowired	 IChangeUnitMapper changeUnitMapper;
	@Autowired IApprovalChangeServices iApprovalChangeServices;

	/**
	 * 删除一条ChangeUnit
	 * @param id
	 */
	public void deleteChangeUnit(int id) throws RuntimeException {
		changeUnitMapper.deleteChangeUnit(id);
	}

	/**
	 * 新增ChangeUnit
	 * @param changeUnit
	 */
	public void addChangeUnit(ChangeUnit changeUnit) throws RuntimeException {		
		changeUnitMapper.addChangeUnit(changeUnit);
		ApprovalChange app = new ApprovalChange();
		app.setApplyType(EnumChangeType.CHANGE_UNIT.toString());
		app.setApplyId(changeUnit.getId());
		app.setIsDeleted("0");
		app.setCreatedId(SessionUser.getUserId());
		app.setModId(app.getCreatedId());
		app.setCreatedTime(new Date());
		app.setModTime(app.getCreatedTime());
		iApprovalChangeServices.addApprovalChange(app);
	}

	/**
	 * 查找一条ChangeUnit
	 * @return ChangeUnit
	 * @param id 主键id
	 */
	@Override
	public ChangeUnit findChangeUnitById(int id) throws RuntimeException {
		return changeUnitMapper.findChangeUnitById(id);
	}

	/**
	 * 修改ChangeUnit
	 * @param changeUnit
	 */
	@Override
	public void updateChangeUnit(ChangeUnit changeUnit) throws RuntimeException {
		changeUnitMapper.updateChangeUnit(changeUnit);		
	}

	/**
	 * 分页查找ChangeUnit
	 * @param cond 查询条件
	 * @return ChangeUnit列表
	 */
	public List<ChangeUnit> findChangeUnitPage(ChangeUnitCond cond) throws RuntimeException {
		int recordCount = changeUnitMapper.findChangeUnitCount(cond);
		
		cond.recordCount = recordCount;
				
		return changeUnitMapper.findChangeUnitPage(cond);
	}

	/**
	 * 查找全部ChangeUnit
	 * @param cond 查询条件
	 * @return ChangeUnit列表
	 */
	public List<ChangeUnit> findChangeUnit(ChangeUnitCond cond) throws RuntimeException {
    	return changeUnitMapper.findChangeUnit(cond);
	}
}
