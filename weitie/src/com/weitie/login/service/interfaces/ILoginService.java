package com.weitie.login.service.interfaces;

import com.weitie.login.entities.LoginInfo;

public interface ILoginService {
	/**
	 * 保存客户信息
	 * @param bean
	 * @throws Exception
	 */
	public void save(LoginInfo bean)throws Exception;
	
	public boolean containsKey(String key);
		
}
