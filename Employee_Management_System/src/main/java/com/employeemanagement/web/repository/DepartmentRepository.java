package com.employeemanagement.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagement.web.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
