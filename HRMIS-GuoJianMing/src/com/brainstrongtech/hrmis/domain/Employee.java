/**
 * 
 */
package com.brainstrongtech.hrmis.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 雇员类
 * @author joeyang ong
 *
 */
public class Employee extends ValueObject implements Comparable<Employee>{
	
	/** 雇员编号 */
	private String payrollNo;
	/** 电话号码 */
	private String telephoneNum;
	private String lastName;
	private String firstName;
	private String initial;
	private Integer deptNo;
	private String jobTitle;
	private Date   hiringDate;
	
	public String getPayrollNo() {
		return payrollNo;
	}
	public void setPayrollNo(String payrollNo) {
		this.payrollNo = payrollNo;
	}
	public String getTelephoneNum() {
		return telephoneNum;
	}
	public void setTelephoneNum(String telephoneNum) {
		this.telephoneNum = telephoneNum;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getInitial() {
		return initial;
	}
	public void setInitial(String initial) {
		this.initial = initial;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Date getHiringDate() {
		return hiringDate;
	}
	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}
	
	@Override
	public String toString() {
	    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		return this.payrollNo+":"+this.telephoneNum+":"+this.lastName+":"+this.firstName+":"+this.initial+":"+this.deptNo+":"+this.jobTitle+":"+sdf.format(hiringDate);
	}
	
	/**
	 *  员工对象正常打印输出
	 */
	public void normalPrint(){
		System.out.println(this);
	}
	
	/**
	 *  员工对象格式化打印输出
	 */	
	public void formattedPrint(){
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		String out = String.format("%10s%20s%20s%20s%20s%20s%20s%20s", this.lastName,this.firstName,this.initial,this.payrollNo,this.telephoneNum,this.deptNo,this.jobTitle,sdf.format(hiringDate));
		System.out.println(out);
	}
	
	/**
	 *  员工信息简易输出
	 */
	public void simplePrint(){
		System.out.println(this.lastName+","+this.firstName+","+this.telephoneNum);
	}
	
	/**
	 * 员工信息格式化简易输出
	 */
	public void simpleFormattedPrint(){
		System.out.println(String.format("%20s%15s%20s", this.lastName,this.firstName,this.telephoneNum));
	}
	
	/**
	 * 从员工信息字符串解析员工对象
	 * @param empInfo
	 * @return
	 * @throws ParseException 
	 */
	public static Employee parseEmpInfoStr(String empInfo){
		
		Employee emp = new Employee();
		
		String[] secs = empInfo.split("\\:");
		emp.setPayrollNo(secs[0]);
		emp.setTelephoneNum(secs[1]);
		emp.setLastName(secs[2]);
		emp.setFirstName(secs[3]);
		emp.setInitial(secs[4]);
		emp.setDeptNo(Integer.valueOf(secs[5]));
        emp.setJobTitle(secs[6]);
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        Date date=new Date();
        try {
			date=sdf.parse(secs[7]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        emp.setHiringDate(date);
				
		return emp;
	}
	@Override
	public int compareTo(Employee o) {
		if(this.lastName.compareTo(o.lastName)<0) return -1;
		else if(this.lastName.compareTo(o.lastName)==0) return 0;
		else  return 1;
	}
	

	
	

}
