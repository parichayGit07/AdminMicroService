package com.flight.admin.beans;

public class AdminCredentials {
private String userName;
private String passWord;
public AdminCredentials() {
	super();
	// TODO Auto-generated constructor stub
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassWord() {
	return passWord;
}
public AdminCredentials(String userName, String passWord) {
	super();
	this.userName = userName;
	this.passWord = passWord;
}
public void setPassWord(String passWord) {
	this.passWord = passWord;
}
}
