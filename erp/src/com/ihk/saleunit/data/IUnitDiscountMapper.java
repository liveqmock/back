package com.ihk.saleunit.data;

import java.util.List;
import java.util.Map;

import com.ihk.saleunit.data.pojo.UnitDiscount;
import com.ihk.saleunit.data.pojo.UnitDiscountCond;

/**
 * UnitDiscount数据访问接口Mapper
 * @author 
 *
 */ 
public interface IUnitDiscountMapper {

	/**
	 * 新增UnitDiscount
	 * @param unitDiscount
	 */
	public void addUnitDiscount(UnitDiscount unitDiscount) ;

	/**
	 * 根据条件删除UnitDiscount
	 * @param cond 删除条件
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
	public List<UnitDiscount> findUnitDiscountPage(UnitDiscountCond cond) ;

	/**
	 * 查找全部UnitDiscount
	 * @param cond 查询条件
	 * @return UnitDiscount列表
	 */
	public List<UnitDiscount> findUnitDiscount(UnitDiscountCond cond) ;

	/**
	 * 查找符合条件的记录条数UnitDiscount
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findUnitDiscountCount(UnitDiscountCond cond) ;
	
	/**
	 * 根据mainId进行修改
	 * @param map
	 * @throws RuntimeException
	 */
	public void updateUnitDiscountMainId(Map<String, String> map) throws RuntimeException;
	
	/**
	 * 根据类型与mainId进行查找
	 * @param map
	 * @return
	 * @throws RuntimeException
	 */
	public UnitDiscount findUnitDiscountByTypeAndMainId(Map<String, String> map) throws RuntimeException; //根据type和mainId获取对应的折扣
}
