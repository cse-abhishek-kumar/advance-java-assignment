package com.employeemanagement.web.exception;

public class DepartmentNotFoundException extends RuntimeException{
	public DepartmentNotFoundException(String msg) {
		super(msg);
	}
}
