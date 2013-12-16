package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IUnitDiscountDetailMapper;
import com.ihk.saleunit.data.pojo.UnitDiscountDetail;
import com.ihk.saleunit.data.pojo.UnitDiscountDetailCond;
import com.ihk.saleunit.data.services.IUnitDiscountDetailServices;

/**
 * UnitDiscountDetail的Services实现(业务实现)
 * @author 
 *
 */
@Service("unitDiscountDetailServices")
public class UnitDiscountDetailServices implements IUnitDiscountDetailServices {
	/**
	 * unitDiscountDetail数据访问接口
	 */
	@Autowired	 IUnitDiscountDetailMapper unitDiscountDetailMapper;

	/**
	 * 删除一条UnitDiscountDetail
	 * @param id
	 */
	public void deleteUnitDiscountDetail(int id) throws RuntimeException {
		unitDiscountDetailMapper.deleteUnitDiscountDetail(id);
	}

	/**
	 * 新增UnitDiscountDetail
	 * @param unitDiscountDetail
	 */
	public void addUnitDiscountDetail(UnitDiscountDetail unitDiscountDetail) throws RuntimeException {		
		unitDiscountDetailMapper.addUnitDiscountDetail(unitDiscountDetail);
	}

	/**
	 * 查找一条UnitDiscountDetail
	 * @return UnitDiscountDetail
	 * @param id 主键id
	 */
	@Override
	public UnitDiscountDetail findUnitDiscountDetailById(int id) throws RuntimeException {
		return unitDiscountDetailMapper.findUnitDiscountDetailById(id);
	}

	/**
	 * 修改UnitDiscountDetail
	 * @param unitDiscountDetail
	 */
	@Override
	public void updateUnitDiscountDetail(UnitDiscountDetail unitDiscountDetail) throws RuntimeException {
		unitDiscountDetailMapper.updateUnitDiscountDetail(unitDiscountDetail);		
	}

	/**
	 * 分页查找UnitDiscountDetail
	 * @param cond 查询条件
	 * @return UnitDiscountDetail列表
	 */
	public List<UnitDiscountDetail> findUnitDiscountDetailPage(UnitDiscountDetailCond cond) throws RuntimeException {
		int recordCount = unitDiscountDetailMapper.findUnitDiscountDetailCount(cond);
		
		cond.recordCount = recordCount;
				
		return unitDiscountDetailMapper.findUnitDiscountDetailPage(cond);
	}

	/**
	 * 查找全部UnitDiscountDetail
	 * @param cond 查询条件
	 * @return UnitDiscountDetail列表
	 */
	public List<UnitDiscountDetail> findUnitDiscountDetail(UnitDiscountDetailCond cond) throws RuntimeException {
    	return unitDiscountDetailMapper.findUnitDiscountDetail(cond);
	}

	/**
	 * 根据discountId查找
	 */
	@Override
	public List<UnitDiscountDetail> findDetailByDiscountId(int discountId)
			throws Exception {
		return unitDiscountDetailMapper.findDetailByDiscountId(discountId);
	}

	/**
	 * 根据discountId删除
	 */
	@Override
	public void deleteUnitDiscountDetailByDiscountId(int discountId)
			throws Exception {
		
		unitDiscountDetailMapper.deleteUnitDiscountDetailByDiscountId(discountId);
		
	}
}
