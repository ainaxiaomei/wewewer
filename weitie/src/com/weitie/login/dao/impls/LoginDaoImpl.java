package com.weitie.login.dao.impls;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.weitie.common.util.CommonUtil;
import com.weitie.login.dao.interfaces.ILoginDao;
import com.weitie.login.entities.LoginInfo;

public class LoginDaoImpl implements ILoginDao {
	@Override
	public void save(LoginInfo bean) {
		
		Session session=CommonUtil.sessoinFactory.openSession();
		if("".equals(bean.getCustName())||null==bean.getCustName()){
			//生成唯一的用户名
			bean.setCustName(bean.getCustId()+"_cust");
		}
		session.save(bean);
		
	}

	@Override
	public List<?> get(String colum,String value, String entityName) {
		Session session=CommonUtil.sessoinFactory.openSession();
		Query query=session.createQuery(" FROM "+entityName+" WHERE "+colum+"="+value);
		return query.list();
	}

	

	
	
}
