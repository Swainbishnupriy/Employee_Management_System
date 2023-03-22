package com.ems.service;

import com.ems.entity.Department;
import com.ems.model.DepartmentDTO;

public interface DepartmentService {
	
	void saveDepartment(Department dept);
	DepartmentDTO getDeptUsingId(int id);
	void assignEmployeeToDept(int employeeId, int deptId);
}
