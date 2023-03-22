package com.ems.dao;

import com.ems.entity.Employee;

public interface EmployeeDAO {

	void saveEmployee(Employee employee);
	Employee getEmployeeUsingId(int id);
	Employee updateEmployee(int id, Employee employee);
	void deleteEmployeeById(int id);
	Employee getEmployeeByEmail(String email);
}
