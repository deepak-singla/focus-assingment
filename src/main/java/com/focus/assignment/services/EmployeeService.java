package com.focus.assignment.services;

import java.util.List;

import com.focus.assignment.web.model.EmployeeDTO;

public interface EmployeeService {
	
	List<EmployeeDTO> getAllEmployess();
	
	EmployeeDTO findEmployeeById(String empId);
	
	EmployeeDTO addNewEmployee(EmployeeDTO employee);
	
	void updateEmployee(EmployeeDTO data);
	
	void deleteEmployeeById(String empId);
	
	

}
