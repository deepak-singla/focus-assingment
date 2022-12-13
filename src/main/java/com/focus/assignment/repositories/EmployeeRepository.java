package com.focus.assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.focus.assignment.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	Employee findEmployeeByEmpId(String empId);
	
	Employee deleteByEmpId(String empId);

}
