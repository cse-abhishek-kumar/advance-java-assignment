package com.employeemanagement.web.mapper;

import com.employeemanagement.web.dto.DepartmentRequestDTO;
import com.employeemanagement.web.dto.DepartmentResponseDTO;
import com.employeemanagement.web.entity.Department;

public class DepartmentMapper {
	public static DepartmentResponseDTO toDTO(Department d) {
		DepartmentResponseDTO dto = new DepartmentResponseDTO();
		
		dto.setId(d.getId());
		dto.setName(d.getName());
		dto.setLocation(d.getLocation());
		
		return dto;
	}
	public static Department toEntity(DepartmentRequestDTO dto) {
		Department dept = new Department();
		dept.setName(dto.getName());
		dept.setLocation(dto.getLocation());
		return dept;
	}
}
