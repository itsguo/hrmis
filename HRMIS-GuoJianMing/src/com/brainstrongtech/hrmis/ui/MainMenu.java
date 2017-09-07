/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.exception.HRMISException;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * @author joeyang ong
 *
 */
public class MainMenu implements BaseUI {

	/*
	 * (non-Javadoc)a
	 * 
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#run()
	 */
	@Override
	public void run() {
		
		boolean isContinued = true;
		String entry=null;
		while(isContinued){
			System.out.println("=====================================================\n");
			System.out.println("倓堊訧捅 - Employee Information - Main Menu");
			System.out.println("=====================================================\n");
			System.out.println("1 - Print All Current Records");
			System.out.println("2 每 Print All Current Records (formatted)");
			System.out.println("3 每 Print Names and Phone Numbers");
			System.out.println("4 每 Print Names and Phone Numbers (formatted)");
			System.out.println("5 - Search for specific Record(s)");
			System.out.println("6 - Add New Records");
			System.out.println("7 每 Delete Records");
			System.out.println("8 - Update Records");
			System.out.println("9 - Cancel\n");
			System.out.println("Q - Quit\n");
			System.out.print("Your selection:");
				
			try{
				
	          entry = SysUtils.getEntry(false);
	           switch(entry.toUpperCase().charAt(0)){
	             case '1': 
	               UILoader.runUI(UIType.EMP_LISTER);
	               break;
	             case '2': 
	               UILoader.runUI(UIType.EMP_FORMATTED_LISTER);
	               break;
	             case '3': 
	               UILoader.runUI(UIType.EMP_SIMPLE_LISTER); 
	               break;
	             case '4': 
	               UILoader.runUI(UIType.EMP_FORMATTED_SIMPLE_LISTER); 
	               break;
	             case '5':
	            	 UILoader.runUI(UIType.EMP_SERACH);
	            	 break;
	             case '6': 
	               UILoader.runUI(UIType.EMP_ENROLL);
	               break;
	             case '7': 
	            	 UILoader.runUI(UIType.EMP_DELETE);
	            	 break;
	             case '8':
	            	 UILoader.runUI(UIType.EMP_UPDATE);
	            	 break;
	             case '9':
	            	 isContinued=false;
	            	 break;
	             case 'Q': 
	               isContinued = false;
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
			
		}
		
		if(entry.charAt(0)=='9'){UILoader.runUI(UIType.LOGIN);}
		else{
		System.out.println("\nThank you for using HRMIS v1.0, Bye!");}
		
	}

}
