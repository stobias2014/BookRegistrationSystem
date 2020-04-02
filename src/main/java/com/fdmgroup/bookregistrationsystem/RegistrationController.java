package com.fdmgroup.bookregistrationsystem;

public class RegistrationController {

	private BookFactory bookFactory;
	private Dao<Book, String> dao;
	private Book book;

	public RegistrationController(BookFactory bookFactory) {
		this.setBookFactory(bookFactory);
	}

	public RegistrationController(BookFactory bookFactory, Dao<Book, String> dao) {
		this.bookFactory = bookFactory;
		this.setDao(dao);
	}

	public RegistrationController(Book book, BookFactory bookFactory, Dao<Book, String> dao) {
		this.book = book;
		this.bookFactory = bookFactory;
		this.dao = dao;
	}

	public BookFactory getBookFactory() {
		return bookFactory;
	}

	public void setBookFactory(BookFactory bookFactory) {
		this.bookFactory = bookFactory;
	}

	public Dao<Book, String> getDao() {
		return dao;
	}

	public void setDao(Dao<Book, String> dao) {
		this.dao = dao;
	}
	
	public void registerBook(String title, String author, String genre) {
		dao.save(bookFactory.createBook(title, author, genre));
	}

}
