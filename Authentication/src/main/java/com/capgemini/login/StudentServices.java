/**
 * 
 */
package com.capgemini.login;

/**
 * 
 */
public class StudentServices {
	
	public static int calculateTotal(Student student) {
		return student.getMarks1()
				+student.getMarks2()
				+student.getMarks3();
	}
	
	public static double calculateAverage(Student student) {
		int total = calculateTotal(student);
		return total/3.0;
	}
	
	public static boolean isPassed(Student student) {
		return calculateAverage(student)>=40;
	}
}
