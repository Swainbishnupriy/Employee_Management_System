package com.ems.serviceimpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ems.dao.EmployeeDAO;
import com.ems.daoimpl.EmployeeDAOImpl;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	//logger used to keep track of records
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	//accessing the Data Access Layer(DAO) to call the methods
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	//method to save details of an employee
	@Override
	public void saveEmployee(Employee employee) {
		logger.info("New employee details added!! "+employee.toString());
		employeeDAO.saveEmployee(employee);
	}

	//method to get details using employee id
	@Override
	public EmployeeDTO getEmployeeUsingId(int id) {
		Employee employee=employeeDAO.getEmployeeUsingId(id);
		if(employee!=null)
		{
			logger.info("Employee with id "+id+" was retrieved at "+new Date());
			return new ModelMapper().map(employee, EmployeeDTO.class);
		}
		else
			logger.error("Employee with id "+id+" was not found!");
			throw new GlobalException("Employee details not found!!");
	}

	//method to update the details of an employee using id
	@Override
	public EmployeeDTO updateEmployee(int id, Employee employee) {
		Employee emp =employeeDAO.updateEmployee(id, employee);
		if(emp!=null)
		{
			return new ModelMapper().map(emp, EmployeeDTO.class);
		}
		else
			throw new GlobalException("Employee with id "+id+" not found!!");
	}

	//method to delete an employee using id
	@Override
	public void deleteEmployeeById(int id) {
		employeeDAO.deleteEmployeeById(id);
		
	}

	//method to fetch details of an employee using email address
	@Override
	public EmployeeDTO getEmployeeByEmail(String email) {
		Employee emp=employeeDAO.getEmployeeByEmail(email);
		if(emp!=null)
		{
			return new ModelMapper().map(emp, EmployeeDTO.class);
		}
		else
			throw new GlobalException("Employee with email "+email+" not found!!");
	}

}
