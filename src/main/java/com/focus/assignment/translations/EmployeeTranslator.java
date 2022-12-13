package com.focus.assignment.translations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.focus.assignment.domain.Department;
import com.focus.assignment.domain.Employee;
import com.focus.assignment.repositories.DepartmentRepository;
import com.focus.assignment.utils.CommonUtills;
import com.focus.assignment.web.model.EmployeeDTO;

@Component
public class EmployeeTranslator {

	@Autowired
	private DepartmentRepository departmentRepository;

	public EmployeeDTO translateToDTO(Employee entity) {
		
		return EmployeeDTO.builder().pan(entity.getPan()).address(entity.getAddress())
				.dob(CommonUtills.transformToString(entity.getDob())).employeeId(entity.getEmpId())
				.departmentCode(entity.getDepartment().getDepartmentCode())
				.name(entity.getName()).build();

	}

	public Employee translateToEntity(EmployeeDTO employeeDTO) {
		Department departmet  = departmentRepository
				.findDepartmentByDepartmentCode(employeeDTO.getDepartmentCode());
		Employee emp = new Employee();
		emp.setAddress(employeeDTO.getAddress());
		emp.setDob(CommonUtills.transformToLocalDate(employeeDTO.getDob()));
		emp.setEmpId(employeeDTO.getEmployeeId());
		emp.setName(employeeDTO.getName());
		emp.setPan(employeeDTO.getPan());
		emp.setVersion(1l);
		emp.setDepartment(departmet);

		return emp;

	}

}
