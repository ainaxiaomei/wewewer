package com.weitie.login.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.weitie.login.dao.impls.LoginDaoImpl;
import com.weitie.login.entities.LoginInfo;
import com.weitie.login.service.impls.LoginServiceImpl;
import com.weitie.login.service.interfaces.ILoginService;

public class LoginAction implements SessionAware{
	private String username;
	private String password;
	private ILoginService loginService;
	public ILoginService getLoginService() {
		return loginService;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}
	private Map<String, Object> session;
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
		try {
			LoginInfo bean=new LoginInfo();
			bean.setCustId("123");
			bean.setCustName(username);
			bean.setPassword(password);
			loginService.save(bean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		Map<String, Object> map=ActionContext.getContext().getSession();
		System.out.println(map.toString());
		System.out.println("---------"+this.username+this.password+"-----");
		return "success";
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
}
