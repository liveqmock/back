package com.ihk.property.data;

import java.util.List;

import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.pojo.UnitPayBillCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * UnitPayBill数据访问接口Mapper
 * @author 
 *
 */ 
public interface IUnitPayBillMapper {

	/**
	 * 新增UnitPayBill
	 * @param unitPayBill
	 */
	public void addUnitPayBill(UnitPayBill unitPayBill) ;

	/**
	 * 根据条件删除UnitPayBill
	 * @param cond 删除条件
	 */
	public void deleteUnitPayBill(PojoDeleteCond cond) throws RuntimeException;

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
	public List<UnitPayBill> findUnitPayBillPage(UnitPayBillCond cond) ;

	/**
	 * 查找全部UnitPayBill
	 * @param cond 查询条件
	 * @return UnitPayBill列表
	 */
	public List<UnitPayBill> findUnitPayBill(UnitPayBillCond cond) ;

	/**
	 * 查找符合条件的记录条数UnitPayBill
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findUnitPayBillCount(UnitPayBillCond cond) ;
	
	/**
	 * 根据unitId 查找第一条
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public UnitPayBill findUnitPayBillLimit1ByUnitId(int unitId) throws RuntimeException;
	
	/**
	 * 根据unitId 查找
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
	public void disabledUnitPayBill(PojoDeleteCond cond) throws RuntimeException;
	
	/**
	 * 启用
	 * @param id
	 * @throws RuntimeException
	 */
	public void enabledUnitPayBill(PojoDeleteCond cond) throws RuntimeException;
	
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
	 * @param cond
	 * @throws RuntimeException
	 */
	public void deleteUnitPayBillByUnitId(PojoDeleteCond cond) throws RuntimeException;
	
}
