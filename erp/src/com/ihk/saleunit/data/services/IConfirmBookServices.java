package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.ConfirmBookCond;

/**
 * ConfirmBook的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IConfirmBookServices {
	/**
	 * 新增ConfirmBook
	 * @param confirmBook
	 */
	public void addConfirmBook(ConfirmBook confirmBook) throws RuntimeException;

	/**
	 * 删除一条ConfirmBook
	 * @param id
	 */
	public void deleteConfirmBook(int id) throws RuntimeException;

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
	public List<ConfirmBook> findConfirmBookPage(ConfirmBookCond cond) throws RuntimeException;

	/**
	 * 查找全部ConfirmBook
	 * @param cond 查询条件
	 * @return ConfirmBook列表
	 */
	public List<ConfirmBook> findConfirmBook(ConfirmBookCond cond) throws RuntimeException;
	
	/**
	 * 根据unitId查找
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public ConfirmBook findConfirmBookByUnitId(int unitId) throws RuntimeException;
	
	public ConfirmBook findConfirmBookByUnitIdIncludeIsDeleted(int unitId) throws RuntimeException; //根据单元id获取对应的临订,正确只有一条,包括删除的
	
	public void updateConfirmBookBefore(ConfirmBook confirmBook) throws RuntimeException;
}