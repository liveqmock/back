package com.ihk.property.data;

import java.util.List;

import com.ihk.property.data.pojo.UnitPayBillDetail;
import com.ihk.property.data.pojo.UnitPayBillDetailCond;

/**
 * UnitPayBillDetail数据访问接口Mapper
 * @author 
 *
 */ 
public interface IUnitPayBillDetailMapper {

	/**
	 * 新增UnitPayBillDetail
	 * @param unitPayBillDetail
	 */
	public void addUnitPayBillDetail(UnitPayBillDetail unitPayBillDetail) ;

	/**
	 * 新增UnitPayBillDetail
	 * @param unitPayBillDetail
	 */
	public void deleteUnitPayBillDetail(int id) throws RuntimeException;


	/**
	 * 修改UnitPayBillDetail
	 * @param unitPayBillDetail
	 */
	public void updateUnitPayBillDetail(UnitPayBillDetail unitPayBillDetail) throws RuntimeException;

	/**
	 * 查找一条UnitPayBillDetail
	 * @return UnitPayBill
	 * @param id 主键id
	 */
	public UnitPayBillDetail findUnitPayBillDetailById(int id) throws RuntimeException;

	/**
	 * 分页查找UnitPayBillDetail
	 * @param cond 查询条件
	 * @return UnitPayBillDetail列表
	 */
	public List<UnitPayBillDetail> findUnitPayBillDetailPage(UnitPayBillDetailCond cond) ;

	/**
	 * 查找全部UnitPayBillDetail
	 * @param cond 查询条件
	 * @return UnitPayBillDetail列表
	 */
	public List<UnitPayBillDetail> findUnitPayBillDetail(UnitPayBillDetailCond cond) ;

	/**
	 * 查找符合条件的记录条数UnitPayBillDetail
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findUnitPayBillDetailCount(UnitPayBillDetailCond cond) ;
}
