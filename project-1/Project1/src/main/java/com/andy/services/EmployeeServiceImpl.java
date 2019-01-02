package com.andy.services;

import javax.servlet.http.HttpSession;

import com.andy.dao.IEmployeeDao;
import com.andy.dto.Credential;
import com.andy.model.Employee;


public class EmployeeServiceImpl implements IEmployeeService {
	IEmployeeDao employeeDao = IEmployeeDao.currentImplamentation;
	@Override
	public Employee findById(int id) {
		employeeDao.findById(id);
		return null;
	}

	@Override
	public Employee findByUserName(String username) {
		employeeDao.findByUserName(username);
		return null;
	}

	@Override
	public Employee findByPassword(String password) {
		employeeDao.findByPassword(password);
		return null;
	}

	@Override
	public boolean login(Credential cred, HttpSession session) {
		//searching if database has values with given username and password
		Employee employee = employeeDao.findByUsernameAndPassword(cred.getUsername(), cred.getPassword()); // WILL RETURN NULL IF DATABASE DOES NOT HAVE EMPLOYEE WITH USERNAME AND PASSWRD
		
		//employee was found within the database
		if (employee != null) {
			session.setAttribute("role", employee.getRole());		
			session.setAttribute("username", employee.getUsername());
			return true;
		}
		//return false if unable to find an employee
		return false;
	}

}
