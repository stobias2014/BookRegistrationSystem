package com.fdmgroup.bookregistrationsystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity

public class Book {
	
	@Id
	@Column(name = "book_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book")
	@SequenceGenerator(name = "book", sequenceName = "book_seq")
	private long bookId;
	private String title;
	private String author;
	private String genre;
	
	public Book() {}
	
	public Book(long bookId) {
		this.bookId = bookId;
	}

	public Book(long bookId, String title, String author, String genre) {
		this.bookId = bookId;
		this.setTitle(title);
		this.setAuthor(author);
		this.setGenre(genre);
	}

	public Book(String title, String author, String genre) {
		this.title = title;
		this.author = author;
		this.genre = genre;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
