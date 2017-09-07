/**
 * 
 */
package com.brainstrongtech.hrmis.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.exception.DataAccessException;
import com.brainstrongtech.hrmis.exception.HRMISException;

/**
 * 
 * 系统通用工具类
 * @author joeyang ong
 *
 */
public final class SysUtils {
	
	/**
	 * 从控制台录入数据
	 * @param canBlank  是否支持空录入
	 * @return
	 */
	public static String getEntry(boolean canBlank){
		
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		String entry = null;
		
		try {
			entry = reader.readLine();
			if(!canBlank){
				if(entry==null||entry.trim().length()==0)
					 throw new BlankEntryException("控制台读取到空白录入!");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new DataAccessException("控制台读取录入信息失败!");
		}
		
		return entry;
		
	}
	
	public static void pause(String message){
		
		System.out.print(message);
		SysUtils.getEntry(true);
		
	}
	
	public static void pause(){
		SysUtils.getEntry(true);		
	}
	
	public static void checkResource(){
		
		File file = new File("d:\\records.txt");
		File file2 =new File("d:\\users.txt");
		if(!file2.exists())
			throw new HRMISException("users information data file is not found!");
		if(!file.exists())
			throw new HRMISException("employee informat data file is not found!");
		
		
	}
	

}
