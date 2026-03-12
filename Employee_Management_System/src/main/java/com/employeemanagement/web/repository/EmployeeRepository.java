package com.employeemanagement.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagement.web.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByDepartmentName(String name);
	List<Employee> findBySalaryBetween(Double minSal,Double maxSal);
}
