package com.weitie.login.service.impls;

import java.util.List;

import com.weitie.login.dao.interfaces.ILoginDao;
import com.weitie.login.entities.LoginInfo;
import com.weitie.login.service.interfaces.ILoginService;

public class LoginServiceImpl implements ILoginService {
	private ILoginDao loginDao;

	public ILoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public void save(LoginInfo bean) throws Exception {
		loginDao.save(bean);
	}

	@Override
	public boolean containsKey(String key) {
		List list=loginDao.get("email", key, "LoginInfo");
		return !list.isEmpty();
	}

}
