package com.dou.book.data;

import java.util.List;

import com.dou.book.data.pojo.SBook;

/**
 *  SBook(书本)的Mapper数据访问接口
 * @author peter.kuang
 *
 */
public interface ISBookMapper {

	/**
	 * 新增SBook(书本)
	 * @param book
	 */
	public void saveBook(SBook book) ;

	/**
	 * 删除SBook(书本)
	 * @param id
	 * @throws RuntimeException
	 */
	public void deleteBook(int id) throws RuntimeException;

	/**
	 * 修改SBook(书本)
	 * @param book
	 * @throws RuntimeException
	 */
	public void updateBook(SBook book) throws RuntimeException;

	/**
	 * 查找全部SBook(书本)
	 * @return
	 */
	public List<SBook> findAllBook() ;

	/**
	 * 根据id查找一个SBook(书本)
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public SBook findBookById(int id) throws RuntimeException;
}
