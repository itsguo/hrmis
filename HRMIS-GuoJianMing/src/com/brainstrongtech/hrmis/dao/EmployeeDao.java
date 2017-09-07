/**
 * 
 */
package com.brainstrongtech.hrmis.dao;

import java.util.List;
import java.util.Set;

import com.brainstrongtech.hrmis.domain.Employee;

/**
 * @author guo jian ming
 *
 */
public interface EmployeeDao {
    List<Employee> loadEmps();
	Set<Employee> sortEmps();
	void addEmps(Employee emp);
	void rewriteEmps(List<Employee> emps);
}
