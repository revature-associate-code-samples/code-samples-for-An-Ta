package com.andy.services;

import javax.servlet.http.HttpSession;

import com.andy.dto.Credential;
import com.andy.model.Employee;

public interface IEmployeeService {
	IEmployeeService currentImplamentation = new EmployeeServiceImpl();
	
	Employee findById(int id);
	
	Employee findByUserName(String username);
	Employee findByPassword(String password);

	boolean login(Credential cred, HttpSession session);
}
