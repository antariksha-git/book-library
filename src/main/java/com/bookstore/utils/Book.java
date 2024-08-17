package com.bookstore.utils;

public class Book {
	int bookid;
	String bookName;
	String price;

	public Book(int bookid, String bookName, String price) {
		this.bookid = bookid;
		this.bookName = bookName;
		this.price = price;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
