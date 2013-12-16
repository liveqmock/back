package com.ihk.property.data.services.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IUnitPayBillMapper;
import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.pojo.UnitPayBillCond;
import com.ihk.property.data.services.IUnitPayBillServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * UnitPayBill的Services实现(业务实现)
 * @author 
 *
 */
@Service("unitPayBillServices")
public class UnitPayBillServices implements IUnitPayBillServices {
	/**
	 * unitPayBill数据访问接口
	 */
	@Autowired	 IUnitPayBillMapper unitPayBillMapper;

	/**
	 * 删除一条UnitPayBill
	 * @param id
	 */
	public void deleteUnitPayBill(int id) throws RuntimeException {
		unitPayBillMapper.deleteUnitPayBill(new PojoDeleteCond(id));
	}

	/**
	 * 新增UnitPayBill
	 * @param unitPayBill
	 */
	public void addUnitPayBill(UnitPayBill unitPayBill) throws RuntimeException {		
		unitPayBillMapper.addUnitPayBill(unitPayBill);
	}

	/**
	 * 查找一条UnitPayBill
	 * @return UnitPayBill
	 * @param id 主键id
	 */
	@Override
	public UnitPayBill findUnitPayBillById(int id) throws RuntimeException {
		return unitPayBillMapper.findUnitPayBillById(id);
	}

	/**
	 * 修改UnitPayBill
	 * @param unitPayBill
	 */
	@Override
	public void updateUnitPayBill(UnitPayBill unitPayBill) throws RuntimeException {
		unitPayBillMapper.updateUnitPayBill(unitPayBill);		
	}

    
	/**
	 * 分页查找UnitPayBill
	 * @param cond 查询条件
	 * @return UnitPayBill列表
	 */
	public List<UnitPayBill> findUnitPayBillPage(UnitPayBillCond cond) throws RuntimeException {
		int recordCount = unitPayBillMapper.findUnitPayBillCount(cond);
		
		cond.recordCount = recordCount;
				
		return unitPayBillMapper.findUnitPayBillPage(cond);
	}

	/**
	 * 查找全部UnitPayBill
	 * @param cond 查询条件
	 * @return UnitPayBill列表
	 */
	public List<UnitPayBill> findUnitPayBill(UnitPayBillCond cond) throws RuntimeException {
    	return unitPayBillMapper.findUnitPayBill(cond);
	}

	/**
	 * 根据unitId查找第一条记录
	 */
	@Override
	public UnitPayBill findUnitPayBillLimit1ByUnitId(int unitId) throws RuntimeException {
		
		return unitPayBillMapper.findUnitPayBillLimit1ByUnitId(unitId);
	}

	/**
	 * 根据unti查找
	 */
	@Override
	public List<UnitPayBill> findUnitPayBillByUnitId(int unitId)
			throws RuntimeException {
		
		return unitPayBillMapper.findUnitPayBillByUnitId(unitId);
	}

	/**
	 * 禁用
	 */
	@Override
	public void disabledUnitPayBill(int id) throws RuntimeException {
		
		unitPayBillMapper.disabledUnitPayBill(new PojoDeleteCond(id));
	}

	/**
	 * 启用
	 */
	@Override
	public void enabledUnitPayBill(int id) throws RuntimeException {
		
		unitPayBillMapper.enabledUnitPayBill(new PojoDeleteCond(id));
	}

	/**
	 * 修改应收款的已收,未收金额(增加收款内容)
	 * @param cond
	 * @throws RuntimeException
	 */
	@Override
	public void updateUnitPayBillHadAndNotPayForAddReceipt(UnitPayBillCond cond)
			throws RuntimeException {
		
		unitPayBillMapper.updateUnitPayBillHadAndNotPayForAddReceipt(cond);
	}
	
	/**
	 * 修改应收款的已收,未收金额(修改收款内容)
	 * @param cond
	 * @throws RuntimeException
	 */
	@Override
	public void updateUnitPayBillHadAndNotPayForDeleteReceipt(UnitPayBillCond cond)
			throws RuntimeException {
		
		unitPayBillMapper.updateUnitPayBillHadAndNotPayForDeleteReceipt(cond);
	}

	/**
	 * 根据单元id删除对应的应收
	 */
	@Override
	public void deleteUnitPayBillByUnitId(int unitId) throws RuntimeException {
		
		PojoDeleteCond cond = new PojoDeleteCond();
		cond.setUnitId(unitId);
		cond.setModId(SessionUser.getUserId());
		cond.setModTime(new Date());
		
		unitPayBillMapper.deleteUnitPayBillByUnitId(cond);
	}
}
