package com.dou.book.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dou.book.data.ISBookMapper;
import com.dou.book.data.pojo.SBook;
import com.dou.book.data.services.ISBookServices;

@Service("bookServices")
@SuppressWarnings("unchecked")
public class SBookServices implements ISBookServices {
	@Autowired	 ISBookMapper bookMapper;


	public List findAllBook() throws RuntimeException {
		return bookMapper.findAllBook();
	}

/*	public SBook getBookByISBN(String isbn) throws RuntimeException {
		return sbookMapper.findBookByISBN(isbn);
	}
*/
	/*public List<SBook> getBooksByPublisher(String publisher)
			throws RuntimeException {
		return sbookMapper.findBooksByPublisher(publisher);
	}
*/
	public void removeBook(int id) throws RuntimeException {
		bookMapper.deleteBook(id);
	}

	public void saveBook(SBook book) throws RuntimeException {
		bookMapper.saveBook(book);
	}

	@Override
	public SBook getBookById(int id) throws RuntimeException {
		return bookMapper.findBookById(id);
	}

	@Override
	public void updateBook(SBook book) throws RuntimeException {
		bookMapper.updateBook(book);
		
	}


	//public  void deleteBook(int book) throws RuntimeException {
		//bookMapper.deleteBook(book);
	//}

	/*public void updateBook(SBook book) throws RuntimeException {
		sbookMapper.updateBook(book);
	}*/

	/*public SBook getBookById(int id) throws RuntimeException {
		return sbookMapper.findBookById(id);
	}*/



}
