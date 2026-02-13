/**
 * 
 */
package com.capgemini.logintest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.capgemini.login.Student;
import com.capgemini.login.StudentServices;

/**
 * 
 */
public class StudentServicesTest {
	Student student=new Student(101,"Rahul",80,90,40);
	
	@Test
	void result() {
		assertEquals(210, StudentServices.calculateTotal(student));
	}
	@Test
	void passed() {
		assertTrue(StudentServices.isPassed(student));
	}
}

