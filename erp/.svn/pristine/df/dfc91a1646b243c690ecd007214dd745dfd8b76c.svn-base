package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.ChangeOut;
import com.ihk.saleunit.data.pojo.ChangeOutCond;

/**
 * ChangeOut数据访问接口Mapper
 * @author 
 *
 */ 
public interface IChangeOutMapper {

	/**
	 * 新增ChangeOut
	 * @param changeOut
	 */
	public void addChangeOut(ChangeOut changeOut) ;

	/**
	 * 根据条件删除ChangeOut
	 * @param cond 删除条件
	 */
	public void deleteChangeOut(int id) throws RuntimeException;

	/**
	 * 修改ChangeOut
	 * @param changeOut
	 */
	public void updateChangeOut(ChangeOut changeOut) throws RuntimeException;

	/**
	 * 查找一条ChangeOut
	 * @return ChangeOut
	 * @param id 主键id
	 */
	public ChangeOut findChangeOutById(int id) throws RuntimeException;

	/**
	 * 分页查找ChangeOut
	 * @param cond 查询条件
	 * @return ChangeOut列表
	 */
	public List<ChangeOut> findChangeOutPage(ChangeOutCond cond) ;

	/**
	 * 查找全部ChangeOut
	 * @param cond 查询条件
	 * @return ChangeOut列表
	 */
	public List<ChangeOut> findChangeOut(ChangeOutCond cond) ;

	/**
	 * 查找符合条件的记录条数ChangeOut
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findChangeOutCount(ChangeOutCond cond) ;
}
