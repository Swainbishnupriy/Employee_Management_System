package com.ems;

import javax.swing.JOptionPane;

import com.ems.entity.Admin;
import com.ems.service.AdminService;
import com.ems.serviceimpl.AdminServiceImpl;

public class AdminCRUD {

	static AdminService adminService = new AdminServiceImpl();
	
	public static void saveAdmin()
	{
		Admin admin = new Admin();
		String name = JOptionPane.showInputDialog("Enter admin name:","Type here..");
		String email = JOptionPane.showInputDialog("Enter email:","Type here..");
		String user = JOptionPane.showInputDialog("Enter user_name:","Type here..");
		String pass = JOptionPane.showInputDialog("Enter password:","Type here..");
		
		admin.setAdminName(name);
		admin.setAdminEmail(email);
		admin.setUserName(user);
		admin.setPassword(pass);
		admin.setRole("admin");
		
		adminService.saveAdmin(admin);
		System.out.println("New admin details has been added!");
		
	}
	
	public static void login()
	{
//		String user = JOptionPane.showInputDialog("Enter user_name:","Type here..");
//		String pass = JOptionPane.showInputDialog("Enter password:","Type here..");
		
		adminService.login(JOptionPane.showInputDialog("Enter user_name:","Type here.."), 
				JOptionPane.showInputDialog("Enter password:","Type here.."));
	}
	
	public static void afterLoginAdmin()
    {
		do {
    	System.out.println();
      	System.out.println("A) Save new department\nB) To check department details using ID\n"
      			+ "C) Assign employee to department\nD) To update employee details\n"
      			+ "E) To delete an employee\nF) Exit");
      	String choice = JOptionPane.showInputDialog("Enter choice: ","Type here...");
    	switch(choice)
    	{
    	case "A":
    		DepartmentCRUD.addDepartment();
    		break;
    		
    	case "B":
    		DepartmentCRUD.getDepartment();
    		break;
    	
    	case "C":
    		DepartmentCRUD.assign();
    		break;
    		
    	case "D":
    		EmployeeCRUD.updateEmployee();
    		break;
    		
    	case "E":
    		EmployeeCRUD.deleteEmployee();
    		break;
    		
    	case "F":
    		App.mainAdmin();
    		break;
    	}
		}while(true);
    }
}
