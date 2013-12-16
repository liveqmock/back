package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.UnitDiscountDetail;
import com.ihk.saleunit.data.pojo.UnitDiscountDetailCond;

/**
 * UnitDiscountDetail的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IUnitDiscountDetailServices {
	/**
	 * 新增UnitDiscountDetail
	 * @param unitDiscountDetail
	 */
	public void addUnitDiscountDetail(UnitDiscountDetail unitDiscountDetail) throws RuntimeException;

	/**
	 * 删除一条UnitDiscountDetail
	 * @param id
	 */
	public void deleteUnitDiscountDetail(int id) throws RuntimeException;

	/**
	 * 修改UnitDiscountDetail
	 * @param unitDiscountDetail
	 */
	public void updateUnitDiscountDetail(UnitDiscountDetail unitDiscountDetail) throws RuntimeException;

	/**
	 * 查找一条UnitDiscountDetail
	 * @return UnitDiscountDetail
	 * @param id 主键id
	 */
	public UnitDiscountDetail findUnitDiscountDetailById(int id) throws RuntimeException;

	/**
	 * 分页查找UnitDiscountDetail
	 * @param cond 查询条件
	 * @return UnitDiscountDetail列表
	 */
	public List<UnitDiscountDetail> findUnitDiscountDetailPage(UnitDiscountDetailCond cond) throws RuntimeException;

	/**
	 * 查找全部UnitDiscountDetail
	 * @param cond 查询条件
	 * @return UnitDiscountDetail列表
	 */
	public List<UnitDiscountDetail> findUnitDiscountDetail(UnitDiscountDetailCond cond) throws RuntimeException;
	
	/**
	 * 根据discountId查找
	 * @param discountId
	 * @return
	 * @throws Exception
	 */
	public List<UnitDiscountDetail> findDetailByDiscountId(int discountId) throws Exception;
	
	/**
	 * 根据discountId查找
	 * @param discountId
	 * @throws Exception
	 */
	public void deleteUnitDiscountDetailByDiscountId(int discountId) throws Exception;
	
}