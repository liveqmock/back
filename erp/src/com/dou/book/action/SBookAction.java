package com.dou.book.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.dou.book.data.pojo.SBook;
import com.dou.book.data.services.ISBookServices;

import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.user.data.pojo.UserAccount;

import org.apache.log4j.Logger;  
import java.text.SimpleDateFormat;

/**
 * SBook(书籍)对应的页面Action
 * @author peter.kuang
 *
 */
@SuppressWarnings("unchecked")
public class SBookAction {
	@Autowired
	ISBookServices bookServices;
	//@Autowired
	private SBook sbook;
	private String tips;
	private String bookId;
	private List bookList;
	private String Id ;
	
	@Autowired
	IUserAccountServices userAccountServices;
	
	private static Logger logger = Logger.getLogger(SBookAction.class);

	/**
	 * 添加书本
	 * @return action结果
	 */
	public String addSBook() {
		String result = "error";
		try {
			bookServices.saveBook(sbook);
			this.setTips("add-ok");
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("system error");
		}
		return result;
	}

	public String viewSBook() {      
		String result = "error";
		try {
			bookList = bookServices.findAllBook();
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("system error,please wait");
		}
		return result;
	}

	public String modifySBook() {
		String result = "error";
		System.out.println("bookID:"+bookId);
		try {
			sbook = bookServices.getBookById(Integer
					.parseInt(this.getBookId()));
			System.out.println("title:"+sbook.getTitle());
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("system error");
		}
		return result;
	}

	public String updateSBook() {
		String result = "error";
		try {
			bookServices.updateBook(sbook);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("update error");
		}
		return result;
	}
	
	public String removeSBook() {
		String result = "error";
		System.out.println("id:"+this.getBookId());
		try {
			bookServices.removeBook(Integer.parseInt(this.getBookId()));
			System.out.println("id:"+this.getBookId());
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("delete error");
		}
		return result;
	}

	public SBook getSbook() {
		return sbook;
	}

	public void setSbook(SBook sbook) {
		this.sbook = sbook;
	}

	public List getBookList() {
		return bookList;
	}

	public void setBookList(List bookList) {
		this.bookList = bookList;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getBookId() {
		return bookId;
	}

	/**
	 * 设置书本id
	 * @param bookId 书本id
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}
	
}
