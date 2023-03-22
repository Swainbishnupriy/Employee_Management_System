package com.ems.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dept")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;
	@Column(name="department_name", length=20, nullable = false)
	private String deptName;
	@Column(name="total_employees", length=10)
	private int totalEmp;
	@Column(length = 20)
	private String location;
	
	@OneToMany
	private List<Employee> employees;
}
