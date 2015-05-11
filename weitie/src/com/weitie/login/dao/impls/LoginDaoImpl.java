package com.weitie.login.dao.impls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.weitie.login.dao.interfaces.ILoginDao;
import com.weitie.login.entities.LoginInfo;

public class LoginDaoImpl implements ILoginDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(LoginInfo bean) {
		Session session=sessionFactory.openSession();
		session.save(bean);
	}
}
