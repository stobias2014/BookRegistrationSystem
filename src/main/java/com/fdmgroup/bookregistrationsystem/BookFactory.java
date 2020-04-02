package com.fdmgroup.bookregistrationsystem;

public class BookFactory {
	
	private static long bookId;
	
	public static long getBookId() {
		return bookId;
	}

	public static void setBookId(long bookId) {
		BookFactory.bookId = bookId;
	}

	public Book createBook() {
		bookId++;
		Book book = new Book(bookId);
		return book;
	}

	public Book createBook(String title, String author, String genre) {
		bookId++;
		Book book = new Book(bookId, title, author, genre);
		
		return book;
		
	}

}
