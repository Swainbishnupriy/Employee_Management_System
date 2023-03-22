package com.ems;

import javax.swing.JOptionPane;

import com.ems.entity.Department;
import com.ems.exception.GlobalException;
import com.ems.model.DepartmentDTO;
import com.ems.model.EmployeeDTO;
import com.ems.service.DepartmentService;
import com.ems.serviceimpl.DepartmentServiceImpl;

public class DepartmentCRUD {
	
	static DepartmentService deptService = new DepartmentServiceImpl();
	
	public static void addDepartment()
	{
		Department dept = new Department();
		String deptName = JOptionPane.showInputDialog("Enter dept. name:","Type here..");
		int total = Integer.parseInt(JOptionPane.showInputDialog("Enter total employees:","Type here.."));
		String loc = JOptionPane.showInputDialog("Enter location:","Type here..");
		
		dept.setDeptName(deptName);
		dept.setTotalEmp(total);
		dept.setLocation(loc);
		
		deptService.saveDepartment(dept);
		System.out.println("New department details added!!");
	}
	
	public static void getDepartment() throws GlobalException
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
		DepartmentDTO dept1= deptService.getDeptUsingId(id);
		
		System.out.println("Department Name: "+dept1.getDeptName());
		System.out.println("Department Location: "+dept1.getLocation());
		System.out.println("Total employees: "+dept1.getTotalEmp());
		System.out.println("==============================");
		
		
	}
	
	public static void assign()
	{
		int deptId = Integer.parseInt(JOptionPane.showInputDialog("Enter dept. id:","Type here.."));
		int empId = Integer.parseInt(JOptionPane.showInputDialog("Enter employee id:","Type here.."));
		deptService.assignEmployeeToDept(empId, deptId);
		JOptionPane.showMessageDialog(null, "Employee has been assigned successfully!!");
	}
}
