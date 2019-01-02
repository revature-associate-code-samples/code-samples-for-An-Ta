package com.andy.launchers;

import com.andy.dao.EmployeeJdbc;
import com.andy.dao.ReimbursementJdbc;
import com.andy.model.Reimbursement;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
public class Launcher {

	public static void main(String[] args) {
		
		ReimbursementJdbc jdbc = new ReimbursementJdbc();
		EmployeeJdbc employJdbc = new EmployeeJdbc();
		
//		;
		System.out.println(employJdbc.findByUserName("manager"));
//		System.out.println(jdbc.findAll());
	}

}
