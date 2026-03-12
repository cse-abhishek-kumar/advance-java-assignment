package com.employeemanagement.web.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.employeemanagement.web.dto.DepartmentRequestDTO;
import com.employeemanagement.web.dto.DepartmentResponseDTO;
import com.employeemanagement.web.entity.Department;
import com.employeemanagement.web.exception.DepartmentNotFoundException;
import com.employeemanagement.web.mapper.DepartmentMapper;
import com.employeemanagement.web.repository.DepartmentRepository;

@Service
public class DepartmentService {
	private DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}
	
	public DepartmentResponseDTO creatDepartment(DepartmentRequestDTO dto) {
		Department dept = DepartmentMapper.toEntity(dto);
		return DepartmentMapper.toDTO(departmentRepository.save(dept));
	}
	public List<DepartmentResponseDTO> getAllDepartment(){
		return departmentRepository.findAll().stream().map(DepartmentMapper::toDTO).collect(Collectors.toList());
	}
	public DepartmentResponseDTO getDepartmentById(Long id) {
		Department dept = departmentRepository.findById(id).orElseThrow(()->new DepartmentNotFoundException("Department not found"));
		return DepartmentMapper.toDTO(dept);
	}
	public Department getDepartmentEntityById(Long id) {
		return departmentRepository.findById(id).orElseThrow(()->new DepartmentNotFoundException("Department not found"));
	}
	
	
}
