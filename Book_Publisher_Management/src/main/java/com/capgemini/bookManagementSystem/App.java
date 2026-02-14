/**
 * 
 */
package com.capgemini.bookManagementSystem;

import java.util.Arrays;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * 
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookPublisherPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Publisher p1 = new Publisher();
		p1.setPublisherName("Abhishek");
		p1.setLoc("Jalandhar");
		
		Book b1 = new Book();
		b1.setTitle("Java Zero To Hero");
		b1.setPrice(10000);
		b1.setPublisher(p1);
		
		Book b2 = new Book();
		b2.setTitle("C++ Basic");
		b2.setPrice(20000);
		b2.setPublisher(p1);
		
		p1.setListOfBooks(Arrays.asList(b1,b2));
		
		em.persist(p1);
		
		em.getTransaction().commit();
		
		Publisher p = em.find(Publisher.class,1);
		System.out.println("Publisher: "+p.getPublisherName());
		
		for(Book b:p.getListOfBooks()) {
			System.out.println("Book: "+b.getTitle()+" Price: "+b.getPrice());
		}
		
		em.close();
		emf.close();

	}

}
