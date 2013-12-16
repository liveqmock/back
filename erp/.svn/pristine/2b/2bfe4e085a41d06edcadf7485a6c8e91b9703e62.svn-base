package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.ChangeUnit;
import com.ihk.saleunit.data.pojo.ChangeUnitCond;

/**
 * ChangeUnit数据访问接口Mapper
 * @author 
 *
 */ 
public interface IChangeUnitMapper {

	/**
	 * 新增ChangeUnit
	 * @param changeUnit
	 */
	public void addChangeUnit(ChangeUnit changeUnit) ;


	/**
	 * 根据条件删除ChangeUnit
	 * @param cond 删除条件
	 */
	public void deleteChangeUnit(int id) throws RuntimeException;

	/**
	 * 修改ChangeUnit
	 * @param changeUnit
	 */
	public void updateChangeUnit(ChangeUnit changeUnit) throws RuntimeException;

    
	/**
	 * 查找一条ChangeUnit
	 * @return ChangeUnit
	 * @param id 主键id
	 */
	public ChangeUnit findChangeUnitById(int id) throws RuntimeException;

	/**
	 * 分页查找ChangeUnit
	 * @param cond 查询条件
	 * @return ChangeUnit列表
	 */
	public List<ChangeUnit> findChangeUnitPage(ChangeUnitCond cond) ;

	/**
	 * 查找全部ChangeUnit
	 * @param cond 查询条件
	 * @return ChangeUnit列表
	 */
	public List<ChangeUnit> findChangeUnit(ChangeUnitCond cond) ;

	/**
	 * 查找符合条件的记录条数ChangeUnit
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findChangeUnitCount(ChangeUnitCond cond) ;
}
