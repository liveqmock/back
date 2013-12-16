package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.UnitDiscountDetail;
import com.ihk.saleunit.data.pojo.UnitDiscountDetailCond;

/**
 * UnitDiscountDetail数据访问接口Mapper
 * @author 
 *
 */ 
public interface IUnitDiscountDetailMapper {

	/**
	 * 新增UnitDiscountDetail
	 * @param unitDiscountDetail
	 */
	public void addUnitDiscountDetail(UnitDiscountDetail unitDiscountDetail) ;

	/**
	 * 根据条件删除UnitDiscountDetail
	 * @param cond 删除条件
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
	public List<UnitDiscountDetail> findUnitDiscountDetailPage(UnitDiscountDetailCond cond) ;

	/**
	 * 查找全部UnitDiscountDetail
	 * @param cond 查询条件
	 * @return UnitDiscountDetail列表
	 */
	public List<UnitDiscountDetail> findUnitDiscountDetail(UnitDiscountDetailCond cond) ;

	/**
	 * 查找符合条件的记录条数UnitDiscountDetail
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findUnitDiscountDetailCount(UnitDiscountDetailCond cond) ;
	
	/**
	 * 根据discountId查找
	 * @param discountId
	 * @return
	 * @throws Exception
	 */
	public List<UnitDiscountDetail> findDetailByDiscountId(int discountId) throws Exception;
	
	/**
	 * 根据discountId进行删除
	 * @param discountId
	 * @throws Exception
	 */
	public void deleteUnitDiscountDetailByDiscountId(int discountId) throws Exception;
}
