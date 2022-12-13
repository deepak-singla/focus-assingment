package com.focus.assignment.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "EMPLOYEE")
@Entity
public class Employee extends BaseEntity {

	private static final long serialVersionUID = 2932045360039813145L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID", unique = true, length = 10, insertable = false, updatable = false)
	private String empId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DOB")
	private LocalDate dob;

	@Column(name = "PAN", length = 10)
	private String pan;

	@Column(name = "address")
	private String address;

	@ManyToOne
	@JoinColumn(name = "DEPT_ID", referencedColumnName = "id")
	private Department department;

}
