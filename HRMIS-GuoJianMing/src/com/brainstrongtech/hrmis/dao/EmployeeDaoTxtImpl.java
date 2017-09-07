/**
 * 
 */
package com.brainstrongtech.hrmis.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.brainstrongtech.hrmis.domain.Employee;

/**
 * @author joeyang ong
 *
 */
public class EmployeeDaoTxtImpl implements EmployeeDao {
	
	private static final File EMP_INFO_FILE = new File("d:/records.txt");

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.dao.EmployeeDao#loadEmps()
	 */
	@Override
	public List<Employee> loadEmps() {

		List<Employee> empList = new ArrayList<Employee>();
		BufferedReader reader = null;
		String empInfo = null;
		try {

			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(EMP_INFO_FILE)));
			while ((empInfo = reader.readLine()) != null) {
				empList.add(Employee.parseEmpInfoStr(empInfo));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return empList;
	}

	@Override
	public Set<Employee> sortEmps() {
		
		TreeSet<Employee> empSet = new TreeSet<Employee>();
		List<Employee> empList=new ArrayList<Employee>();
		empList=this.loadEmps();
        for(int i=0;i<empList.size();i++){
        	empSet.add(empList.get(i));
        }
		        
		
		return empSet;
	}

	@Override
	public void addEmps(Employee emp) {
		 BufferedWriter writer=null;
		 try {
		 writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(EMP_INFO_FILE, true)));
          writer.write(emp.toString());
          writer.newLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		   
		   try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
	    
		
	}

	@Override
	public void rewriteEmps(List<Employee> emps) {
		 BufferedWriter writer=null;
		 try {
          writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(EMP_INFO_FILE,false)));
          for (Employee employee : emps) {
		 writer.write(employee.toString());
          writer.newLine();
		}
         
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		   
		   try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
		
	}



}
