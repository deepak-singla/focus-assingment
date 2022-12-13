package com.focus.assignment.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus.assignment.domain.Employee;
import com.focus.assignment.repositories.EmployeeRepository;
import com.focus.assignment.translations.EmployeeTranslator;
import com.focus.assignment.web.model.EmployeeDTO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeTranslator employeeTranslator;

	@Override
	public List<EmployeeDTO> getAllEmployess() {
		List<Employee> employeeList = employeeRepository.findAll();
		List<EmployeeDTO> employeDTOList  = employeeList.stream()
				.map(obj -> employeeTranslator.translateToDTO(obj))
				.collect(Collectors.toList());
		return employeDTOList;
	}

	@Override
	public EmployeeDTO findEmployeeById(String empId) {
		Employee employeeEntity = employeeRepository.findEmployeeByEmpId(empId);
		return employeeTranslator.translateToDTO(employeeEntity);
	}

	@Override
	public EmployeeDTO addNewEmployee(EmployeeDTO employee) {
		Employee employeeEntity = employeeTranslator.translateToEntity(employee);
		employeeRepository.save(employeeEntity);
		return employee;
	}

	@Override
	public void updateEmployee(EmployeeDTO data) {
		Employee oldEntity = employeeRepository.findEmployeeByEmpId(data.getEmployeeId());
		if(oldEntity == null) {
			throw new RuntimeException();
		}
		
		Employee newEntity = employeeTranslator.translateToEntity(data);
		employeeRepository.save(newEntity);

	}

	@Override
	public void deleteEmployeeById(String empId) {
		Employee oldEntity = employeeRepository.findEmployeeByEmpId(empId);
		if(oldEntity == null) {
			throw new RuntimeException();
		}
		employeeRepository.delete(oldEntity);
	}

}
