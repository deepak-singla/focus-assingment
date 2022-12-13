package com.focus.assignment.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.focus.assignment.domain.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
	
	Department findDepartmentByDepartmentCode(String Code);

}
