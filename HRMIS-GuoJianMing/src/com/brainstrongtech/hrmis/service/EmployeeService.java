/**
 * 
 */
package com.brainstrongtech.hrmis.service;

import java.util.List;
import java.util.Set;

import com.brainstrongtech.hrmis.domain.Employee;

/**
 * @author joeyang ong
 *
 */
public interface EmployeeService {
	
	
	void enrollEmployee(Employee emp);
	List<Employee> listEmployee();
	Set<Employee> sortEmployee();
	void rewriteEmployee(List<Employee> emps);


}
