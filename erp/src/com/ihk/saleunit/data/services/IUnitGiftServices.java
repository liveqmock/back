package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.UnitGift;
import com.ihk.saleunit.data.pojo.UnitGiftCond;

/**
 * UnitGift的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IUnitGiftServices {
	/**
	 * 新增UnitGift
	 * @param unitGift
	 */
	public void addUnitGift(UnitGift unitGift) throws RuntimeException;

	/**
	 * 删除一条UnitGift
	 * @param id
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
	public List<UnitGift> findUnitGiftPage(UnitGiftCond cond) throws RuntimeException;

	/**
	 * 查找全部UnitGift
	 * @param cond 查询条件
	 * @return UnitGift列表
	 */
	public List<UnitGift> findUnitGift(UnitGiftCond cond) throws RuntimeException;
}