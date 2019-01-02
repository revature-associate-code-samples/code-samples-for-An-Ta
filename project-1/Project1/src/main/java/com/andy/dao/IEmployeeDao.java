package com.andy.dao;

import java.util.List;

import com.andy.model.Employee;

public interface IEmployeeDao {
	IEmployeeDao currentImplamentation = new EmployeeJdbc();
	
	Employee findById(int id);
	
	Employee findByUserName(String username);
	Employee findByPassword(String password);

	Employee findByUsernameAndPassword(String username, String password);
	
}
