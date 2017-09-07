/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import com.brainstrongtech.hrmis.exception.HRMISException;

/**
 * @author joeyang ong
 *
 */
public class UILoader {
	 
	 public static BaseUI load(UIType type){
		 
		 if(type.equals(UIType.MAINMENU)){
			 return new MainMenu();
		 }
		 else if(type.equals(UIType.EMP_LISTER)){
			 return new EmployeeLister();
		 }
		 else if(type.equals(UIType.EMP_FORMATTED_LISTER)){
			 return new EmployeeSorttedLister();
		 }
		 else if(type.equals(UIType.EMP_SIMPLE_LISTER)){
			  return new EmployeeSimpleLister();
		 }
		 else if(type.equals(UIType.EMP_FORMATTED_SIMPLE_LISTER)){
			 return new EmployeeSimpleSorttedLister();
		 }
		 else if(type.equals(UIType.EMP_SERACH)){
			 return new EmployeeSeacher();
		 }
		 else if(type.equals(UIType.EMP_ENROLL)){
			 return new EmployeeEnroller();
		 }
		 else if(type.equals(UIType.EMP_DELETE)){
			 return new EmployeeDelete();
		 }
		 else if(type.equals(UIType.EMP_UPDATE)){
			 return new EmployeeUpdate();
		 }
		 else if(type.equals(UIType.LOGIN)){
			 return new Login();
		 }
		 
		 
		 throw new HRMISException("UI类型不正确，无法加载UI模块!");
		 
	 }
	 
	 
	 public static void runUI(UIType type){
	     load(type).run();	 
	 }
	
}
