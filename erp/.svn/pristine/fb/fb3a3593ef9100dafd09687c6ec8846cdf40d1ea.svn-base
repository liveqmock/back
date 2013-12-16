package com.ihk.property.data.services.impl;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IUnitPayBillDetailMapper;
import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.pojo.UnitPayBillDetail;
import com.ihk.property.data.pojo.UnitPayBillDetailCond;
import com.ihk.property.data.services.IUnitPayBillDetailServices;
import com.ihk.property.data.services.IUnitPayBillServices;
import com.ihk.utils.SessionUser;

/**
 * UnitPayBillDetail的Services实现(业务实现)
 * @author 
 *
 */
@Service("unitPayBillDetailServices")
@SuppressWarnings("unchecked")
public class UnitPayBillDetailServices implements IUnitPayBillDetailServices {

	/**
	 * unitPayBillDetail数据访问接口
	 */
	@Autowired	 IUnitPayBillDetailMapper unitPayBillDetailMapper;
	@Autowired   IUnitPayBillServices unitPayBillServices;
	

	/**
	 * 删除一条UnitPayBillDetail
	 * @param id
	 */
	public void deleteUnitPayBillDetail(int id) throws RuntimeException {
		unitPayBillDetailMapper.deleteUnitPayBillDetail(id);
	}

	/**
	 * 新增UnitPayBillDetail
	 * @param unitPayBillDetail
	 */
	public void addUnitPayBillDetail(UnitPayBillDetail unitPayBillDetail) throws RuntimeException {		
		unitPayBillDetailMapper.addUnitPayBillDetail(unitPayBillDetail);
		
		//明细表在增加数据的时候  去修改账单
		UnitPayBill up = unitPayBillServices.findUnitPayBillById(unitPayBillDetail.getBillId());
		BigDecimal had = up.getHadPay();
		if(had == null)
			had = new BigDecimal(0);
		had = had.add(unitPayBillDetail.getPayMoney());
		up.setHadPay(had);
		
		BigDecimal not = up.getNotPay();
		if(not == null)
			not = new BigDecimal(0);
		not = not.subtract(unitPayBillDetail.getPayMoney());
		up.setNotPay(not);
		up.setModId(SessionUser.getUserId());
		up.setModTime(new Date());
		unitPayBillServices.updateUnitPayBill(up);
	}

	/**
	 * 查找一条UnitPayBillDetail
	 * @return UnitPayBillDetail
	 * @param id 主键id
	 */
	@Override
	public UnitPayBillDetail findUnitPayBillDetailById(int id) throws RuntimeException {
		return unitPayBillDetailMapper.findUnitPayBillDetailById(id);
	}

	/**
	 * 修改UnitPayBillDetail
	 * @param unitPayBillDetail
	 */
	@Override
	public void updateUnitPayBillDetail(UnitPayBillDetail unitPayBillDetail) throws RuntimeException {
		unitPayBillDetailMapper.updateUnitPayBillDetail(unitPayBillDetail);		
	}

	/**
	 * 分页查找UnitPayBillDetail
	 * @param cond 查询条件
	 * @return UnitPayBillDetail列表
	 */
	public List<UnitPayBillDetail> findUnitPayBillDetailPage(UnitPayBillDetailCond cond) throws RuntimeException {
		int recordCount = unitPayBillDetailMapper.findUnitPayBillDetailCount(cond);
		
		cond.recordCount = recordCount;
				
		return unitPayBillDetailMapper.findUnitPayBillDetailPage(cond);
	}

	/**
	 * 查找全部UnitPayBillDetail
	 * @param cond 查询条件
	 * @return UnitPayBillDetail列表
	 */
	public List<UnitPayBillDetail> findUnitPayBillDetail(UnitPayBillDetailCond cond) throws RuntimeException {
    	return unitPayBillDetailMapper.findUnitPayBillDetail(cond);
	}
}
