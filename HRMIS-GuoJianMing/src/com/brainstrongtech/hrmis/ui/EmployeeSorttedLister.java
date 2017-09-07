/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * @author joeyang ong
 *
 */
public class EmployeeSorttedLister implements BaseUI {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#run()
	 */
	@Override
	public void run() {
		
		System.out.println("employee sort and formatted out!");
		System.out.println("==============================================================================================================================================================");

		EmployeeService empService = new EmployeeServiceImpl();
		for(Employee emp:empService.sortEmployee()){
			emp.formattedPrint();
		}
		System.out.println();
		System.out.println("==============================================================================================================================================================");

		SysUtils.pause("Press any key to return MainMenu...");
	 
	}

}
