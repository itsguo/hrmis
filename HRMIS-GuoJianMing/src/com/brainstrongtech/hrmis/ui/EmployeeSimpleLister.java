package com.brainstrongtech.hrmis.ui;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;
import com.brainstrongtech.hrmis.utils.SysUtils;

public class EmployeeSimpleLister implements BaseUI{

	@Override
	public void run() {
		System.out.println("=========================================================================================");
		EmployeeService empService = new EmployeeServiceImpl();
		for(Employee emp: empService.listEmployee()){
			emp.simplePrint();
		}
		System.out.println();
		System.out.println("=========================================================================================");
		SysUtils.pause("Press any key to return MainMenu...");
	
	}
	

}
