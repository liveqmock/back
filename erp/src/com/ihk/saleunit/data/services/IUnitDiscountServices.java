package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.UnitDiscount;
import com.ihk.saleunit.data.pojo.UnitDiscountCond;

/**
 * UnitDiscount的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IUnitDiscountServices {
	/**
	 * 新增UnitDiscount
	 * @param unitDiscount
	 */
	public void addUnitDiscount(UnitDiscount unitDiscount) throws RuntimeException;

	/**
	 * 删除一条UnitDiscount
	 * @param id
	 */
	public void deleteUnitDiscount(int id) throws RuntimeException;

	/**
	 * 修改UnitDiscount
	 * @param unitDiscount
	 */
	public void updateUnitDiscount(UnitDiscount unitDiscount) throws RuntimeException;

	/**
	 * 查找一条UnitDiscount
	 * @return UnitDiscount
	 * @param id 主键id
	 */
	public UnitDiscount findUnitDiscountById(int id) throws RuntimeException;

	/**
	 * 分页查找UnitDiscount
	 * @param cond 查询条件
	 * @return UnitDiscount列表
	 */
	public List<UnitDiscount> findUnitDiscountPage(UnitDiscountCond cond) throws RuntimeException;

	/**
	 * 查找全部UnitDiscount
	 * @param cond 查询条件
	 * @return UnitDiscount列表
	 */
	public List<UnitDiscount> findUnitDiscount(UnitDiscountCond cond) throws RuntimeException;
	
	/**
	 * 修改
	 * @param unitDiscountId
	 * @param mainId
	 * @param type
	 * @throws RuntimeException
	 */
	public void updateUnitDiscountMainId(int unitDiscountId, int mainId, String type) throws RuntimeException; //给折扣表设置其mainId及type
	
	/**
	 * 查找
	 * @param type
	 * @param mainId
	 * @return
	 * @throws RuntimeException
	 */
	public UnitDiscount findUnitDiscountByTypeAndMainId(String type, int mainId) throws RuntimeException; //根据type和mainId获取对应的折扣
	
}