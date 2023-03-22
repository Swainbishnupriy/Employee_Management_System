package com.ems.dao;

import com.ems.entity.Department;

public interface DepartmentDAO {
	void saveDepartment(Department dept);
	Department getDeptUsingId(int id);
	void assignEmployeeToDept(int employeeId, int deptId);
}
