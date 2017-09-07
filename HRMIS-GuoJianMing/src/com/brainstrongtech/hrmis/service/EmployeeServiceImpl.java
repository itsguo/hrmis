/**
 * 
 */
package com.brainstrongtech.hrmis.service;

import java.util.List;
import java.util.Set;

import com.brainstrongtech.hrmis.dao.EmployeeDao;
import com.brainstrongtech.hrmis.dao.EmployeeDaoTxtImpl;
import com.brainstrongtech.hrmis.domain.Employee;

/**
 * @author joeyang ong
 *
 */
public class EmployeeServiceImpl implements EmployeeService {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.service.EmployeeService#enrollEmployee(com.brainstrongtech.hrmis.domain.Employee)
	 */
	@Override
	public void enrollEmployee(Employee emp) {
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		empDao.addEmps(emp);

	}

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.service.EmployeeService#listEmployee()
	 */
	@Override
	public List<Employee> listEmployee() {
		
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		return empDao.loadEmps();

	}

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.service.EmployeeService#sortEmployee()
	 */
	@Override
	public Set<Employee> sortEmployee() {
		
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		return empDao.sortEmps();

	}

	@Override
	public void rewriteEmployee(List<Employee> emps) {
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		empDao.rewriteEmps(emps);
	}



}
