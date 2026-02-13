/**
 * 
 */
package com.capgemini.AccountManagementSystem;


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
		
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("AccountManagement");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Account account = new Account("ACC12345","Saving");
		Customer customer = new Customer("John Dae",account);
		
		account.setCustomer(customer);
		em.persist(customer);
		
		em.getTransaction().commit();
		System.out.println("Customer Added in database");
	}

}
