package com.employeemanagement.web.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.web.dto.EmployeeRequestDTO;
import com.employeemanagement.web.dto.EmployeeResponseDTO;
import com.employeemanagement.web.entity.Department;
import com.employeemanagement.web.entity.Employee;
import com.employeemanagement.web.exception.DepartmentNotFoundException;
import com.employeemanagement.web.exception.EmployeeNotFoundException;
import com.employeemanagement.web.mapper.EmployeeMapper;
import com.employeemanagement.web.repository.DepartmentRepository;
import com.employeemanagement.web.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private DepartmentService deptService;
	
	
	
	public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {
		Department dept = departmentRepository.findById(dto.getDepartment()).orElseThrow(()->new DepartmentNotFoundException("Department not found"));
		Employee emp = EmployeeMapper.toEntity(dto, dept);
		return EmployeeMapper.toDTO(employeeRepository.save(emp));
	}
	
	public List<EmployeeResponseDTO> getAllEmployees(){
		return employeeRepository.findAll().stream().map(EmployeeMapper::toDTO).collect(Collectors.toList());
	}
	public EmployeeResponseDTO getEmployeeById(Long id) {
		Employee emp = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found"));
		return EmployeeMapper.toDTO(emp);
	}
	public EmployeeResponseDTO updateEmployee(Long id,EmployeeRequestDTO dto) {
		Employee emp = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found"));
		Department dept = deptService.getDepartmentEntityById(dto.getDepartment());
		emp.setFirstName(dto.getFirstName());
		emp.setLastName(dto.getLastName());
		emp.setEmail(dto.getEmail());
		emp.setSalary(dto.getSalary());
		emp.setDepartment(dept);
		return EmployeeMapper.toDTO(employeeRepository.save(emp));
				
	}
	public void deleteEmployee(Long id) {
		if(!employeeRepository.existsById(id)) {
			throw new EmployeeNotFoundException("Employee not found");
		}
		employeeRepository.deleteById(id);
	}
}
