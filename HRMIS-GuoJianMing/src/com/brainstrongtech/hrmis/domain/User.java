package com.brainstrongtech.hrmis.domain;

public class User {
  private String username;
  private String password;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
  public static User parseUserInfoStr(String info){
	  User user=new User();
	  String[] secs = info.split("\\:");
	  user.setUsername(secs[0]);
	  user.setPassword(secs[1]);
	  return user;
  }
}
