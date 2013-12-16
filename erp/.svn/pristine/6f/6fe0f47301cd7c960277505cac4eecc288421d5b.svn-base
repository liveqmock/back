package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.Mortgage;
import com.ihk.saleunit.data.pojo.MortgageCond;

/**
 * Mortgage的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IMortgageServices {

	/**
	 * 新增Mortgage
	 * @param mortgage
	 */
	public void addMortgage(Mortgage mortgage) throws RuntimeException;

	/**
	 * 删除一条Mortgage
	 * @param id
	 */
	public void deleteMortgage(int id) throws RuntimeException;

	/**
	 * 修改Mortgage
	 * @param mortgage
	 */
	public void updateMortgage(Mortgage mortgage) throws RuntimeException;

	/**
	 * 查找一条Mortgage
	 * @return Mortgage
	 * @param id 主键id
	 */
	public Mortgage findMortgageById(int id) throws RuntimeException;

	/**
	 * 分页查找Mortgage
	 * @param cond 查询条件
	 * @return Mortgage列表
	 */
	public List<Mortgage> findMortgagePage(MortgageCond cond) throws RuntimeException;

	/**
	 * 查找全部Mortgage
	 * @param cond 查询条件
	 * @return Mortgage列表
	 */
	public List<Mortgage> findMortgage(MortgageCond cond) throws RuntimeException;
}