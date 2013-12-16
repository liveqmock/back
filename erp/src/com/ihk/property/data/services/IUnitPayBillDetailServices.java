package com.ihk.property.data.services;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.UnitPayBillDetail;
import com.ihk.property.data.pojo.UnitPayBillDetailCond;

/**
 * UnitPayBillDetail的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IUnitPayBillDetailServices {

	/**
	 * 新增UnitPayBillDetail
	 * @param unitPayBillDetail
	 */
	public void addUnitPayBillDetail(UnitPayBillDetail unitPayBillDetail) throws RuntimeException;

	/**
	 * 删除一条UnitPayBillDetail
	 * @param id
	 */
	public void deleteUnitPayBillDetail(int id) throws RuntimeException;

	/**
	 * 修改UnitPayBillDetail
	 * @param unitPayBillDetail
	 */
	public void updateUnitPayBillDetail(UnitPayBillDetail unitPayBillDetail) throws RuntimeException;

	/**
	 * 查找一条UnitPayBillDetail
	 * @return UnitPayBillDetail
	 * @param id 主键id
	 */
	public UnitPayBillDetail findUnitPayBillDetailById(int id) throws RuntimeException;

	/**
	 * 分页查找UnitPayBillDetail
	 * @param cond 查询条件
	 * @return UnitPayBillDetail列表
	 */
	public List<UnitPayBillDetail> findUnitPayBillDetailPage(UnitPayBillDetailCond cond) throws RuntimeException;

	/**
	 * 查找全部UnitPayBillDetail
	 * @param cond 查询条件
	 * @return UnitPayBillDetail列表
	 */
	public List<UnitPayBillDetail> findUnitPayBillDetail(UnitPayBillDetailCond cond) throws RuntimeException;
}