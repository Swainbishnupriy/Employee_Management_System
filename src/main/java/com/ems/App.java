package com.ems;


import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.service.AdminService;
import com.ems.serviceimpl.AdminServiceImpl;



public class App 
{
	static AdminService adminService = new AdminServiceImpl();
	static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
    	mainMenu();
    }
    
    public static void mainMenu()
    {
    	System.out.println();
    	int ch;
    	do {
        System.out.println("---Welcome to Employee Management System---");
        System.out.println("1) Admin\n2) Employee\n3) Exit");
//        ch = sc.nextInt();
        ch = Integer.parseInt(JOptionPane.showInputDialog("Enter choice: ","Type here"));
        switch(ch)
        {
        case 1:
        	mainAdmin();
        	break;
        case 2:
        	mainUser();
        	break;
        case 3:
        	System.exit(0);
        	break;
        default:
        	System.out.println("Wrong Input!!");	
        }
    	}while(ch!=3);
    }
    
    
    
    //main menu for user/employee
    public static void mainUser()
    {
    	do {
    	System.out.println("---------Employee Menu---------");
      	System.out.println("A) Save new employee\nB) To check employee details using ID\n"
      			+ "C) To check employee details using email\nD) Exit");
      	String choice = JOptionPane.showInputDialog("Enter choice: ","Type here...");
    	switch(choice)
    	{
    	case "A":
    		EmployeeCRUD.saveEmployee();
    		break;
    		
    	case "B":
    		EmployeeCRUD.getEmployee();
    		break;
    	
    	case "C":
    		EmployeeCRUD.getEmployeeByEmail();
    		break;
 
    	case "D":
    		mainMenu();
    		break;
    	}
    	}while(true);
    }
    
    //main menu for admin
    public static void mainAdmin()
    {
    	do {
    	System.out.println("---------Admin Menu---------");
      	System.out.println("A) Save new admin\nB) LogIn\nC) Exit");
      	String choice = JOptionPane.showInputDialog("Enter choice: ","Type here...");
    	switch(choice)
    	{
    	case "A":
    		AdminCRUD.saveAdmin();
    		break;
    		
    	case "B":
    		boolean status=adminService.login(JOptionPane.showInputDialog
    				("Enter user_name:","Type here.."), 
    				JOptionPane.showInputDialog("Enter password:","Type here.."));
    		if(status==true)
    		{
    			AdminCRUD.afterLoginAdmin();
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null, "Wrong Credentials");
    		}
    		break;
    	
    	case "C":
    		mainMenu();
    		break;
    		
    	}
    	}while(true);
    }
    
    
    
}
