package com.brainstrongtech.hrmis.ui;

import java.util.List;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.exception.HRMISException;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;
import com.brainstrongtech.hrmis.utils.SysUtils;

public class EmployeeDelete implements BaseUI {


	@Override
	public void run() {
		Employee m = null;
		Integer index = null;
		EmployeeService empService = new EmployeeServiceImpl();
		List<Employee> list = empService.listEmployee();
		String enrollCode = null;
		String go = null;
		boolean isContinued = true;

		while (isContinued) {
			System.out.println("Employee Record Deletion:");
			System.out.println("Enter employee's 3 digit payroll number to enable record deletion:");

			try {
				enrollCode = SysUtils.getEntry(false);
				Integer.parseInt(enrollCode);
				for (Employee employee : list) {
					
					if (employee.getPayrollNo().equals(enrollCode)) {
						m = employee;
						index = list.indexOf(employee);
					}
				}

				if (m != null && index != null) {
					System.out.println(m);
					System.out.println("Confirm record deletion,(y)es or (n)o:");
					go = SysUtils.getEntry(false);
					if (go.toUpperCase().charAt(0) == 'Y') {
					    
						 list.remove(index.intValue());
						empService.rewriteEmployee(list);
						System.out.println("Record deleted");
						  System.out.println("=================================");
					        SysUtils.pause("Press any key to return MainMenu...");
					}
				} else
					throw new HRMISException();
				isContinued = false;
			} catch (BlankEntryException e) {
				SysUtils.pause("No payroll number  entered, try again!");
			} catch (NumberFormatException e) {
				System.out.println("Payroll number can contain only numerical characters");
			}catch(HRMISException e){
				System.out.println("Employee record -" + enrollCode+ "- not found");
				SysUtils.pause("Please input again...");
			}

		}

	}
}
