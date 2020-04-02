package com.fdmgroup.bookregistrationsystem;

import java.util.HashMap;
import java.util.Map;

public class BookDao implements Dao<Book, String> {
	
	Map <String, Book> bookMap = new HashMap<>();

	@Override
	public void save(Book book) {
		bookMap.put(book.getAuthor(), book);
	}

	@Override
	public Book read(String author) {
		Book book = bookMap.get(author);
		return book;
	}

}
