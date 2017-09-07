package com.brainstrongtech.hrmis.ui;

import java.util.List;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.exception.HRMISException;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;
import com.brainstrongtech.hrmis.utils.CheckUtils;
import com.brainstrongtech.hrmis.utils.SysUtils;

public class EmployeeUpdate implements BaseUI {

	@Override
	public void run() {
		Integer index = null;
		EmployeeService empService = new EmployeeServiceImpl();
		List<Employee> list = empService.listEmployee();
		String enrollCode = null;
		boolean isContinued = true;
		Boolean s=true;

		while (isContinued) {
			System.out.println("Employee Record Update:");
			System.out.println("Enter employee's 3 digit payroll number to enable record update:");

			try {
				enrollCode = SysUtils.getEntry(false);
				Integer.parseInt(enrollCode);
				for (Employee employee : list) {
					
					if (employee.getPayrollNo().equals(enrollCode)) {
					   index=list.indexOf(employee);
					   System.out.println("该员工信息如下：");
					   System.out.println(employee);
					   while(s){
					   System.out.println("====================================");
						System.out.println("Please Choose Modified");
						System.out.println("1 - TelephoneNum");
						System.out.println("2 – LastName");
						System.out.println("3 – FirstName");
						System.out.println("4 – Initial");
						System.out.println("5 - DeptNo");
						System.out.println("6 - JobTitle");
						System.out.println("7 – HiringDate");
					   
					    
						try{
							
					           String entry = SysUtils.getEntry(false);
					           switch(entry.toUpperCase().charAt(0)){
					             case '1': 
					            	 employee.setTelephoneNum(CheckUtils.checkEnrollPhoneNum());
					               break;
					             case '2': 
					            	 employee.setLastName( CheckUtils.checkENrollLastName());        
					               break;
					             case '3': 
					            	 employee.setFirstName( CheckUtils.checkENrollFirstName());
					               break;
					             case '4': 
					            	 employee.setInitial(CheckUtils.checkENrollInitial());	 
					               break;
					             case '5':
					            	 employee.setDeptNo(CheckUtils.checkENrollDeptNo()); 
					            	 break;
					             case '6': 
					            	 employee.setJobTitle(CheckUtils.checkENrollJobTitle());
					               break;
					             case '7': 
					            	 employee.setHiringDate(CheckUtils.checkENrollDate());
					            	 break;
						         default:			
					               SysUtils.pause("Invalid Code, please enter to continue....");
					               continue;
						          
					           }
			                    
							}catch(BlankEntryException e){
				               SysUtils.pause("No selection entered. Please enter to continue....");
				               continue;
							}catch(HRMISException e){
								System.out.println(e.getMessage());
							}
						s=false;
					    }
					}
				}

				if (index != null) {
					empService.rewriteEmployee(list);
					System.out.println("修改成功！");
					SysUtils.pause("Press any key to return MainMenu...");
					
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
