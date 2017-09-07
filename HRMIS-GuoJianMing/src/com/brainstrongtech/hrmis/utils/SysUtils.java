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
 * ϵͳͨ�ù�����
 * @author joeyang ong
 *
 */
public final class SysUtils {
	
	/**
	 * �ӿ���̨¼������
	 * @param canBlank  �Ƿ�֧�ֿ�¼��
	 * @return
	 */
	public static String getEntry(boolean canBlank){
		
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		String entry = null;
		
		try {
			entry = reader.readLine();
			if(!canBlank){
				if(entry==null||entry.trim().length()==0)
					 throw new BlankEntryException("����̨��ȡ���հ�¼��!");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new DataAccessException("����̨��ȡ¼����Ϣʧ��!");
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
