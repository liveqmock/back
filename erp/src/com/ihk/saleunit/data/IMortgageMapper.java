package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.Mortgage;
import com.ihk.saleunit.data.pojo.MortgageCond;

/**
 * Mortgage数据访问接口Mapper
 * @author 
 *
 */ 
public interface IMortgageMapper {

	/**
	 * 新增Mortgage
	 * @param mortgage
	 */
	public void addMortgage(Mortgage mortgage) ;

	/**
	 * 根据条件删除Mortgage
	 * @param cond 删除条件
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
	public List<Mortgage> findMortgagePage(MortgageCond cond) ;

	/**
	 * 查找全部Mortgage
	 * @param cond 查询条件
	 * @return Mortgage列表
	 */
	public List<Mortgage> findMortgage(MortgageCond cond) ;

	/**
	 * 查找符合条件的记录条数Mortgage
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findMortgageCount(MortgageCond cond) ;
}
