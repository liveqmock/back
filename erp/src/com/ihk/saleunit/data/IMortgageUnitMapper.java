package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.MortgageUnit;
import com.ihk.saleunit.data.pojo.MortgageUnitCond;

/**
 * MortgageUnit数据访问接口Mapper
 * @author 
 *
 */ 
public interface IMortgageUnitMapper {

	/**
	 * 新增MortgageUnit
	 * @param mortgageUnit
	 */
	public void addMortgageUnit(MortgageUnit mortgageUnit) ;

	/**
	 * 根据条件删除MortgageUnit
	 * @param cond 删除条件
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
	public List<MortgageUnit> findMortgageUnitPage(MortgageUnitCond cond) ;

	/**
	 * 查找全部MortgageUnit
	 * @param cond 查询条件
	 * @return MortgageUnit列表
	 */
	public List<MortgageUnit> findMortgageUnit(MortgageUnitCond cond) ;

	/**
	 * 查找符合条件的记录条数MortgageUnit
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findMortgageUnitCount(MortgageUnitCond cond) ;
}
