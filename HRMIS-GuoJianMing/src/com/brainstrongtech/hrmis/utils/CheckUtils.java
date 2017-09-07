package com.brainstrongtech.hrmis.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.exception.HRMISException;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;

public class CheckUtils {
	/**
	 * Ô±¹¤¹¤ºÅ¼ì²â
	 * @return
	 */
	public static String checkEnrollCode(){
		
		String enrollCode = null;
		boolean isContinued = true;
		List<Employee> List=new ArrayList<Employee>();
		EmployeeService employeeService=new EmployeeServiceImpl();
		List=employeeService.listEmployee();
		
		while(isContinued){
			
		  System.out.print("Please enter 3 digital code:");
		  
		  try{
		    enrollCode = SysUtils.getEntry(false);
		    Integer.parseInt(enrollCode);
		    if(enrollCode.length()!=3){throw new HRMISException("the length of enrollCode must be 3.");}
		    for (Employee employee : List) {
				if(employee.getPayrollNo().equals(enrollCode)){
					throw new HRMISException("The number already exists...");
				}
			}
		    
		    isContinued = false;
		  }catch(BlankEntryException e){
			 SysUtils.pause("No payroll number entered, try again!"); 
		  }catch(NumberFormatException e){
			 SysUtils.pause("can only digital number here!"); 
		  }catch(HRMISException e){
			  System.out.println(e.getMessage());
			  SysUtils.pause();
		  }
		  		  
		
		}
		
		return enrollCode;
     }
	/**
	 * µç»°ºÅÂë¼ì²â
	 * @return
	 */
	public static String checkEnrollPhoneNum(){
		String enrollCode = null;
		boolean isContinued = true;
		
		while(isContinued){
			
		  System.out.print("Enter Phone Number(02-12345678):");
		  
		  try{
		    enrollCode = SysUtils.getEntry(false);
		    String regEx="0[2-8]-[1-9]\\d{7}";
		    Pattern patter=Pattern.compile(regEx);
		    Matcher matcher=patter.matcher(enrollCode);
		    Boolean rs=matcher.matches();
		    if(!rs){throw new HRMISException();}
		    isContinued = false;
		  }catch(BlankEntryException e){
			 SysUtils.pause("No Phone number entered, try again!"); 
		  }catch(HRMISException e){
			  SysUtils.pause("Invalid phone number,try again!");
		  }
		  		  
		
		}
		
		return enrollCode;
		
	}
	/**
	 * LastName¼ì²â
	 * @return
	 */
    public static String checkENrollLastName(){
    	String enrollCode = null;
		boolean isContinued = true;
		
		while(isContinued){
			
		  System.out.print("Enter Last Name:");
		  
		  try{
		    enrollCode = SysUtils.getEntry(false);
		    Pattern pattern = Pattern.compile("[0-9]+?"); 
		    Matcher isNum = pattern.matcher(enrollCode);
		    if(isNum.find()){throw new HRMISException();}
		    isContinued = false;
		  }catch(BlankEntryException e){
			 SysUtils.pause("No last name entered, try again!"); 
		  }catch(HRMISException e){
			 SysUtils.pause("Last name can contain only alphabetical characters and spaces!"); 
		  }
		  		  
		
		}
		
		return enrollCode;
    }
    /**
     * First Name¼ì²â
     * @return
     */
    public static String checkENrollFirstName(){
    	String enrollCode = null;
		boolean isContinued = true;
		
		while(isContinued){
			
		  System.out.print("Enter First Name:");
		  
		  try{
		    enrollCode = SysUtils.getEntry(false);
		    Pattern pattern = Pattern.compile("[0-9]+?"); 
		    Matcher isNum = pattern.matcher(enrollCode);
		    if(isNum.find()){throw new HRMISException();}
		    isContinued = false;
		  }catch(BlankEntryException e){
			 SysUtils.pause("No first name entered, try again!"); 
		  }catch(HRMISException e){
			 SysUtils.pause("First name can contain only alphabetical characters and spaces!"); 
		  }
		  		  
		
		}
		
		return enrollCode;
    }
    /**
     * Ö°Î»¼ì²â
     * @return
     */
	    public static String checkENrollInitial(){
	    	String enrollCode = null;
			boolean isContinued = true;
			
			while(isContinued){
				
			  System.out.print("Enter Middle Init:");
			  
			  try{
			    enrollCode = SysUtils.getEntry(false);
			    Pattern pattern = Pattern.compile("[a-z]\\s*",Pattern.CASE_INSENSITIVE); 
			    Matcher isChar = pattern.matcher(enrollCode);
			    if(!isChar.matches()){throw new HRMISException();}
			    isContinued = false;
			  }catch(BlankEntryException e){
				 SysUtils.pause("No Middle Init entered, try again!"); 
			  }catch(HRMISException e){
				 SysUtils.pause("Middle Init can contain only alphabetical characters and spaces!"); 
			  }
			  		  
			
			}
			
			return enrollCode;
	    }
	    /**
	     * ²¿ÃÅºÅ¼ì²â
	     * @return
	     */
	    public static Integer checkENrollDeptNo(){
	    	
			String enrollCode = null;
			boolean isContinued = true;
			Integer i=null;
			while(isContinued){
				
			  System.out.print("Enter Dept #:");
			  
			  try{
			    enrollCode = SysUtils.getEntry(false);
			   i= Integer.parseInt(enrollCode);
			    isContinued = false;
			  }catch(BlankEntryException e){
				 SysUtils.pause("No Dept# entered, try again!"); 
			  }catch(NumberFormatException e){
				 SysUtils.pause("Dept #can only digital number here!"); 
			  }
			  		  
			
			}
			
			return i;
	    }
      /**
       * Ö°³Æ¼ì²â
       * @return
       */
	    public static String checkENrollJobTitle(){
	    	String enrollCode = null;
			boolean isContinued = true;
			
			while(isContinued){
				
			  System.out.print("Enter Job TiTle:");
			  
			  try{
			    enrollCode = SysUtils.getEntry(false);
			    Pattern pattern = Pattern.compile("[0-9]+?"); 
			    Matcher isNum = pattern.matcher(enrollCode);
			    if(isNum.find()){throw new HRMISException();}
			    isContinued = false;
			  }catch(BlankEntryException e){
				 SysUtils.pause("No job title entered, try again!"); 
			  }catch(HRMISException e){
				 SysUtils.pause("job title can contain only alphabetical characters and spaces!"); 
			  }
			  		  
			
			}
			
			return enrollCode;
	    }
	    /**
	     * ÈÕÆÚ¼ì²â
	     * @return
	     */
	    public static Date checkENrollDate(){
	    	String enrollCode = null;
			boolean isContinued = true;
			  SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			  sdf.setLenient(false);
			  Date date=null;
			while(isContinued){
				
			  System.out.print("Enter Date Hired(dd-mm-yyyy):");

			  try{
			    enrollCode = SysUtils.getEntry(false);
                date=sdf.parse(enrollCode);
			    isContinued = false;
			  }catch(BlankEntryException e){
				 SysUtils.pause("No date hired entered, try again!"); 
			  }catch(ParseException e){
				  SysUtils.pause("Invalid Date Hired");
			  }
			  		  
			
			}
			
			return date;
	    }
}
