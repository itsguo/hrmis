package com.brainstrongtech.hrmis.ui;

import com.brainstrongtech.hrmis.domain.User;
import com.brainstrongtech.hrmis.exception.HRMISException;
import com.brainstrongtech.hrmis.service.LoginService;
import com.brainstrongtech.hrmis.service.LoginServiceImpl;
import com.brainstrongtech.hrmis.utils.SysUtils;

public class Login implements BaseUI{

	@Override
	public void run() {
		System.out.println("======Welcome to HRMIS===========");
		System.out.println("=============LOGIN===============");
		System.out.print("Username:");  String username=SysUtils.getEntry(false);
		System.out.print("Password:"); String password=SysUtils.getEntry(false);
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		LoginService loginservice=new LoginServiceImpl();
		
		try {
			loginservice.checkUser(user);
		    UILoader.runUI(UIType.MAINMENU);
		} catch (HRMISException e) {
		      System.out.println("用户名或密码错误，请重试...");
		      this.run();
		}
		
	}

}
