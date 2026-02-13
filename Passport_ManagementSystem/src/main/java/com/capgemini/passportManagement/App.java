/**
 * 
 */
package com.capgemini.passportManagement;

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
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("personPassportPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Person person =new Person();
		person.setName("Abhishek");
		person.setDob(LocalDate.of(2004, 6, 8));
		
		Passport passport = new Passport();
		passport.setPassportNumber("IND123456");
		passport.setIssueDate(LocalDate.now());
		passport.setExpiryDate(LocalDate.now().plusYears(10));
		person.setPassport(passport);
		passport.setPerson(person);
		
		em.persist(person);
		em.getTransaction().commit();
		
		em.close();
		emf.close();

	}

}
