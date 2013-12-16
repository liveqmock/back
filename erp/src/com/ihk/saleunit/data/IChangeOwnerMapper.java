package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.ChangeOwner;
import com.ihk.saleunit.data.pojo.ChangeOwnerCond;

/**
 * ChangeOwner数据访问接口Mapper
 * @author 
 *
 */ 
public interface IChangeOwnerMapper {

	/**
	 * 新增ChangeOwner
	 * @param changeOwner
	 */
	public void addChangeOwner(ChangeOwner changeOwner) ;

	/**
	 * 根据条件删除ChangeOwner
	 * @param cond 删除条件
	 */
	public void deleteChangeOwner(int id) throws RuntimeException;

	/**
	 * 修改ChangeOwner
	 * @param changeOwner
	 */
	public void updateChangeOwner(ChangeOwner changeOwner) throws RuntimeException;

	/**
	 * 查找一条ChangeOwner
	 * @return ChangeOwner
	 * @param id 主键id
	 */
	public ChangeOwner findChangeOwnerById(int id) throws RuntimeException;

	/**
	 * 分页查找ChangeOwner
	 * @param cond 查询条件
	 * @return ChangeOwner列表
	 */
	public List<ChangeOwner> findChangeOwnerPage(ChangeOwnerCond cond) ;

	/**
	 * 查找全部ChangeOwner
	 * @param cond 查询条件
	 * @return ChangeOwner列表
	 */
	public List<ChangeOwner> findChangeOwner(ChangeOwnerCond cond) ;

	/**
	 * 查找符合条件的记录条数ChangeOwner
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findChangeOwnerCount(ChangeOwnerCond cond) ;
}
