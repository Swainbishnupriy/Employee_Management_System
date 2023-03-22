package com.ems.service;

import com.ems.entity.Employee;
import com.ems.model.EmployeeDTO;

public interface EmployeeService {

	void saveEmployee(Employee employee);
	EmployeeDTO getEmployeeUsingId(int id);
	EmployeeDTO updateEmployee(int id, Employee employee);
	void deleteEmployeeById(int id);
	EmployeeDTO getEmployeeByEmail(String email);
}
