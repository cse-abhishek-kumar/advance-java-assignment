package com.employeemanagement.web.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEmployeeNotFound(EmployeeNotFoundException ex, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(),ex.getMessage(),request.getRequestURI());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleDepartmentNotFound(DepartmentNotFoundException ex, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(),ex.getMessage(),request.getRequestURI());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationError(MethodArgumentNotValidException ex, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(),"Validation failed",request.getRequestURI());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
}
