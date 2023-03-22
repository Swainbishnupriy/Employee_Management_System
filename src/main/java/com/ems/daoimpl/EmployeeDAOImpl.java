package com.ems.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ems.config.HibernateUtil;
import com.ems.dao.EmployeeDAO;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;

public class EmployeeDAOImpl implements EmployeeDAO{

	//this method gets the session to save the new employee details
	@Override
	public void saveEmployee(Employee employee) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			//add all the new employee details
			session.save(employee);
			
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
	public Employee getEmployeeUsingId(int id) {
		try(Session session=HibernateUtil.getSession())
		{
			Employee employee=session.get(Employee.class, id);
			return employee;
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
	public Employee updateEmployee(int id, Employee employee) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			Employee emp=session.get(Employee.class, id);
			
			//updating existing details with the new one
			emp.setEmpName(employee.getEmpName());
			emp.setEmpAddress(employee.getEmpAddress());
			emp.setSalary(employee.getSalary());
			emp.setContact(employee.getContact());
			emp.setEmail(employee.getEmail());
			emp.setDesignation(employee.getDesignation());
			emp.setDOJ(employee.getDOJ());
			emp.setUserName(employee.getUserName());
			emp.setPassword(employee.getPassword());
			
			
			session.saveOrUpdate(emp);
			session.getTransaction().commit();
			
			return emp; //returning employee entity
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void deleteEmployeeById(int id) {
		try(Session session=HibernateUtil.getSession())
		{
			
			Employee employee=session.load(Employee.class, id);
			
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "Do you want to delete?",
					"Are you sure?",JOptionPane.YES_NO_OPTION);
			if(input==0)
			{
				session.delete(employee);
				//session.evict(employee);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "User wants to retain it!");
			}
			session.getTransaction().commit();
			
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		try(Session session=HibernateUtil.getSession())
		{
			String query="from Employee e where e.email=:a";
			Query q =session.createQuery(query);
			q.setParameter("a", email);
			
			Employee emp=(Employee) q.uniqueResult();
			return emp;
		}
		catch(HibernateException e)
		{
		System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	

}
