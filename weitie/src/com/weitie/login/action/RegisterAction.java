package com.weitie.login.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.weitie.common.util.ImageUtil;
import com.weitie.login.service.interfaces.ILoginService;

public class RegisterAction implements SessionAware{
	private static final transient Logger log=LogManager.getLogger(RegisterAction.class);
	private ILoginService loginService;
	private Map<String, Object> session;
	private String username;
	private String password;
	private InputStream imageStream;
	public InputStream getImageStream() {
		return imageStream;
	}
	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}
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
	public ILoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	public String execute(){
		//1 检查用户名是否已经存在
		String name=username;
		return "SUCCESS";
		
	}
	public String getValidateCode(){
		//output
		//创建图片
		Map<String, BufferedImage> map = 
			ImageUtil.createImage();
		//取得图片
		String key = 
			map.keySet().iterator().next();
		BufferedImage image = map.get(key);
		//将图片转换为InputStream
		try {
			imageStream = 
				ImageUtil.getInputStream(image);
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		//将验证码记录到session
		session.put("imageCode", key);
		
		return "VALCODE";
	    
		
		
	}
	
}
