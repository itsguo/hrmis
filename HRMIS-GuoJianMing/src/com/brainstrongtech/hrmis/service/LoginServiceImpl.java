package com.brainstrongtech.hrmis.service;

import java.util.List;

import com.brainstrongtech.hrmis.dao.LoginDao;
import com.brainstrongtech.hrmis.dao.LoginDaoImpl;
import com.brainstrongtech.hrmis.domain.User;
import com.brainstrongtech.hrmis.exception.HRMISException;

public class LoginServiceImpl implements LoginService {

	@Override
	public void checkUser(User user) {
		 Integer i=null;
		 LoginDao logindao=new LoginDaoImpl();
	     List<User> userlist=logindao.checkUser();
	     for (User user2 : userlist) {
			if(user2.getUsername().equals(user.getUsername())){
				if(user2.getPassword().equals(user.getPassword())){i=1;}
			}
		}
	     if(i==null){
	    	 throw new HRMISException();
	     }
	   
	}

}
