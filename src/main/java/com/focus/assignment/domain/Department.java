package com.focus.assignment.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "DEPARTMENT")
@Entity
@Getter
@Setter
public class Department extends BaseEntity{

	private static final long serialVersionUID = 8734726160147650822L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEPARTMENT_ID", length = 10, insertable = false, updatable = false)
	private String departmentId;
	
	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;
	
	@Column(name = "DEPARTMENT_HEAD")
	private String deparmentHead;
	
	@Column(name = "DEPARTMENT_CODE")
	private String departmentCode;
	
	@OneToMany
	@JoinColumn(name ="DEPT_ID")
	private List<Employee> employees;

}
