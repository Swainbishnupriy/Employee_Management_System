package com.ems.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.config.HibernateUtil;
import com.ems.dao.DepartmentDAO;
import com.ems.entity.Department;
import com.ems.entity.Employee;


public class DepartmentDAOImpl implements DepartmentDAO{

	@Override
	public void saveDepartment(Department dept) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			//add all the new department details
			session.save(dept);
			
			//java object saved to the database
			session.getTransaction().commit();
			
			//clear the session
			session.clear();
		}
		catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Department getDeptUsingId(int id) {
		
		try(Session session=HibernateUtil.getSession())
		{
			Department dept=session.get(Department.class, id);
			return dept;
		}
		catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void assignEmployeeToDept(int employeeId, int deptId) {
		try(Session session=HibernateUtil.getSession())
		{
			Employee emp = session.get(Employee.class, employeeId);
			Department dept = session.get(Department.class, deptId);
			
			List<Employee> employees = new ArrayList<>();
			employees.add(emp);
			
			dept.setEmployees(employees);
			emp.setDept(dept);
			
			dept.setTotalEmp(dept.getTotalEmp()+1);
			
			session.beginTransaction();
			session.saveOrUpdate(dept);
			
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	
	
	
	
	
}
