package com.fdmgroup.bookregistrationsystem;

import org.mockito.*;
import static org.mockito.Mockito.*;

import javax.persistence.Persistence;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBookRegistrationSystem {
	
	Book book;
	private static BookFactory bookFactory;
	RegistrationController registrationController;
	Dao<Book, String> bookStringDao;
	private static Dao<Book, Long> bookDao;
	
	Book mockBook;
	BookFactory mockBookFactory;
	Dao<Book, String> mockDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookFactory = new BookFactory();
		bookDao = new JPABookDao(Persistence.createEntityManagerFactory("books"));
	}

	@Test
	public void test_BookFactory_WhenCreateBookCalledOnce_ReturnsBookWithMatchingIdToBookFactoryBookId() {
		book = bookFactory.createBook();
		
		assertEquals(BookFactory.getBookId(), book.getBookId());
	}
	
	@Test
	public void test_BookFactory_WhenCreateBookCalledTwice_ReturnsBookWithMatchingIdToBookFactoryBookId() {
		
		book = bookFactory.createBook();
		book = bookFactory.createBook();
		
		assertEquals(BookFactory.getBookId(), book.getBookId());
	}
	
	@Test
	public void test_RegistrationController_WhenRegisterBookCalledWithArguments_BookFactory_CreateBookCalledWithArguments() {
		mockDao = mock(Dao.class);
		mockBookFactory = mock(BookFactory.class);
		registrationController = new RegistrationController(mockBookFactory, mockDao);
		
		registrationController.registerBook("title", "authorName", "genre");
		
		verify(mockBookFactory).createBook("title", "authorName", "genre");
	}
	
	@Test
	public void test_RegistrationController_WhenRegisterBookCalled_Dao_SaveCalled() {
		mockBookFactory = mock(BookFactory.class);
		mockDao = mock(Dao.class);
		registrationController = new RegistrationController(mockBookFactory, mockDao);
		
		registrationController.registerBook("title", "author", "genre");
		
		verify(mockDao).save(mockBookFactory.createBook("title", "author", "genre"));
	}
	
	@Test
	public void test_BookDao_SavesABook() {
		book = new Book(1L, "title", "author", "genre");
		bookStringDao = new BookDao();
		
		bookStringDao.save(book);
		
		assertEquals(book, bookStringDao.read(book.getAuthor()));
	}
	
	@Test
	public void test_JPABookDao_SavesABookToDatabase() {
		book = new Book("title", "author", "genre");
		bookDao.save(book);
		
		assertEquals(book, bookDao.read(book.getBookId()));
	}
	
	

}
