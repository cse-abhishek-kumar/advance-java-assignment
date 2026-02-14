/**
 * 
 */
package com.capgemini.departmentManagement;

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
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("deptempPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Department dept = new Department("Testing","Jalandhar");
		em.persist(dept);
		
		
		Employee emp = new Employee("Abhishek","SDE",952222.3,dept);
		Employee emp1 = new Employee("Chandan","SDE2",952242.3,dept);
		Employee emp2 = new Employee("Bhairav","SDE3",952232.3,dept);
		em.persist(emp);
		em.persist(emp1);
		em.persist(emp2);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();

	}

}
