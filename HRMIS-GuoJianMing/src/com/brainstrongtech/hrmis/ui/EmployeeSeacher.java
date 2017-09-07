package com.brainstrongtech.hrmis.ui;

import java.util.List;
import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.exception.HRMISException;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;
import com.brainstrongtech.hrmis.utils.SysUtils;

public class EmployeeSeacher implements BaseUI {
    Employee e=null;
	@Override
	public void run() {
		
		EmployeeService empService = new EmployeeServiceImpl();
		List<Employee> list=empService.listEmployee();
		String enrollCode = null;
		boolean isContinued = true;
		
		while(isContinued){
			System.out.println("=======================");
			System.out.println("Enter keyword:");
	
		  
		  try{
		    enrollCode = SysUtils.getEntry(false);
		    for (Employee employee : list) {
				if(employee.getLastName().toUpperCase().equals(enrollCode.toUpperCase())){
					e=employee;
				}
				}
			
	        if(e!=null){e.normalPrint(); 
	        System.out.println("=================================");
	        SysUtils.pause("Press any key to return MainMenu...");
	        }
	        else throw new HRMISException();  
	         
		    isContinued = false;
		  }catch(BlankEntryException e){
			 SysUtils.pause("No keyword entered, try again!"); 
		  }catch(HRMISException e){
			  System.out.println("Keyword -"+enrollCode+"- not found");
			  SysUtils.pause("Press any key to return Search...");
		  }
			
            
	}
	}
}
