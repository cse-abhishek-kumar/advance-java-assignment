/**
 * 
 */
package com.capgemini.lockerManagement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * 
 */
public class App {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("empLockerPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Locker locker = new Locker("L101",2);
		em.persist(locker);
		
		Employee employee = new Employee("Rahul","IT",locker);
		em.persist(employee);
		
		em.getTransaction().commit();
		
		Employee fetched = em.find(Employee.class, employee.getId());
		System.out.println("Employee Name: "+fetched.getName());
		System.out.println("Locker: "+fetched.getId());
		
		
		em.close();
		emf.close();

	}
}
