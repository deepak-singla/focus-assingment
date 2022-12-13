package com.focus.assignment.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
	
	private String employeeId;
	
	private String name;
	
	private String dob;
	
	private String pan;
	
	private String address;
	
	private String departmentCode;  

}
