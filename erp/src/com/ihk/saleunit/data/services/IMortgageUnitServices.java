package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.MortgageUnit;
import com.ihk.saleunit.data.pojo.MortgageUnitCond;

/**
 * MortgageUnit的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IMortgageUnitServices {
	/**
	 * 新增MortgageUnit
	 * @param mortgageUnit
	 */
	public void addMortgageUnit(MortgageUnit mortgageUnit) throws RuntimeException;

	/**
	 * 删除一条MortgageUnit
	 * @param id
	 */
	public void deleteMortgageUnit(int id) throws RuntimeException;

	/**
	 * 修改MortgageUnit
	 * @param mortgageUnit
	 */
	public void updateMortgageUnit(MortgageUnit mortgageUnit) throws RuntimeException;

	/**
	 * 查找一条MortgageUnit
	 * @return MortgageUnit
	 * @param id 主键id
	 */
	public MortgageUnit findMortgageUnitById(int id) throws RuntimeException;

	/**
	 * 分页查找MortgageUnit
	 * @param cond 查询条件
	 * @return MortgageUnit列表
	 */
	public List<MortgageUnit> findMortgageUnitPage(MortgageUnitCond cond) throws RuntimeException;

	/**
	 * 查找全部MortgageUnit
	 * @param cond 查询条件
	 * @return MortgageUnit列表
	 */
	public List<MortgageUnit> findMortgageUnit(MortgageUnitCond cond) throws RuntimeException;
}