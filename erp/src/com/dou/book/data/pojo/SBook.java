package com.dou.book.data.pojo;

import java.sql.Date;

/**
 * SBook的实体类
 * @author peter.kuang
 *
 */
public class SBook {
	private int id;
	private String title;
	private String author;
	private int total;
	private float price;
	private String isbn;
	private String publisher;
	//private Date createdate;

	/**
	 * 取得id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getPrice(){
		return price;
	}

	
	public SBook(){};

	/**
	 * 
	 * @param id
	 * @param title
	 * @param author
	 * @param total
	 * @param price
	 * @param isbn
	 * @param publisher
	 */
	public SBook(int id, String title, String author, int total, float price,
			String isbn, String publisher) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.total = total;
		this.price = price;
		this.isbn = isbn;
		this.publisher = publisher;
		
	}
	public SBook( String title, String author, int total, float price,
			String isbn, String publisher) {
		super();		
		this.title = title;
		this.author = author;
		this.total = total;
		this.price = price;
		this.isbn = isbn;
		this.publisher = publisher;		
	}
}


