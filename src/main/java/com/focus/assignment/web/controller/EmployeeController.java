package com.focus.assignment.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.focus.assignment.services.EmployeeService;
import com.focus.assignment.web.model.EmployeeDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/api/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("employees")
	public ResponseEntity<List<EmployeeDTO>> listEmployees() {
		List<EmployeeDTO> empDTO = employeeService.getAllEmployess();
		return new ResponseEntity<>(empDTO, HttpStatus.OK);
	}

	@GetMapping("/employee/{empId}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable String empId) {
		log.debug("Finding Employees");
		EmployeeDTO empDTO = employeeService.findEmployeeById(empId);
		return new ResponseEntity<>(empDTO, HttpStatus.OK);
	}

	@PostMapping("/add/employee")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<EmployeeDTO> addNewEmployee(@RequestBody EmployeeDTO empDto) {
		EmployeeDTO empDTO = employeeService.addNewEmployee(empDto);
		return new ResponseEntity<>(empDTO, HttpStatus.OK);
	}

	@PutMapping("/employee/{empId}/update")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<String> updateEmployee(@PathVariable("empId") String empId, @RequestBody EmployeeDTO empDto) {
		employeeService.updateEmployee(empDto);
		return new ResponseEntity<>("Update Sucessfull", HttpStatus.OK);
	}

	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

}
