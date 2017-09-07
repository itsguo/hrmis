/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;
import com.brainstrongtech.hrmis.utils.CheckUtils;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * @author guo jian ming
 *
 */
public class EmployeeEnroller implements BaseUI {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#run()
	 */
	@Override
	public void run() {
        EmployeeService empService = new EmployeeServiceImpl();
        String go;
        do{
        System.out.println("=======================");
		System.out.println("employee enroll here!");
        Employee emp = new Employee();
		emp.setPayrollNo(CheckUtils.checkEnrollCode());
        emp.setTelephoneNum(CheckUtils.checkEnrollPhoneNum());
        emp.setLastName(CheckUtils.checkENrollLastName());
        emp.setFirstName(CheckUtils.checkENrollFirstName());
        emp.setInitial(CheckUtils.checkENrollInitial());
        emp.setDeptNo(CheckUtils.checkENrollDeptNo());
        emp.setJobTitle(CheckUtils.checkENrollJobTitle());
        emp.setHiringDate(CheckUtils.checkENrollDate());
        empService.enrollEmployee(emp);
        System.out.println("==================");
        System.out.println("Record Saved");
        System.out.println("Add another employee record?(y)es or (n)o:");  
        go=SysUtils.getEntry(false);
        }while(go.toUpperCase().charAt(0)=='Y');
        
	}
	}
	
	
	