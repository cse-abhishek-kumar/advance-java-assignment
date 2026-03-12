package com.employeemanagement.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.web.dto.EmployeeRequestDTO;
import com.employeemanagement.web.dto.EmployeeResponseDTO;
import com.employeemanagement.web.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeResponseDTO> addEmployee(@Valid @RequestBody EmployeeRequestDTO dto){
		return ResponseEntity.ok(employeeService.createEmployee(dto));
	}
	
	@GetMapping
	public List<EmployeeResponseDTO> getEmployees(){
		return employeeService.getAllEmployees();
	}
}
