package com.ihk.property.data.services;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.pojo.UnitPayBillCond;

/**
 * UnitPayBill的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IUnitPayBillServices {

	/**
	 * 新增UnitPayBill
	 * @param unitPayBill
	 */
	public void addUnitPayBill(UnitPayBill unitPayBill) throws RuntimeException;

	/**
	 * 删除一条UnitPayBill
	 * @param id
	 */
	public void deleteUnitPayBill(int id) throws RuntimeException;

	/**
	 * 修改UnitPayBill
	 * @param unitPayBill
	 */
	public void updateUnitPayBill(UnitPayBill unitPayBill) throws RuntimeException;

	/**
	 * 查找一条UnitPayBill
	 * @return UnitPayBill
	 * @param id 主键id
	 */
	public UnitPayBill findUnitPayBillById(int id) throws RuntimeException;

	/**
	 * 分页查找UnitPayBill
	 * @param cond 查询条件
	 * @return UnitPayBill列表
	 */
	public List<UnitPayBill> findUnitPayBillPage(UnitPayBillCond cond) throws RuntimeException;

	/**
	 * 查找全部UnitPayBill
	 * @param cond 查询条件
	 * @return UnitPayBill列表
	 */
	public List<UnitPayBill> findUnitPayBill(UnitPayBillCond cond) throws RuntimeException;
	
	/**
	 * 根据unitId查找第一条UnitPayBill
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public UnitPayBill findUnitPayBillLimit1ByUnitId(int unitId) throws RuntimeException;
	
	/**
	 * 根据unitId查找UnitPayBill
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public List<UnitPayBill> findUnitPayBillByUnitId(int unitId) throws RuntimeException;
	
	/**
	 * 禁用
	 * @param id
	 * @throws RuntimeException
	 */
	public void disabledUnitPayBill(int id) throws RuntimeException;
	
	/**
	 * 启用
	 * @param id
	 * @throws RuntimeException
	 */
	public void enabledUnitPayBill(int id) throws RuntimeException;
	
	/**
	 * 修改应收款的已收,未收金额(增加收款内容)
	 * @param cond
	 * @throws RuntimeException
	 */
	public void updateUnitPayBillHadAndNotPayForAddReceipt(UnitPayBillCond cond) throws RuntimeException;
	
	/**
	 * 修改应收款的已收,未收金额(修改收款内容)
	 * @param cond
	 * @throws RuntimeException
	 */
	public void updateUnitPayBillHadAndNotPayForDeleteReceipt(UnitPayBillCond cond) throws RuntimeException;
	
	/**
	 * 根据单元id删除对应的应收
	 * @param unitId
	 * @throws RuntimeException
	 */
	public void deleteUnitPayBillByUnitId(int unitId) throws RuntimeException;
	
	
}