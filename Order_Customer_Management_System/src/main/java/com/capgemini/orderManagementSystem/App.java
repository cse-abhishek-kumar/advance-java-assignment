/**
 * 
 */
package com.capgemini.orderManagementSystem;

import java.time.LocalDate;

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
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("orderPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Customer p1 = new Customer();
		p1.setCustomerName("Abhishek");
		p1.setEmail("test@gmsil.com");
		
		em.persist(p1);
		
		Order o1 = new Order();
		o1.setOrderDate(LocalDate.now());
		o1.setTotalAmt(4000);
		o1.setCustomer(p1);
		
		Order o2 = new Order();
		o2.setOrderDate(LocalDate.now().minusDays(1));
		o2.setTotalAmt(5000);
		o2.setCustomer(p1);
		
		em.persist(o1);
		em.persist(o2);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();

	}

}
