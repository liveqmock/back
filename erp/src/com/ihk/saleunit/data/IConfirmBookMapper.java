package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.ConfirmBookCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * ConfirmBook数据访问接口Mapper
 * @author 
 *
 */ 
public interface IConfirmBookMapper {

	/**
	 * 新增ConfirmBook
	 * @param confirmBook
	 */
	public void addConfirmBook(ConfirmBook confirmBook) ;

	/**
	 * 根据条件删除ConfirmBook
	 * @param cond 删除条件
	 */
	public void deleteConfirmBook(PojoDeleteCond cond) throws RuntimeException;

	/**
	 * 修改ConfirmBook
	 * @param confirmBook
	 */
	public void updateConfirmBook(ConfirmBook confirmBook) throws RuntimeException;

	/**
	 * 查找一条ConfirmBook
	 * @return ConfirmBook
	 * @param id 主键id
	 */
	public ConfirmBook findConfirmBookById(int id) throws RuntimeException;

	/**
	 * 分页查找ConfirmBook
	 * @param cond 查询条件
	 * @return ConfirmBook列表
	 */
	public List<ConfirmBook> findConfirmBookPage(ConfirmBookCond cond) ;

	/**
	 * 查找全部ConfirmBook
	 * @param cond 查询条件
	 * @return ConfirmBook列表
	 */
	public List<ConfirmBook> findConfirmBook(ConfirmBookCond cond) ;

	/**
	 * 查找符合条件的记录条数ConfirmBook
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findConfirmBookCount(ConfirmBookCond cond) ;
	
	/**
	 * 根据unitId查找
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public ConfirmBook findConfirmBookByUnitId(int unitId) throws RuntimeException;
	
	/**
	 * 查找临订,根据unitId,包括已删除的
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public ConfirmBook findConfirmBookByUnitIdIncludeIsDeleted(int unitId) throws RuntimeException;
	
	/**
	 * 重置一条临订
	 */
	
	public void updateConfirmBookBefore(ConfirmBook confirmBook) throws RuntimeException;
}
