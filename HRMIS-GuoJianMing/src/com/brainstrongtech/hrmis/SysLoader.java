/**
 * 
 */
package com.brainstrongtech.hrmis;

import com.brainstrongtech.hrmis.exception.HRMISException;
import com.brainstrongtech.hrmis.ui.UILoader;
import com.brainstrongtech.hrmis.ui.UIType;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * @author guo jian ming
 *
 */
public class SysLoader {
	
	public static void main(String[] args) {
		
		try{
		 SysUtils.checkResource();
		 UILoader.runUI(UIType.LOGIN);
		}catch(HRMISException e){
		  System.out.println(e.getMessage());
		}
		
	}

}
