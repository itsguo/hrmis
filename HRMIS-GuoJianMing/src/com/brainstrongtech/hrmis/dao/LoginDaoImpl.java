package com.brainstrongtech.hrmis.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.brainstrongtech.hrmis.domain.User;

public class LoginDaoImpl implements LoginDao {
	private static final File USER_FILE = new File("d:/users.txt");
	@Override
	public List<User> checkUser() {
		List<User> userlist=new ArrayList<User>();
		BufferedReader reader=null;
		String userInfo=null;
		try {
			reader=new BufferedReader(new InputStreamReader(new FileInputStream(USER_FILE)));
			while((userInfo=reader.readLine())!=null){
				userlist.add(User.parseUserInfoStr(userInfo));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userlist;
	}


}
