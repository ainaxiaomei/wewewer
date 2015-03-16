package com.weitie.login.action;

public class LoginAction {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public LoginAction(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LoginAction() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute(){
		System.out.println("---------"+this.username+this.password+"-----");
		return "success";
		
	}
}
