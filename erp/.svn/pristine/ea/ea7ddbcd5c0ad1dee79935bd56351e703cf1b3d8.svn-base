package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.UnitGift;
import com.ihk.saleunit.data.pojo.UnitGiftCond;

/**
 * UnitGift数据访问接口Mapper
 * @author 
 *
 */ 
public interface IUnitGiftMapper {

	/**
	 * 新增UnitGift
	 * @param unitGift
	 */
	public void addUnitGift(UnitGift unitGift) ;

	/**
	 * 根据条件删除UnitGift
	 * @param cond 删除条件
	 */
	public void deleteUnitGift(int id) throws RuntimeException;

	/**
	 * 修改UnitGift
	 * @param unitGift
	 */
	public void updateUnitGift(UnitGift unitGift) throws RuntimeException;

	/**
	 * 查找一条UnitGift
	 * @return UnitGift
	 * @param id 主键id
	 */
	public UnitGift findUnitGiftById(int id) throws RuntimeException;

	/**
	 * 分页查找UnitGift
	 * @param cond 查询条件
	 * @return UnitGift列表
	 */
	public List<UnitGift> findUnitGiftPage(UnitGiftCond cond) ;

	/**
	 * 查找全部UnitGift
	 * @param cond 查询条件
	 * @return UnitGift列表
	 */
	public List<UnitGift> findUnitGift(UnitGiftCond cond) ;

	/**
	 * 查找符合条件的记录条数UnitGift
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findUnitGiftCount(UnitGiftCond cond) ;
}
