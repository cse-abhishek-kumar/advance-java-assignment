package com.employeemanagement.web.mapper;

import com.employeemanagement.web.dto.DepartmentResponseDTO;
import com.employeemanagement.web.dto.EmployeeRequestDTO;
import com.employeemanagement.web.dto.EmployeeResponseDTO;
import com.employeemanagement.web.entity.Department;
import com.employeemanagement.web.entity.Employee;

public class EmployeeMapper {
	public static EmployeeResponseDTO toDTO(Employee e) {
		EmployeeResponseDTO dto = new EmployeeResponseDTO();
		dto.setId(e.getId());
		dto.setFirstName(e.getFirstName());
		dto.setLastName(e.getLastName());
		dto.setEmail(e.getEmail());
		dto.setSalary(e.getSalary());
		
		DepartmentResponseDTO deptDTO = new DepartmentResponseDTO();
		deptDTO.setId(e.getDepartment().getId());
		deptDTO.setName(e.getDepartment().getName());;
		deptDTO.setLocation(e.getDepartment().getLocation());
		
		dto.setDepartment(deptDTO);
		
		return dto;
	}
	
	public static Employee toEntity(EmployeeRequestDTO dto,Department department) {
		Employee emp = new Employee();
		emp.setFirstName(dto.getFirstName());
		emp.setLastName(dto.getLastName());
		emp.setEmail(dto.getEmail());
		emp.setSalary(dto.getSalary());
		emp.setDepartment(department);
		return emp;
	}
}
