package com.weitie.login.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.weitie.common.util.CommonUtil;
import com.weitie.common.util.ImageUtil;
import com.weitie.login.entities.LoginInfo;
import com.weitie.login.service.interfaces.ILoginService;

public class RegisterAction implements SessionAware{
	private static final transient Logger log=LogManager.getLogger(RegisterAction.class);
	private ILoginService loginService;
	private Map<String, Object> session;
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private InputStream imageStream;
	public InputStream getImageStream() {
		return imageStream;
	}
	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
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
		//为什么下面报错
		//if(StringUtils.isNotBlank(email)&&StringUtils.isNotBlank(password)){
		if(!"".equals(email)&&null!=email&&!"".equals(password)&&null!=password){
			try {
				LoginInfo loginInfo =new LoginInfo();
				loginInfo.setEmail(email);
				loginInfo.setPassword(password);
				loginInfo.setCustId(CommonUtil.generateId(loginInfo.getClass()));
				loginService.save(loginInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "SUCCESS";
		}else{
			return "ERROR";
		}
		
		
	}
	public void check() throws IOException{
		//获取email
		if(loginService.containsKey(email)){
			PrintWriter pw=ServletActionContext.getResponse().getWriter();
			StringBuilder sb =new StringBuilder();
			sb.append("{").append("INFO").append(":").append("\"email already Exists\"").append("}");
			pw.write(sb.toString());
		}
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
