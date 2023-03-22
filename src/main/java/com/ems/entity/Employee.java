package com.ems.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee extends User{

	@Column(length=30, nullable = false)
	private String empName;
	@Column(length=30, nullable = false)
	private String empAddress;
	@Column(length=20, nullable = false)
	private double salary;
	@Column(length=10, nullable = false)
	private String contact;
	@Column(length=50, nullable = false, unique = true)
	private String email;
	@Column(length=30, nullable = false)
	private String designation;
	@Column(nullable = false)
	private LocalDate DOJ;
	
	@ManyToOne
	private Department dept;

	@Builder
	public Employee(int id, String userName, String password, String role, String empName, String empAddress,
			double salary, String contact, String email, String designation, LocalDate dOJ) {
		super(id, userName, password, role);
		this.empName = empName;
		this.empAddress = empAddress;
		this.salary = salary;
		this.contact = contact;
		this.email = email;
		this.designation = designation;
		DOJ = dOJ;
	}
	
	
}
