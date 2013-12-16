package com.dou.book.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dou.book.data.pojo.SBook;

@Transactional 
@SuppressWarnings("unchecked")
public interface ISBookServices {
	public void saveBook(SBook book) throws RuntimeException;

	public void removeBook(int id) throws RuntimeException;

	//public List<SBook> getBooksByPublisher(String publisher)
	//		throws RuntimeException;

//	public SBook getBookByISBN(String isbn) throws RuntimeException;

	public void updateBook(SBook book) throws RuntimeException;

	public List findAllBook() throws RuntimeException;


	public SBook getBookById(int id) throws RuntimeException;
	//public void deleteBook(int book) throws RuntimeException;
}
