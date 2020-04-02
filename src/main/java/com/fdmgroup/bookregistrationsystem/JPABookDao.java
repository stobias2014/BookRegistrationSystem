package com.fdmgroup.bookregistrationsystem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class JPABookDao implements Dao<Book, Long> {
	
	private EntityManagerFactory emf;

	public JPABookDao(EntityManagerFactory emf) {
		this.setEmf(emf);
	}
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void save(Book book) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Book read(Long id) {
		EntityManager em = emf.createEntityManager();
		Book book = em.find(Book.class, id);
		return book;
	}



}
